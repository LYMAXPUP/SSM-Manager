package com.utils;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * JSON工具类
 */
public class JsonUtils {
    /**
     * 输出JSON
     *
     * @param response HttpServletResponse
     * @param data     JSON数据
     * @throws IOException IO异常
     */
    public static void outJson(HttpServletResponse response, JSONObject data) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.write(data.toString());
        writer.flush();
    }

}
