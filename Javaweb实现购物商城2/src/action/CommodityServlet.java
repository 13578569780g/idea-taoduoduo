package action;

import dao.CommodityDao;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/release")
public class CommodityServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();


        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        CommodityDao commodityDao = new CommodityDao();
        String imgPath="";

        try {
            String name ="";
            String price = "";
            String introduce = "";
            String category = "";
            String path="";
            List<FileItem> list = upload.parseRequest(req);
            for (FileItem item : list) {


                if (item.isFormField()){
                    switch (item.getFieldName()){
                        case "name" :
                   name = item.getString("utf-8");
                            break;
                        case "price" :
                             price = item.getString("utf-8");
                            break;
                        case "introduce" :
                            introduce = item.getString("utf-8");
                            break;
                        case "category":
                            category = item.getString("utf-8");
                            break;
                    }
                }else {
                    // 拿到文件的名称
                    String fileName = item.getName();
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


                if (name!=""&&price!=""&&introduce!=""&&imgPath!=""&&category!="") {
                    int ty = Integer.valueOf(category);
                    try {
                        commodityDao.setCommodity(name,price,introduce,imgPath,ty);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }

                    out.println("<script>alert('添加成功');location.href = 'index';</script>");
                }

            }

        } catch (FileUploadException e) {
            e.printStackTrace();
        }



    }


}
