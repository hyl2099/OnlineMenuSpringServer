package com.lisa.onlineMenu.repository;

import com.lisa.onlineMenu.documents.menu.Menu;
import com.lisa.onlineMenu.repository.menu.MenuRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuRepositoryTest {
    // @Autowired注解：自动加载Spring为我们自动实例化的实现了TeacherRepository接口的对象
    @Autowired
    private MenuRepository menuRepository;

    // @Test：本方法为一个单元测试方法
    @Test
    public void addTeacher() {
        // 执行数据保存操作
        menuRepository.save(new Menu());
        // 打印Spring为我们自动实例化的对象
        System.out.println(menuRepository);
    }
}
