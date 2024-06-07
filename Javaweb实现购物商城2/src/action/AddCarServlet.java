package action;

import bean.Car;
import bean.User;
import dao.CarAmountDao;
import dao.CarDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/AddCar")
public class AddCarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        // 获取商品 ID
        String i = req.getParameter("id");

        // 获取 用户名
        User user = (User) req.getSession(false).getAttribute("user");
        String name = user.getName();
        CarDao carDao = new CarDao();

        CarAmountDao carAmountDao = new CarAmountDao();
        String amount="" ;
        int amount1 = 0;

        Car car = new Car();
        try {
            car = carDao.getCar(name,i);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (car!=null){

            try {
                amount = carAmountDao.findAmount(name,i);
                amount1 = Integer.parseInt(amount) + 1;
                carAmountDao.modCarAmount(String.valueOf(amount1),name,i);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }else {
            try {
                carDao.setCargoods(name,i,"1");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

        out.println("<script>alert('该物品已成功加入购物车');location.href = '/Car?demo=2';</script>");

    }
}
