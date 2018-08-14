package com.third.easyprice.controller;

import com.alibaba.fastjson.JSONObject;
import com.third.easyprice.bean.Shop;
import com.third.easyprice.dao.ShopDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/price")
public class TestController {

    @Autowired
    private ShopDao shopDao ;

    @RequestMapping(value = "/test" , method = RequestMethod.GET)
    public JSONObject test(){

        String name = "1" ;
        List<Shop> objects = shopDao.queryByName(name);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", objects) ;
        jsonObject.put("msg" , "success") ;
        return jsonObject;

    }
}
