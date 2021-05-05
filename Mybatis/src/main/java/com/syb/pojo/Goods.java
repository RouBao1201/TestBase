package com.syb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Abin
 * @date Created in 2021/5/1 0:05
 * @Modified By:
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    private Integer id;
    private String name;
    private Integer prices;
}
