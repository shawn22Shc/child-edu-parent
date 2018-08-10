package com.xsx.ce.mapper;

import com.xsx.ce.pojo.XsxContentChildren;
import com.xsx.ce.pojo.XsxContentChildrenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XsxContentChildrenMapper {
    int countByExample(XsxContentChildrenExample example);

    int deleteByExample(XsxContentChildrenExample example);

    int deleteByPrimaryKey(Long id);

    int insert(XsxContentChildren record);

    int insertSelective(XsxContentChildren record);

    List<XsxContentChildren> selectByExample(XsxContentChildrenExample example);

    XsxContentChildren selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") XsxContentChildren record, @Param("example") XsxContentChildrenExample example);

    int updateByExample(@Param("record") XsxContentChildren record, @Param("example") XsxContentChildrenExample example);

    int updateByPrimaryKeySelective(XsxContentChildren record);

    int updateByPrimaryKey(XsxContentChildren record);
}