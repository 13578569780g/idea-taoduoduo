package dao;

import bean.Commodity;
import bean.User;
import bean.UserInfor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {

    // QueryRunner是SQL语句的操作对象
    QueryRunner runner = new QueryRunner(); // 完成数据库的增删改查
    //  登录账号
    public User getUser (String name , String pwd) throws SQLException {
        // 1.调用DBHelper获取连接对象
        Connection  conn = DBHelper.getConnection();
        // 2.准备执行的sql语句
        String sql="select * from user where name=? and pwd=? ";
        // 3.调用查询方法,将查询的数据封装成User对象
        User user = runner.query(conn,sql,new BeanHandler<User>(User.class),name,pwd);
        // 4.关闭连接对象
        DBHelper.close(conn);
        // 5.返回user
        return user;
    }

    //   注册账号
    public void setUser (String name , String pwd,String imgs , String phone , String address) throws SQLException {
        // 1.调用DBHelper获取连接对象
        Connection  conn = DBHelper.getConnection();
        // 2.准备执行的sql语句
        String sql="insert into user (name,pwd,imgs,phone,address) values (?,?,?,?,?); ";
        // 3.调用查询方法,将查询的数据封装成User对象
        int count = runner.update(conn,sql,name,pwd,imgs,phone,address);
        // 4.关闭连接对象
        DBHelper.close(conn);
    }

    public int getManage (String name , String pwd) throws SQLException {
        int temp = 0;
        // 1.调用DBHelper获取连接对象
        Connection  conn = DBHelper.getConnection();
        // 2.准备执行的sql语句
        String sql="select * from manage where name=? and pwd=? ";
        // 3.调用查询方法,将查询的数据封装成User对象
        User user = runner.query(conn,sql,new BeanHandler<User>(User.class),name,pwd);
        // 4.关闭连接对象
        DBHelper.close(conn);
        if(user != null){
            temp = 0;
        }else {
            temp = 1;
        }
        return temp;
    }

    // 查找用户信息
    public ArrayList<UserInfor> findUserInfor(String name) throws SQLException {
        Connection con = DBHelper.getConnection();
        ArrayList<UserInfor> findgoods = new ArrayList<>();
        String sql = "select * from user where name =?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            findgoods.add(new UserInfor(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6)));
        }
        return findgoods;
    }

    // 修改保存用户信息
    public void modUser (int id ,String name,String pwd,String phone,String imgpath,String address)throws SQLException {
        // 1.调用DBHelper获取连接对象
        Connection conn = DBHelper.getConnection();
        // 2.准备执行的sql语句
        String sql="update user set name=?,pwd=?,imgs=? , phone=?,address=? where id=?";
        // 3.调用查询方法,将查询的数据封装成User对象
        int count = runner.update(conn,sql,name,pwd,imgpath,phone,address,id);
        System.out.println(count);
        // 4.关闭连接对象
        DBHelper.close(conn);
    }



}
