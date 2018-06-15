package com.yimew.controller.sys;

import com.yimew.utils.DateUtils;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.*;

@Controller
@RequestMapping(value = "/uploading")
public class UploadController {

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    List<Map<String, String>> uploadPics(@RequestParam MultipartFile[] myfiles, HttpServletRequest request,
                                         HttpServletResponse response) {

        String todayPath =DateUtils.dateToString(new Date(),"yyyyMMdd");
        //图片路径
        String uploadPath = request.getSession().getServletContext().getRealPath("upload")+"/"+todayPath;
        System.out.println(uploadPath);
        //压缩图路径
        String thumPath = request.getSession().getServletContext().getRealPath("thum")+"/"+todayPath;
        //最小压缩图路径
        String thumistPath = request.getSession().getServletContext().getRealPath("thumist")+"/"+todayPath;

        //判断路径是否存在不存在创建
        File thumDic = new File(thumPath);
        if (!thumDic.exists()){
            thumDic.mkdirs();
        }
        File thumistDic = new File(thumistPath);
        if (!thumistDic.exists()){
            thumistDic.mkdirs();
        }

        // 结果集
        List<Map<String, String>> uploadFiles = new ArrayList<>();
        Map<String, String> uploadFile = null;
        for (MultipartFile pic : myfiles) {
            uploadFile = new HashMap<>();
            //原始文件名
            String oldFileName = pic.getOriginalFilename();
            uploadFile.put("originalFilename", oldFileName);
            int lastIndex = oldFileName.lastIndexOf(".");
            String expendName = oldFileName.substring(lastIndex);
            //校验文件后缀名是否合法
//            if(Const.ILLEGAL_EXPENDNAME_LIST.contains(expendName)){
//                uploadFile.put("isSuccess", "false");
//                uploadFile.put("error", "illegal_expendname:"+expendName);
//                uploadFiles.add(uploadFile);
//                return uploadFiles;
//            }
            //文件名
            String fileName = String.valueOf(new Date().getTime()) + expendName;
            uploadFile.put("fileName", fileName);
            //完整路径
            String contextPath = request.getContextPath();
            String allpath = request.getScheme() + "://" + request.getServerName() + ":" +
                    request.getServerPort() + contextPath + "/" +"upload/"+todayPath+"/"+ fileName;
            uploadFile.put("fileUrl", allpath);

            try {
                // 这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉，我是看它的源码才知道的
                FileUtils.copyInputStreamToFile(pic.getInputStream(), new File(uploadPath, fileName));

                //生成0.5质量图片
                Thumbnails.of(uploadPath+"/"+fileName)
                        .scale(1f)
                        .outputQuality(0.5f)
                        .toFile(thumPath+"/"+fileName);
                String thumUrl = request.getScheme() + "://" + request.getServerName() + ":" +
                        request.getServerPort() + contextPath + "/thum/"+todayPath+"/"+ fileName;

                uploadFile.put("thumUrl", thumUrl);
                //生成0.1质量图片
                Thumbnails.of(uploadPath+"/"+fileName)
                        .scale(1f)
                        .outputQuality(0.1f)
                        .toFile(thumistPath+"/"+fileName);
                String thumistUrl = request.getScheme() + "://" + request.getServerName() + ":" +
                        request.getServerPort() + contextPath + "/thumist/"+todayPath+"/"+ fileName;

                uploadFile.put("thumistUrl", thumistUrl);

            } catch (Exception e) {
                e.printStackTrace();
                uploadFile.put("isSuccess", "false");
                continue;
            } finally {
                uploadFiles.add(uploadFile);
            }
            uploadFile.put("isSuccess", "true");
        }
        return uploadFiles;
    }


}
