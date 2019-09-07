package com.xingyun.struts2.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.xingyun.struts2.model.MessageStore;

/**
 * @author 星云
 * @功能
 * @日期和时间 9/7/2019 12:40 PM
 */
public class HelloWorldAction extends ActionSupport {
    private MessageStore messageStore;

    @Override
    public String execute() {
        messageStore = new MessageStore() ;

        return SUCCESS;
    }

    public MessageStore getMessageStore() {
        return messageStore;
    }
}
