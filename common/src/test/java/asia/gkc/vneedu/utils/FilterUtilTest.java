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

package asia.gkc.vneedu.utils;

import asia.gkc.vneedu.model.User;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by jakes on 4/7/16.
 */
public class FilterUtilTest {
    @Test
    public void exclude() throws Exception {
        User user = new User();
        user.setAtId("10");
        user.setScore(20);
        FilterUtil.exclude(Arrays.asList("atId", "score"), user);

        assertNull(user.getAtId());

        assertNull(user.getScore());
    }

}