package com.xsx.ce.mapper;

import com.xsx.ce.pojo.ReListBig;
import com.xsx.ce.pojo.ReListBigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReListBigMapper {
    int countByExample(ReListBigExample example);

    int deleteByExample(ReListBigExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(ReListBig record);

    int insertSelective(ReListBig record);

    List<ReListBig> selectByExampleWithBLOBs(ReListBigExample example);

    List<ReListBig> selectByExample(ReListBigExample example);

    ReListBig selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") ReListBig record, @Param("example") ReListBigExample example);

    int updateByExampleWithBLOBs(@Param("record") ReListBig record, @Param("example") ReListBigExample example);

    int updateByExample(@Param("record") ReListBig record, @Param("example") ReListBigExample example);

    int updateByPrimaryKeySelective(ReListBig record);

    int updateByPrimaryKeyWithBLOBs(ReListBig record);
}