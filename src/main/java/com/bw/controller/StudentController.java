package com.bw.controller;

import com.bw.pojo.PageResult;
import com.bw.pojo.Student;
import com.bw.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@ResponseBody
public class StudentController {
                        @Autowired
                        IStudentService studentService;

                /**
                 * 登录
                 * @param student
                 * @param session
                 * @return
                 */
                   @RequestMapping("/login")
                   public boolean login(Student student , HttpSession session){
                   student=this.studentService.login(student.getName(),student.getPwd());
                    if(student!=null){
                      session.setAttribute("studentId",student.getId());
                      return true;
                      }
                      return false;
                  }
                    /**
                     * 列表
                     */
                    @RequestMapping("/list")
                    public PageResult list(int pageNum, int pageSize){
                            return  this.studentService.getList(pageNum,pageSize);
                             }
                    /**
                     * 删除
                     */
                    @RequestMapping("/del")
                    public boolean del(int  id){
                        return this.studentService.del(id)>1;
                    }
                /**
                 * 添加
                 */
                    @RequestMapping("/add")
                   public int add(@RequestBody Student student){
                        return this.studentService.add(student);
                    }
                    /**
                     *回显
                     */
                    @RequestMapping("/findOne")
                    public Student findOne(int id){

                        return this.studentService.findOne(id);
                    }
                    /**
                     * 修改
                     */
                    @RequestMapping("/update")
                    public int update(@RequestBody Student student){

                        return this.studentService.update(student);
                    }
}
