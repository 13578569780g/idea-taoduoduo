package action;

import bean.Commodity;
import dao.CommodityDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(urlPatterns = "/Showgoods")
public class ShowGoodsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String temp = req.getParameter("id");
        Commodity commodity = new Commodity();

        CommodityDao commodityDao = new CommodityDao();

        if (temp!=null){
            int temp1 = Integer.parseInt(temp);
            try {
                commodity=commodityDao.modfindCommodity(temp1);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        req.setAttribute("name",commodity.getName());
        req.setAttribute("price",commodity.getPrice());
        req.setAttribute("introduce",commodity.getIntroduce());
        req.setAttribute("img",commodity.getImg());
        req.setAttribute("id",commodity.getId());

        req.getRequestDispatcher("show_goods.jsp").forward(req, resp);


    }

}
