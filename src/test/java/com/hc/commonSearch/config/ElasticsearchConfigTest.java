package com.hc.commonSearch.config;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ElasticsearchConfigTest {
    @Autowired
    RestHighLevelClient client;

    @Test
    void testElasticsearchConnection(){
        boolean success= false;
        SearchRequest searchRequest = new SearchRequest();
        try {
            client.search(searchRequest, RequestOptions.DEFAULT);
            success=true;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        assertThat(success).isTrue();
    }

}