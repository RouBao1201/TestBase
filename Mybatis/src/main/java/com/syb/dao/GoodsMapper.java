package com.syb.dao;

import com.syb.pojo.Goods;
import com.syb.pojo.PurchaseRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Abin
 * @date Created in 2021/5/1 0:02
 * @Modified By:
 * @Description
 */
@Repository
@Mapper
public interface GoodsMapper {

    List<Goods> findAll();

    Goods findByGoodsName(@Param("name") String name);

    Integer insertPurchase(PurchaseRecord purchaseRecord);

    Integer updateStockByGoodsId(@Param("goodsid") Integer goodsid,@Param("num")Integer num);

}
