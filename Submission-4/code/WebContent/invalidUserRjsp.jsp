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

<li><a href='checkBalR.jsp'>Check Balance</a></li>
<li><a href='recharge.jsp'>Recharge</a></li>
<li><a href='getCredit.jsp'>Get Credits</a></li>
<li><a href='transactionsR.jsp'>View Transaction History</a></li>
<li><a href='logout.jsp'>Log out</a></li>
</ul>
</div>
INVALID USERNAME
</body>
</html>

