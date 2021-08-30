package com.atguigu.demomptest.entity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

@Data
//可指定某个表
//@TableName("User")
public class User {

    @TableId(type = IdType.ASSIGN_ID)
    //@TableId(type = IdType.INPUT)//可以自己输入
    private Long id;

    private String name;
    private Integer age;
    private  String email;
    //LocalDate
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;//create_time
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private  Date updateTime;//update_time

    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;

    //当model字段多于数据库中 报错
    //private  int num;
}
