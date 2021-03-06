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

import asia.gkc.vneedu.common.property.CdnProperties;
import com.qiniu.util.StringMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * File Name: ResultModel.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/5/16 2:43 PM
 */

@Component
public class ResultModel {
    /**
     * 返回码
     */
    private int error;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回数据
     */
    private Map<String, Object> retData = new HashMap<>();

    private static Map<String, Object> cdnData;

    @Autowired
    public ResultModel(CdnProperties cdnProperties) {
        ResultModel.cdnData = new HashMap<>();
        ResultModel.cdnData.put("cdn", new StringMap()
                .put("cdn_enable", cdnProperties.isCdnEnabled())
                .put("local", cdnProperties.getLocalStorageProperties().getUrlPath() + "/" +
                        cdnProperties.getLocalStorageProperties().getStoreInDir())
                .put("qiniu", cdnProperties.getQiniuProperties().getUrlPath()).map()
        );
    }

    public ResultModel() {
        this(ResultStatus.SUCCESS);
    }

    public ResultModel(int error, String message) {
        this.error = error;
        this.message = message;
    }

    public ResultModel(Map<String, Object> retData, String message, int error) {
        this.retData.putAll(retData);
        this.retData = retData;
        this.message = message;
        this.error = error;
    }

    public ResultModel(ResultStatus resultStatus) {
        this.error = resultStatus.getError();
        this.message = resultStatus.getMessage();
        if (ResultModel.cdnData != null) {
            this.retData.putAll(ResultModel.cdnData);
        }
    }

    public ResultModel(ResultStatus resultStatus, String retData) {
        this(resultStatus);
        this.retData.put("data", retData);
    }

    public ResultModel(ResultStatus resultStatus, Map<String, Object> retData) {
        this(resultStatus);
        this.retData.putAll(retData);
    }

    public ResultModel(ResultStatus resultStatus, String key, Object data) {
        this(resultStatus);
        this.retData.put(key, data);
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getRetData() {
        return retData;
    }

    public void setRetData(Map<String, Object> retData) {
        this.retData = retData;
    }

    /**
     * retData增加一项
     * @param key - 属性
     * @param data - 对应值
     */
    public void addData(String key, Object data) {
        this.retData.put(key, data);
    }

    /**
     * ResultModel 构造方法
     * @return ResultModel
     */

    public static ResultModel OK() {
        return new ResultModel();
    }

    public static ResultModel SUCCESS(Map<String, Object> retData) {
        return new ResultModel(ResultStatus.SUCCESS, retData);
    }

    public static ResultModel SUCCESS(String retData) {
        return new ResultModel(ResultStatus.SUCCESS, retData);
    }

    public static ResultModel SUCCESS(String key, Object data) {
        return new ResultModel(ResultStatus.SUCCESS, key, data);
    }

    public static ResultModel ERROR(ResultStatus r) {
        return new ResultModel(r);
    }
}
