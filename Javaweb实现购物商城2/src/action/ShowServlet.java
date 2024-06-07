package action;

import dao.CommodityDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/index")
public class ShowServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);

}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        CommodityDao commodityDao =new CommodityDao();

        String temp = req.getParameter("id");

        if (temp!=null){
            int temp1 = Integer.parseInt(temp);
            try {
                commodityDao.delCommodity(temp1);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        try {
            req.setAttribute("Arraylist",  commodityDao.getCommodity());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }

}
