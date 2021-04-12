package com.tjy.util;

import java.util.ArrayList;
import java.util.List;

public class ClassTimeUtil {

    public static List<String> list;

    public static List<String> getClassList() {
        list = new ArrayList<>();
        list.add("一二节");
        list.add("三四节");
        list.add("五六节");
        list.add("七八节");
        return list;
    }
}
