package com.xsx.ce.service.impl;

import com.github.pagehelper.PageHelper;
import com.xsx.ce.mapper.ReArtificialTopMapper;
import com.xsx.ce.pojo.ReArtificialTop;
import com.xsx.ce.pojo.ReArtificialTopExample;
import com.xsx.ce.service.ReArtificialTopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： shawn
 * @Description：
 * @Date： Create in 11:25 2018/6/28
 * @ModifiedBy:
 */

@Service
public class ReArtificialTopServiceImpl implements ReArtificialTopService {

    @Autowired
    private ReArtificialTopMapper reArtificialTopMapper;

    @Override
    public List<Long> getReArtificialTopList() {
        List<Long> result = new ArrayList<>();
        ReArtificialTopExample example = new ReArtificialTopExample();
        example.setOrderByClause(" rank ASC ");
        PageHelper.startPage(1,100);
        List<ReArtificialTop> list = reArtificialTopMapper.selectByExample(example);
        for (ReArtificialTop top:list ) {
            result.add(top.getLittleId());
        }
        return result;
    }
}
