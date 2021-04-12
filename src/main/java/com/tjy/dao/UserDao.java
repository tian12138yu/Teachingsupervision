package com.tjy.dao;

import com.tjy.domian.Notice;
import com.tjy.domian.Student;
import com.tjy.domian.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    public User getUserByMassage(@Param("username") String username, @Param("password") String password);
    public List<User> getAllUser(@Param("username") String username,@Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
    public int getUserCounts(@Param("username") String username);
    public int updateState(Integer id, Boolean state);
    public int addUser(User user);
    public User getUpdateUser(int id);
    public int editUser(User user);
    public int deleteUser(int id);
    int getUserIdByName(String name);
    Student getStudent(String username, String password);

    void insertNotice(Notice notice);
    List<Notice> getNotice(User user);

    void updateNoticeById(Integer id);

    void updateUser(User user1);

    int getCountUserLogin();
}
