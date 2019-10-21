package com.antsdouble.factory;


/**
 * @Auther: ants_double
 * @Date: 2018-12-15 21:12
 * @Description:
 */
public class MainboardFactory {
    public static Mainboard createMainboard(int type) {
        Mainboard mainboard = null;
        if (type == 1) {
            mainboard = new IntelMainboard(755);
        } else if (type == 2) {
            mainboard = new AmdMainboard(938);
        }
        return mainboard;
    }
}
