package com.atguigu.springcloud.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Description:
 * @Author 胡菜鸡
 * @Create 2021-11-17-13:48
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {  //实现Serializable（序列化）接口
    private Long    id;
    private String  serial;
}
