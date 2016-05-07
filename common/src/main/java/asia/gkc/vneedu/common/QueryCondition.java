package asia.gkc.vneedu.common;

import org.springframework.util.StringUtils;

/**
 * File Name: QueryCondition.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @since 5/7/16 1:37 PM
 */

public class QueryCondition {
    private String[] exclude;
    private String[] expand;

    public QueryCondition(String exclude, String expand) {
        if (!StringUtils.isEmpty(exclude))
            this.exclude = exclude.split(",");

        if (!StringUtils.isEmpty(expand))
            this.expand = expand.split(",");
    }

    public String[] getExclude() {
        return exclude == null ? new String[]{} : exclude;
    }

    public void setExclude(String[] exclude) {
        this.exclude = exclude;
    }

    public String[] getExpand() {
        return expand == null ? new String[]{} : expand;
    }

    public void setExpand(String[] expand) {
        this.expand = expand;
    }
}
