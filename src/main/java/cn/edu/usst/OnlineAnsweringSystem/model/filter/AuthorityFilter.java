package main.java.cn.edu.usst.OnlineAnsweringSystem.model.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(
        filterName = "authorityFilter",
        urlPatterns = { "/*" },
        initParams = {
                @WebInitParam(name = "encoding", value = "UTF-8"),
                @WebInitParam(name = "loginPage", value = "login.jsp"),
                @WebInitParam(name = "loginDo", value = "login.do"),
                @WebInitParam(name = "registerPage", value = "register.jsp"),
                @WebInitParam(name = "registerDo", value = "register.do")
        })
public class AuthorityFilter implements Filter {
   private FilterConfig config;
   // 实现初始化方法
   public void init(FilterConfig fConfig) throws ServletException {
      config = fConfig;
   }
   // 实现过滤方法
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
      // 获取该过滤器的配置参数
      String encoding = config.getInitParameter("encoding");
      String loginPage = config.getInitParameter("loginPage");
      String loginDo = config.getInitParameter("loginDo");
      String registerPage = config.getInitParameter("registerPage");
      String registerDo = config.getInitParameter("registerDo");
      // 设置请求request的编码字符集
      request.setCharacterEncoding(encoding);
      response.setContentType("text/html;charset=utf-8");
      HttpServletRequest hrequest = (HttpServletRequest)request;
      HttpSession session = hrequest.getSession(true);
      //测试：先在session中添加user信息
//      session.setAttribute("userId", 103);//记得删除
//      session.setAttribute("userId", 301);//记得删除
//      session.setAttribute("userName", "Henry Klein");//记得删除
//      session.setAttribute("userName", "Bob Gill");//记得删除
//      session.setAttribute("userKind", "student"); //记得删除
//      session.setAttribute("userKind", "teacher"); //记得删除
//      chain.doFilter(request, response); //记得删除
      //登陆过滤
      // 获得客户请求的页面
      String requestPath = hrequest.getServletPath();
      // 静态页面全部放行
      if(requestPath.contains("/static")) {
         chain.doFilter(request, response);
      }
      //非管理员访问管理员界面
      else if(requestPath.contains("admin") && !session.getAttribute("userKind").equals("admin")){
         //转发到登录页面
         request.getRequestDispatcher(loginPage).forward(request, response);
      }
      // 如果session作用域的userName为null，即用户请求的既不是登录页面，也不是处理登录的页面
      else if(session.getAttribute("userName")==null && !requestPath.endsWith(loginPage) && !requestPath.endsWith(registerPage) && !requestPath.endsWith(registerDo) && !requestPath.endsWith(loginDo)){
         //转发到登录页面
         request.getRequestDispatcher(loginPage).forward(request, response);
      }else{
         chain.doFilter(request, response);
      }
   }
   // 实现销毁方法
   public void destroy() {
      config = null;
   }
}
