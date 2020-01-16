package com.dsy.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsonTest {
    public static void main(String[] args) {
        JSONObject a = new JSONObject();
        a.put("a", "a");
        JSONArray array = new JSONArray();
        array.add(JSON.toJSONString(a));
        System.out.println(JSON.toJSONString(array));


        String tmp = "[\"{\\\"a\\\":\\\"a\\\"}\"]";
        if (JSON.parse(tmp) instanceof JSONArray){
            System.out.println(111);
            JSONArray jsonArray = JSONArray.parseArray(tmp);
            System.out.println(jsonArray.getString(0));
        }
        if (JSONArray.isValidArray(tmp)){
            System.out.println(222);
        }
    }
}
