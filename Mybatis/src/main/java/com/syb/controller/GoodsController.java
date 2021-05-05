package com.syb.controller;

import com.syb.annotation.ValidMyself;
import com.syb.pojo.Goods;
import com.syb.pojo.PurchaseRecord;
import com.syb.pojo.ResponseResult;
import com.syb.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * @author Abin
 * @date Created in 2021/5/1 0:30
 * @Modified By:
 * @Description
 */
@Controller
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    /**
     * @author Abin
     * @date Create in 2021/5/1 4:31
     * @Param []
     * @Description 查询所有的商品信息
     */
    @RequestMapping("findAllGoods")
    @ResponseBody
    public List<Goods> findAll() {
        return goodsService.findAll();
    }

    @RequestMapping("findByGoodsName/{name}")
    @ResponseBody
    public Goods findByGoodsName(@PathVariable("name") String name) {
        return goodsService.findByGoodsName(name);
    }

    @RequestMapping("insertPurchase")
    @ResponseBody
    public ResponseResult insertPurchase(@RequestBody @ValidMyself PurchaseRecord purchaseRecord) {
        String purchaseMessage = goodsService.insertPurchase(purchaseRecord);
        ResponseResult result = ResponseResult.success(purchaseMessage, purchaseMessage);
        return result;
    }

    @RequestMapping("updateStockByGoodsId/{goodsid}/{num}")
    @ResponseBody
    public String updateStockByGoodsId(@PathVariable("goodsid") Integer goodsid, @PathVariable("num") Integer num) {
        Integer checkCount = goodsService.updateStockByGoodsId(goodsid, num);
        if(checkCount>=1){
            return "OK";
        }else{
            return "No";
        }
    }


}
