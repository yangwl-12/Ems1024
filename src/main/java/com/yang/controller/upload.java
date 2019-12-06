package com.yang.controller;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("upload")
public class upload {

    @RequestMapping("down")
    public String down(String fileName, String openStyle, HttpServletRequest request, HttpServletResponse response) throws Exception {
        openStyle = openStyle == null ? "attachment" : openStyle;
//        根据相对目录获取绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/down");
//            读取下载的指定文件
        File file = new File(realPath, fileName);
//             获取文件的输入流
        FileInputStream is = new FileInputStream(file);
//        默认的下载方式是在线打开inline  以附件的形式下载attachment
        response.setHeader("content-disposition", openStyle + ";fileName=" + URLEncoder.encode(fileName, "UTF-8"));

        //响应的的输出流
        ServletOutputStream os = response.getOutputStream();
        //IO拷贝
        IOUtils.copy(is, os);
        IOUtils.closeQuietly(is);//优雅的关流
        IOUtils.closeQuietly(os);//优雅的关流
        return null;
    }


    @RequestMapping("test3")
    public String test3(HttpServletRequest request, MultipartFile aa) throws IOException {
        System.out.println("文件名" + aa.getOriginalFilename());
        System.out.println("文件类型" + aa.getContentType());
//        根据相对upload获取绝对upload
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
//        修改文件名 uuid+时间戳方式
        String newfileNamePrefix = new SimpleDateFormat("yyyyMMddhhmmssSSS").format(new Date()) +
                UUID.randomUUID().toString().replace("-", "");
        String newfileNameSuffix = "." + FilenameUtils.getExtension(aa.getOriginalFilename());
//        新的文件名
        String newfileName = newfileNamePrefix + newfileNameSuffix;
        //创建日期目录
        String dataDayString = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        File dateDay = new File(realPath, dataDayString);
        if (!dateDay.exists()) {
            dateDay.mkdirs();
        }
        aa.transferTo(new File(dateDay, newfileName));
        return "login";
    }

}
