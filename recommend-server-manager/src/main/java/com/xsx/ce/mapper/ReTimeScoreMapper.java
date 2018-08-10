package com.xsx.ce.mapper;

import com.xsx.ce.pojo.ReTimeScore;
import com.xsx.ce.pojo.ReTimeScoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReTimeScoreMapper {
    int countByExample(ReTimeScoreExample example);

    int deleteByExample(ReTimeScoreExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReTimeScore record);

    int insertSelective(ReTimeScore record);

    List<ReTimeScore> selectByExample(ReTimeScoreExample example);

    ReTimeScore selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReTimeScore record, @Param("example") ReTimeScoreExample example);

    int updateByExample(@Param("record") ReTimeScore record, @Param("example") ReTimeScoreExample example);

    int updateByPrimaryKeySelective(ReTimeScore record);

    int updateByPrimaryKey(ReTimeScore record);
}