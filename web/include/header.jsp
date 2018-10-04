<%-- 
    Document   : header
    Created on : Jun 6, 2017, 1:43:46 AM
    Author     : BadzBadtz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Web Services Page</title>
        <style>
            body {
                font: 20px Montserrat, sans-serif;
                line-height: 1.8;
                color: #2f2f2f;
            }
            p {font-size: 16px;}
            .margin {margin-bottom: 45px;}
            .bg-1 { 
                background-image: url("images/StormTrooper.jpg");
              /*  background-color: #1abc9c;  Green */
                color: #ffffff;
            }
            .bg-2 { 
                background-color: #474e5d; /* Dark Blue */
                color: #ffffff;
            }
            .bg-3 { 
                background-color: #ffffff; /* White */
                color: #555555;
            }
            .bg-4 { 
                background-color: #2f2f2f; /* Black Gray */
                color: #fff;
            }
            .container-fluid {
                padding-top: 50px;
                padding-bottom: 50px;
            }
            .navbar {
                padding-top: 15px;
                padding-bottom: 15px;
                border: 0;
                border-radius: 0;
                margin-bottom: 0;
                font-size: 12px;
                letter-spacing: 5px;
            }
            .navbar-nav  li a:hover {
                color: #1abc9c !important;
            }
  </style>
    </head>
    <body>
        <div class="container-fluid bg-1 text-center">
            <h3 class="margin">Welcome to my IS project</h3>
            <img src="images/kmutt_name.png" class="img-responsive margin" style="display:inline" alt="KMUTT" width="350" height="350">
            <h3></h3>
        </div>
        <nav class="navbar navbar-default">
            <div class="container">
              <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>                        
                </button>
                <a class="navbar-brand">HPB WebServices</a>
              </div>
              <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav navbar-right">
                  <li><a href="MainPage.jsp">Main</a></li>
                  <li><a href="DeptNamePages.jsp">People</a></li>
                  <li><a href="DepartmentPages.jsp">Department</a></li>
                  <li><a href="EmpCardPages.jsp">Employee Card</a></li>
                </ul>
              </div>
            </div>
        </nav>
        
   
    </body>
</html>
