package com.atguigu.demomptest;

import com.atguigu.demomptest.entity.User;
import com.atguigu.demomptest.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class DemomptestApplicationTests {

    @Autowired
    private UserMapper userMapper;

    //mp复杂查询操作
    @Test
    public void testSelect(){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
       //ge、gt、le、lt
        //queryWrapper.ge("age",21);

        //eq、ne
        //queryWrapper.eq("name","aaa");

        //between nobetween
        queryWrapper.between("age",20,30);

        //like、notLike、likeLeft、likeRight
        queryWrapper.like("name","张");

        //orderBy、orderByDesc、orderByAsc
        queryWrapper.orderByDesc("id");

        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }


    @Test
    public void testDeleteId(){

        int rows = userMapper.deleteById(1432231393203810306L);
        System.out.println();


    }


    //分页查询
    @Test
    public void testSelectPage(){
        Page<User> page=new Page(1,3);
        Page<User> userPage=userMapper.selectPage(page,null);
        //返回对象得到分页所有数据
        long pages=userPage.getPages();//总页数
        long current=userPage.getCurrent();//当前页
        List<User> users=userPage.getRecords();//查询数据集合
        long totle=userPage.getTotal();//总记录数
        boolean hasNext=userPage.hasNext();//下一页
        boolean hasPrevious=userPage.hasPrevious();//上一页



    }





    //简单条件查询
    @Test
    public void testSelect2(){
        Map<String,Object> columMap=new HashMap<>();
        columMap.put("name","Lisi");
        columMap.put("age",20);
        List<User> users=userMapper.selectByMap(columMap);
        System.out.println(users);

    }


    //多个id批量查询
    @Test
    public void testSelect1(){
        List<User> users=userMapper.selectBatchIds(Arrays.asList(1432231393203810306L));
        System.out.println(users);

    }



    @Test
    public void testOptimisticLocker(){
        User user=userMapper.selectById(1432208860974825473L);
        user.setName("Lisi");
        userMapper.updateById(user);


    }



    @Test
    public void testAdd(){
        User user=new User();
        user.setName("李四");
        user.setAge(20);
        user.setEmail("@qq.com");
        int insert=userMapper.insert(user);
        System.out.println(insert);
    }

    @Test
    public void testUpdate(){
        User user=new User();
        user.setId(1432203902238040065L);
        user.setName("gaiaa");
        int count=userMapper.updateById(user);
        System.out.println(count);
    }


    @Test
    public void findAll() {
        List<User> users =userMapper.selectList(null);
        System.out.println(users);

    }

}
