package com.yang.service;

import com.yang.dao.EmpDao;
import com.yang.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Emp> findtAll() {
        return empDao.selectAll();
    }

    @Override
    public void addOne(Emp emp) {
        empDao.insertOne(emp);
    }

    @Override
    public void removeOne(String id) {
        empDao.deleteOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void modifyOne(Emp emp) {
        empDao.updateOne(emp);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Emp findOneEmp(String id) {
        return empDao.selectOneEmp(id);
    }
}
