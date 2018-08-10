package com.xsx.ce.mapper;

import com.xsx.ce.pojo.XsxUser;
import com.xsx.ce.pojo.XsxUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XsxUserMapper {
    int countByExample(XsxUserExample example);

    int deleteByExample(XsxUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(XsxUser record);

    int insertSelective(XsxUser record);

    List<XsxUser> selectByExample(XsxUserExample example);

    XsxUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") XsxUser record, @Param("example") XsxUserExample example);

    int updateByExample(@Param("record") XsxUser record, @Param("example") XsxUserExample example);

    int updateByPrimaryKeySelective(XsxUser record);

    int updateByPrimaryKey(XsxUser record);
}