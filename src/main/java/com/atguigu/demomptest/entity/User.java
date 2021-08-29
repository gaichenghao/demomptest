package com.atguigu.demomptest.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
//可指定某个表
//@TableName("User")
public class User {
    private long id;
    private String name;
    private Integer age;
    private  String email;
    //当model字段多于数据库中 报错
    //private  int num;
}
