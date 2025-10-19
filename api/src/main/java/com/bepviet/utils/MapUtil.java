package com.bepviet.utils;

import java.util.Map;

public class MapUtil {
    public static <T> T getObject(Map<String, Object> params, String key, Class<T> clazz){
        Object object = params.getOrDefault(key, null);
        if(object != null){
            if(clazz.isEnum()){
                object = Enum.valueOf((Class<Enum>) clazz, object.toString().toUpperCase());
            }
            else if(clazz.getTypeName().equals("java.lang.Long")){
                object = Long.valueOf(object.toString());
            }
            else if(clazz.getTypeName().equals("java.lang.Integer")){
                object = Integer.valueOf(object.toString());
            }
            else if (clazz.getTypeName().equals("java.lang.Double")){
                object = (object != "" ? Double.valueOf(object.toString()) : null);
            }
            else if(clazz.getTypeName().equals("java.lang.String")){
                object = String.valueOf(object);
            }
            return clazz.cast(object);
        }
        return null;
    }
}
