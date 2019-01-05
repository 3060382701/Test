package com.cssl.service.impl;

import com.cssl.dao.Empdao;
import com.cssl.pojo.Emp;
import com.cssl.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class EmpServiceImpl implements EmpService {
    @Autowired
    private Empdao empdao;

    @Override
    public List<Emp> selectall() {
        return empdao.selectall();
    }

    @Override
    public Page<Emp> findall(int pageindex) {
        Page<Emp> page = PageHelper.startPage(pageindex, 3, "empno desc");
        empdao.selectall();
        return page;
    }
}
