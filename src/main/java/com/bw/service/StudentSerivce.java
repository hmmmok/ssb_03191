package com.bw.service;

import com.bw.mapper.StudentMapper;
import com.bw.pojo.PageResult;
import com.bw.pojo.Student;
import com.bw.pojo.StudentExample;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentSerivce implements  IStudentService {

                    @Resource
                    StudentMapper  studentMapper;

                    @Override
                    public Student login(String name, String pwd) {
                        StudentExample example=new StudentExample();
                        StudentExample.Criteria criteria = example.createCriteria();
                        criteria.andNameEqualTo(name);
                        criteria.andPwdEqualTo(pwd);
                        List<Student> list=this.studentMapper.selectByExample(example);
                      if(list.size()==0){
                         return  null;
                      }
                        return list.get(0);
                    }

                    @Override
                    public PageResult getList(int pageNum, int pageSize) {
                        PageHelper.startPage(pageNum,pageSize);
                        List<Student> list=this.studentMapper.selectByExample(null);
                        Page<Student> page= (Page<Student>) list;
                        return new PageResult(page.getResult(),page.getTotal());
                    }

                    @Override
                    public int del(int id) {
                        return this.studentMapper.deleteByPrimaryKey(id);
                    }

                    @Override
                    public int add(Student student) {
                        return this.studentMapper.insert(student);
                    }

                    @Override
                    public Student findOne(int id) {
                        return this.studentMapper.selectByPrimaryKey(id);

                    }

                    @Override
                    public int update(Student student) {
                        return this.studentMapper.updateByPrimaryKeySelective(student);
                    }

}
