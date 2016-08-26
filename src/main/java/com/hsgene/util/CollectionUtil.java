package com.hsgene.util;

import java.util.Collection;

/**
 * Created by hjc on 2016/8/26.
 */
public class CollectionUtil {

    public static <T> boolean isEmpty(Collection<T> collection) {
        return collection == null || collection.size() == 0;
    }

    public static <T> boolean isNotEmpty(Collection<T> collection) {
        return collection != null && collection.size() > 0;
    }


}
