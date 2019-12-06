package com.yang.controller;

import com.yang.entity.Emp;
import com.yang.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("Emp")
public class EmpController {
    @Autowired
    private EmpService empService;

    @RequestMapping("findAll")
    public String findAll(HttpServletRequest request) {
        List<Emp> list = new ArrayList<>();
        list = empService.findtAll();
        request.setAttribute("list", list);
        return "emplist";
    }

    //删除
    @RequestMapping("deleteOne")
    public String deleteOne(String id) {
        empService.removeOne(id);
        return "redirect:/Emp/findAll";
    }

    //添加
    @RequestMapping("addOne")
    public String addOne(Emp emp) {
        empService.addOne(emp);
        return "redirect:/Emp/findAll";
    }

    //根据id查询一个
    @RequestMapping("findOne")
    public String findOne(String id, HttpServletRequest request) {
        Emp emp = empService.findOneEmp(id);
        request.setAttribute("emp", emp);
        return "updateEmp";
    }

    //    更新
    @RequestMapping("updateOne")
    public String updateOne(Emp emp) {
        empService.modifyOne(emp);
        return "redirect:/Emp/findAll";
    }

}
