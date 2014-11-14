 <%
    if ((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "")) {
%>
You are not logged in<br/>
<a href="index.jsp">Please Login</a>
<%} else {
%>
Welcome <%=session.getAttribute("userid")%>
<a href='checkBal.jsp'>Check Balance</a>
<a href='pay.jsp'>Make Payment</a>
<a href='transfer.jsp'>Transfer Money</a>
<a href='transHistory.jsp'>View Transaction History</a>
<a href='viewOffers.jsp'>View Offers</a>
<a href='logout.jsp'>Log out</a>

<%
    }
%>