javax.servlet.http.HttpSession

To Create an Object For HttpSession Class:
javax.servlet.http.HttpServletRequest
      public HttpSession getSession(boolean);

HttpSession session=request.getSession(true);

Add Req.g.p.values To Session Object
====================================
javax.servlet.http.HttpSession
public void setAttribute(Object key,Object value);

String eno=request.getParameter("ENO");
                session.setAttribute("ENO",eno);

To Read Values From Session Object
=======================================
javax.servlet.http.HttpSession
   public Object getAttribute(Object key);

String eno=(String)session.getAttribute("ENO");


















