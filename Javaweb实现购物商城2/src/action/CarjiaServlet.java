package action;

import bean.User;
import dao.CarAmountDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/carjia")
public class CarjiaServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        // 获取 用户名
        User user = (User) req.getSession(false).getAttribute("user");
        String id = req.getParameter("id");
        String name = user.getName();
        String amount = req.getParameter("amount");

        int amount1 = 0;
        amount1 = Integer.parseInt(amount);
        amount1++;
        amount = String.valueOf(amount1);

        CarAmountDao carAmountDao = new CarAmountDao();
        try {
            carAmountDao.modCarAmount(amount,name,id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        req.getRequestDispatcher("/Car?demo=2").forward(req, resp);

    }

}
