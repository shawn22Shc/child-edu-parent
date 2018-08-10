package com.xsx.ce.mapper;

import com.xsx.ce.pojo.ReArtificialTop;
import com.xsx.ce.pojo.ReArtificialTopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReArtificialTopMapper {
    int countByExample(ReArtificialTopExample example);

    int deleteByExample(ReArtificialTopExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReArtificialTop record);

    int insertSelective(ReArtificialTop record);

    List<ReArtificialTop> selectByExample(ReArtificialTopExample example);

    ReArtificialTop selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReArtificialTop record, @Param("example") ReArtificialTopExample example);

    int updateByExample(@Param("record") ReArtificialTop record, @Param("example") ReArtificialTopExample example);

    int updateByPrimaryKeySelective(ReArtificialTop record);

    int updateByPrimaryKey(ReArtificialTop record);
}