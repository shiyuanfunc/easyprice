package com.third.easyprice.dao;

import com.third.easyprice.bean.Shop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopDao {

    List<Shop> queryByName(String shopName);
}
