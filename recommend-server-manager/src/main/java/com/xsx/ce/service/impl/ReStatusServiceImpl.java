package com.xsx.ce.service.impl;

import com.xsx.ce.mapper.ReStatusMapper;
import com.xsx.ce.pojo.ReStatus;
import com.xsx.ce.service.ReStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author： shawn
 * @Description：
 * @Date： Create in 17:19 2018/6/15
 * @ModifiedBy:
 */

@Service
public class ReStatusServiceImpl implements ReStatusService {

    @Autowired
    private ReStatusMapper reStatusMapper;

    private static String statusKey = "total_status";

    @Override
    public boolean getReStatus() {
        ReStatus reStatus = reStatusMapper.selectByPrimaryKey(statusKey);
        if(reStatus != null ){
            Integer value = reStatus.getIntValue();
            if(value != null){
                if (value.intValue() == 1){
                    return true;
                }
            }
        }
        return false;
    }
}
