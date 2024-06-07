package dao;

import bean.Commodity;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import util.DBHelper;

import java.sql.*;
import java.util.ArrayList;

public class CommodityDao {

    // QueryRunner是SQL语句的操作对象
    QueryRunner runner = new QueryRunner(); // 完成数据库的增删改查

    // 添加商品信息
    public void setCommodity (String name,String price,String introuduce,String myimgs,int type) throws SQLException {
        // 1.调用DBHelper获取连接对象
        Connection conn = DBHelper.getConnection();
        // 2.准备执行的sql语句
        String sql="insert into commodity (name,price,introduce,img,type) values (?,?,?,?,?); ";
        // 3.调用查询方法,将查询的数据封装成User对象
        int count = runner.update(conn,sql,name,price,introuduce,myimgs,type);
        // 4.关闭连接对象
        DBHelper.close(conn);

    }
        // 将 商品 添加到 集合中，展示出来
    public ArrayList<Commodity>  getCommodity () throws SQLException {
        // 1.调用DBHelper获取连接对象
        Connection conn = DBHelper.getConnection();
        ArrayList <Commodity> data = new ArrayList<>();
        String sql2 = "select * from commodity";
        PreparedStatement preparedStatement = conn.prepareStatement(sql2);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){

            data.add(new Commodity(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5)));
        }
        return data;
    }


    // 删除商品信息
    public void delCommodity (int id)throws SQLException {
        // 1.调用DBHelper获取连接对象
        Connection conn = DBHelper.getConnection();
        // 2.准备执行的sql语句
        String sql="delete from commodity where id=?";
        // 3.调用查询方法,将查询的数据封装成User对象
        int count = runner.update(conn,sql,id);
        // 4.关闭连接对象
        DBHelper.close(conn);
    }

    // 修改商品信息
    public void modCommodity (int id ,String name,String price,String introduce,String imgpath,int type)throws SQLException {
        // 1.调用DBHelper获取连接对象
        Connection conn = DBHelper.getConnection();
        // 2.准备执行的sql语句
        String sql="update commodity set name=?,price=?,introduce=? , img=?,type=? where id=?";
        // 3.调用查询方法,将查询的数据封装成User对象
        int count = runner.update(conn,sql,name,price,introduce,imgpath,type,id);
        System.out.println(count);
        // 4.关闭连接对象
        DBHelper.close(conn);
    }


    //  修改商品的时候，根据 id 查 设置默认值
    public Commodity modfindCommodity (int id) throws SQLException {
        Connection con = DBHelper.getConnection();
        String sql3 = "select * from commodity where `id` =?";
        Commodity commodity = runner.query(con,sql3,new BeanHandler<Commodity>(Commodity.class),id);
        DBHelper.close(con);
        return commodity;
    }

    //  模糊 查找 。
    public ArrayList<Commodity> findCommodity(String text) throws SQLException {

        Connection con = DBHelper.getConnection();
        ArrayList<Commodity> findgoods = new ArrayList<>();
        String sql = "select * from commodity where name like '%"+text+"'|| name like '"+text+"%'|| name like '%"+text+"%'||name ="+"'"+text+"'";
        Statement preparedStatement = con.createStatement();
        ResultSet resultSet = preparedStatement.executeQuery(sql);
        while (resultSet.next()) {
            findgoods.add(new Commodity(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5)));
        }
        return findgoods;
    }

    // 用户 查询 不同类型的商品
    public ArrayList<Commodity> findTypeCommodity(String id) throws SQLException {

        Connection con = DBHelper.getConnection();
        ArrayList<Commodity> findgoods = new ArrayList<>();
        String sql = "select * from commodity where type =?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            findgoods.add(new Commodity(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5)));
        }
        return findgoods;
    }


}
