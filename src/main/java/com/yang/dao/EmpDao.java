package com.yang.dao;

import com.yang.entity.Emp;

import java.util.List;

public interface EmpDao {
    //查询所有
    List<Emp> selectAll();

    //添加
    void insertOne(Emp emp);

    //删除
    void deleteOne(String id);

    //更新
    void updateOne(Emp emp);

    //根据id查询一个
    Emp selectOneEmp(String id);
}
