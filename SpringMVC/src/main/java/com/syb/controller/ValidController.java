package com.syb.controller;

import com.syb.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.validation.Valid;

/**
 * @Auther: Abin
 * @Description:
 * @Date: Created in 21:06 2021/4/28
 * @Modified By:
 */
@Controller
public class ValidController {

    @RequestMapping("valid/{name}")
    @ResponseBody
    public String showValidOne(@PathVariable("name")  String name) {
        return "Hello_Valid";
    }

    @RequestMapping("valid")
    @ResponseBody
    public String showValidTwo(@Validated @RequestBody Student student,BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return bindingResult.getFieldError().getDefaultMessage();
        }
        return "OK";
    }

    @RequestMapping("validated")
    @ResponseBody
    public String showValidated(@RequestBody @Valid Student student, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return bindingResult.getFieldError().getDefaultMessage();
        }
        return "Hello_Validated";
    }
}
