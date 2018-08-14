package com.third.easyprice.service.impl;

import com.third.easyprice.dao.ShopDao;
import com.third.easyprice.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {


    @Autowired
    private ShopDao shopDao ;

    @Override
    public List<Object> queryByName(String shopName) {

        List<Object> objects = shopDao.queryByName(shopName);
        return objects;
    }
}
