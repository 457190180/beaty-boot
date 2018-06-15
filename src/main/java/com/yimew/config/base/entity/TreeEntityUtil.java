//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.yimew.config.base.entity;

import com.yimew.utils.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class TreeEntityUtil<T extends TreeEntity> {
    public TreeEntityUtil() {
    }

    public Map<String, T> asMapById(List<T> list) {
        Map<String, T> map = new HashMap();
        if (CollectionUtils.isNotEmpty(list)) {
            Iterator i$ = list.iterator();

            while(i$.hasNext()) {
                T treeEntity = (T) i$.next();
                map.put(treeEntity.getId(), treeEntity);
            }
        }

        return map;
    }

    public T organizeListAsTree(T topElement, List<T> list) {
        Map<String, List<T>> childListByParentId = this.organizeListAsMapByParentId(list);
        this.recursionChildList(childListByParentId, topElement);
        return topElement;
    }

    private Map<String, List<T>> organizeListAsMapByParentId(List<T> list) {
        Map<String, List<T>> childListMap = new HashMap();
        Iterator i$ = list.iterator();

        while(i$.hasNext()) {
            T treeEntity = (T) i$.next();
            String parentId = treeEntity.getParentId();
            if (StringUtils.isNotEmpty(parentId)) {
                Object childList;
                if (childListMap.containsKey(parentId)) {
                    childList = (List)childListMap.get(parentId);
                } else {
                    childList = new ArrayList();
                }

                ((List)childList).add(treeEntity);
                childListMap.put(parentId, (List<T>) childList);
            }

            treeEntity.setChildList((List)null);
            treeEntity.setParent((TreeEntity)null);
        }

        return childListMap;
    }

    private void recursionChildList(Map<String, List<T>> childListMap, T parent) {
        if (childListMap != null && childListMap.containsKey(parent.getId())) {
            parent.setChildList((List)childListMap.get(parent.getId()));
        }

        if (parent.getChildList() != null && !parent.getChildList().isEmpty()) {
            for(int i = 0; i < parent.getChildList().size(); ++i) {
                T child = (T) parent.getChildList().get(i);
                this.recursionChildList(childListMap, child);
            }

        }
    }

    public void sortList(List<T> list, List<T> sourcelist, String parentId) {
        for(int i = 0; i < sourcelist.size(); ++i) {
            T e = (T) sourcelist.get(i);
            if (e.getParent() != null && e.getParent().getId() != null && e.getParent().getId().equals(parentId)) {
                list.add(e);

                for(int j = 0; j < sourcelist.size(); ++j) {
                    T childe = (T) sourcelist.get(j);
                    if (childe.getParent() != null && childe.getParent().getId() != null && childe.getParent().getId().equals(e.getId())) {
                        this.sortList(list, sourcelist, e.getId());
                        break;
                    }
                }
            }
        }

    }
}
