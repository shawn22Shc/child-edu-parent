package com.xsx.test;

import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * @Author： shawn
 * @Description：
 * @Date： Create in 13:54 2018/7/4
 * @ModifiedBy:
 */


public class Test001{

    // 应该怎么写呢
    private final static Logger logger = Logger.getLogger(String.valueOf(Test001.class));
    public static final String FFMPEG_PATH = "D:/ffmpeg/bin/ffmpeg.exe";
    private static Process process;

    private String video_path;
    private String videoFileName;

    public Test001(String video_path,String videoFileName){
        this.video_path = video_path;
        this.videoFileName = videoFileName;
    }

    /*@Override
    public void run() {
        convertCommand(video_path,videoFileName);
    }*/

    /**
     * 视频转换
     * @param video_path
     * @return
     */


    public static String convertCommand(String video_path,String videoFileName,String hd) {

        return "";
    }

    private static Integer checkVideoType(String PATH) {

        return 9;
    }




    public static void main (String[] args) {

    }


}
