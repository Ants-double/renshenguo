package com.antsdouble.zqwservice.data.spider.util;


import com.antsdouble.zqwservice.data.spider.config.SpiderParameter;
import com.everise.airqualityforecast.commons.domain.spider.*;

import java.util.HashMap;

/**
 * @author lyy
 * @description
 * @date 2019/7/15
 */
public class ProcessType {



    private static final String APISTUDY = "https://www.aqistudy.cn/apinew/aqistudyapi.php";
    private static final String APIZQ = "https://m.zq12369.com/api/newzhenqiapi.php";

    private SpiderParameter spiderParameter;

    public ProcessType(SpiderParameter spiderParameter) {
        this.spiderParameter = spiderParameter;
    }

    private HashMap<String, AirRequestEntity> requestEntityMap = new HashMap<>(16);

    public HashMap<String, AirRequestEntity> getRequestEntityMap() {
        // 0
        AirRequestValueEntity airRequestValueEntity = getAirRequestEntity( spiderParameter.getCity());
        AirRequestEntity airRequestEntity = getAirRequestEntity(airRequestValueEntity, "GETDATA", APISTUDY);
        requestEntityMap.put("0", airRequestEntity);
        // 1
        AirRequestValueDetailEntity airRequestValueDetailEntity = getAirRequestValueDetailEntity(spiderParameter.getCity(),
                spiderParameter.getStartTime(), spiderParameter.getEndTime(), "HOUR");
        AirRequestEntity airRequestDetailEntity = getAirRequestEntity(airRequestValueDetailEntity, "GETDETAIL", APISTUDY);
        requestEntityMap.put("1", airRequestDetailEntity);
        // 2

        AirRequestValueMaEntity airRequestValueMaEntity = getAirRequestValueMaEntity(spiderParameter.getTimePoint(), "HOUR");
        AirRequestEntity airRequestMaEntity = getAirRequestEntity(airRequestValueMaEntity, "GETMAPDATA", APISTUDY);
        requestEntityMap.put("2", airRequestMaEntity);

        // 3
        AirRequestValueProviceEntity airRequestValueProviceEntity = getAirRequestValueProviceEntity(spiderParameter.getTimePoint(), "HOUR");
        AirRequestEntity airRequestProviceEntity = getAirRequestEntity(airRequestValueProviceEntity, "GETPROVINCEDATA", APISTUDY);
        requestEntityMap.put("3", airRequestProviceEntity);

        // 6
        AirRequestValueCityTimeEntity airRequestValueCityTimeEntity = getAirRequestValueCityTimeEntity(spiderParameter.getCity(),spiderParameter.getStartTime(), spiderParameter.getEndTime());
        AirRequestEntity airRequestCityTimeEntity = getAirRequestEntity(airRequestValueCityTimeEntity, "GETCITYTIME", APISTUDY);
        requestEntityMap.put("6", airRequestCityTimeEntity);

        // 18
        AirRequestValuePointTimeEntity airRequestValueCityPointEntity = getAirRequestValuePointTimeEntity(spiderParameter.getCity(),spiderParameter.getStartTime(), spiderParameter.getEndTime());
        AirRequestEntity airRequestCityPointEntity = getAirRequestEntity(airRequestValueCityPointEntity, "GETCITYPOINTAVG", "https://www.zq12369.com/api/zhenqiapi.php");
        requestEntityMap.put("18", airRequestCityPointEntity);
        return requestEntityMap;
    }


    private AirRequestValuePointTimeEntity getAirRequestValuePointTimeEntity(String city,String startTime,String endTime){
        AirRequestValuePointTimeEntity airRequestValuePointTimeEntity=new AirRequestValuePointTimeEntity();
        airRequestValuePointTimeEntity.setAppId("a01901d3caba1f362d69474674ce477f");
        airRequestValuePointTimeEntity.setCity(city);
        airRequestValuePointTimeEntity.setStartTime(startTime);
        airRequestValuePointTimeEntity.setEndTime(endTime);
        airRequestValuePointTimeEntity.setSecret("cf6d138cc6be63003c5ac0c437000118");
        return airRequestValuePointTimeEntity;
    }


    private AirRequestValueCityTimeEntity getAirRequestValueCityTimeEntity(String city, String startTime, String endTime) {
        AirRequestValueCityTimeEntity airRequestValueCityTimeEntity = new AirRequestValueCityTimeEntity();
        airRequestValueCityTimeEntity.setCity(city);
        airRequestValueCityTimeEntity.setStartTime(startTime);
        airRequestValueCityTimeEntity.setEndTime(endTime);
        return airRequestValueCityTimeEntity;
    }

    private AirRequestValueProviceEntity getAirRequestValueProviceEntity(String timePoint, String type) {
        AirRequestValueProviceEntity airRequestValueProviceEntity = new AirRequestValueProviceEntity();
        airRequestValueProviceEntity.setTimepoint(timePoint);
        airRequestValueProviceEntity.setType(type);
        return airRequestValueProviceEntity;
    }

    private AirRequestValueMaEntity getAirRequestValueMaEntity(String timePoint, String type) {
        AirRequestValueMaEntity airRequestValueMaEntity = new AirRequestValueMaEntity();
        airRequestValueMaEntity.setTimepoint(timePoint);
        airRequestValueMaEntity.setType(type);
        return airRequestValueMaEntity;
    }


    private AirRequestValueDetailEntity getAirRequestValueDetailEntity(String city, String startTime, String endTime, String type) {
        AirRequestValueDetailEntity airRequestValueDetailEntity = new AirRequestValueDetailEntity();
        airRequestValueDetailEntity.setCity(city);
        airRequestValueDetailEntity.setStartTime(startTime);
        airRequestValueDetailEntity.setEndTime(endTime);
        airRequestValueDetailEntity.setType(type);
        return airRequestValueDetailEntity;
    }

    private AirRequestValueEntity getAirRequestEntity(String city) {
        AirRequestValueEntity airRequestValueEntity = new AirRequestValueEntity();
        airRequestValueEntity.setCity(city);
        return airRequestValueEntity;
    }

    private AirRequestEntity getAirRequestEntity(BaseAirRequestValueEntity airRequestValueEntity, String paraType, String url) {
        AirRequestEntity airRequestEntity = new AirRequestEntity();
        airRequestEntity.setMethodName(paraType);
        airRequestEntity.setMethodUrl(url);
        airRequestEntity.setMethodValue(airRequestValueEntity);
        return airRequestEntity;
    }


}
