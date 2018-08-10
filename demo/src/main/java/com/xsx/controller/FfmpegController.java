package com.xsx.controller;

import com.xsx.test.Test001;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
    //private static final String path = "D:\\abc";

    @RequestMapping("/ff")
    @ResponseBody
    public ResponseEntity<byte[]> ff(HttpServletRequest request, HttpServletResponse response, MultipartFile file, String hd) throws IOException {
        System.out.println("--------------------------进来啦------------------------------");
        long now = new Date().getTime();
        String day = getDay();
        String sp = File.separator;
        String origName = file.getOriginalFilename();
        // 保持 名
        String saveName = String.valueOf(now)+"_"+origName;
        // 转码 名
        String newName = hd+"_"+String.valueOf(now)+"_"+origName;
        //保存 地址  /home/ffmpegDir/2018/7/4
        String savePath = path+sp+day+sp;
        //保存文件夹路径
        File saveDir = new File(savePath);
        if(!saveDir.exists()){
            saveDir.mkdirs();
        }
        String savePathAndNmae = savePath+saveName;
        File saveFile = new File(savePathAndNmae);
        file.transferTo(saveFile);
        String newPathAndName = savePath+newName;
        Test001.convertCommand(savePathAndNmae,newPathAndName,hd);

        File download = new File(newPathAndName);

        return buildResponseEntity(download);
    }

    public static ResponseEntity<byte[]> buildResponseEntity(File file) throws IOException {
        byte[] body = null;
        //获取文件
        InputStream is = new FileInputStream(file);
        body = new byte[is.available()];
        is.read(body);
        HttpHeaders headers = new HttpHeaders();
        //设置文件类型
        headers.add("Content-Disposition", "attchement;filename=" + file.getName());
        //设置Http状态码
        //返回数据
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, HttpStatus.OK);
        return entity;
    }

    //------------------------------private--------------------------------------
    private String getDay(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return  sdf.format(date);
    }


}
