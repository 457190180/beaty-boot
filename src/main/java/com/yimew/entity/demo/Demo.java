package com.yimew.entity.demo;

import java.io.Serializable;
import java.util.Date;

public class Demo implements Serializable {
    private String demoId;

    private String demoIntro;

    private Date createTime;

    private Date updateTime;

    private String createBy;

    private String updateBy;

    private static final long serialVersionUID = 1L;

    public String getDemoId() {
        return demoId;
    }

    public void setDemoId(String demoId) {
        this.demoId = demoId == null ? null : demoId.trim();
    }

    public String getDemoIntro() {
        return demoIntro;
    }

    public void setDemoIntro(String demoIntro) {
        this.demoIntro = demoIntro == null ? null : demoIntro.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", demoId=").append(demoId);
        sb.append(", demoIntro=").append(demoIntro);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}