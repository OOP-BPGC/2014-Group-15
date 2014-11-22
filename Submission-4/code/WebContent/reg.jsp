<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><link href = "images/background.png" rel="icon" type="image/gif">
    <head><title>
	e-Wallet | Register</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
        <link rel="stylesheet" href="sheets/sheet1.css">
    </head>
    <body>
    <div id='cssmenu'>
<body>
	<style>
body {
    background-image: url("images/background.jpg");
}
</style>
<!--Nav Bar-->
	<ul>
  <li><a href="home.jsp">Home</a></li>
  <li><a href="index.jsp">Login</a></li>
  <li><a href="reg.jsp"><font color= "#666666">Register</font></a></li>
  
  
</ul>
</div>
<link rel="stylesheet" href="sheets/sheet2.css">

<div id="login">
  <div id="triangle"></div>
  <h1>Registration Form</h1>
        <form method="post" action="./Registration">
            <input type="username" placeholder="First Name" name="firstName" required/>
             <input type="username" placeholder="Last Name" name="lastName"/>
             <input type="username" placeholder="Email ID" name="email" required/>
             <input type="username" placeholder="Username" name="userName" required/>
             <input type="password" placeholder="Password" name="password" required/>
             <input type="password" placeholder="Re-Enter Password" name="repassword" required/>
             <br>
             <input type="radio"  name="status" value="customer">Customer
             <input type="radio" value="seller" name="status">Seller
             <input type="radio" value="recharge" name="status">Recharge Person
             
             <input type="submit" value="Register" />                    
               
        </form>
         
</div>
 
    </body>
</html>