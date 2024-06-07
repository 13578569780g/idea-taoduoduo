package action;

import bean.User;
import dao.CommodityDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/UserShow")
public class UserShowServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        CommodityDao commodityDao = new CommodityDao();
        User user = (User) req.getSession(false).getAttribute("user");
        String name = user.getName();

        try {
            req.setAttribute("Arraylist1",  commodityDao.getCommodity());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        req.setAttribute("userName",name);
        req.setAttribute("footName","全部商品");
        req.getRequestDispatcher("user_index.jsp").forward(req, resp);

    }

}