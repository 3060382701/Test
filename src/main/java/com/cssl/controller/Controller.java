package com.cssl.controller;

import com.cssl.pojo.Emp;
import com.cssl.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private EmpService eservice;

    @GetMapping("/chaxun")
    public String chaxun(Model model)
    {
        List<Emp> list=eservice.selectall();
        for (Emp emp : list) {
            System.out.println(emp+"\t");
        }
        model.addAttribute("elist", list);
        return "success";
    }

    @RequestMapping("/fenye")
    public String  findall(int pageindex,Model model)
    {
        Page<Emp> page=eservice.findall(pageindex);
        model.addAttribute("page", page);
        return "success";
    }

    @ResponseBody
    @PostMapping("/fenye1")
    public List<Emp> fen(int pageindex,Model mod) throws IOException
    {
        System.out.println("来过");
        PageHelper.startPage(pageindex, 3);
        List<Emp> page=eservice.findall(pageindex);
        mod.addAttribute("page", page);
        return page;
    }
}
