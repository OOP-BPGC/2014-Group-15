<!DOCTYPE html>

<%@page import="java.io.PrintWriter"%>
<%@page import="eWalletWebApp.Customer"%>
<html lang="en-IN"><link href = "images/background.png" rel="icon" type="image/gif">
<head><title>
	e-Wallet | Check Balance</title>

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

<li><a href='checkBalC.jsp'>Check Balance</a></li>
<li><a href='pay.jsp'>Make Payment</a></li>
<li><a href='transferC.jsp'>Transfer Money</a></li>
<li><a href='transactionsC.jsp'>View Transaction History</a></li>
<li><a href='viewOffers.jsp'>View Offers</a></li>
<li><a href='logout.jsp'>Log out</a></li>
</ul>
<center>
</div>
<div id="pay">
<center>
<h1>MAKE PAYMENT</h1>
<form method="post" action="pay" >
            <input type="username" placeholder="Seller Username" name="sellerUserName"/>
             <input type="username" placeholder="Amount to be paid" name="amountToBePaid"/>
            
             <input type="submit" value="Confirm Payment" />                    
               
        </form>
</body>
</html>
