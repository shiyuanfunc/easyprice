package com.third.easyprice.service;

import com.third.easyprice.bean.Shop;

import java.util.List;
import java.util.Map;

public interface ShopService {

    List<Shop> queryByName(List<Map<String , Object>> json);
}
