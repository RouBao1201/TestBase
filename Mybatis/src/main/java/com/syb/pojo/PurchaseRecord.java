package com.syb.pojo;

import com.syb.annotation.MaxValidMyself;
import com.syb.annotation.MinValidMyself;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Abin
 * @date Created in 2021/5/4 23:02
 * @Modified By:
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseRecord {
    private Integer goodsId;
    private String goodsName;
    @MaxValidMyself(value = 100,message = "购买数量过高，怀疑你刷单!")
    @MinValidMyself(value = 1,message = "最少买一份哦！")
    private Integer purchaseCount;
    private String clientId;
}
