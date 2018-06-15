package com.yimew.dao.demo;

import com.yimew.entity.demo.Demo;
import com.yimew.entity.demo.DemoQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DemoDao {
    int countByExample(DemoQuery example);

    int deleteByExample(DemoQuery example);

    int deleteByPrimaryKey(String demoId);

    int insert(Demo record);

    int insertSelective(Demo record);

    List<Demo> selectByExample(DemoQuery example);

    Demo selectByPrimaryKey(String demoId);

    int updateByExampleSelective(@Param("record") Demo record, @Param("example") DemoQuery example);

    int updateByExample(@Param("record") Demo record, @Param("example") DemoQuery example);

    int updateByPrimaryKeySelective(Demo record);

    int updateByPrimaryKey(Demo record);
}