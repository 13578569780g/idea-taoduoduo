package action;

import bean.User;
import dao.CarDao;
import dao.UserDao;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/MyInfor")
public class MyInforServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        String imgPath="";

        User user = (User) req.getSession(false).getAttribute("user");
        String name = user.getName();
        UserDao userDao = new UserDao();
        String id = req.getParameter("id");  // 判断进行什么操作
        if (id.equals("1")){  // 点击查看个人信息
            try {
                req.setAttribute("Arraylist",userDao.findUserInfor(name));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            req.getRequestDispatcher("myInfor.jsp").forward(req, resp);


        } else if (id.equals("2")){  // 点击提交修改 个人信息

//            String newid = req.getParameter("id1"); //  用户id
//            String oldimg = req.getParameter("img1");
//            System.out.println(oldimg+"----");

            try {
                String newname ="";
                String newpwd = "";
                String newphone = "";
                String newaddress = "";
                String path="";
                String newid ="";
                String oldimg="";

                List<FileItem> list = upload.parseRequest(req);
                for (FileItem item : list) {
                    if (item.isFormField()){
                        switch (item.getFieldName()){
                            case "newname" :
                                newname = item.getString("utf-8");
                                break;
                            case "newpwd" :
                                newpwd = item.getString("utf-8");
                                break;
                            case "newphone" :
                                newphone = item.getString("utf-8");
                                break;
                            case "newaddress":
                                newaddress = item.getString("utf-8");
                                break;
                            case "id1":
                                newid = item.getString("utf-8");
                            case "img1":
                                oldimg = item.getString("utf-8");
                        }
                    }else {
                        // 拿到文件的名称
                        String fileName = item.getName();
                        if(fileName.isEmpty()){
                            imgPath = oldimg;
                        }else{
                            // 时间戳唯一 唯一的fileName
                            fileName=fileName.substring(fileName.lastIndexOf("."));
                            fileName=System.currentTimeMillis()+fileName;
                            imgPath="Mysql_imgs/"+fileName;
                            // 拿到文件存储的路径
                            String fullPath = getClass().getClassLoader().getResource("").getPath();
                            String targetPath = "/out/artifacts/mydemo_war_exploded/WEB-INF/classes/";
                            String desiredPath = fullPath.replace(targetPath, "");
                            path = desiredPath+"/web/Mysql_imgs/"+fileName;
                            // 创建读写流
                            InputStream in = item.getInputStream();
                            FileOutputStream outt = new FileOutputStream(path);
                            // 完成读写操作
                            byte [] buffer = new byte[1024];
                            int len = 0 ;
                            while ((len = in.read(buffer)) > 0) {
                                outt.write(buffer);
                            }
                            // 关闭资源
                            in.close();
                            outt.close();
                            item.delete();
                        }

                    }
                    if (newname!=""&&newphone!=""&&newpwd!=""&&imgPath!=""&&newphone!="") {
                        try {
                            userDao.modUser(Integer.valueOf(newid),newname,newpwd,newphone,imgPath,newaddress);
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        out.println("<script>alert('保存成功');location.href = '/UserShow';</script>");
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            }

        }




    }
}
