package com.antsdouble.grib2jsonweb.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.antsdouble.grib2jsonweb.util.Launcher;
import com.antsdouble.grib2jsonweb.util.Windparameter;
import com.github.kevinsawicki.http.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.concurrent.TimeUnit;

/**
 * @author lyy
 * @Deprecated
 * @date 2019/10/14
 */
@RestController
@RequestMapping(value = "wind")
public class WindOperation {
    private static Logger logger = LoggerFactory.getLogger(WindOperation.class);
    private static Integer DEFAULT_CONTENT_LENGTH = 100;
    @Autowired
    private Windparameter windparameter;

    /**
     * 创建目录
     *
     * @param dir
     * @return
     */
    private boolean createDir(String dir) {
        try {
            boolean flag = true;
            File file = new File(dir);

            if (!file.exists()) {
                flag = file.mkdirs();
            }

            return flag;
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }

    /**
     * 功能描述http://localhost:9009/wind/test?testStr=-d*-n*-o*F:/test01.json*--names*F:/gfs.t18z.pgrb2full.0p50.f000
     *
     * @param [testStr]
     * @return java.lang.String
     * @author lyy
     * @date 2019/8/12
     */
    @RequestMapping(
            value = "gribJson",
            method = RequestMethod.GET
    )
    public String gribJson(@RequestParam(defaultValue = "100") String above,
                                      @RequestParam(defaultValue = "0") Float leftLon,
                                      @RequestParam(defaultValue = "360") Float rightLon,
                                      @RequestParam(defaultValue = "90") Float topLat,
                                      @RequestParam(defaultValue = "-90") Float bottomLat,
                                      @RequestParam(defaultValue = "20191007") String dataDate,
                                      @RequestParam(defaultValue = "00") String dataTime) {
        try {
            String fileJsonName = String.format("%s_%.2f_%.2f_%.2f_%.2f.json",
                    above,
                    leftLon,
                    rightLon,
                    topLat,
                    bottomLat);
            String fileSourceName = String.format("%s_%.2f_%.2f_%.2f_%.2f",
                    above,
                    leftLon,
                    rightLon,
                    topLat,
                    bottomLat);
            String dirPath = String.format("%s/%s/%s/", windparameter.getRootDirectory(), dataDate, dataTime);
            String testStr = String.format("-d*-n*-o*%s*--names*%s",
                    dirPath + fileJsonName,
                    dirPath + fileSourceName);
            String requestPath =
                    String.format(
                            "https://nomads.ncep.noaa.gov/cgi-bin/filter_gfs_0p25.pl?file=gfs.t%sz.pgrb2.0p25.anl&lev_%s_m_above_ground=on&var_UGRD=on&var_VGRD=on&subregion=&leftlon=%.2f&rightlon=%.2f&toplat=%.2f&bottomlat=%.2f&",
                            dataTime,
                            above,
                            leftLon,
                            rightLon,
                            topLat,
                            bottomLat);
            String requestLastPath = "dir=%2Fgfs." + dataDate + "%2F" + dataTime;

            logger.debug(testStr);
            logger.debug(requestPath + requestLastPath);
            logger.debug(fileJsonName);
            logger.debug(fileSourceName);
            logger.debug(dirPath);

            if (createDir(dirPath)) {
                File output = new File(dirPath + fileSourceName);
                String sResult = null;


                switch (judeFileExists(output)) {

                    // 存在直接读
                    case 0:
                        sResult = readToString(dirPath + fileJsonName);

                        if (sResult.length() < DEFAULT_CONTENT_LENGTH) {
                            HttpRequest.get(requestPath + requestLastPath).receive(output);
                            Launcher.main(testStr.split("\\*"));
                            sResult = readToString(dirPath + fileJsonName);
                        }

                        break;

                    // 不存在发起网络请求 并保存
                    case 1:
                        HttpRequest.get(requestPath + requestLastPath).receive(output);

                        TimeUnit.SECONDS.sleep(500);
                        Launcher.main(testStr.split("\\*"));

                        sResult = readToString(dirPath + fileJsonName);

                        break;

                    // 异常 直接返回不做处理
                    case 2:
                        break;

                    default:
                        break;
                }

                return sResult;
            } else {
                return "创建路径错误";
            }
        } catch (RuntimeException e) {
            return "运行时异常";
        } catch (Exception ex) {
            return "数据解析异常";
        }
    }

    /**
     * 功能描述 // 判断文件是否存在,如果不存在则创建
     *
     * @param
     * @return int
     * @author lyy
     * @date 2019/8/14
     */
    private int judeFileExists(File file) {
        boolean flag = true;

        if (file.exists()) {
            return 0;
        } else {
            try {
                file.createNewFile();

                return 1;
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e) {
                e.printStackTrace();

                return 2;
            }
        }
    }

    private String readToString(String fileName) throws IOException {
        String encoding = "UTF-8";
        File file = new File(fileName);
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        FileInputStream in = null;

        try {
            in = new FileInputStream(file);
            in.read(filecontent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();

            if (null != in) {
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();

            if (null != in) {
                in.close();
            }
        } finally {
            if (null != in) {
                in.close();
            }
        }

        try {
            return new String(filecontent, encoding);
        } catch (UnsupportedEncodingException e) {
            System.err.println("The OS does not support " + encoding);
            e.printStackTrace();

            return null;
        }
    }
}
