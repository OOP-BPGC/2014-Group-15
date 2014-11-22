<!DOCTYPE html>

<%@page import="eWalletWebApp.Login"%>
<html lang="en-IN"><link href = "images/background.png" rel="icon" type="image/gif">
<head><title>
	e-Wallet | LoginSuccess</title>

<link rel="stylesheet" href="sheets/sheet1.css">

</head>
<div id='cssmenu'>
<body>
	<style>
body {
    background-image: url("images/background.jpg");
}
</style>
Welcome ${currentUser1.userName}
<ul>

<li><a href='checkBalS.jsp'>Check Balance</a></li>
<li><a href='transferS.jsp'>Transfer Money</a></li>
<li><a href='transactionsS.jsp'>View Transaction History</a></li>
<li><a href='addOffers.jsp'>Add Offers</a></li>
<li><a href='logout.jsp'>Log out</a></li>
</ul>
</div>
<center>

<div id="checkBalance">
  <div id="triangle"></div>
  <h2>Check Balance</h2>
  </center>
  
CURRENT BALANCE = ${currentUser1.wallet.balance} 


</body>
</html>

