//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.yimew.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtils extends org.apache.commons.lang3.StringUtils {
    public StringUtils() {
    }

    public static String listToString(List<String> stringList) {
        if (CollectionUtils.isEmpty(stringList)) {
            return null;
        } else {
            StringBuilder builder = new StringBuilder();

            for(int i = 0; i < stringList.size(); ++i) {
                builder.append((String)stringList.get(i));
                if (i < stringList.size() - 1) {
                    builder.append(",");
                }
            }

            return builder.toString();
        }
    }

    public static List<String> stringToList(String string) {
        return isEmpty(string) ? null : Arrays.asList(string.split(","));
    }

    public static List<Integer> stringToIntList(String string) {
        if (isEmpty(string)) {
            return null;
        } else {
            List<Integer> integerList = new ArrayList();
            String[] stringArray = string.split(",");

            for(int i = 0; i < stringArray.length; ++i) {
                String str = stringArray[i];
                if (isNotEmpty(str)) {
                    integerList.add(Integer.valueOf(str));
                }
            }

            return integerList;
        }
    }

    public static String FilterNull(Object o) {
        return o != null && !"null".equals(o.toString()) ? o.toString().trim() : "";
    }

    public static boolean isEmptyWithFilterNull(Object o) {
        if (o == null) {
            return true;
        } else {
            return "".equals(FilterNull(o.toString()));
        }
    }
}
