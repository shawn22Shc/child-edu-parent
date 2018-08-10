package com.xsx.ce.mapper;

import com.xsx.ce.pojo.XsxChildInfo;
import com.xsx.ce.pojo.XsxChildInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XsxChildInfoMapper {
    int countByExample(XsxChildInfoExample example);

    int deleteByExample(XsxChildInfoExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(XsxChildInfo record);

    int insertSelective(XsxChildInfo record);

    List<XsxChildInfo> selectByExample(XsxChildInfoExample example);

    XsxChildInfo selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") XsxChildInfo record, @Param("example") XsxChildInfoExample example);

    int updateByExample(@Param("record") XsxChildInfo record, @Param("example") XsxChildInfoExample example);

    int updateByPrimaryKeySelective(XsxChildInfo record);

    int updateByPrimaryKey(XsxChildInfo record);
}