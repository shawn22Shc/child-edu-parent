package com.xsx.ce.mapper;

import com.xsx.ce.pojo.ReWatchLog;
import com.xsx.ce.pojo.ReWatchLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReWatchLogMapper {
    int countByExample(ReWatchLogExample example);

    int deleteByExample(ReWatchLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReWatchLog record);

    int insertSelective(ReWatchLog record);

    List<ReWatchLog> selectByExample(ReWatchLogExample example);

    ReWatchLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReWatchLog record, @Param("example") ReWatchLogExample example);

    int updateByExample(@Param("record") ReWatchLog record, @Param("example") ReWatchLogExample example);

    int updateByPrimaryKeySelective(ReWatchLog record);

    int updateByPrimaryKey(ReWatchLog record);
}