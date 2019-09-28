package com.benqio.push.portal.demo;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.*;
import java.util.stream.Collectors;

public class JsonArrayDemo {

    public static void main(String[] args) {

        System.out.println(setMin(getTypeConfig(1),2));
        System.out.println(setMax(getTypeConfig(1), 2));


    }

    public static String[] getTypeConfig(int typeConfigPrefix){
        String typeConfig = "[{1:\"0,50,100,200\"},{2:\"0,50,100,300\"}]";
        List<String> list = JSONArray.parseArray(typeConfig, String.class);
        String[] array = list.toArray(new String[list.size()]);
        JSONObject jsonObject = JSONObject.parseObject(array[typeConfigPrefix - 1]);
        return jsonObject.get(typeConfigPrefix).toString().split(",");
    }

    public static Integer setMax(String[] array ,int nameCode){
        return Integer.valueOf(array[nameCode]);
    }

    public static Integer setMin(String[] array ,int nameCode){

        return Integer.valueOf(array[nameCode-1]);
    }


}
