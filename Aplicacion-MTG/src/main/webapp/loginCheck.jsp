<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        String username=request.getParameter("correo");
        String password=request.getParameter("password");
       
        if((username.equals("shakar@gmail.com") && password.equals("123")))
            {
            session.setAttribute("correo",username);
            response.sendRedirect("menu.jsp");
            }
        else
            response.sendRedirect("error.jsp");
        %>
    </body>
</html>