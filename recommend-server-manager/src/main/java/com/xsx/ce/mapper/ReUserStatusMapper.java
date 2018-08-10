package com.xsx.ce.mapper;

import com.xsx.ce.pojo.ReUserStatus;
import com.xsx.ce.pojo.ReUserStatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReUserStatusMapper {
    int countByExample(ReUserStatusExample example);

    int deleteByExample(ReUserStatusExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(ReUserStatus record);

    int insertSelective(ReUserStatus record);

    List<ReUserStatus> selectByExample(ReUserStatusExample example);

    ReUserStatus selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") ReUserStatus record, @Param("example") ReUserStatusExample example);

    int updateByExample(@Param("record") ReUserStatus record, @Param("example") ReUserStatusExample example);

    int updateByPrimaryKeySelective(ReUserStatus record);

    int updateByPrimaryKey(ReUserStatus record);
}