package com.xsx.ce.mapper;

import com.xsx.ce.pojo.AliTest;
import com.xsx.ce.pojo.AliTestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AliTestMapper {
    int countByExample(AliTestExample example);

    int deleteByExample(AliTestExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AliTest record);

    int insertSelective(AliTest record);

    List<AliTest> selectByExample(AliTestExample example);

    AliTest selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AliTest record, @Param("example") AliTestExample example);

    int updateByExample(@Param("record") AliTest record, @Param("example") AliTestExample example);

    int updateByPrimaryKeySelective(AliTest record);

    int updateByPrimaryKey(AliTest record);
}