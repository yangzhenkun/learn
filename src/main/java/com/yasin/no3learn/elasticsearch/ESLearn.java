package com.yasin.no3learn.elasticsearch;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.script.Script;
import org.elasticsearch.script.ScriptType;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

import static java.util.Collections.singletonMap;

/**
 * @author yangzhenkun
 * @create 2018-10-31 18:10
 */
public class ESLearn {

    public RestHighLevelClient getClient() {

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));

        return client;
    }



    @Test
    public void get(){

        RestHighLevelClient restHighLevelClient = getClient();

        GetRequest request = new GetRequest("movies","movie","1");

        try {
            GetResponse getResponse = restHighLevelClient.get(request);

            System.out.println(JSON.toJSONString(getResponse.getSourceAsString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void upsert(){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","yasin");
        jsonObject.put("age",10);


        UpdateRequest brandUp = new UpdateRequest("chelib", "brand", "1");
        /**
         * 不存在该数据就插入
         */
        brandUp.upsert(jsonObject.toJSONString(), XContentType.JSON);

        Map<String, Object> parameters = singletonMap("count", 4);//脚本参数
        //使用painless语言和上面的参数创建一个内联脚本
        Script stored =
                new Script(ScriptType.STORED, null, "increment-field", parameters);
        brandUp.script(stored);

        try {
            UpdateResponse updateResponse = getClient().update(brandUp);
            System.out.println(JSON.toJSONString(updateResponse));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}
