<!DOCTYPE HTML>
<html>
<head>
<title>
MAKE PAYMENT
</title>
</head>
<body>
	<style>
body {
    background-image: url("images/background.jpg");
}
</style>
<ul>
<li><a href='checkBalS.jsp'>Check Balance</a></li>
<li><a href='transferS.jsp'>Transfer Money</a></li>
<li><a href='transactionsS.jsp'>View Transaction History</a></li>
<li><a href='addOffers.jsp'>Add Offers</a></li>
<li><a href='logout.jsp'>Log out</a></li>	
</ul>
<center>
</div>
<h1>MONEY TRANSFER</h1>
<form method="post" action="payment" >
            <input type="username" placeholder="Receiver Username" name="rUserName"/>
             <input type="username" placeholder="Amount to be transferred" name="amount"/>
            
             <input type="submit" value="Confirm Transaction" />                    
               
        </form>
</body>
</html>
