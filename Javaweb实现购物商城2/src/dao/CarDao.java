package dao;

import bean.Car;
import bean.Commodity;
import bean.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import util.DBHelper;

import java.sql.*;
import java.util.ArrayList;

public class CarDao {

    // QueryRunner是SQL语句的操作对象
    QueryRunner runner = new QueryRunner(); // 完成数据库的增删改查

    // 添加购物车信息
    public void setCargoods (String name,String id,String amount) throws SQLException {
        // 1.调用DBHelper获取连接对象
        Connection conn = DBHelper.getConnection();
        // 2.准备执行的sql语句
        String sql="insert into car (user_name,goods,amount,state) values (?,?,?,?); ";
        // 3.调用查询方法,将查询的数据封装成User对象
        int count = runner.update(conn,sql,name,id,amount,"0");
        // 4.关闭连接对象
        DBHelper.close(conn);

    }


    // 遍历 该用户 在 购物车 中加入了 什么商品
    public ArrayList<Car> CarCommodity(String text) throws SQLException {
        Connection con = DBHelper.getConnection();
        ArrayList<Car> cargoods = new ArrayList<>();
        String sql = "select g.id,g.name, g.price,g.introduce,g.img,c.amount from commodity g,car c WHERE g.id=c.goods and user_name=? and state = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1,text);
        preparedStatement.setString(2,"0");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            cargoods.add(new Car(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6)));
        }
        return cargoods;

    }

    // 下架购物车商品
    public void delCar (String id,String name)throws SQLException {
        // 1.调用DBHelper获取连接对象
        Connection conn = DBHelper.getConnection();
        // 2.准备执行的sql语句
        String sql="delete from car where user_name=?&&goods=?&&state=?";
        // 3.调用查询方法,将查询的数据封装成User对象
        int count = runner.update(conn,sql,name,id,"0");
        // 4.关闭连接对象
        DBHelper.close(conn);
    }


    //  判断购物车 是否有这个商品
    public Car getCar (String name , String id) throws SQLException {
        // 1.调用DBHelper获取连接对象
        Connection  conn = DBHelper.getConnection();
        // 2.准备执行的sql语句
        String sql="select * from car where user_name=? and goods=? and state = ? ";
        // 3.调用查询方法,将查询的数据封装成User对象
        Car car = runner.query(conn,sql,new BeanHandler<Car>(Car.class),name,id ,"0");
        // 4.关闭连接对象
        DBHelper.close(conn);
        // 5.返回car
        return car;
    }

    // 清除 购物车内容
    public void buyCar (String name) throws SQLException{
        Connection  conn = DBHelper.getConnection();
        // 2.准备执行的sql语句
        String sql="update car set state = ? where user_name = ? ";
        // 3.调用查询方法,将查询的数据封装成User对象
       PreparedStatement preparedStatement = conn.prepareStatement(sql);
       preparedStatement.setString(1,"1");
       preparedStatement.setString(2,name);
       preparedStatement.executeUpdate();
        // 4.关闭连接对象
        DBHelper.close(conn);

    }



// 遍历 该用户 已经下单 的 物品
    public ArrayList<Car> buyCommodity(String text) throws SQLException {

        Connection con = DBHelper.getConnection();
        ArrayList<Car> cargoods = new ArrayList<>();
        String sql = "select g.id,g.name, g.price,g.introduce,g.img,c.amount from commodity g,car c WHERE g.id=c.goods and user_name=? and state = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1,text);
        preparedStatement.setString(2,"1");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            cargoods.add(new Car(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6)));
        }
        return cargoods;
    }

    // 遍历 该用户 已经收藏 的 物品
    public ArrayList<Car> collectCommodity(String text) throws SQLException {
        Connection con = DBHelper.getConnection();
        ArrayList<Car> cargoods = new ArrayList<>();
        String sql = "select g.id,g.name, g.price,g.introduce,g.img,c.amount from commodity g,car c WHERE g.id=c.goods and user_name=? and state = ?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1,text);
        preparedStatement.setString(2,"2");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            cargoods.add(new Car(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6)));
        }
        return cargoods;
    }

    // 取消收藏的商品
    public void delCollect (String id,String name)throws SQLException {
        // 1.调用DBHelper获取连接对象
        Connection conn = DBHelper.getConnection();
        // 2.准备执行的sql语句
        String sql="delete from car where user_name=?&&goods=?&&state=?";
        // 3.调用查询方法,将查询的数据封装成User对象
        int count = runner.update(conn,sql,name,id,"2");
        // 4.关闭连接对象
        DBHelper.close(conn);
    }

    // 添加商品收藏信息
    public void setCollect (String name,String id,String amount) throws SQLException {
        // 1.调用DBHelper获取连接对象
        Connection conn = DBHelper.getConnection();
        // 2.准备执行的sql语句
        String sql="insert into car (user_name,goods,amount,state) values (?,?,?,?); ";
        // 3.调用查询方法,将查询的数据封装成User对象
        int count = runner.update(conn,sql,name,id,amount,"2");
        // 4.关闭连接对象
        DBHelper.close(conn);
    }

    // 删除 订单信息
    public void delBuy (String id,String name)throws SQLException {
        // 1.调用DBHelper获取连接对象
        Connection conn = DBHelper.getConnection();
        // 2.准备执行的sql语句
        String sql="delete from car where user_name=?&&goods=?&&state=?";
        // 3.调用查询方法,将查询的数据封装成User对象
        int count = runner.update(conn,sql,name,id,"1");
        // 4.关闭连接对象
        DBHelper.close(conn);
    }

}
