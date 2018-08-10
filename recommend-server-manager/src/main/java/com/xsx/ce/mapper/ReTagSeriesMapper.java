package com.xsx.ce.mapper;

import com.xsx.ce.pojo.ReTagSeries;
import com.xsx.ce.pojo.ReTagSeriesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReTagSeriesMapper {
    int countByExample(ReTagSeriesExample example);

    int deleteByExample(ReTagSeriesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReTagSeries record);

    int insertSelective(ReTagSeries record);

    List<ReTagSeries> selectByExample(ReTagSeriesExample example);

    ReTagSeries selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReTagSeries record, @Param("example") ReTagSeriesExample example);

    int updateByExample(@Param("record") ReTagSeries record, @Param("example") ReTagSeriesExample example);

    int updateByPrimaryKeySelective(ReTagSeries record);

    int updateByPrimaryKey(ReTagSeries record);
}