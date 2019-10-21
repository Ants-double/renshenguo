package com.antsdouble.zqwservice.data.spider.api.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.antsdouble.zqwservice.data.spider.api.SpiderContentServer;
import com.everise.airqualityforecast.commons.domain.ContentSiteBj;
import com.everise.airqualityforecast.commons.domain.ContentSiteDetailBj;
import com.everise.airqualityforecast.commons.domain.WeatherAqiBj;
import com.everise.airqualityforecast.commons.domain.WeatherSummaryBj;
import com.everise.airqualityforecast.commons.mapper.ContentSiteBjMapper;
import com.everise.airqualityforecast.commons.mapper.ContentSiteDetailBjMapper;
import com.everise.airqualityforecast.commons.mapper.WeatherAqiBjMapper;
import com.everise.airqualityforecast.commons.mapper.WeatherSummaryBjMapper;
import com.antsdouble.zqwservice.data.spider.config.SpiderParameter;
import com.antsdouble.zqwservice.data.spider.util.TimeConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

/**
 * @author lyy
 * @description
 * @date 2019/7/17
 */
@Service("SpiderContentServer")
public class SpiderContentServerImpl implements SpiderContentServer {

    @Autowired
    SpiderParameter spiderParameter;

    @Autowired
    ContentSiteBjMapper contentSiteBjMapper;
    @Autowired
    ContentSiteDetailBjMapper contentSiteDetailBjMapper;
    @Autowired
    WeatherAqiBjMapper weatherAqiBjMapper;
    @Autowired
    WeatherSummaryBjMapper weatherSummaryBjMapper;


