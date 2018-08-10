package com.xsx.ce.mapper;

import com.xsx.ce.pojo.XsxContentTag;
import com.xsx.ce.pojo.XsxContentTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XsxContentTagMapper {
    int countByExample(XsxContentTagExample example);

    int deleteByExample(XsxContentTagExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XsxContentTag record);

    int insertSelective(XsxContentTag record);

    List<XsxContentTag> selectByExample(XsxContentTagExample example);

    XsxContentTag selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XsxContentTag record, @Param("example") XsxContentTagExample example);

    int updateByExample(@Param("record") XsxContentTag record, @Param("example") XsxContentTagExample example);

    int updateByPrimaryKeySelective(XsxContentTag record);

    int updateByPrimaryKey(XsxContentTag record);
}