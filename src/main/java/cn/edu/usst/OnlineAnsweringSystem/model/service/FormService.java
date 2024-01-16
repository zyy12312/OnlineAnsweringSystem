package main.java.cn.edu.usst.OnlineAnsweringSystem.model.service;

import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Question;
import main.java.cn.edu.usst.OnlineAnsweringSystem.model.bean.Reply;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//跟表单有关的逻辑代码
public class FormService {
   public static Map<String,Object> getFormData(List<FileItem> fileItemList, DiskFileItemFactory diskFileItemFactory, int userId) {
      Question question = new Question();
      String courseName = null;
      //确认该操作是否支持文件上传操作，enctype="multipart/form-data"。由于这里确定了enctype="multipart/form-data"，所以else的情况（即一般的表单情况）不处理
      //if(request.getContentType().startsWith("multipart/form-data")) {
      //创建磁盘工厂对象
      //DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
      //创建servlet文件上传核心对象
      //ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
      try {
         //使用servlet文件上传核心对象ServletFileUpload解析request请求，获取请求中表单提交过来的数据
         //List<FileItem> fileItemList = servletFileUpload.parseRequest(request); request不能写在service里面，所以在servlet里面读出fileItemList之后传进来
         for (FileItem fileItem : fileItemList) { //每个fileItem都是一个组件的信息
            //判断该input的type是file类型还是非file类型
            if (fileItem.isFormField()) { //非file类型
               String inputName = fileItem.getFieldName();
               String value = fileItem.getString("UTF-8");
               if (inputName.equals("course"))
                  courseName = value;
               if (inputName.equals("title"))
                  question.setTitle(value);
               if (inputName.equals("content"))
                  question.setContent(value);
               if (inputName.equals("open"))
                  question.setOpen(Integer.parseInt(value));
            } else if(fileItem.getString("UTF-8").length()!=0){ //file类型
               question.setFile_name(fileItem.getName());
               //fileUpload(request, diskFileItemFactory, servletFileUpload);
               // 写入文件
               String path = "/Users/zhengxiaozhu/IdeaProjects/OnlineAnsweringSystem/src/main/web/static/picture";
               diskFileItemFactory.setRepository(new File(path));
               File file = new File(path + "/" + fileItem.getName());
               if(!file.exists())
                  fileItem.write(file);
            }
         }
         question.setSid(userId);
      } catch (Exception e) {
         e.printStackTrace();
      }
      //}
      Map<String, Object> map = new HashMap<>();
      map.put("courseName", courseName);
      map.put("question", question);
      return map;
   }

   public static Reply getReplyFromMap(Map<String, String[]> map, String userKind){
      Reply reply=new Reply();
      reply.setContent(map.get("newReplyContent")[0]);
      reply.setQuestion_id(Integer.parseInt(map.get("question_id3")[0]));
      if(userKind.equals("student"))
         reply.setSender(0);
      else reply.setSender(1);
      return reply;
   }
}
