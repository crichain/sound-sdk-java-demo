package com.crichain.sdk.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;

import java.io.*;

/**
 * 读取json文件
 *
 * @author admin
 */
@Controller
public class ReadJsonUtil {
//    /**
//     * 读取json文件
//     *
//     * @param fileName
//     * @return
//     */
//    public static String readJsonFile(String fileName) {
//        String jsonStr = "";
//        try {
//            File jsonFile = new File(fileName);
//            FileReader fileReader = new FileReader(jsonFile);
//            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
//            int ch = 0;
//            StringBuffer sb = new StringBuffer();
//            while ((ch = reader.read()) != -1) {
//                sb.append((char) ch);
//            }
//            fileReader.close();
//            reader.close();
//            jsonStr = sb.toString();
//            return jsonStr;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    /**
//     * 获取abi
//     *
//     * @param path 路径
//     * @return string abiJSON数组
//     */
//    public static String getAbiArray(String path) {
//        if ("".equals(path)) {
//            return null;
//        }
//        String jsonFile = readJsonFile(path);
//        JSONObject json = JSON.parseObject(jsonFile);
//        JSONArray abi = json.getJSONArray("abi");
//        return abi.toString();
//    }
//
//    /**
//     * 获取JSON文件中指定属性值
//     *
//     * @param path 文件路径
//     * @param param 属性值
//     * @return String
//     */
//    public static String getJson(String path, String param) {
//        if ("".equals(path) || "".equals(param)) {
//            return null;
//        }
//        String jsonFile = readJsonFile(path);
//        JSONObject json = JSON.parseObject(jsonFile);
//        return json.getString(param);
//    }
//
//    /**
//     * 获取abi数组中指定方法的FunctionType
//     * @param path 文件路径
//     * @param searchMethod 方法名
//     * @return String
//     */
//    public static String getFunctionType(String path, String searchMethod){
//        if ("".equals(path) || "".equals(searchMethod)) {
//            return null;
//        }
//        String jsonFile = readJsonFile(path);
//        JSONObject json = JSON.parseObject(jsonFile);
//        JSONArray abi = json.getJSONArray("abi");
//        for (int i = 0; i < abi.size(); i++) {
//            JSONObject jsonObject = abi.getJSONObject(i);
//            if (searchMethod.equals(jsonObject.getString("name"))){
//                return jsonObject.getString("stateMutability");
//            }
//        }
//        return null;
//    }
}
