package com.third.easyprice.dao;

import com.third.easyprice.bean.Shop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ShopDao {

    List<Shop> queryByName(String shopName);

    List<Shop> orderList(Map<String ,String > map);
}
