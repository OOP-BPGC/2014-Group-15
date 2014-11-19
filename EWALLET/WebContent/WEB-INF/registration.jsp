<%@ page import ="java.sql.*" %>
<%
    String user = request.getParameter("userName");   
    String pwd = request.getParameter("password");
    String fname = request.getParameter("firstName");
    String lname = request.getParameter("lastName");
    String email = request.getParameter("emailID");
    String status = request.getParameter("status");
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/EWALLET",
            "root", "abhi1204");
    Statement st = con.createStatement();
    ResultSet rs;
    int i = st.executeUpdate("insert into users values ('" + fname + "','" + lname + "','" + user + "','" + email + "','" + pwd  + "','" + status+ "', CURDATE())");
    if (i > 0) {
        session.setAttribute("userid", user);
        response.sendRedirect("welcome.jsp");
       out.print("Registration Successfull!"+"<a href='index.jsp'>Go to Login</a>");
    } else {
        response.sendRedirect("index.jsp");
    }
%>