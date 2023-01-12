package com.hc.commonsearch.util.query.highlight;

import com.hc.commonsearch.config.SearchConfig;
import com.hc.commonsearch.dto.SearchParam;
import lombok.experimental.UtilityClass;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;


@UtilityClass
public class HighlightQueryBuilder implements SearchConfig {

    public SearchParam buildHighlightQuery(SearchParam searchParam) {
        HighlightBuilder highlightBuilder = new HighlightBuilder();

        highlightBuilder.preTags(HIGHLIGHT_PRE_TAG)
                .postTags(HIGHLIGHT_POST_TAG)
                .numOfFragments(HIGHLIGHT_NUM_OF_FRAGMENTS)
                .noMatchSize(HIGHLIGHT_NO_MATCH_SIZE)
                .fragmentSize(HIGHLIGHT_FRAGMENT_SIZE);

        setHighlightFields(HIGHLIGHT_FIELDS, highlightBuilder);

        return searchParam;
    }

    private HighlightBuilder setHighlightFields(String[] fields, HighlightBuilder highlightBuilder) {

        for (String field : fields) {
            highlightBuilder.field(field);
        }

        return highlightBuilder;
    }


}
