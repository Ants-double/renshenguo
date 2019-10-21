package com.lyy.taskroot;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * @author lyy
 * @description
 * @date 2019/4/29
 */
public class HolidayUtil {
    public static String request(String httpArg) {
        //工作日对应结果为 0, 休息日对应结果为 1, 节假日对应的结果为 2
        String httpUrl = "http://api.goseek.cn/Tools/holiday";
        String result = "";
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl + "?date=" + httpArg;
        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream is = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result =jsonStringToMap(String.valueOf(sbf)).get("data").toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    private static Map<String, Object> jsonStringToMap(String json) {
        //String转成JSONObject形式
        JSONObject jsonArray = JSONObject.parseObject(json);
        Map<String, Object> param = JSONObject.parseObject(jsonArray.toJSONString(), new TypeReference<Map<String, Object>>() {});
        return param;
    }

}
