package com.yimew.entity.wechatBase;

import com.yimew.web.Const;

import javax.validation.constraints.NotNull;

public class TplMsg {
    private String touser;
    private String template_id= Const.WEICHAT.TEMPLATE_ID;
    private String page =Const.WEICHAT.PAGE;
    private String form_id;
    @NotNull(message = "userCode不能为null")
    private String userCode;

    private TplData data;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getForm_id() {
        return form_id;
    }

    public void setForm_id(String form_id) {
        this.form_id = form_id;
    }

    public TplData getData() {
        return data;
    }

    public void setData(TplData data) {
        this.data = data;
    }
}
