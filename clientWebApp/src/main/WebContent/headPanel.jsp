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
  <script>
  $(document).ready(function() {
    $.get("profile", function(responseJson) {    
        var $ul = $("<ul>").appendTo($("#somediv")); 
        $.each(responseJson, function(index, item) { 
        	$("<li>").text(item).appendTo($ul);    
        });
    });
});
</script>
  
  <title>Main Panel</title>
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
            <li><a href="userProfile.jsp">Profile</a></li>
            <li><a href="login.jsp">Logout</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </nav>
  <div class="container">  
    <div class="d-flex justify-content-center">
      <h2 id="title" class="text-center">Users</h2>
      <form action="profile?parameter=Remove" class="form-inline" method="post">
          <div class="form-group">
              <div class="col-sm-4">
                <input type="number" class="form-control" id="id" placeholder="Enter id" name="id">
              </div>
            </div>
              <button type="submit" class="btn btn-success">Remove</button>
        </form>        
        <div id="somediv"></div>      
    </div>
  </div>
    
</body>
</html>