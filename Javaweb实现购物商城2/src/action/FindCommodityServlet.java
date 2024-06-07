package action;

import dao.CommodityDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/FindCommodity")
public class FindCommodityServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String id = req.getParameter("id");
        String text = req.getParameter("text1");
        CommodityDao commodityDao = new CommodityDao();

        if (id.equals("1")){

            try {
                req.setAttribute("Arraylist",commodityDao.findCommodity(text));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            req.getRequestDispatcher("index.jsp").forward(req, resp);

        }else if (id.equals("2")){
            try {
                req.setAttribute("Arraylist1",commodityDao.findCommodity(text));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            req.setAttribute("footName","商品");
            req.getRequestDispatcher("user_index.jsp").forward(req, resp);
        }else if (id.equals("3")){  // 美妆类
            try {
                req.setAttribute("Arraylist1",commodityDao.findTypeCommodity(id));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            req.setAttribute("footName","美妆类商品");
            req.getRequestDispatcher("user_index.jsp").forward(req, resp);
        }else if (id.equals("5")){  // 食品类商品
            try {
                req.setAttribute("Arraylist1",commodityDao.findTypeCommodity(id));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            req.setAttribute("footName","食品类商品");
            req.getRequestDispatcher("user_index.jsp").forward(req, resp);
        }else if (id.equals("6")){ // 电器类
            try {
                req.setAttribute("Arraylist1",commodityDao.findTypeCommodity(id));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            req.setAttribute("footName","电器类商品");
            req.getRequestDispatcher("user_index.jsp").forward(req, resp);
        }else if (id.equals("7")){  // 全部商品
            try {
                req.setAttribute("Arraylist1",commodityDao.getCommodity());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            req.setAttribute("footName","全部商品");
            req.getRequestDispatcher("user_index.jsp").forward(req, resp);
        }else if (id.equals("8")){  // 服装类
            try {
                req.setAttribute("Arraylist1",commodityDao.findTypeCommodity(id));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            req.setAttribute("footName","服装类商品");
            req.getRequestDispatcher("user_index.jsp").forward(req, resp);
        }


    }
}
