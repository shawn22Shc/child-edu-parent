package com.xsx.ce.util;

import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： shawn
 * @Description：
 * @Date： Create in 17:49 2018/6/12
 * @ModifiedBy:
 */


public class FfmpegUtil {

    @Value("web.upload-path")
    private String path;

    private final String inputPath = "video/";

    private final String outputPath = "video/";

    private final String ffmpegPath = "ffmpeg";

    private static void jpg(String vedioPath) {
        List<String> command = new ArrayList<String>();
        //ffmpeg -ss 00:02:06 -i test1.flv -f image2 -y test1.jpg;

    }

}
