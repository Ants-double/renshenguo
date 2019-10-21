package com.antsdouble.zqwservice.data.spider.controller;

import com.antsdouble.zqwservice.data.spider.api.SpiderContentServer;
import com.antsdouble.zqwservice.data.spider.config.SpiderParameter;
import com.antsdouble.zqwservice.data.spider.util.AqiQuerySpider;
import com.antsdouble.zqwservice.data.spider.util.TimeConvert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * @author lyy
 * @description
 * @date 2019/7/15
 */
@RestController
@EnableScheduling
@RequestMapping(value = "task")
public class SpiderTaskController {

    private static Logger logger = LoggerFactory.getLogger(SpiderTaskController.class);
    @Autowired
    SpiderParameter spiderParameter;

    @Autowired
    SpiderContentServer spiderContentServer;

    @RequestMapping(value = "aqistudy", method = RequestMethod.GET)
    public String aqistudy() {
//        logger.info(spiderParameter.toString());
//        // 设置时间
//        LocalDateTime startTime = TimeConvert.stringConvertLocalDateTime(spiderParameter.getStartTime(),
//                "yyyy-MM-dd HH:mm:ss");
//        spiderParameter.setStartTime(TimeConvert.localDateTimeConvertString(startTime, "yyyy-MM-dd HH:mm:ss"));
//        spiderParameter.setEndTime(TimeConvert.localDateTimeConvertString(startTime, "yyyy-MM-dd HH:mm:ss"));
//        logger.info(spiderParameter.toString());
//        AqiQuerySpider aqiQuerySpider = new AqiQuerySpider(spiderParameter);
//        String param = aqiQuerySpider.getData(aqiQuerySpider.postFormData(aqiQuerySpider.getParam()));
//        String result = spiderContentServer.insertSpiderHistoryData(param);
//        startTime = startTime.plusDays(1);
//        spiderParameter.setStartTime(TimeConvert.localDateTimeConvertString(startTime, "yyyy-MM-dd HH:mm:ss"));
//        spiderParameter.setEndTime(TimeConvert.localDateTimeConvertString(startTime, "yyyy-MM-dd HH:mm:ss"));
       return spiderParameter.toString();
    }
    @Scheduled(fixedRate = 300000, initialDelay = 5000)
    public void oneMinuteUpdate() {
        logger.info(spiderParameter.toString());
        // 设置时间
        LocalDate startTime = TimeConvert.stringConvertLocalDate(spiderParameter.getStartTime(),
                "yyyy-MM-dd HH:mm:ss");
        if (startTime.isAfter(LocalDate.now())||startTime.isEqual(LocalDate.now())) {
            logger.info("已统计到当前时间" + LocalDateTime.now());
            return;
        }
        spiderParameter.setStartTime(TimeConvert.localDateConvertString(startTime, "yyyy-MM-dd HH:mm:ss"));
        spiderParameter.setEndTime(TimeConvert.localDateConvertString(startTime, "yyyy-MM-dd HH:mm:ss"));
        logger.info(spiderParameter.toString());
        AqiQuerySpider aqiQuerySpider = new AqiQuerySpider(spiderParameter);
        String param = aqiQuerySpider.getData(aqiQuerySpider.postFormData(aqiQuerySpider.getParam()));
        String result = spiderContentServer.insertSpiderHistoryData(param);
        startTime = startTime.plusDays(1);
        spiderParameter.setStartTime(TimeConvert.localDateConvertString(startTime, "yyyy-MM-dd HH:mm:ss"));
        spiderParameter.setEndTime(TimeConvert.localDateConvertString(startTime, "yyyy-MM-dd HH:mm:ss"));


    }
/*
    @Scheduled(fixedRate = 3600000, initialDelay = 5000)
    public void oneHourUpdate() {
        logger.info(String.format("现在时间是%s", TimeConvert.getTimeStamp()));
        // 取数
        AqiQuerySpider aqiQuerySpider = new AqiQuerySpider(spiderParameter);
        String param = aqiQuerySpider.getData(aqiQuerySpider.postFormData(aqiQuerySpider.getParam()));

        // 存库
        String result = spiderContentServer.insertSpiderNewData(param);
        logger.info(result);

    }

    @Scheduled(cron = "* 10 * * * *")
    public void oneMinuteUpdate() {
        // 设置时间
        // 取数
        AqiQuerySpider aqiQuerySpider = new AqiQuerySpider(spiderParameter);
        String param = aqiQuerySpider.getData(aqiQuerySpider.postFormData(aqiQuerySpider.getParam()));
        // 存库

    }
*/
}
