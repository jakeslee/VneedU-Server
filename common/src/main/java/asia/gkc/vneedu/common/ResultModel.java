package asia.gkc.vneedu.common;

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

    public Object getRetData() {
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
