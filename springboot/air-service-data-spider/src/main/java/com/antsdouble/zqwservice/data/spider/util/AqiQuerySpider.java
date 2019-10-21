package com.antsdouble.zqwservice.data.spider.util;

import com.antsdouble.zqwservice.data.spider.config.SpiderParameter;
import com.everise.airqualityforecast.commons.domain.spider.AirRequestEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lyy
 * @description
 * @date 2019/7/15
 */

public class AqiQuerySpider {

    private ProcessType processType ;
    AirRequestEntity airRequestEntity = null;
    private SpiderParameter spiderParameter;

    public AqiQuerySpider(SpiderParameter spiderParameter) {
        this.spiderParameter = spiderParameter;
        processType = new ProcessType(spiderParameter);
    }


    public Map<String, String> getParam() {
        HashMap<String, AirRequestEntity> requestEntityMap = processType.getRequestEntityMap();
        airRequestEntity = requestEntityMap.get(spiderParameter.getFlag());
        if (airRequestEntity.getMethodUrl() == "https://www.aqistudy.cn/apinew/aqistudyapi.php") {
            Map<String, String> data = JavaScriptEngine.getParam(airRequestEntity, "js/aqiStudyJs.js", "d");
            return data;
        } else if ("https://www.zq12369.com/api/zhenqiapi.php".equals(airRequestEntity.getMethodUrl())) {

            Map<String, String> zqParam = JavaScriptEngine.getZqParam(airRequestEntity, "js/newZhenqiJs.js");
            return zqParam;
        } else {
            Map<String, String> param = JavaScriptEngine.getParam(airRequestEntity, "js/newZhenqiJs.js", "param");
            return param;
        }


    }

    public String postFormData(Map<String, String> param) {
        String postFormData = JavaScriptEngine.postZqFormData(airRequestEntity.getMethodUrl(), param);
        return postFormData;
    }

    public String getData(String strData) {
        if (airRequestEntity.getMethodUrl() == "https://www.aqistudy.cn/apinew/aqistudyapi.php") {
            String data = JavaScriptEngine.getData(strData);
            return data;
        } else if ("https://www.zq12369.com/api/zhenqiapi.php".equals(airRequestEntity.getMethodUrl())) {
            String zqData = JavaScriptEngine.getZqData(strData, "js/newZhenqiJs.js");
            return zqData;
        } else {
            String data = JavaScriptEngine.getData(strData);
            return data;
        }

    }


}
