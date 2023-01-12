package com.hc.commonsearch.config;

public final class SearchConfig {

    public static final String SEARCH_INDEX = "index";

    public static final int SEARCH_SIZE = 10;
    public static final int NAVI_SIZE = 5;

    public static final String REGION_FIELD = "region";
    public static final String PRICE_FIELD = "price";
    public static final String DATE_FIELD = "createDate";
    public static final String CATEGORY_FIELD = "category";
    public static final String DEFAULT_SEARCH_FIELD = "field";

    public static final String HIGHLIGHT_COLOR = "red";
    public static final String HIGHLIGHT_PRE_TAG = "<strong style=\"color:" + HIGHLIGHT_COLOR + ";\">";
    public static final String HIGHLIGHT_POST_TAG = "</strong>";
    public static final String[] HIGHLIGHT_FIELDS = {"field1", "field2"};
    public static final int HIGHLIGHT_NUM_OF_FRAGMENTS = 1;
    public static final int HIGHLIGHT_NO_MATCH_SIZE = 250;
    public static final int HIGHLIGHT_FRAGMENT_SIZE = 250;

    private SearchConfig(){
        throw new IllegalStateException("Can not be instantiated");
    }

}
