package com.xsx.ce.service.impl;

import com.github.pagehelper.PageHelper;
import com.xsx.ce.mapper.ReWatchLogMapper;
import com.xsx.ce.pojo.ReWatchLog;
import com.xsx.ce.pojo.ReWatchLogExample;
import com.xsx.ce.service.ReWatchLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author： shawn
 * @Description：
 * @Date： Create in 11:18 2018/6/21
 * @ModifiedBy:
 */

@Service
public class ReWatchLogServiceImpl implements ReWatchLogService {

    @Autowired
    private ReWatchLogMapper reWatchLogMapper;

    @Override
    public int getLittleWatchLogCount(Long littleId, Long time) {
        //System.out.println("little:"+littleId+" time:"+time);
        ReWatchLogExample example = new ReWatchLogExample();
        example.createCriteria().andCreatetimelongGreaterThanOrEqualTo(time).andLittleIdEqualTo(littleId);
        return reWatchLogMapper.countByExample(example);
    }


    @Override
    public int getUserWatchLogCount(Long userId, Long time) {
        ReWatchLogExample example = new ReWatchLogExample();
        example.createCriteria().andCreatetimelongGreaterThanOrEqualTo(time).andUserIdEqualTo(userId);
        return reWatchLogMapper.countByExample(example);
    }

    @Override
    public List<ReWatchLog> getUserWatchlog(int pageNum, int pageSize, Long userId, Long time) {
        //System.out.println(" pageNum: "+pageNum +" pageSize: "+pageSize);
        ReWatchLogExample example = new ReWatchLogExample();
        example.createCriteria().andCreatetimelongGreaterThanOrEqualTo(time).andUserIdEqualTo(userId);
        example.setOrderByClause(" id ASC ");
        PageHelper.startPage(pageNum,pageSize);
        List<ReWatchLog> list = reWatchLogMapper.selectByExample(example);
        //System.out.println("size : "+list.size());
        return list;
    }


    @Override
    public List<ReWatchLog> getVideoWatchlog(int pageNum, int pageSize, Long videoId, Long time) {
        ReWatchLogExample example = new ReWatchLogExample();
        example.createCriteria().andCreatetimelongGreaterThanOrEqualTo(time).andLittleIdEqualTo(videoId);
        example.setOrderByClause(" id ASC ");
        PageHelper.startPage(pageNum,pageSize);
        List<ReWatchLog> list =  reWatchLogMapper.selectByExample(example);
        return list;
    }
}
