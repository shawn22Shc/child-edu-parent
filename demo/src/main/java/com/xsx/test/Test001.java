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


public class Test001 {

    // 应该怎么写呢
    private final static Logger logger = Logger.getLogger(String.valueOf(Test001.class));
    public static final String FFMPEG_PATH = "D:/ffmpeg/bin/ffmpeg.exe";
    private static Process process;

    private String video_path;
    private String videoFileName;

    public Test001(String video_path, String videoFileName){
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
        System.out.println(" path :"+video_path);
        if(StringUtils.isEmpty(video_path)){
            return null;
        }
        File file = new File(video_path);
        if (!file.exists()) {
            System.err.println("路径[" + video_path + "]对应的视频文件不存在!");
            return null;
        }
        try {
            Integer type = checkVideoType(video_path);
            System.out.println("--------type:"+type);

            if(0==type){
                //"ffmpeg -i 1080.mp4 -s hd720 -c:v libx264 -crf 23 -c:a aac -strict -2 720.mp4"
                List<String> commands = new java.util.ArrayList<String>();
                commands.add("ffmpeg");
                commands.add("-i");
                commands.add(video_path);
                commands.add("-s");
                commands.add(hd);
                commands.add("-c:v");
                commands.add("libx264");
                commands.add("-crf");
                commands.add("23");
                commands.add("-c:a");
                commands.add("aac");
                commands.add("-strict");
                commands.add("-2");
                commands.add(videoFileName);
                ProcessBuilder builder = new ProcessBuilder();
                String sp = File.separator;
                System.out.println("---:"+sp+":--");
                builder.command(commands);
                //builder.command("ffmpeg -i D:"+sp+"1080.mp4 -s hd720 -c:v libx264 -crf 23 -c:a aac -strict -2 D:"+sp+"111720.mp4");
                process = builder.start();
                //process.waitFor();//等待进程执行完毕
                //防止ffmpeg进程塞满缓存造成死锁
                InputStream error = process.getErrorStream();
                InputStream is = process.getInputStream();
                byte[] b = new byte[1024];
                int readbytes = -1;
                try {
                    while((readbytes = error.read(b)) != -1){
                        logger.info("FFMPEG视频转换进程错误信息："+new String(b,0,readbytes));
                    }
                    while((readbytes = is.read(b)) != -1){
                        logger.info("FFMPEG视频转换进程输出内容为："+new String(b,0,readbytes));
                    }
                }catch (IOException e2){
                    e2.printStackTrace();
                }finally {
                    error.close();
                    is.close();
                }
            }
            //videoUrl = "http://"+JsonResponseHelper.serverAddress+"/wamei/upload/video/"+videoName;
            //logger.info("视频格式转换："+videoUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /*public static void cha(Test001 a){
        System.out.println(a);
        a = new Test001("b","b");
        System.out.println("2:"+a);
        Test001 a = new Test001("a","b");
        System.out.println("1:"+a);
        cha(a);
        System.out.println("3:"+a);
        System.out.println(a.getVideo_path());
    }*/

    public static void cha(String a){
        a = "123";
    }
    static boolean foo(char c) {
        System.out.print(c);
        return true;
    }
    public static void main(String[] args) {
          Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
              @Override
              public void uncaughtException(Thread thread, Throwable throwable) {

              }
          });
    }

    private static Integer checkVideoType(String PATH) {
        String type = PATH.substring(PATH.lastIndexOf(".") + 1, PATH.length())
                .toLowerCase();
        // ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
        if (type.equals("avi")) {
            return 0;
        } else if (type.equals("mpg")) {
            return 0;
        } else if (type.equals("wmv")) {
            return 0;
        } else if (type.equals("3gp")) {
            return 0;
        } else if (type.equals("mov")) {
            return 0;
        } else if (type.equals("mp4")) {
            return 0;//本身是MP4格式不用转换
        } else if (type.equals("asf")) {
            return 0;
        } else if (type.equals("asx")) {
            return 0;
        } else if (type.equals("flv")) {
            return 0;
        }
        // 对ffmpeg无法解析的文件格式(wmv9，rm，rmvb等),
        else if (type.equals("wmv9")) {
            return 1;
        } else if (type.equals("rm")) {
            return 1;
        } else if (type.equals("rmvb")) {
            return 1;
        }
        return 9;
    }


    public String getVideo_path() {
        return video_path;
    }

    public void setVideo_path(String video_path) {
        this.video_path = video_path;
    }

    public String getVideoFileName() {
        return videoFileName;
    }

    public void setVideoFileName(String videoFileName) {
        this.videoFileName = videoFileName;
    }

    /* public static void main (String[] args) {
        long start = new Date().getTime();
        String videoPath = "D:/1080.mp4";
        String fileName = "new720.mp4";
        Test001 v1= new Test001(videoPath,fileName);
        v1.convertCommand(videoPath,fileName,"hd720");
        long end = new Date().getTime();
        System.out.println( (end-start)/1000 );
    }*/


}
