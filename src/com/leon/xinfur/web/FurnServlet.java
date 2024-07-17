package com.leon.xinfur.web; /**
 * Date：2024/7/3  20:21
 * Description：TODO
 *
 * @author Leon
 * @version 1.0
 */

import com.leon.xinfur.entity.Furn;
import com.leon.xinfur.entity.Page;
import com.leon.xinfur.service.FurnService;
import com.leon.xinfur.service.impl.FurnServiceImpl;
import com.leon.xinfur.utils.DataUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class FurnServlet extends BasicServlet {
    private FurnService furnService = new FurnServiceImpl();

    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Furn> Furns = furnService.getAllFurn();
        request.setAttribute("furns", Furns);
        request.getRequestDispatcher("/views/manager/furn_manage.jsp").forward(request, response);
    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建一个新的Furn对象
        Furn furn = DataUtils.copyParamToBean(request.getParameterMap(), new Furn());
        // 将Furn对象添加到furnService中
        furnService.addFurn(furn);
        // 跳转到furnServlet页面，传入action=list参数
        //request.getRequestDispatcher("/manage/furnServlet?action=list").forward(request, response);
        response.sendRedirect(request.getContextPath() + "/manage/furnServlet?action=page&pageNo=" + request.getParameter("pageNo"));
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        furnService.deleteFurnById(DataUtils.parseInt(request.getParameter("id"), 0));
        response.sendRedirect(request.getContextPath() + "/manage/furnServlet?action=page&pageNo=" + request.getParameter("pageNo"));
    }

    protected void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = DataUtils.parseInt(request.getParameter("id"), 0);
        Furn furn = furnService.queryFurnById(id);
        request.setAttribute("furn", furn);
        request.getRequestDispatcher("/views/manager/furn_update.jsp").forward(request, response);
    }

    //不带图片文件的更新
    //protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //    Furn furn = DataUtils.copyParamToBean(request.getParameterMap(), new Furn());
    //    furnService.updateFurn(furn);
    //    response.sendRedirect(request.getContextPath() + "/manage/furnServlet?action=page&pageNo="+request.getParameter("pageNo"));
    //}

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //将提交修改的家居信息，封装成Furn对象

        //如果你的表单是enctype="multipart/form-data", req.getParameter("id") 得不到id
        int id = DataUtils.parseInt(req.getParameter("id"), 0);
        //获取到对应furn对象[从db中获取]
        Furn furn = furnService.queryFurnById(id);
        //todo 做一个判断 furn为空就不处理
        if (furn != null) {
            //1. 判断是不是文件表单(enctype="multipart/form-data")
            if (ServletFileUpload.isMultipartContent(req)) {
                //2. 创建 DiskFileItemFactory 对象, 用于构建一个解析上传数据的工具对象
                DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
                //3. 创建一个解析上传数据的工具对象

                ServletFileUpload servletFileUpload =
                        new ServletFileUpload(diskFileItemFactory);
                //解决接收到文件名是中文乱码问题
                servletFileUpload.setHeaderEncoding("utf-8");

                //4. 关键的地方, servletFileUpload 对象可以把表单提交的数据text / 文件
                //   将其封装到 FileItem 文件项中
                try {
                    List<FileItem> list = servletFileUpload.parseRequest(req);
                    //遍历，并分别处理=> 自然思路
                    for (FileItem fileItem : list) {
                        if (fileItem.isFormField()) {//如果是true就是文本 input text(普通的表单字段)
                            if ("name".equals(fileItem.getFieldName())) {//家居名
                                furn.setName(fileItem.getString("utf-8"));
                            } else if ("maker".equals(fileItem.getFieldName())) {//制造商
                                furn.setMaker(fileItem.getString("utf-8"));
                            } else if ("price".equals(fileItem.getFieldName())) {//价格
                                furn.setPrice(new BigDecimal(fileItem.getString()));
                            } else if ("sales".equals(fileItem.getFieldName())) {//销量
                                furn.setSales(new Integer(fileItem.getString()));
                            } else if ("stock".equals(fileItem.getFieldName())) {//库存
                                furn.setStock(new Integer(fileItem.getString()));
                            }
                        } else {//是一个文件
                            //获取上传的文件的名字
                            String name = fileItem.getName();
                            //如果用户没有选择新的图片, name = ""
                            if (!"".equals(name)) {
                                //1.指定一个目录 , 就是我们网站工作目录下
                                String filePath = "/" + DataUtils.FURN_IMG_DIRECTORY;
                                //2. 获取到完整目录 [io/servlet基础]
                                String fileRealPath =
                                        req.getServletContext().getRealPath(filePath);
                                //3. 创建这个上传的目录=> 创建目录?=> Java基础
                                File fileRealPathDirectory = new File(fileRealPath);
                                if (!fileRealPathDirectory.exists()) {//不存在，就创建
                                    fileRealPathDirectory.mkdirs();//创建
                                }

                                //4. 将文件拷贝到fileRealPathDirectory目录
                                //   构建一个上传文件的完整路径 ：目录+文件名
                                //   对上传的文件名进行处理, 前面增加一个前缀，保证是唯一即可, 不错
                                name = UUID.randomUUID() + "_" + System.currentTimeMillis() + "_" + name;
                                String fileFullPath = fileRealPathDirectory + "/" + name;
                                fileItem.write(new File(fileFullPath)); //保存

                                fileItem.getOutputStream().close();//关闭流

                                //更新家居的图片路径
                                furn.setImgPath(DataUtils.FURN_IMG_DIRECTORY + "/" + name);
                                //todo 删除原来旧的不用的图片
                            }
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("不是文件表单...");
            }
        }else{
            System.out.println("没有找到对应的家居...");
        }

        //更新furn对象->DB
        furnService.updateFurn(furn);
        //可以请求转发到更新成功的页面..
        req.getRequestDispatcher("/views/manager/update_ok.jsp").forward(req, resp);

    }

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = DataUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = DataUtils.parseInt(request.getParameter("pageSize"), Page.DEFAULT_PAGE_SIZE);
        Page<Furn> page = furnService.Page(pageNo, pageSize);
        request.setAttribute("page", page);
        request.getRequestDispatcher("/views/manager/furn_manage.jsp").forward(request, response);
    }
}
