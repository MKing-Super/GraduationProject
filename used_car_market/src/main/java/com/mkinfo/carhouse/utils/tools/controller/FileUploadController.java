/**
 * projectName: used_car_market
 * fileName: FileUploadController.java
 * packageName: com.mkinfo.carhouse.utils.tools.controller
 * date: 2021-01-24 19:42
 * copyright(c) 2020- xxx公司
 */
package com.mkinfo.carhouse.utils.tools.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @version: V1.0
 * @author: MK
 * @className: FileUploadController
 * @packageName: com.mkinfo.carhouse.utils.tools.controller
 * @description: 文件上传
 * @date: 2021-01-24 19:42
 **/
@Controller
@RequestMapping("/fileUpload")
public class FileUploadController {

    /**
     * @title: toFileUpload
     * @path: /fileUpload/toFileUpload
     * @description: 跳转到文件上传页面
     * @author: MK
     * @date: 2021-01-24 19:43
     * @param: []
     * @return: java.lang.String
     * @throws:
     * @modefied: 2021-01-24 19:43 MK 修改
     */
    @RequestMapping("/toFileUpload")
    public String toFileUpload() {
        return "utils/tools/FileUploadPractice/FileUploadPractice.html";
    }

    /**
     * @title: addImg
     * @path: /fileUpload/addImg
     * @description: 选择文件即刻上传
     * @author: MK
     * @date: 2021-01-25 22:25
     * @param: [request, response]
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     * @throws:
     * @modefied: 2021-01-25 22:25 MK 修改
     */
    @RequestMapping(value = "/addImg", method = {RequestMethod.POST})
    @ResponseBody
    public Map<String, Object> addImg(HttpServletRequest request, HttpServletResponse response) {
        String projectPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        Map<String, Object> result = new HashMap<String, Object>();
        // 转型为MultipartHttpRequest：
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        // 获得文件：
        MultipartFile file = multipartRequest.getFile("file");
        try {
            if (true) {
                String imgDir = "E:\\images";        // 图片上传地址
                // 对文件进行存储处理
                byte[] bytes = file.getBytes();
                Path path = Paths.get(imgDir, "\\" + file.getOriginalFilename());
                Files.write(path, bytes);

                result.put("msg", "上传成功！");
                result.put("result", true);
            }
        } catch (IOException e) {
            result.put("msg", "出错了");
            result.put("result", false);
            e.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return result;
    }

    //      /fileUpload/add
    @RequestMapping("/add")
    @ResponseBody
    public Map<String, Object> add(@RequestParam("images") MultipartFile file) {
        Map<String, Object> result = new HashMap<>();
        try {
            // 图片上传地址
            //项目的绝对路径 + 文件夹
            //String property = System.getProperty("user.dir") + "\\upload";
            String picturesPath = "E:\\git\\used_car_market_upload\\upload";
            File filePath = new File(picturesPath);
            //若文件夹不存在，则创建一个文件夹
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            // 对文件进行存储处理
            byte[] bytes = file.getBytes();
            Path path = Paths.get(picturesPath, "\\" + file.getOriginalFilename());
            Files.write(path, bytes);

            result.put("msg", "上传成功！");
            result.put("result", true);
        } catch (IOException e) {
            result.put("msg", "出错了");
            result.put("result", false);
            e.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return result;
    }

}
