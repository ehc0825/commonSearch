package com.hc.commonsearch.util.query.highlight;

import com.hc.commonsearch.dto.SearchParam;
import lombok.experimental.UtilityClass;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;

import static com.hc.commonsearch.config.SearchConfig.*;


@UtilityClass
public class HighlightQueryBuilder{

    public SearchParam buildHighlightQuery(SearchParam searchParam) {
        HighlightBuilder highlightBuilder = new HighlightBuilder();

        highlightBuilder.preTags(HIGHLIGHT_PRE_TAG)
                .postTags(HIGHLIGHT_POST_TAG)
                .numOfFragments(HIGHLIGHT_NUM_OF_FRAGMENTS)
                .noMatchSize(HIGHLIGHT_NO_MATCH_SIZE)
                .fragmentSize(HIGHLIGHT_FRAGMENT_SIZE);

        searchParam.setSearchSourceBuilder(searchParam.getSearchSourceBuilder()
                .highlighter(setHighlightFields(highlightBuilder)));
        return searchParam;
    }

    private HighlightBuilder setHighlightFields(HighlightBuilder highlightBuilder) {

        for (String field : HIGHLIGHT_FIELDS) {
            highlightBuilder.field(field);
        }

        return highlightBuilder;
    }


}
