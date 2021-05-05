package com.syb.service;

import com.syb.pojo.Goods;
import com.syb.pojo.PurchaseRecord;

import java.util.List;

/**
 * @author Abin
 * @date Created in 2021/5/1 0:14
 * @Modified By:
 * @Description
 */
public interface GoodsService {
    List<Goods> findAll();
    Goods findByGoodsName(String name);
    String insertPurchase(PurchaseRecord purchaseRecord);
    Integer updateStockByGoodsId(Integer goodsid,Integer num);
}
