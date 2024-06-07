package action;

import bean.User;
import dao.CarDao;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/Car")
public class CarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        // 获取 用户名
        User user = (User) req.getSession(false).getAttribute("user");
        String name = user.getName();

        CarDao carDao = new CarDao();
        UserDao userDao = new UserDao();

        String id = req.getParameter("demo"); // 获取 哪一张方式
        if (id.equals("1")){  // 购物车中 结算
            try {
                carDao.buyCar(name);
                req.setAttribute("Arraylist",  carDao.CarCommodity(name));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            req.getRequestDispatcher("car.jsp").forward(req, resp);
        }else if(id.equals("2")){   // 查看购物车
            try {
                req.setAttribute("Arraylist",  carDao.CarCommodity(name));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            req.getRequestDispatcher("car.jsp").forward(req, resp);
        }else if(id.equals("3")){      //  查看个人订单
            try {
                req.setAttribute("Arraylist",  carDao.buyCommodity(name));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            req.getRequestDispatcher("order.jsp").forward(req, resp);
        }else if (id.equals("5")){       // 购物车 点击结算，跳转到结算页面
            try {
                req.setAttribute("Arraylist",  carDao.CarCommodity(name));
                req.setAttribute("address",userDao.findUserInfor(name).get(0).getAddress());
                req.setAttribute("name",userDao.findUserInfor(name).get(0).getName());
                req.setAttribute("phone",userDao.findUserInfor(name).get(0).getPhone());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            req.getRequestDispatcher("bill.jsp").forward(req, resp);
        }else if (id.equals("6")){  // 订单页面，点击付款，付款成功，跳转到 个人订单
            try {
                carDao.buyCar(name);
                req.setAttribute("Arraylist",  carDao.CarCommodity(name));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            out.println("<script>alert('付款成功!');location.href = '/Car?demo=3';</script>");
        }else if (id.equals("7")){  // 在商品详情页 点击 收藏商品
            String shopid = req.getParameter("idd"); // 商品id
            try {
                carDao.setCollect(name,shopid,"1");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            out.println("<script>alert('收藏成功!');location.href = '/Car?demo=8';</script>");
        }else if (id.equals("8")){ // 主页面中  点击查看 我的收藏
            try {
                req.setAttribute("Arraylist", carDao.collectCommodity(name));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            req.getRequestDispatcher("collect.jsp").forward(req, resp);
        }else if (id.equals("9")){ // 收藏页面中  取消收藏
            String shopid = req.getParameter("shopidd"); // 收藏订单的号
            try {
                carDao.delCollect(shopid,name);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            out.println("<script>alert('取消收藏成功!');location.href = '/Car?demo=8';</script>");
        }else if (id.equals("10")){   // 删除订单信息
            String shopid = req.getParameter("idd");
            try {
                carDao.delBuy(shopid,name);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            out.println("<script>alert('删除订单成功!');location.href = '/Car?demo=3';</script>");
        }


    }
}
