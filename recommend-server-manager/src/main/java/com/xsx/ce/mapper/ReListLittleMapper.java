package com.xsx.ce.mapper;

import com.xsx.ce.pojo.ReListLittle;
import com.xsx.ce.pojo.ReListLittleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReListLittleMapper {
    int countByExample(ReListLittleExample example);

    int deleteByExample(ReListLittleExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(ReListLittle record);

    int insertSelective(ReListLittle record);

    List<ReListLittle> selectByExample(ReListLittleExample example);

    ReListLittle selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") ReListLittle record, @Param("example") ReListLittleExample example);

    int updateByExample(@Param("record") ReListLittle record, @Param("example") ReListLittleExample example);

    int updateByPrimaryKeySelective(ReListLittle record);

    int updateByPrimaryKey(ReListLittle record);
}