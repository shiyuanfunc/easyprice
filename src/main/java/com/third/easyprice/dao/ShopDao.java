package com.third.easyprice.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopDao {

    List<Object> queryByName(String shopName);
}
