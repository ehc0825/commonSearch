package com.hc.commonSearch.service;

import com.hc.commonSearch.dao.SearchDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

    @Autowired
    SearchDao searchDao;



}
