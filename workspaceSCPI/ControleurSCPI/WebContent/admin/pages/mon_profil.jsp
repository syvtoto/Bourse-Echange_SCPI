<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.ecetech.bti3.projetIT.scpi.beans.*" %>
    
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Profil</title>

    <link href="./admin/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="./admin/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="./admin/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="./admin/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
    
<%@include file="header.jsp" %>
   
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Mon profile</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row notification -->
           
            <!-- /.row -->
              <div class="card mb-3">
        <div class="card-header">
          
        </div>
        

        <div class="card-body">
        <% Client client = (Client)request.getAttribute("client");
        %>

            <div class="row">
              <div class="col-sm-6 col-md-6 col-md-offset-3 col-sm-offset-3" >
                <div class="thumbnail">
                  <img src="./assets/images/user.png" width="40%" height="25px" alt="Photo de profile">
                  <div class="caption">
                    <h3><% out.print(client.getNom()+" "+client.getPrenom());%></h3>
                    <p><% out.print("Email : "+client.getEmail()); %></p>
                    
                    <p><a href="#" class="btn btn-primary" role="button">Modifier</a> <a href="#" class="btn btn-default" role="button">Changer mon mot de passe</a></p>
                  </div>
                </div>
              </div>
            </div>
       
        
        </div>




            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="./admin/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="./admin/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="./admin/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="./admin/dist/js/sb-admin-2.js"></script>

</body>

</html>
