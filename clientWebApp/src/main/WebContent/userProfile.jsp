<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="./Css/styles.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <title>Profile</title>
</head>
<body>
    <nav class="navbar navbar-light " style="background-color: rgb(42, 129, 243);">
    <div class="container-fluid">
      <div id="navheader" class="navbar-header">
        <a class="navbar-brand" href="#" style="color: black">ClientWebApp</a>
      </div>
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" style="color: black"> User 
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Profile</a></li>
            <li><a href="login.jsp">Logout</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </nav>
  <div class="container">  
    <div class="d-flex justify-content-center">
      <div id="user_profile">
      <form name="userProfile" class="form-horizontal" action="profile?parameter=Update" method="POST">
            <div class="form-group">
                <label class="control-label col-sm-4" for="name">Name:</label>
                <div class="col-sm-4">
                  <input type="text" class="form-control" id="name" placeholder="Enter name" name="name" required="required">
                </div>
            </div>
            <div class="form-group">
              <label class="control-label col-sm-4" for="email">Email:</label>
              <div class="col-sm-4">
                <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" required="required">
              </div>
            </div>
            <div class="form-group">
              <label class="control-label col-sm-4" for="password">Password:</label>
              <div class="col-sm-4">          
                <input type="password" class="form-control" id="password" placeholder="Enter password" name="password" required="required">
              </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-4" for="ddd">DDD:</label>
                <div class="col-sm-4">
                  <input type="number" class="form-control" id="ddd" placeholder="xx" name="ddd" required="required">
                </div>
            </div>
            <div class="form-group">
              <label class="control-label col-sm-4" for="phone">Phone:</label>
              <div class="col-sm-4">
                <input type="text" class="form-control" id="phone" placeholder="xxxxx-xxxx" name="phone" required="required"> 
              </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-4" for="type">Type:</label>
                <div class="col-sm-4">
                  <input type="text" class="form-control" id="type" placeholder="Ex.:Residencial" name="type" required="required">
                </div>
              </div>
            <div class="form-group">        
              <div class="text-center">
                <a type="button" class="btn btn-danger" href="headPanel.jsp">Cancel</a>
                <button type="submit" class="btn btn-success">Apply changes</button>
              </div>
            </div>
          </form>
        </div>  
      </div>
    </div>
</body>
</html>