package com.xsx.ce.mapper;

import com.xsx.ce.pojo.XsxContent;
import com.xsx.ce.pojo.XsxContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XsxContentMapper {
    int countByExample(XsxContentExample example);

    int deleteByExample(XsxContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(XsxContent record);

    int insertSelective(XsxContent record);

    List<XsxContent> selectByExample(XsxContentExample example);

    XsxContent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") XsxContent record, @Param("example") XsxContentExample example);

    int updateByExample(@Param("record") XsxContent record, @Param("example") XsxContentExample example);

    int updateByPrimaryKeySelective(XsxContent record);

    int updateByPrimaryKey(XsxContent record);
}