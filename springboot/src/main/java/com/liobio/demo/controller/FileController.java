package com.liobio.demo.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liobio.demo.entity.FilesEntity;
import com.liobio.demo.service.FilesService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.util.List;

/**
 * @author LIOBIO
 * @version 1.0.0
 * @ClassName FileController.java
 * @createTime 2022/03/04/22:11:00
 * @Description
 */
@RestController
@RequestMapping("/file")
public class FileController {


    @Value("${files.upload.path}")
    private String fileUploadPath;

    @Value("${server.ip}")
    private String serverIp;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private FilesService filesService;
    /**
     * 文件上传接口
     * @param file 前端传递过来的文件
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String type = FileUtil.extName(originalFilename);
        long size = file.getSize();

        // 定义一个文件唯一的标识码
        String fileUUID = IdUtil.fastSimpleUUID() + StrUtil.DOT + type;

        File uploadFile = new File(fileUploadPath + fileUUID);
        // 判断配置的文件目录是否存在，若不存在则创建一个新的文件目录
        File parentFile = uploadFile.getParentFile();
        if(!parentFile.exists()) {
            parentFile.mkdirs();
        }

        String url;
        // 获取文件的md5
        String md5 = SecureUtil.md5(file.getInputStream());

        // 从数据库查询是否存在相同的记录
        FilesEntity dbFiles = getFileByMd5(md5);
        if (dbFiles != null) {
            //存在只获取相同MD5文件的URL
            url = dbFiles.getUrl();
        } else {
            //  不存在就上传文件到磁盘
            file.transferTo(uploadFile);
            url = "http://" + serverIp + ":"+serverPort+"/file/" + fileUUID;
        }


        // 存储数据库
        FilesEntity saveFile = new FilesEntity();
        saveFile.setName(originalFilename);
        saveFile.setType(type);
        saveFile.setSize(size/1024); // 单位 kb
        saveFile.setUrl(url);
        saveFile.setMd5(md5);
        filesService.save(saveFile);

        return url;
    }

    /**
     * 文件下载接口   http://ip:port/file/{fileUUID}
     * @param fileUUID
     * @param response
     * @throws IOException
     */
    @GetMapping("/{fileUUID}")
    public void download(@PathVariable String fileUUID, HttpServletResponse response) throws IOException {
        // 根据文件的唯一标识码获取文件
        File uploadFile = new File(fileUploadPath + fileUUID);
        // 设置输出流的格式
        ServletOutputStream os = response.getOutputStream();
        response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileUUID, "UTF-8"));
        response.setContentType("application/octet-stream");

        // 读取文件的字节流
        os.write(FileUtil.readBytes(uploadFile));
        os.flush();
        os.close();
    }


    /**
     * 通过文件的md5查询文件
     * @param md5
     * @return
     */
    private FilesEntity getFileByMd5(String md5) {
        // 查询文件的md5是否存在
        QueryWrapper<FilesEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("md5", md5);
        List<FilesEntity> filesList = filesService.list(queryWrapper);
        return filesList.size() == 0 ? null : filesList.get(0);
    }

}
