package com.yasin;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author yangzhenkun
 * @create 2018-10-24 16:19
 */
public class StaticLearn {


    public static void main(String[] args) {

        List<Byte> datas = new ArrayList<>();

        Executor pool = Executors.newFixedThreadPool(6);
        for (int j = 0; j < 6; j++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
//           datas.add(newPerson(i));

                    try {
                        work();
//                            byte b = httpGet("http://www.baidu.com", null, null).getBytes()[0];
//                            datas.add(b);
                    } catch (Exception e) {
//                        e.printStackTrace();
                    }

                }
            });
        }

    }

    public static void work() throws Exception {

        for (int i = 0; i < 10000000; i++) {
            String data = httpGet("http://www.baidu.com", null, null);
            work();
        }
    }


    public static byte[] newPerson(int i) {
        byte[] data = new byte[1024];

        if (i % 1024 == 0) {

            System.out.println(i);
        }
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return data;
    }

    public static String httpPost(String url, Map<String, String> params, HttpHost host) throws Exception {
        HttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        ArrayList<NameValuePair> reqParams = null;
        if (params != null && !params.isEmpty()) {
            reqParams = new ArrayList<NameValuePair>();
            for (Map.Entry<String, String> e : params.entrySet()) {
                reqParams.add(new BasicNameValuePair(e.getKey(), e.getValue()));
            }
        }

        if (reqParams != null) {
            httpPost.setEntity(new UrlEncodedFormEntity(reqParams, "UTF-8"));
        }

        // 设置请求头信息，鉴权
        httpPost.setHeader("Authorization", "Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0");
        // 设置配置请求参数
        RequestConfig.Builder builder = RequestConfig.custom().setConnectTimeout(3000)// 连接主机服务超时时间
                .setConnectionRequestTimeout(3000)// 请求超时时间
                .setSocketTimeout(3000);

        if (host != null) {
            builder.setProxy(host);
        }

        RequestConfig requestConfig = builder.build();
        // 为httpPost实例设置配置
        httpPost.setConfig(requestConfig);
        HttpResponse response = null;
        response = client.execute(httpPost);
        HttpEntity httpEntity = response.getEntity();
        return EntityUtils.toString(httpEntity);
    }


    public static String httpGet(String url, String[] params, HttpHost host) throws Exception {
        HttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);


        // 设置请求头信息，鉴权
        httpGet.setHeader("Authorization", "Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0");
        // 设置配置请求参数
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000)// 连接主机服务超时时间
                .setConnectionRequestTimeout(35000)// 请求超时时间
                .setSocketTimeout(60000).setProxy(host)// 数据读取超时时间
                .build();
        // 为httpGet实例设置配置
        httpGet.setConfig(requestConfig);
        HttpResponse response = null;
        response = client.execute(httpGet);
        HttpEntity httpEntity = response.getEntity();
        String data = EntityUtils.toString(httpEntity);
//        httpGet = null;
        return data;
    }


}
