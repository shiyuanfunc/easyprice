package com.third.easyprice.controller;

import com.alibaba.fastjson.JSONObject;
import com.third.easyprice.bean.Shop;
import com.third.easyprice.service.ShopService;
import com.third.easyprice.utils.BaiduTest;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value = "/shop")
public class ShopController {

    @Autowired
    private ShopService shopService ;

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
        List<Map<String, Object>> convert = BaiduTest.convert(detect);

        String key = UUID.randomUUID().toString().replace("-","");
        List<Shop> result = shopService.queryByName(convert , key);
        jsonObject.put("data" , result);
        jsonObject.put("key" , key);
        return jsonObject ;
    }


    /**
     *
     * @param
     * @param type  用户分类 类型
     * @return
     */
    @RequestMapping(value = "/order" , method = RequestMethod.GET)
    public JSONObject orderResult( String type ){
        JSONObject jsonObject = new JSONObject();
        if (StringUtils.isBlank(type)){
            jsonObject.put("msg" , "服务器错误");
            jsonObject.put("data" , null);
            jsonObject.put("code" , "403");
            return jsonObject ;
        }

        List<Shop> shops = shopService.orderList(type);
        jsonObject.put("msg" , "请求正常");
        jsonObject.put("data",shops);
        jsonObject.put("code" ,"200");
        return jsonObject ;
    }

}
