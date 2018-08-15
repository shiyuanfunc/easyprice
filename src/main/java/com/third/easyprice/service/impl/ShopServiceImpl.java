package com.third.easyprice.service.impl;

import com.third.easyprice.bean.Shop;
import com.third.easyprice.dao.ShopDao;
import com.third.easyprice.service.ShopService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
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
        StringBuilder sb = new StringBuilder();

        for (Shop shop : resultList){
            sb.append("'");
            sb.append(shop.getProductId());
            sb.append("'");
            sb.append(",");
        }
        String ids = sb.toString();
        if (!StringUtils.isBlank(ids)){
            ids = ids.substring(0,ids.length()-1);
        }

        Jedis jedis = new Jedis("111.231.232.212" , 6379);
        jedis.auth("redisroot");
        jedis.set("123456789" , ids);

        return resultList;
    }

    /**
     *  根据排列要求排序
     * @param
     * @return
     */
    @Override
    public List<Shop> orderList(String type) {

        Jedis jedis = new Jedis("111.231.232.212" , 6379);
        jedis.auth("redisroot");
        String ids = jedis.get("123456789");

        Map<String , String > map = new HashMap<>();
        map.put("ids", ids);
        // 0.天猫  1.京东  2.苏宁
        map.put("key" , type);
        List<Shop> list = shopDao.orderList(map);
        return list ;
    }
}
