package com.xsx.ce.mapper;

import com.xsx.ce.pojo.ReTagLittle;
import com.xsx.ce.pojo.ReTagLittleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReTagLittleMapper {
    int countByExample(ReTagLittleExample example);

    int deleteByExample(ReTagLittleExample example);

    int deleteByPrimaryKey(Long littleId);

    int insert(ReTagLittle record);

    int insertSelective(ReTagLittle record);

    List<ReTagLittle> selectByExample(ReTagLittleExample example);

    ReTagLittle selectByPrimaryKey(Long littleId);

    int updateByExampleSelective(@Param("record") ReTagLittle record, @Param("example") ReTagLittleExample example);

    int updateByExample(@Param("record") ReTagLittle record, @Param("example") ReTagLittleExample example);

    int updateByPrimaryKeySelective(ReTagLittle record);

    int updateByPrimaryKey(ReTagLittle record);
}