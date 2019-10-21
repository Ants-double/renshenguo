package com.antsdouble.prototype.twoprototype;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: ants_double
 * @Date: 2018-12-16 11:02
 * @Description:
 */
public class PrototypeManager {
    private static Map<String, Prototype> map = new HashMap<String, Prototype>();

    private PrototypeManager() {
    }

    public synchronized static void setPrototype(String prototypeId, Prototype prototype) {
        map.put(prototypeId, prototype);
    }

    public synchronized static void removePrototype(String prototypeId) {
        map.remove(prototypeId);
    }

    public synchronized static Prototype getPrototype(String prototypeId) throws Exception {
        Prototype prototype = map.get(prototypeId);
        if (prototype == null) {
            throw new Exception("你希望的原型还没有创建或者已删除");
        }
        return prototype;
    }
}
