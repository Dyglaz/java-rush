package com.javarush.task.task35.task3505;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static <K, V extends Convertable<K>> Map<K, V> convert(List<V> list) {
        Map<K, V> result = new HashMap(list.size());

        for (V convertable : list) {
            result.put(convertable.getKey(), convertable);
        }

        return result;
    }
}