    @Override
    public String insertSpiderNewData(String strData) {
        String insertId = UUID.randomUUID().toString().replaceAll("-", "");
        JSONObject parse = JSON.parseObject(strData);
        List<ContentSiteDetailBj> detailBjList = new ArrayList<>(50);
        List<WeatherAqiBj> weatherAqiBjsList = new ArrayList<>(5);
        List<WeatherSummaryBj> weatherSummaryBjList = new ArrayList<>(5);

        // 天气aqi
        JSONObject jsonObjectAqi = parse.getJSONObject("result").getJSONObject("data").getJSONObject("aqi");
        WeatherAqiBj weatherAqiBj = new WeatherAqiBj();
        Float o31 = jsonObjectAqi.getFloat("o3");
        weatherAqiBj.setO3(o31);
        Float complexion = jsonObjectAqi.getFloat("complexrank");
        weatherAqiBj.setDayComplex(complexion);
        Float pm101 = jsonObjectAqi.getFloat("pm10");
        weatherAqiBj.setPm10(pm101);
        Float aFloat = jsonObjectAqi.getFloat("74complexrank");
        weatherAqiBj.setComplexRank74(aFloat);
        Float co21 = jsonObjectAqi.getFloat("co");
        weatherAqiBj.setCo(co21);
        Float no21 = jsonObjectAqi.getFloat("no2");
        weatherAqiBj.setNo2(no21);
        Float dayComplex = jsonObjectAqi.getFloat("day_complex");
        weatherAqiBj.setDayComplex(dayComplex);
        Float pm251 = jsonObjectAqi.getFloat("pm2_5");
        weatherAqiBj.setPm25(pm251);
        Float so21 = jsonObjectAqi.getFloat("so2");
        weatherAqiBj.setSo2(so21);
        Float aFloat1 = jsonObjectAqi.getFloat("169complexrank");
        weatherAqiBj.setComplexRank169(aFloat1);
        Float aqi1 = jsonObjectAqi.getFloat("aqi");
        weatherAqiBj.setAqi(aqi1);
        Float rank = jsonObjectAqi.getFloat("rank");
        weatherAqiBj.setAqiRank(rank);
        Float dayAqi = jsonObjectAqi.getFloat("day_aqi");
        weatherAqiBj.setDayAqi(dayAqi);
        Float o38h = jsonObjectAqi.getFloat("o3_8h");
        weatherAqiBj.setO38h(o38h);
        String city = jsonObjectAqi.getString("city");
        weatherAqiBj.setDataCity(city);
        String level1 = jsonObjectAqi.getString("level");
        weatherAqiBj.setQualityLevel(level1);
        String quality1 = jsonObjectAqi.getString("quality");
        weatherAqiBj.setQuality(quality1);
        String dayPoll = jsonObjectAqi.getString("day_poll");
        weatherAqiBj.setDayPoll(dayPoll);
        String primaryPollutant1 = jsonObjectAqi.getString("primary_pollutant");
        weatherAqiBj.setPrimaryPollutants(primaryPollutant1);
        String time1 = jsonObjectAqi.getString("time");
        weatherAqiBj.setDataTime(getDataFromString(time1));
        weatherAqiBj.setGmtCreate(new Date());
        weatherAqiBj.setGmtModified(new Date());
        weatherAqiBj.setId(insertId);
        weatherAqiBjsList.add(weatherAqiBj);
        Integer insertWeatherAqi = weatherAqiBjMapper.insertWeatherAqi(weatherAqiBjsList);

        // 天气
        JSONObject jsonObjectWeather = parse.getJSONObject("result").getJSONObject("data").getJSONObject("weather");
        WeatherSummaryBj weatherSummaryBj=new WeatherSummaryBj();
        String wd = jsonObjectWeather.getString("wd");
        weatherSummaryBj.setWd(wd);
        String weather = jsonObjectWeather.getString("weather");
        weatherSummaryBj.setWeather(weather);
        String time2 = jsonObjectWeather.getString("time");
        weatherSummaryBj.setDataTime(getDataFromString(time2));
        String tq = jsonObjectWeather.getString("tq");
        weatherSummaryBj.setTq(tq);
        Float temp1 = jsonObjectWeather.getFloat("temp");
        weatherSummaryBj.setTemp(temp1);
        Float rain = jsonObjectWeather.getFloat("rain");
        weatherSummaryBj.setRain(rain);
        Float visibility = jsonObjectWeather.getFloat("visibility");
        weatherSummaryBj.setVisibility(visibility);
        Float pressure = jsonObjectWeather.getFloat("pressure");
        weatherSummaryBj.setPressure(pressure);
        Float wDangle = jsonObjectWeather.getFloat("wdangle");
        weatherSummaryBj.setwDangle(wDangle);
        Float wl = jsonObjectWeather.getFloat("wl");
        weatherSummaryBj.setWl(wl);
        Float humI = jsonObjectWeather.getFloat("humi");
        weatherSummaryBj.setHumi(humI);
        Float ws = jsonObjectWeather.getFloat("ws");
        weatherSummaryBj.setWs(ws);
        weatherSummaryBj.setGmtCreate(new Date());
        weatherSummaryBj.setGmtModified(new Date());
        weatherSummaryBj.setDataCity(city);
        weatherSummaryBj.setId(insertId);
        weatherSummaryBjList.add(weatherSummaryBj);
        Integer insertWeatherSummary = weatherSummaryBjMapper.insertWeatherSummary(weatherSummaryBjList);

        //详细信息
        JSONArray jsonArray = parse.getJSONObject("result").getJSONObject("data").getJSONArray("rows");
        for (Object temp : jsonArray) {
            ContentSiteDetailBj contentSiteDetailBj = new ContentSiteDetailBj();
            JSONObject jsonObject = (JSONObject) temp;
            Float o3 = jsonObject.getFloat("o3");
            contentSiteDetailBj.setO3(o3);
            Float zq_aqi = jsonObject.getFloat("zq_aqi");
            contentSiteDetailBj.setZqAqi(zq_aqi);
            String complexIndex = jsonObject.getString("complexindex");
            contentSiteDetailBj.setComplexIndex(complexIndex);
            String latitude = jsonObject.getString("latitude");
            contentSiteDetailBj.setLatitude(latitude);
            Float pm10 = jsonObject.getFloat("pm10");
            contentSiteDetailBj.setPm10(pm10);
            Float co = jsonObject.getFloat("co");
            contentSiteDetailBj.setCo(co);
            Float pm2_5 = jsonObject.getFloat("pm2_5");
            contentSiteDetailBj.setPm25(pm2_5);
            Float no2 = jsonObject.getFloat("no2");
            contentSiteDetailBj.setNo2(no2);
            Float indexation = jsonObject.getFloat("indexratio");
            contentSiteDetailBj.setIndexRatio(indexation);
            Float so2 = jsonObject.getFloat("so2");
            contentSiteDetailBj.setSo2(so2);
            Float aqi = jsonObject.getFloat("aqi");
            contentSiteDetailBj.setAqi(aqi);
            String pointed = jsonObject.getString("pointgid");
            contentSiteDetailBj.setPointgId(pointed);
            String longitude = jsonObject.getString("longitude");
            contentSiteDetailBj.setLongitude(longitude);
            Float ratio = jsonObject.getFloat("ratio");
            contentSiteDetailBj.setRatio(ratio);
            String level = jsonObject.getString("level");
            contentSiteDetailBj.setAirLevel(level);
            String cityName = jsonObject.getString("cityname");
            contentSiteDetailBj.setDataCity(cityName);
            String quality = jsonObject.getString("quality");
            contentSiteDetailBj.setQuality(quality);
            String pointName = jsonObject.getString("pointname");
            contentSiteDetailBj.setDataSite(pointName);
            contentSiteDetailBj.setPointname(pointName);
            String region = jsonObject.getString("region");
            contentSiteDetailBj.setRegion(region);
            String pointLevel = jsonObject.getString("pointlevel");
            if ("国控点".equals(pointLevel)) {
                contentSiteDetailBj.setDataSiteType(1);
            } else if ("省控点".equals(pointLevel)) {
                contentSiteDetailBj.setDataSiteType(2);
            } else {
                contentSiteDetailBj.setDataSiteType(0);

            }
            String primaryPollutant = jsonObject.getString("primary_pollutant");
            contentSiteDetailBj.setPrimaryPollutant(primaryPollutant);
            contentSiteDetailBj.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            String time = jsonObject.getString("time");
            contentSiteDetailBj.setDataTime(getDataFromString(time));
            contentSiteDetailBj.setGmtCreate(new Date());
            contentSiteDetailBj.setGmtModified(new Date());
            contentSiteDetailBj.setDataSourcesType(2);
            detailBjList.add(contentSiteDetailBj);
        }

        Integer contentSiteDetail = contentSiteDetailBjMapper.insertContentSiteDetail(detailBjList);

        return String.format("update data %d rows,aqi%d rows ,site info%d rows",insertWeatherSummary,insertWeatherAqi,contentSiteDetail);
    }



