package com.antsdouble.zqwservice.data.spider.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.everise.airqualityforecast.commons.domain.spider.AirRequestEntity;
import com.everise.airqualityforecast.commons.domain.spider.AirRequestValuePointTimeEntity;
import com.github.kevinsawicki.http.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lyy
 * @description
 * @date 2019/7/15
 */
public class JavaScriptEngine {

    private static Logger logger = LoggerFactory.getLogger(JavaScriptEngine.class);
    private static ScriptEngineManager instance = null;

    private static ScriptEngine engine;


    private static Invocable getInvocable(String path) throws IOException, ScriptException {

        instance = new ScriptEngineManager();
        //调用Java8 nashorn 运行JavaScript脚本
        engine = new ScriptEngineManager().getEngineByName("nashorn");
        //读取文件对象
        Resource aesJs = new ClassPathResource(path);
        BufferedReader br = new BufferedReader(new InputStreamReader(aesJs.getInputStream(), "UTF-8"));
        String line = null;
        String FileContent = "";
        while ((line = br.readLine()) != null) {
            FileContent += line;
            FileContent += "\r\n";
            // 补上换行符
        }
        //执行脚本
        engine.eval(FileContent);
        return (Invocable) engine;


    }

    public static Map<String, String> getZqParam(AirRequestEntity airRequestEntity, String jsPath) {
        String paramStr = null;
        try {
            Invocable invocable = getInvocable(jsPath);
            if (invocable == null) {
                logger.error("js引擎加载失败");
            }
            AirRequestValuePointTimeEntity methodValue = (AirRequestValuePointTimeEntity) airRequestEntity.getMethodValue();
            String cityStr = (String) invocable.invokeFunction("encode_param", methodValue.getCity());
            String methodStr = (String) invocable.invokeFunction("encode_param", airRequestEntity.getMethodName());
            String startStr = (String) invocable.invokeFunction("encode_param", methodValue.getStartTime());
            String endStr = (String) invocable.invokeFunction("encode_param", methodValue.getEndTime());
            String secretStr = (String) invocable.invokeFunction("encode_secret",airRequestEntity.getMethodName(),cityStr,methodValue.getStartTime(),methodValue.getEndTime());
            methodValue.setCity(cityStr);
            methodValue.setStartTime(startStr);
            methodValue.setEndTime(endStr);
            methodValue.setSecret(secretStr);
            logger.debug(methodValue.toString());
            Map<String, String> data = new HashMap<>(10);
            data.put("appId", methodValue.getAppId());
            data.put("method", methodStr);
            data.put("city", methodValue.getCity());
            data.put("startTime", methodValue.getStartTime());
            data.put("endTime", methodValue.getEndTime());
            data.put("secret", secretStr);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("js脚本初始化失败");
            throw new RuntimeException("js脚本初始化失败");
        }
    }

    public static Map<String, String> getParam(AirRequestEntity airRequestEntity, String jsPath,String keyData) {

        String paramStr = null;
        try {
            Invocable invocable = getInvocable(jsPath);
            if (invocable == null) {
                logger.error("js引擎加载失败");
            }
            Object parse = JSONObject.parse(JSON.toJSONString(airRequestEntity.getMethodValue()));
            paramStr = (String) invocable.invokeFunction("getParam", airRequestEntity.getMethodName(), parse);
            logger.debug(paramStr);
            Map<String, String> data = new HashMap<>(5);
            data.put(keyData, paramStr);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("js脚本初始化失败");
            throw new RuntimeException("js脚本初始化失败");
        }
    }


    public static String postZqFormData(String url, Map<String, String> data) {

        OutputStream output = new OutputStream() {
            private StringBuilder string = new StringBuilder();

            @Override
            public void write(int b) throws IOException {
                this.string.append((char) b);
            }

            //Netbeans IDE automatically overrides this toString()
            @Override
            public String toString() {
                return this.string.toString();
            }
        };
        HttpRequest form = HttpRequest.post(url).form(data);
        HttpRequest receive = form.receive(output);
        return output.toString();


    }



    public static String getData(String strData) {

        try {
            //调用Java8 nashorn 运行JavaScript脚本
            Invocable invocable = getInvocable("js/aqiStudyJs.js");

            if (invocable == null) {
                logger.error("js引擎异常");
                return "";
            }
            String getParam = (String) invocable.invokeFunction("decodeData", strData);
            System.out.println(getParam);
            return getParam;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("js脚本初始化失败");
        }


    }
    public static String getZqData(String strData,String path) {

        try {
            //调用Java8 nashorn 运行JavaScript脚本
            Invocable invocable = getInvocable(path);

            if (invocable == null) {
                logger.error("js引擎异常");
                return "";
            }
            String getParam = (String) invocable.invokeFunction("decode_result", strData);
            System.out.println(getParam);
            return getParam;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("js脚本初始化失败");
        }


    }


}
