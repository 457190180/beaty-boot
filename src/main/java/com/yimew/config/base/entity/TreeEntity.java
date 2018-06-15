//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.yimew.config.base.entity;

import java.util.List;

public abstract class TreeEntity<T extends TreeEntity> extends BaseEntity {
    protected String id;
    protected String name;
    protected String parentId;
    protected String parentIds;
    protected T parent;
    protected List<T> childList;
    protected Integer delFlag;

    public TreeEntity() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return this.parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return this.parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<T> getChildList() {
        return this.childList;
    }

    public void setChildList(List<T> childList) {
        this.childList = childList;
    }

    public T getParent() {
        return this.parent;
    }

    public void setParent(T parent) {
        this.parent = parent;
    }

    public Integer getDelFlag() {
        return this.delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}
