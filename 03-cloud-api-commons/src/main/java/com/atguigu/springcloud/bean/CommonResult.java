package com.atguigu.springcloud.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description: 向前端页面传递的实体类
 * @Author 胡菜鸡
 * @Create 2021-11-17-14:32
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    private Integer code;   //数字编码 如404
    private String  message; //消息
    private T       data;   //数据

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
