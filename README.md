Project Name: e-Wallet Project Authors: Prajwal Sagar Sambali Giridhar Naidu Aditya Rungta Aannesha Satpati Akhil Balaji Mihika Dave Abhinav Gupta

Setup- 	Build path for the mysql driver in the lib folder
		Provide the database username(DB_user) and password(DB_Pass) in the DBconf.java
		Run Init.java (as java application) once to create the required database and the tables.
		Init.java creates a virtualBank user with username: virtualbank and password:virtualadmin

RUN:
Run the Driver.java class as java application

We have started working on the jsp files(also included). So the project is a Java Web Project.

Assumptions- The user gives the expected inputs.
			 If a username is given as Receiver for  makePayment(), moneyTransfer(), recharge(), the username should exist
			 Each seller can have only 1 offer which is applicable on all the items.
			 When virtual bank logsIn it can recharge anybody's account with any amount.
			 User does not logIn if he is not registered.

Console based programming has been completed and it is in working condition. For the Web Application few JSP files have been created. Additional feature of Gift Cards can be implemented later.

All classes are complete

Update on 11:30 PM 19/11/2014
The Test cases :
	In the TestLogin:
			It first tests the forgot password method
			then the login method
			then the signup method

