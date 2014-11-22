<!DOCTYPE HTML>
<html>
<head>
<title>
Recharge
</title>
</head>
<html lang="en-IN"><link href = "images/background.png" rel="icon" type="image/gif">
<link rel="stylesheet" href="sheets/sheet1.css">

</head>
<div id='cssmenu'>
<body>
	<style>
body {
    background-image: url("images/background.jpg");
}
</style>
<ul>
<li><a href='checkBalR.jsp'>Check Balance</a></li>
<li><a href='recharge.jsp'>Recharge</a></li>
<li><a href='getCredit.jsp'>Get Credits</a></li>
<li><a href='transactionsR.jsp'>View Transaction History</a></li>
<li><a href='logout.jsp'>Log out</a></li>
</ul>

</div>
<center>
<h1>Recharge</h1>
<form method="post" action="recharge" >
            <input type="username" placeholder="Receiver Username" name="rUserName"/>
             <input type="username" placeholder="Amount " name="amount"/>
            
             <input type="submit" value="Recharge" />                    
               
        </form>
</body>
</html>
