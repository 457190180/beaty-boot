package com.yimew.dao.sys;

import com.yimew.entity.sys.Log;
import com.yimew.entity.sys.LogQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogDao {
    int countByExample(LogQuery example);

    int deleteByExample(LogQuery example);

    int deleteByPrimaryKey(String logId);

    int insert(Log record);

    int insertSelective(Log record);

    List<Log> selectByExample(LogQuery example);

    Log selectByPrimaryKey(String logId);

    int updateByExampleSelective(@Param("record") Log record, @Param("example") LogQuery example);

    int updateByExample(@Param("record") Log record, @Param("example") LogQuery example);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);
}