package com.third.easyprice.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/shop")
public class ShopController {

    @RequestMapping(value = "/query" , method = RequestMethod.POST)
    public JSONObject queryShop(@RequestParam("file") MultipartFile file){
        JSONObject jsonObject = new JSONObject() ;
        if (file.isEmpty()){
            jsonObject.put("msg" , "图片不存在,请重新上传");
            return jsonObject ;
        }

        return null ;
    }
}
