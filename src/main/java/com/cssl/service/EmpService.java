package com.cssl.service;

import com.cssl.pojo.Emp;
import com.github.pagehelper.Page;

import java.util.List;

public interface EmpService {

    public List<Emp> selectall();

    public Page<Emp> findall(int pageindex);

}
