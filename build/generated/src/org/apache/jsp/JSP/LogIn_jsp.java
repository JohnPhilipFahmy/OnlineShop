package org.apache.jsp.JSP;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class LogIn_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>LogIn Page</title>\n");
      out.write("        <style>\n");
      out.write("            body{width: 1000px;\n");
      out.write("                 height: 1300px;\n");
      out.write("                 background: linear-gradient(to bottom,black,white ,black );  }\n");
      out.write("\n");
      out.write("\n");
      out.write("            #bage\n");
      out.write("            {\n");
      out.write("                width: auto;\n");
      out.write("                height: 350px;\n");
      out.write("                margin-left: auto;\n");
      out.write("                margin-right: auto;\n");
      out.write("                position: absolute;\n");
      out.write("                top:100px;\n");
      out.write("                left: 200px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #EmailInput{margin-left:55px;\n");
      out.write("                        margin-top:30px;}\n");
      out.write("\n");
      out.write("            #passwordInput{margin-left:32px;}\n");
      out.write("\n");
      out.write("\n");
      out.write("            #userTybe{margin-left:55px;}\n");
      out.write("            #button{margin-left:200px; }\n");
      out.write("            #msg{margin-left:250px;\n");
      out.write("                 margin-top:250px;  \n");
      out.write("                 background-color:wheat;\n");
      out.write("                 width: 200px;\n");
      out.write("                 border-radius: 100px 100px 100px 100px;}\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        ");

            String validate = request.getParameter("validate");
            String msg = "";
            if (validate != null && validate.equals("false")) {
                msg = "Invalid Username or Password";
            }

        
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div id=\"msg\">  <span style=\"color: red\" >");
      out.print( msg);
      out.write(" </span></div>\n");
      out.write("        <div id=\"bage\">\n");
      out.write("            <form method=\"POST\" action=\"../LoginnCheak\">\n");
      out.write("                <br><br>\n");
      out.write("                <label for=\"text\" id=\"Email\">Email:-</label>\n");
      out.write("                <input type=\"text\" id=\"EmailInput\" name=\"Email\" >\n");
      out.write("\n");
      out.write("                <br><br>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <label for=\"password\" id=\"password\">password:- </label>\n");
      out.write("                <input type=\"password\" name=\"password\" id=\"passwordInput\"> \n");
      out.write("                <br><br>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                <br><br>\n");
      out.write("                <br>\n");
      out.write("                <input type=\"Submit\" id=\"button\" name=\"button\" value=\"Sign Up\">\n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
