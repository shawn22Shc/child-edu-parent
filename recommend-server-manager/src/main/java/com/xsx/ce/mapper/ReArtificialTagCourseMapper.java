package com.xsx.ce.mapper;

import com.xsx.ce.pojo.ReArtificialTagCourse;
import com.xsx.ce.pojo.ReArtificialTagCourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReArtificialTagCourseMapper {
    int countByExample(ReArtificialTagCourseExample example);

    int deleteByExample(ReArtificialTagCourseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReArtificialTagCourse record);

    int insertSelective(ReArtificialTagCourse record);

    List<ReArtificialTagCourse> selectByExample(ReArtificialTagCourseExample example);

    ReArtificialTagCourse selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReArtificialTagCourse record, @Param("example") ReArtificialTagCourseExample example);

    int updateByExample(@Param("record") ReArtificialTagCourse record, @Param("example") ReArtificialTagCourseExample example);

    int updateByPrimaryKeySelective(ReArtificialTagCourse record);

    int updateByPrimaryKey(ReArtificialTagCourse record);
}