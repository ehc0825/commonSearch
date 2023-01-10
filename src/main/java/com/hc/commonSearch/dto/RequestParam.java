package com.hc.commonSearch.dto;

import lombok.Data;

@Data
public class RequestParam {

    private String query;

    private boolean research;

    private String sort;

}
