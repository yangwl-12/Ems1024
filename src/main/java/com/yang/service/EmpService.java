package com.yang.service;

import com.yang.entity.Emp;

import java.util.List;

public interface EmpService {
    //查询所有
    List<Emp> findtAll();

    //添加
    void addOne(Emp emp);

    //删除
    void removeOne(String id);

    //更新
    void modifyOne(Emp emp);

    //根据id查询一个
    Emp findOneEmp(String id);
}
