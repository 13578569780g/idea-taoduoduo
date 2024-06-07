package action;

import bean.User;
import biz.UserBiz;
import dao.UserDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


@WebServlet("/user.let")
public class UserServlet extends HttpServlet {

    // 构建UserBiz的对象
    UserBiz userBiz = new UserBiz();

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

        //1.判读用户请求的类型为login
        String method = req.getParameter("type");
        switch (method) {
            case "login":
                // 从 login.html中 拿 账号，密码等数据
                String name = req.getParameter("name");
                String pwd = req.getParameter("pwd");

                String option = req.getParameter("option");
                int temp = -1;
                //  调用UserBiz的getUser方法，根据 网页中 输入的账号密码，获取相应对象
                User user = userBiz.getUser(name,pwd);
                if(option.equals("option1")){  // 用户登录
                    if (user == null) {
                        out.println("<script>alert('用户名或密码不存在');location.href = 'login.html';</script>");
                    }else {
                        session.setAttribute("user",user);//user-->Object
                        req.getRequestDispatcher("/UserShow").forward(req, resp);

                    }
                }else if(option.equals("option2")){  // 管理员登录
                    try {
                        temp = new UserDao().getManage(name,pwd);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    if (temp == 1){
                        out.println("<script>alert('用户名或密码不存在');location.href = 'login.html';</script>");
                    }else{
                        req.getRequestDispatcher("/index").forward(req, resp);
                    }
                }

                 break;
            case "register" :

                // 从 login.html中 拿 账号，密码等数据
                String name1 = req.getParameter("name");
                String pwd1 = req.getParameter("pwd");
                String phone = req.getParameter("phone");
                String address = req.getParameter("address");
                UserDao userDao = new UserDao();
                try {
                    userDao.setUser(name1,pwd1,"imgs/touxiang.jpg",phone,address);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                out.println("<script>alert('注册成功');location.href = 'login.html';</script>");
                break;

        }

    }

}
