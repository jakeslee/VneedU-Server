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

/**
 * File Name: ResultStatus.java
 * Function:
 *
 * @author jakes.
 * @version 1.0
 * @DateTime 4/5/16 3:17 PM
 */

public enum ResultStatus {
    SUCCESS(0, "Success"),
    /**
     * 通用错误
     */
    RESOURCE_NOT_FOUND(1000, "RESOURCE NOT FOUND"),
    BAD_REQUEST(1001, "BAD REQUEST"),
    REPETITIVE_OPERATION(1002, "REPETITIVE OPERATION"),

    /**
     * 需求操作错误
     */
    CATEGORY_NOT_EXIST(2000, "CATEGORY NOT EXIST"),
    FIELD_REQUIRED(2001, "Required field must be provided"),
    NICE_NOT_ONCE(2002, "You have done it before"),
    REQUIREMENT_NOT_EXIST(2003, "Requirement not exist"),
    STATUS_ERROR(2004, "Status error"),
    INCORRECT_PRICE(2005, "INCORRECT PRICE"),
    INCORRECT_PAY_METHOD(2006, "INCORRECT PAY METHOD"),

    /**
     * 文件操作错误
     */
    FILE_ID_INCORRECT(3000, "User file id error"),
    FILE_TYPE_NOT_ALLOWED(3001, "Type of file not allowed"),
    FILE_SIZE_NOT_ALLOWED(3002, "Size of file not allowed"),
    ERROR_IN_TYPE_OF_SEARCHING(3003, "Type searching not allowed"),
    EMPTY_FILE(3004, "EMPTY FILE"),

    /**
     * 用户操作错误
     */
    PHONE_REQUIRED(4000, "PHONE REQUIRED"),
    PHONE_EXISTS(4001, "PHONE EXISTS"),
    PASSWORD_EMPTY(4002, "PASSWORD EMPTY"),
    PASSWORD_LENGTH_ERROR(4003, "PASSWORD LENGTH ERROR"),
    PHONE_ILLEGAL(4004, "PHONE ILLEGAL"),
    OPERATION_DENIED(4005, "OPERATION DENIED"),
    CODE_ERROR(4006, "CODE ERROR"),
    TOKEN_EXISTS(4007, "TOKEN EXISTS"),
    ERROR_IN_SAVING(4008, "ERROR IN SAVING"),

    /**
     * 授权操作错误
     */
    AUTHORIZATION_TIMEOUT(5000, "AUTHORIZATION TIMEOUT"),
    UNAUTHORIZED(5001, "UNAUTHORIZED"),
    PERMISSION_DENIED(5002, "PERMISSION DENIED"),
    AUTHORIZATION_HEADER_ERROR(5003, "AUTHORIZATION HEADER ERROR"),
    AUTHORIZATION_TOKEN_ERROR(5004, "AUTHORIZATION TOKEN ERROR"),
    AUTHORIZATION_PASSWORD_ERROR(5005, "AUTHORIZATION PASSWORD ERROR"),

    ;

    private int error;

    private String message;

    ResultStatus(int error, String message) {
        this.error = error;
        this.message = message;
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
}
