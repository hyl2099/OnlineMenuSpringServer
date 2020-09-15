package com.example.demo.Controller;

import com.example.demo.repository.Teacher;
import com.example.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;

    // 设置路由
    @RequestMapping("/teacher/save")
    // 使用@RequestBody注解，将请求的`json`数据，直接加载至teacher对象
    public Teacher saveTeacher(@RequestBody Teacher teacher) {
        // 打印加载的数据
        System.out.println(teacher);

        // 调用保存操作
        return teacherRepository.save(teacher);
    }


}
