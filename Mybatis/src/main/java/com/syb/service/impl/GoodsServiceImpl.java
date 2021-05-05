package com.syb.service.impl;

import com.syb.annotation.TransactionMyself;
import com.syb.dao.GoodsMapper;
import com.syb.pojo.Goods;
import com.syb.pojo.PurchaseRecord;
import com.syb.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Abin
 * @date Created in 2021/5/1 0:14
 * @Modified By:
 * @Description
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public List<Goods> findAll() {
        return goodsMapper.findAll();
    }

    @Override
    public Goods findByGoodsName(String name) {
        return goodsMapper.findByGoodsName(name);
    }

    @Override
    @TransactionMyself
    public String insertPurchase(PurchaseRecord purchaseRecord) {
        Integer purchaseCount = goodsMapper.insertPurchase(purchaseRecord);
        if(purchaseCount>=1){
            return "购买成功";
        }
        return "购买失败";
    }

    @Override
    @TransactionMyself
    public Integer updateStockByGoodsId(Integer goodsid,Integer num) {
        Integer stock = goodsMapper.updateStockByGoodsId(goodsid, num);
        int cou = 2/0;
        return stock;
    }
}
