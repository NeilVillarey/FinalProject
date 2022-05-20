

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
    .background{
        background-image: url("./images/menu.jpg");
       background-size: cover;

  height: 100vh;
 text-align: center; 
  background-position: center;
  background-repeat: no-repeat;
        
    }

</style>

<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <jsp:include page="/MainJdbc"/>
        <title>Order</title>
        <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
    </head>


    <body class="background">
        
            
      <div class="mask d-flex align-items-center h-100 gradient-custom-3">
    <div class="container h-100">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-12 col-md-9 col-lg-7 col-xl-6">
          <div class="card" style="border-radius: 15px;">
          
              <div class="card-body p-5">
        <form method="post" action="ShowController">
<!--            <div class="img-thumbnail"><img src="./images/pawsome-menu-s.png" alt="menu" width="450" 
                                            height="500"></div><br>-->
            <div class="form-outline mb-4"> Order:<input name="orders" type="text" size="20" placeholder="order" required> </div>
         <div class="form-outline mb-4">Add-Ons: <input name="addon" type="text" size="20" placeholder="add-on" required> </div>
        <div class="form-outline mb-4">Additional Instructions:<input name="additional" type="text" size="20" placeholder="additional" required> </div>
         <div class="form-outline mb-4">Amount:<input name="amount" type="number" size="20" placeholder="amount" required> </div>

            <input type="submit">
        </form>
                     </div>
    </div>
</div>
                            </div>
    </div>
</div>
    </body>
  
</html>
