<!DOCTYPE html>
<html lang="pt-br">
<head>
  <title>ClientWebApp</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="./Css/styles.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
  <nav class="navbar navbar-light" style="background-color: rgb(42, 129, 243);">
    <div class="container-fluid">
      <div id="navheader" class="navbar-header">
        <a class="navbar-brand" href="#" style="color: black">ClientWebApp</a>
      </div>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#" style="color: black"><span class="glyphicon glyphicon-user"></span > Sign Up</a></li>
        <li><a href="login.jsp" style="color: black"><span class="glyphicon glyphicon-log-in"></span > Login</a></li>
      </ul>
    </div>
  </nav>
    <div class="container">  
      <div class="d-flex justify-content-center">
        <h2 id="title" class="text-center">Sign up</h2>
        <form name="Signup" class="form-horizontal" action="profile?parameter=Signup" method="POST">
          <div class="form-group">
              <label class="control-label col-sm-4" for="name">Nome:</label>
              <div class="col-sm-4">
                <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
              </div>
          </div>
          <div class="form-group">
            <label class="control-label col-sm-4" for="email">Email:</label>
            <div class="col-sm-4">
              <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-sm-4" for="password">Password:</label>
            <div class="col-sm-4">          
              <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
            </div>
          </div>
          <div class="form-group">
              <label class="control-label col-sm-4" for="ddd">DDD:</label>
              <div class="col-sm-4">
                <input type="number" class="form-control" id="ddd" placeholder="xx" name="ddd">
              </div>
          </div>
          <div class="form-group">
            <label class="control-label col-sm-4" for="phone">Phone:</label>
            <div class="col-sm-4">
              <input type="text" class="form-control" id="phone" placeholder="xxxxx-xxxx" name="number">
            </div>
          </div>
          <div class="form-group">
              <label class="control-label col-sm-4" for="type">Type:</label>
              <div class="col-sm-4">
                <input type="text" class="form-control" id="type" placeholder="Ex.:Residencial" name="type">
              </div>
            </div>
          <div class="form-group">        
            <div class="text-center">
              <button type="submit" class="btn btn-default">Submit</button>
            </div>
          </div>
        </form>
      </div>  
    </div>
</body>
</html>
