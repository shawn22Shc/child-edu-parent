package com.xsx.ce.service.impl;

import com.xsx.ce.mapper.ReListLittleMapper;
import com.xsx.ce.pojo.ReListLittle;
import com.xsx.ce.pojo.ReListLittleExample;
import com.xsx.ce.service.ReUserListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author： shawn
 * @Description：
 * @Date： Create in 16:22 2018/6/27
 * @ModifiedBy:
 */

@Service
public class ReUserListServiceImpl implements ReUserListService {

    @Autowired
    private ReListLittleMapper reListLittleMapper;

    @Override
    public int updateOrCreateUserLittleList(Long userId, String ids) {
        ReListLittle reListLittle = new ReListLittle();
        reListLittle.setUserId(userId);
        reListLittle.setIds(ids);
        ReListLittleExample example = new ReListLittleExample();
        example.createCriteria().andUserIdEqualTo(userId);
        int count = reListLittleMapper.countByExample(example);
        if (count == 0){
            return reListLittleMapper.insert(reListLittle);
        }else {
            return reListLittleMapper.updateByPrimaryKey(reListLittle);
        }
    }
}
