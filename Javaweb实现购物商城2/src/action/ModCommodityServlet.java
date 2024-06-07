package action;

import dao.CommodityDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns="/indexmod")
public class ModCommodityServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        CommodityDao commodityDao = new CommodityDao();
        String temp = req.getParameter("mod");
        int temp1 = 0;

        if (temp!=null) {
            temp1=Integer.parseInt(temp);
        }

        String method = req.getParameter("type");

        switch (method) {
            case "mod1":

                String s1 = null;
                String s2 = null;
                String s3 = null;
                String s4 = null;
                try {
                    s1 = commodityDao.modfindCommodity(temp1).getName();
                    s2 = commodityDao.modfindCommodity(temp1).getPrice();
                    s3 = commodityDao.modfindCommodity(temp1).getIntroduce();
                    s4 = commodityDao.modfindCommodity(temp1).getImg();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                req.setAttribute("name1", s1);
                req.setAttribute("price1", s2);
                req.setAttribute("introduce1", s3);
                req.setAttribute("id1",temp1);
                req.setAttribute("img1",s4);
                req.getRequestDispatcher("mod.jsp").forward(req, resp);
                break;

        }

    }

}