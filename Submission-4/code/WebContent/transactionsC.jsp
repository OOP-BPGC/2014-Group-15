<!DOCTYPE html>

<%@page import="eWalletWebApp.Transaction"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="eWalletWebApp.User"%>
<%@page import="java.util.ArrayList"%>

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
<li><a href='checkBalC.jsp'>Check Balance</a></li>
<li><a href='pay.jsp'>Make Payment</a></li>
<li><a href='transferC.jsp'>Transfer Money</a></li>
<li><a href='transactionsC.jsp'>View Transaction History</a></li>
<li><a href='viewOffers.jsp'>View Offers</a></li>
<li><a href='logout.jsp'>Log out</a></li>
</ul>
<center>
</div>
  <div id="triangle"></div>
  <h2>Your Transaction History</h2>
  </center>
  <br>
  <% User user=(User)session.getAttribute("currentUser1");
  try{
	  	ArrayList<Transaction> transactions=new ArrayList<Transaction>();
  		transactions=user.viewTransactionHistory();
 	 if(transactions.size()==0)
		  out.println("No Transactions Yet!");
  	else
  	for(int i=0;i<transactions.size();i++)
  	{
  		out.println("TransactionID: "+transactions.get(i).id);
  		%>
  		<br>
  		<% 
  		out.println("Sender: "+transactions.get(i).sender);
  		%>
  		<br>
  		<% 
  		out.println("Receiver: "+transactions.get(i).receiver);
  		%>
  		<br>
  		<% 
  		out.println("Amount: "+transactions.get(i).amount);
  		%>
  		<br>
  		<% 
  		out.println("Date: "+transactions.get(i).date);
  		%>
  		<br>
  		<br>
  		<%
  	}
  }catch(Exception e){System.out.println("ERROR");e.printStackTrace();}
  	%>
 
  
</body>
</html>