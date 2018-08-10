package com.xsx.ce.mapper;

import com.xsx.ce.pojo.ReTagUser;
import com.xsx.ce.pojo.ReTagUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReTagUserMapper {
    int countByExample(ReTagUserExample example);

    int deleteByExample(ReTagUserExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(ReTagUser record);

    int insertSelective(ReTagUser record);

    List<ReTagUser> selectByExampleWithBLOBs(ReTagUserExample example);

    List<ReTagUser> selectByExample(ReTagUserExample example);

    ReTagUser selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") ReTagUser record, @Param("example") ReTagUserExample example);

    int updateByExampleWithBLOBs(@Param("record") ReTagUser record, @Param("example") ReTagUserExample example);

    int updateByExample(@Param("record") ReTagUser record, @Param("example") ReTagUserExample example);

    int updateByPrimaryKeySelective(ReTagUser record);

    int updateByPrimaryKeyWithBLOBs(ReTagUser record);

    int updateByPrimaryKey(ReTagUser record);
}