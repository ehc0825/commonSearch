package com.hc.commonsearch.service;

import com.hc.commonsearch.dao.SearchDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

    @Autowired
    SearchDao searchDao;



}
