package dao;

import org.apache.commons.dbutils.QueryRunner;
import util.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarAmountDao {

    // QueryRunner是SQL语句的操作对象
    QueryRunner runner = new QueryRunner(); // 完成数据库的增删改查


    //  更新 数量
    public void modCarAmount (String amount , String name, String goods)throws SQLException {
        // 1.调用DBHelper获取连接对象
        Connection conn = DBHelper.getConnection();
        // 2.准备执行的sql语句
        String sql="update car set amount=? where user_name=?&& goods=?";
        // 3.调用查询方法,将查询的数据封装成User对象
        int count = runner.update(conn,sql,amount,name,goods);
        // 4.关闭连接对象
        DBHelper.close(conn);
    }


    // 查询 该商品 目前购物车里面有 几个
    public String findAmount (String name, String id)throws SQLException{
        String count="";
        // 1.调用DBHelper获取连接对象
        Connection conn = DBHelper.getConnection();
        // 2.准备执行的sql语句
        String sql="select amount from car where user_name=? && goods=?";
        // 3.调用查询方法,将查询的数据封装成User对象
        PreparedStatement preparedStatement =conn.prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            count =  resultSet.getString(1);
        }

        // 4.关闭连接对象
        DBHelper.close(conn);
        return count;
    }

}
