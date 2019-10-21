package com.antsdouble.singles;

/**
 * @ClassName SimpleSingle
 * @Description 私有构造器版本
 * @date 4/3/2019
 * @Author liyy
 * @Version 1.0
 */
public class SimpleSingle {

    private  static SimpleSingle instance;
    private SimpleSingle(){}

    public static SimpleSingle getInstance(){
        //多线程的时候会出问题
        if (null==instance){
            instance=new SimpleSingle();
        }
        return instance;
    }
}
