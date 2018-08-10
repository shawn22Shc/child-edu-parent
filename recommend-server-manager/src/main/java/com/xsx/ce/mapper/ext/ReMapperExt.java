package com.xsx.ce.mapper.ext;

import com.xsx.ce.pojo.XsxUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReMapperExt {

    /**
     * 获取 用户 ids
     * @return
     */
    List<Long> selectUserIds();

    /**
     * 获取 小课 ids
     * @return
     */
    List<Long> selectLittleIds();

    /**
     * 获取 某大课下的所有小课
     * @param pid
     * @param size  取前几节课
     * @return
     */
    List<Long> selectLittleIdsByPid(@Param("pid")Long pid ,@Param("size")Integer size);
}