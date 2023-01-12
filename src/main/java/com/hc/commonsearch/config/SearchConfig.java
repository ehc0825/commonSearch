package com.hc.commonsearch.config;

public interface SearchConfig {

    String SEARCH_INDEX = "index";

    int SEARCH_SIZE = 10;
    int NAVI_SIZE = 5;

    String REGION_FIELD = "region";
    String PRICE_FIELD = "price";
    String DATE_FIELD = "createDate";
    String CATEGORY_FIELD = "category";
    String DEFAULT_SEARCH_FIELD = "field";

    String HIGHLIGHT_COLOR = "red";
    String HIGHLIGHT_PRE_TAG = "<strong style=\"color:" + HIGHLIGHT_COLOR + ";\">";
    String HIGHLIGHT_POST_TAG = "</strong>";
    String[] HIGHLIGHT_FIELDS = {"field1", "field2"};
    int HIGHLIGHT_NUM_OF_FRAGMENTS = 1;
    int HIGHLIGHT_NO_MATCH_SIZE = 250;
    int HIGHLIGHT_FRAGMENT_SIZE = 250;

}
