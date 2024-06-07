package biz;

import bean.User;
import dao.UserDao;

import java.sql.SQLException;

public class UserBiz {
    // 构建UserDao的对象
    UserDao userDao = new UserDao();
    //   返回 sql语句 执行的结果
    public User getUser(String name, String pwd){  // 返回 user 对象
        User  user = null;
        try {
            user  = userDao.getUser(name,pwd);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
}
