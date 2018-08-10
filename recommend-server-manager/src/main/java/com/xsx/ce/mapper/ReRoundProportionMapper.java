package com.xsx.ce.mapper;

import com.xsx.ce.pojo.ReRoundProportion;
import com.xsx.ce.pojo.ReRoundProportionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReRoundProportionMapper {
    int countByExample(ReRoundProportionExample example);

    int deleteByExample(ReRoundProportionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReRoundProportion record);

    int insertSelective(ReRoundProportion record);

    List<ReRoundProportion> selectByExample(ReRoundProportionExample example);

    ReRoundProportion selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReRoundProportion record, @Param("example") ReRoundProportionExample example);

    int updateByExample(@Param("record") ReRoundProportion record, @Param("example") ReRoundProportionExample example);

    int updateByPrimaryKeySelective(ReRoundProportion record);

    int updateByPrimaryKey(ReRoundProportion record);
}