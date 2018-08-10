package com.xsx.ce.mapper;

import com.xsx.ce.pojo.ReStatus;
import com.xsx.ce.pojo.ReStatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReStatusMapper {
    int countByExample(ReStatusExample example);

    int deleteByExample(ReStatusExample example);

    int deleteByPrimaryKey(String id);

    int insert(ReStatus record);

    int insertSelective(ReStatus record);

    List<ReStatus> selectByExample(ReStatusExample example);

    ReStatus selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ReStatus record, @Param("example") ReStatusExample example);

    int updateByExample(@Param("record") ReStatus record, @Param("example") ReStatusExample example);

    int updateByPrimaryKeySelective(ReStatus record);

    int updateByPrimaryKey(ReStatus record);
}