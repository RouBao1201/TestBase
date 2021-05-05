package com.syb.customEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Abin
 * @date Created in 2021/5/5 15:15
 * @Modified By:
 * @Description
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ResponseEnum {
    SUCCESS(200,"success"),ERROR(500,"error");
    private Integer code;
    private String message;

}
