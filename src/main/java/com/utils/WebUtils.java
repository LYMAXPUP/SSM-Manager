package com.utils;

import com.alibaba.fastjson.JSONObject;

public class WebUtils {
    public static String returnData(Object obj){
        //返回值做处理
        JSONObject data = (JSONObject) JSONObject.toJSON(obj);
        return data.toString();
    }
}
