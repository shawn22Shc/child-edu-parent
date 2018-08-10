package com.xsx.controller;

import com.xsx.test.Test001;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author： shawn
 * @Description：
 * @Date： Create in 17:49 2018/7/4
 * @ModifiedBy:
 */

@EnableAutoConfiguration
@Controller
public class FfmpegController {

    private static final String path = "/home/ffmpegDir";

    @RequestMapping("/ff")
    @ResponseBody
    public String ff(HttpServletRequest request, HttpServletResponse response, MultipartFile file, String hd) throws IOException {

        return null;
    }


    public static ResponseEntity<byte[]> buildResponseEntity(File file) throws IOException {
        return null;
    }

    //------------------------------private--------------------------------------
    private String getDay(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return  sdf.format(date);
    }


}
