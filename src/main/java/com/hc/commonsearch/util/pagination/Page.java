package com.hc.commonsearch.util.pagination;

import com.hc.commonsearch.config.SearchConfig;
import lombok.Data;

@Data
public class Page implements SearchConfig {

    private int currentPage;
    private int totalCount;
    private int naviSize = NAVI_SIZE;
    private int pageSize = SEARCH_SIZE;
    private int totalPage;
    private int beginPage;
    private int endPage;
    private boolean showPrev;
    private boolean showNext;

    public Page(int totalCount, int currentPage) {
        this.totalCount = totalCount;
        this.currentPage = currentPage;

        pagination(totalCount, currentPage);
    }

    private void pagination(int totalCount, int currentPage) {
        this.totalPage = (int) Math.ceil((double) totalCount / pageSize);
        this.beginPage = (currentPage - 1) / naviSize * naviSize + 1;
        this.endPage = Math.min(beginPage + naviSize - 1, totalPage);
        this.showPrev = (beginPage != 1);
        this.showNext = (endPage != totalPage);
    }

}
