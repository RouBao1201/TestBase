package com.syb.pojo;

import com.syb.customEnum.ResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Abin
 * @date Created in 2021/5/5 13:09
 * @Modified By:
 * @Description 返回前台信息对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseResult {
    private Integer code;
    private String message;
    private Object data;


    public static ResponseResult success(Integer code,String message,Object data){
        ResponseResult result = new ResponseResult();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static ResponseResult success(String message,Object data){
        ResponseResult result = new ResponseResult();
        result.setCode(ResponseEnum.SUCCESS.getCode());
        result.setMessage(message);
        result.setData(data);
        return result;
    }


    public static ResponseResult error(Integer code,String message,Object data){
        ResponseResult result = new ResponseResult();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static ResponseResult error(String message,Object data){
        ResponseResult result = new ResponseResult();
        result.setCode(ResponseEnum.ERROR.getCode());
        result.setMessage(message);
        result.setData(data);
        return result;
    }

}
