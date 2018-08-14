package com.third.easyprice.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.third.easyprice.bean.Shop;
import com.third.easyprice.dao.ShopDao;
import com.third.easyprice.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDao shopDao ;

    @Override
    public List<Shop> queryByName(List<Map<String , Object>> json , String key) {

        if (json.isEmpty()){
            return null ;
        }

        List<Shop> resultList = new LinkedList<>();

        for (Map map : json){
            String score = map.get("score").toString();
            if (Double.parseDouble(score) >= 0.5){
                List<Shop> result = shopDao.queryByName(map.get("keyword").toString().trim());
                resultList.addAll(result);
            }
        }

        Jedis jedis = new Jedis("111.231.232.212" , 6379);
        jedis.auth("redisroot");
        jedis.set(key , resultList.toString());

        return resultList;
    }

    /**
     *  根据排列要求排序
     * @param key
     * @return
     */
    @Override
    public List<Shop> orderList(String key , String type) {

        Jedis jedis = new Jedis("111.231.232.212" , 6379);
        jedis.auth("redisroot");
        String resultStr = jedis.get(key);

        JSONArray array = JSONObject.parseArray(resultStr);
        List<Shop> list1 = new ArrayList<>();
        List<Shop> list2 = new ArrayList<>();
        for (Object o : array){
            Shop shop = (Shop)o;
            if (shop.getStore().equals(type)){
                list1.add(shop);
            }else{
                list2.add(shop);
            }
        }
        //对list数据进行排序
        List<Shop> resultList = new LinkedList<>();
        resultList.addAll(list1);
        resultList.addAll(list2);

        return resultList;
    }
}