    @Override
    public String insertSpiderHistoryData(String strData) {
        List<ContentSiteBj> contentSiteBjList=new ArrayList<>(50);

        JSONObject parse = JSON.parseObject(strData);
        JSONArray jsonArray = parse.getJSONArray("rows");
        for (Object temp : jsonArray){
            ContentSiteBj contentSiteBj=new ContentSiteBj();
            JSONObject jsonObject = (JSONObject) temp;
            Float aqi = jsonObject.getFloat("aqi");
            contentSiteBj.setAqi(aqi);
            Float pm25 = jsonObject.getFloat("pm2_5");
            contentSiteBj.setPm25(pm25);
            Float pm10 = jsonObject.getFloat("pm10");
            contentSiteBj.setPm10(pm10);
            Float no2 = jsonObject.getFloat("no2");
            contentSiteBj.setNo2(no2);
            Float so2 = jsonObject.getFloat("so2");
            contentSiteBj.setSo2(so2);
            Float o3 = jsonObject.getFloat("o3");
            contentSiteBj.setO3(o3);
            Float co = jsonObject.getFloat("co");
            contentSiteBj.setCo(co);
            String pointName = jsonObject.getString("pointname");
            contentSiteBj.setDataSite(pointName);
            contentSiteBj.setDataSourcesType(2);
            contentSiteBj.setGmtCreate(new Date());
            contentSiteBj.setGmtModified(new Date());
            contentSiteBj.setDataCity(spiderParameter.getCity());
            contentSiteBj.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            contentSiteBj.setDataTime(getDataFromString(spiderParameter.getStartTime()));
            contentSiteBjList.add(contentSiteBj);
        }
        Integer integer = contentSiteBjMapper.insertContentSite(contentSiteBjList);
        return String.format("update data %d rows",integer);
    }
    private Date getDataFromString(String time) {
        try {
            return TimeConvert.stringConvertDate(time, "yyyy-MM-dd HH:mm:ss");
        } catch (ParseException e) {
            return new Date();
        }
    }
}
