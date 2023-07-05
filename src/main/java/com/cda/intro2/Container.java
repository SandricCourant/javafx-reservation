package com.cda.intro2;

import java.util.HashMap;

public class Container {
    private static Container container;
    private final HashMap<Class, Object> objects = new HashMap<>();

    private Container(){}
    public static Container getInstance() {
        if (container == null) {
            container = new Container();
        }
        return container;
    }
    public void register(Class c,Object o) {
        objects.put(c, o);
    }
    public <T> T get(Class<T> c) {
        Object registeredObject = objects.get(c);
        return c.cast(registeredObject);
    }
}
