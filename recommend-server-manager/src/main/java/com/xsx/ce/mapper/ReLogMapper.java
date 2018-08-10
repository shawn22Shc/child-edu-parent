package com.xsx.ce.mapper;

import com.xsx.ce.pojo.ReLog;
import com.xsx.ce.pojo.ReLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReLogMapper {
    int countByExample(ReLogExample example);

    int deleteByExample(ReLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReLog record);

    int insertSelective(ReLog record);

    List<ReLog> selectByExample(ReLogExample example);

    ReLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReLog record, @Param("example") ReLogExample example);

    int updateByExample(@Param("record") ReLog record, @Param("example") ReLogExample example);

    int updateByPrimaryKeySelective(ReLog record);

    int updateByPrimaryKey(ReLog record);
}