/*
 * Copyright 2016 Jakes Lee
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package asia.gkc.vneedu.common;

import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * File Name: QueryCondition.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @since 5/7/16 1:37 PM
 */

public class QueryCondition implements Serializable {
    private String[] exclude;
    private String[] expand;

    public QueryCondition() {
    }

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
