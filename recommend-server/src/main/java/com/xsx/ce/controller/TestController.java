package com.xsx.ce.controller;

import com.xsx.ce.mapper.XsxChildInfoMapper;

import com.xsx.ce.mapper.XsxUserMapper;
import com.xsx.ce.pojo.ReTagUser;
import com.xsx.ce.pojo.ReWatchLog;
import com.xsx.ce.pojo.ext.ReLittleTag;
import com.xsx.ce.service.*;
import com.xsx.ce.util.DateUtil;
import com.xsx.ce.util.MyThread;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.JedisPool;

import java.time.Instant;
import java.util.*;

@Controller
@EnableAutoConfiguration
public class TestController {

    @Autowired
    private ReActionHandleService reActionHandleService;

    @Autowired
    private ReProduceService reProduceService;

    /*@Autowired
    private ReTagLittleService littleService;*/

    @RequestMapping("/reAc")
    @ResponseBody
    public Object reAc(Long id){
        // 处理 小课的tag  即应对 有修改 小课标签的情况
        // 同时 处理 每节小课 观看人 性别 年龄标签
        // 先执行此方法  不然修改 标签  对于今天的用户行为将会没有意义
        int littleCount = reActionHandleService.handleLittleTag();
        // 处理 用户的tag
        // 即任意一次观看行为 标签时长
        int userCount = reActionHandleService.handleUserTag();
        // 生成 推荐
        // 即生成 re_List
        int reCount = reProduceService.produceUserReList();
        System.out.println("L:"+littleCount+" U:"+userCount+" R:"+reCount);
        return "L:"+littleCount+" U:"+userCount+" R:"+reCount;
    }

}
