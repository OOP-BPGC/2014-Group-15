<!DOCTYPE html>

<html lang="en-IN"><link href = "images/background.png" rel="icon" type="image/gif">
<head><title>
	e-Wallet | Login</title>

<link rel="stylesheet" href="sheets/sheet1.css">

</head>
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
  <li><a href="index.jsp"><font color= "#666666">Login</font></a></li>
  <li><a href="reg.jsp">Register</a></li>
  
  
</ul>
</div>
<!--Login Box-->
<link rel="stylesheet" href="sheets/sheet2.css">

<script type="text/javascript">
$('#toggle-login').click(function(){
  $('#login').toggle();
});
</script>
<span href="#" class="button" id="toggle-login"></span>

<div id="login">
  <div id="triangle"></div>
  <h1>Login</h1>
  <form method="post" action="./loginServlet">
    <input type="username" placeholder="Username" name="userName"/>
    <input type="password" placeholder="Password" name="password"/>
    <input type="submit" value="Login" />
    
  </form>
  <h2>${message}</h2>
  <c:remove var="message" scope="session" />
</div>
 
</body>
</html>