package com.xingyun.struts2.model;

/**
 * @功能
 * @作者 @author星云
 * @日期和时间 9/7/2019 12:38 PM
 */
public class MessageStore {
    private String message;
    public MessageStore() {
        message = "Hello Struts User";
    }

    public String getMessage() {
        return message;
    }
}
