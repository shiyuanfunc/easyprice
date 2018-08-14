package com.third.easyprice.service.impl;

import com.third.easyprice.bean.Shop;
import com.third.easyprice.dao.ShopDao;
import com.third.easyprice.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ShopServiceImpl implements ShopService {


    @Autowired
    private ShopDao shopDao ;

    @Override
    public List<Shop> queryByName(List<Map<String , Object>> json) {

        if (json.isEmpty()){
            return null ;
        }

        List<Shop> resultList = new ArrayList<>();

        for (Map map : json){
            String score = map.get("score").toString();
            if (Double.parseDouble(score) >= 0.5){
                List<Shop> result = shopDao.queryByName(map.get("keyword").toString().trim());
                resultList.addAll(result);
            }
        }
        return resultList;
    }
}
