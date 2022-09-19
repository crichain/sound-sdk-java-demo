package com.crichain.sdk.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;


/**
 * @author Administrator
 */
public class HttpClientUtil {

    /**
     * 发送 get 请求（无参数）
     *
     * @param url
     * @throws IOException
     */
    public static JSONObject doGet(String url) throws IOException {
        return doGet(url, new HashMap<>());
    }

    /**
     * 发送 get 请求（有参数）
     *
     * @param url
     * @param params
     * @throws IOException
     */
    public static JSONObject doGet(String url, Map<String, Object> params) {
        if (params.size() > 0) {
            url = url + "?" + handleParams(params);
        }
        //start get
        //1、创建客户端
        CloseableHttpResponse response = null;
        String result = null;
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            // 超时设置（可不设置）
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000) //连接超时
                    .setConnectionRequestTimeout(5000)//请求超时
                    .setSocketTimeout(5000)
                    .setRedirectsEnabled(true)  //允许自动重定向
                    .build();
            //2、创建Http的请求方式get,post etc... 需要传入请求地址
            HttpGet httpGet = new HttpGet(url);
            httpGet.setConfig(requestConfig);// 设置配置
            httpGet.setHeader("x-request-id", UUID.randomUUID().toString());
            //3、httpClient执行请求,并获取返回结果
            response = httpClient.execute(httpGet);
            //4、输出获取到的结果
            //从response中取出返回的entity
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity);
            //输出
            //System.out.println("get返回状态行:"+response.getStatusLine());
            //System.out.println("get返回结果:"+ result);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            5、关闭连接 也可以直接调用close（）方法
            HttpClientUtils.closeQuietly(response);
        }

//        Map<String, Object> map = new HashMap<>();
//        map.put("result", JSON.parseObject(result, Map.class));
//        map.put("status", response.getStatusLine().getStatusCode());
        return JSON.parseObject(result);
    }

    /**
     * 拼接 get参数
     *
     * @param params
     * @return
     */
    private static String handleParams(Map<String, Object> params) {
        // 处理参数
        StringBuffer buffer = new StringBuffer();
        if (params.size() > 0) {
            Iterator<Map.Entry<String, Object>> iterator = params.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Object> entry = iterator.next();
                buffer.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
        }
        return buffer.toString().substring(0, buffer.length() - 1);
    }

    /**
     * 发送 post 请求（无参数）
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static JSONObject doPost(String url) throws IOException {
        return doPost(url, new HashMap<>());
    }

    /**
     * 发送 post 请求（有参数）
     *
     * @param url
     * @param params
     * @return
     * @throws IOException
     */
    public static JSONObject doPost(String url, Map<String, Object> params) {
        CloseableHttpResponse response = null;
        String result = null;
        try {
            //start post
            //1、创建客户端
            CloseableHttpClient httpClient = HttpClients.createDefault();
            // 超时设置（可不设置）
            //连接超时
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000)
                    //请求超时
                    .setConnectionRequestTimeout(5000)
                    .setSocketTimeout(5000)
                    //允许自动重定向
                    .setRedirectsEnabled(true)
                    .build();
            //1、创建post请求
            HttpPost httpPost = new HttpPost(url);
            // 设置配置
            httpPost.setConfig(requestConfig);
            // 表单提交，默认方式是 json 格式
            httpPost.addHeader("Content-Type", "application/json; chartset=UTF-8");
            httpPost.addHeader("x-request-id", UUID.randomUUID().toString());
            //2、设置请求参数HttpEntity
            //StringEntity的方式,这种方式比较自由，可以传输自定义的数据格式，只需要后台能处理即可
            //这种方式是真正的post请求，请求参数是防止body中，后台通过流的方式获取数据
            //JSONObject使用阿里巴巴的fastjson
            //创建StringEntity，并设置ContentType
            String jsonString = JSON.toJSONString(params);
            StringEntity stringEntity = new StringEntity(jsonString, ContentType.APPLICATION_JSON);
            //stringEntity加入http中
            httpPost.setEntity(stringEntity);
            //3、发送http请求
            response = httpClient.execute(httpPost);
            //4、获取返回结果
            result = EntityUtils.toString(response.getEntity());
            //5、输出结果
            //System.out.println("StringEntity返回状态行:"+response.getStatusLine());
            //System.out.println("StringEntity返回结果:"+result);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6、关闭
            HttpClientUtils.closeQuietly(response);
        }

        //end post

//        Map<String, Object> map = new HashMap<>();
//        map.put("result", JSON.parseObject(result, Map.class));
//        map.put("status", response.getStatusLine().getStatusCode());
        return JSON.parseObject(result);
    }
}
