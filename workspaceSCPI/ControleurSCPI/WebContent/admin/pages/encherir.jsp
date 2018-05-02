<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Encherir</title>

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
                    <h1 class="page-header">Enrechir</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row notification -->
           
            <!-- /.row -->
              <div class="card mb-3">
        <div class="card-header">
          
        </div>
        

        <div class="card-body">

            <div class="row">
              <div class="col-sm-6 col-md-10 col-md-offset-1 col-sm-offset-3" >
                <div class="thunmail">
                  
                   <div class="caption">
                    <h3>SCPI : GAMMA</h3>

                    <form method="post" action="" id="idForm">   

                      <div class="form-group">
                        <div class="form-row">

                          <div class="col-md-6">
                            <label for="exampleInputName">Nombre de parts</label>
                            <input class="form-control" name="prenom" id="exampleInputName" disabled="true" type="text"  value="20" aria-describedby="nameHelp">
                          </div>
                          <div class="col-md-6">
                            <label for="exampleInputName">Valeur d'une part</label>
                            <input class="form-control" name="prenom" id="exampleInputName" disabled="true" type="text"  value="21" aria-describedby="nameHelp">
                          </div>
   
                        </div>
                        <hr>
                        <div class="form-row">

                          <div class="col-md-6">
                            <label for="exampleInputName">Proposer un prix</label>
                            <input class="form-control" name="prenom" id="exampleInputName"  type="text"  value="" aria-describedby="nameHelp">
                          </div>                    

                          
                        </div>

                        <div class="form-row">

                          <div class="col-md-6 col-md-offset-3">
                            <p> </br><a href="#" class="btn btn-danger" role="button">Valider</a> 
                            
                          </div>                    

                          
                        </div>


                      </div>

                    

                  </form>

                    
                    
                    
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
