package com.hc.commonSearch.dao;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SearchDao {

    @Autowired
    RestHighLevelClient client;



}
