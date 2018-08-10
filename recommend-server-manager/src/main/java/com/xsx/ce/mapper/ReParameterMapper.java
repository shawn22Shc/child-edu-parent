package com.xsx.ce.mapper;

import com.xsx.ce.pojo.ReParameter;
import com.xsx.ce.pojo.ReParameterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReParameterMapper {
    int countByExample(ReParameterExample example);

    int deleteByExample(ReParameterExample example);

    int deleteByPrimaryKey(String id);

    int insert(ReParameter record);

    int insertSelective(ReParameter record);

    List<ReParameter> selectByExample(ReParameterExample example);

    ReParameter selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ReParameter record, @Param("example") ReParameterExample example);

    int updateByExample(@Param("record") ReParameter record, @Param("example") ReParameterExample example);

    int updateByPrimaryKeySelective(ReParameter record);

    int updateByPrimaryKey(ReParameter record);
}