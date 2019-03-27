package com.bw.service;

import com.bw.pojo.PageResult;
import com.bw.pojo.Student;

public interface IStudentService {
    Student login(String name, String pwd);

    PageResult getList(int pageNum, int pageSize);

    int del(int id);

    int add(Student student);

    Student findOne(int id);

    int update(Student student);
}
