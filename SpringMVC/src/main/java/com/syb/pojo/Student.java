package com.syb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

/**
 * @Auther: Abin
 * @Description:
 * @Date: Created in 21:16 2021/4/28
 * @Modified By:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @NotBlank(message = "姓名不能为空")
    private String name;

    @Max(value = 100,message = "年龄不能超过100岁")
    private Integer age;

    @Null(message = "性别不能填写")
    private String sex;

    @Email(message = "邮箱格式不正确")
    private String email;
}
