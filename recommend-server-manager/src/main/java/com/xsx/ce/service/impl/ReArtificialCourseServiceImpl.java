package com.xsx.ce.service.impl;

import com.xsx.ce.mapper.ReArtificialTagCourseMapper;
import com.xsx.ce.mapper.ext.ReMapperExt;
import com.xsx.ce.pojo.ReArtificialTagCourse;
import com.xsx.ce.pojo.ReArtificialTagCourseExample;
import com.xsx.ce.service.ReArtificialCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author： shawn
 * @Description： 获取人工 性别 年龄推荐
 * @Date： Create in 9:19 2018/6/28
 * @ModifiedBy:
 */

@Service
public class ReArtificialCourseServiceImpl implements ReArtificialCourseService {

    @Autowired
    private ReArtificialTagCourseMapper reArtificialTagCourseMapper;

    @Autowired
    private ReMapperExt mapperExt;

    @Override
    public List<Long> getReArtificialCourseList(int size,int age, int gender) {
        Map<Long,Long> repeatMap = new HashMap<>();
        List<Long> littleIdList = new ArrayList<>();
        if (size <= 0){
            return littleIdList;
        }
        int genderReq = (gender == 1) ? 21:22;
        List<Integer> tagValueList = new ArrayList<>();
        tagValueList.add(age);
        tagValueList.add(genderReq);

        // 年龄 性别 推荐 大课列表
        ReArtificialTagCourseExample example = new ReArtificialTagCourseExample();
        example.createCriteria().andTypeEqualTo(1).andTagIdIn(tagValueList);
        List<ReArtificialTagCourse> bigGenderList = reArtificialTagCourseMapper.selectByExample(example);

        // 年龄 性别 推荐 小课列表
        example.clear();
        example.createCriteria().andTypeEqualTo(2).andTagIdIn(tagValueList);
        List<ReArtificialTagCourse> littleGenderList = reArtificialTagCourseMapper.selectByExample(example);

        //处理 大课
        int bigListSize = bigGenderList.size();
        for (ReArtificialTagCourse big:bigGenderList) {
            int bigSize = (size/bigListSize) + ( (size&bigListSize)>0 ? 1 : 0  ) ;
            if (bigSize > 0 ){
                List<Long> littleIdListForBig = mapperExt.selectLittleIdsByPid(big.getCourseId(),bigSize);
                for (Long littleId :littleIdListForBig){
                    if ( ! repeatMap.containsKey(littleId)){
                        repeatMap.put(littleId,littleId);
                        littleIdList.add(littleId);
                    }
                }

            }
        }
        //处理小课
        for (ReArtificialTagCourse little:littleGenderList) {
            Long littleId = little.getCourseId();
            if ( ! repeatMap.containsKey(littleId)){
                repeatMap.put(littleId,littleId);
                littleIdList.add(littleId);
            }
        }
        // 乱序
        Collections.shuffle(littleIdList);
        //然后 取值
        if ( littleIdList.size() > size ){
            return littleIdList.subList(0,size);
        }
        return littleIdList;
    }

}
