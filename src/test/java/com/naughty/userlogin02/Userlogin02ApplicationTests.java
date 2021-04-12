package com.naughty.userlogin02;

//import com.naughty.userlogin02.dao.MenuDao;
import com.tjy.dao.MenuDao;
import com.tjy.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Userlogin02ApplicationTests {

    @Autowired
    UserDao userDao;
    @Autowired
    MenuDao menuDao;

    @Test
    void contextLoads() {
//        List<User> ulist = userDao.getAllUser(null,0,2);
//        System.out.println("总人数为: "+ulist.size());
//        for (User us:ulist
//             ) {
//            System.out.println(us);
//        }

    }

}
