package com.third.easyprice.controller;

import com.alibaba.fastjson.JSONObject;
import com.third.easyprice.bean.Shop;
import com.third.easyprice.dao.ShopDao;
import com.third.easyprice.service.ShopService;
import com.third.easyprice.utils.BaiduTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/price")
public class TestController {

    @Autowired
    private ShopDao shopDao ;

    @Autowired
    private ShopService shopService ;

    private static Map<String, Object> map = new HashMap<>();


    @RequestMapping(value = "/test" , method = RequestMethod.GET)
    public JSONObject test(){

        String name = "小米" ;
        List<Shop> objects = shopDao.queryByName(name);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", objects) ;
        jsonObject.put("msg" , "success") ;
        return jsonObject;
    }

    @RequestMapping(value = "/test2" , method = RequestMethod.GET)
    public JSONObject test2(){
        File file = new File("C:\\Users\\song\\Desktop\\小米.jpg") ;
        String result = BaiduTest.detect(file);
        List<Map<String, Object>> convert = BaiduTest.convert(result);
        List<Shop> listShop = shopService.queryByName(convert, "123456789");

        map.put("data" , listShop);
       // shopService.orderList("123","");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data" , listShop);
        return jsonObject ;
    }

    @RequestMapping(value = "/test3" , method = RequestMethod.GET)
    public JSONObject test3(){
        List<Shop> list = (List<Shop>) map.get("data");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data" , list);
        return  jsonObject ;
    }
}
