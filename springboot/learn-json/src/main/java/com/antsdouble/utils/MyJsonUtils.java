package com.antsdouble.utils;

import com.alibaba.fastjson.serializer.SerializerFeature;

public class MyJsonUtils {
    public static  final SerializerFeature[] FEATURES={
            SerializerFeature.WriteMapNullValue,
            SerializerFeature.WriteNullListAsEmpty,
            SerializerFeature.WriteNullBooleanAsFalse,
            SerializerFeature.WriteNullNumberAsZero,
            SerializerFeature.WriteNullStringAsEmpty,
            SerializerFeature.WriteDateUseDateFormat
    };
}
