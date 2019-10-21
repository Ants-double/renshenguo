package com.antsdouble.zqwservice.data.spider.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

/**
 * @author lyy
 * @description
 * @date 2019/7/16
 */
@Controller
public class SpiderParameter {

    @Value("${spider.flag}")
    @Getter
    private String flag;
    @Getter
    @Setter
    @Value("${spider.startTime}")
    private String startTime;
    @Getter
    @Setter
    @Value("${spider.endTime}")
    private String endTime;
    @Getter
    @Setter
    @Value("${spider.timePoint}")
    private String timePoint;
    @Getter
    @Value("${spider.city}")
    private String city;

    @Override
    public String toString() {
        return "SpiderParameter{" +
                "flag='" + flag + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", timePoint='" + timePoint + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
