package com.lwh.learn.elasticsearch.index;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

import java.io.IOException;

/**
 * @author lwh
 * @date 2022年08月13日
 */
public class SearchIndex {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));
        // 查询索引
        GetIndexRequest request = new GetIndexRequest("user2");
        GetIndexResponse response = client.indices().get(request, RequestOptions.DEFAULT);
        System.out.println("aliases: " + response.getAliases());
        System.out.println("mappings: " + response.getMappings());
        System.out.println("settings: " + response.getSettings());
        client.close();
    }
}
