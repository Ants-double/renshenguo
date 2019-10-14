package com.antsdouble.grib2jsonweb.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author lyy
 * @description
 * @date 2019/8/14
 */
@Component
public class Windparameter {

    @Setter
    @Getter
    @Value("${wind.rootDir}")
    private String rootDirectory;

}
