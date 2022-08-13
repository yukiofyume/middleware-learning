package com.lwh.learn.elasticsearch.document;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lwh.learn.elasticsearch.entity.User;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * @author lwh
 * @date 2022年08月13日
 */
public class InsertDocument {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));
        IndexRequest request = new IndexRequest();
        request.index("user").id("1001");
        User user = new User();
        user.setName("zhangsan");
        user.setAge(30);
        user.setSex("男");
        ObjectMapper objectMapper = new ObjectMapper();
        String document = objectMapper.writeValueAsString(user);
        request.source(document, XContentType.JSON);
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        System.out.println(response.getIndex());
        System.out.println(response.getId());
        System.out.println(response.getResult());
        client.close();
    }
}
