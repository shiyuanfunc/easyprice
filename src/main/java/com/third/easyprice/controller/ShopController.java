package com.third.easyprice.controller;

import com.alibaba.fastjson.JSONObject;
import com.third.easyprice.utils.BaiduTest;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping(value = "/shop")
public class ShopController {

    @RequestMapping(value = "/query" , method = RequestMethod.POST)
    public JSONObject queryShop(@RequestParam("file") MultipartFile file) throws IOException {
        JSONObject jsonObject = new JSONObject() ;
        if (file.isEmpty()){
            jsonObject.put("msg" , "图片不存在,请重新上传");
            return jsonObject ;
        }

        String filename = file.getOriginalFilename();
        String suffix = filename.substring(filename.indexOf("."));
        final File tempFile = File.createTempFile(UUID.randomUUID().toString(), suffix);
        file.transferTo(tempFile);

        String detect = BaiduTest.detect(tempFile);

        return null ;
    }
}
