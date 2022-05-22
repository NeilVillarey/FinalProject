<!DOCTYPE html>
<html lang="en">
  <head>
    <title>EcoHero - Our Events</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Sans:400,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Great+Vibes" rel="stylesheet">

    <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="css/animate.css">
    
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">

    <link rel="stylesheet" href="css/aos.css">

    <link rel="stylesheet" href="css/ionicons.min.css">

    <link rel="stylesheet" href="css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="css/jquery.timepicker.css">

    
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/icomoon.css">
    <link rel="stylesheet" href="css/style.css">
  </head>
  <body>
	<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
	      <a class="navbar-brand" href="index.html">Coffee<small>Blend</small></a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>
	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
	          <li class="nav-item"><a href="adminpage.jsp" class="nav-link">Home</a></li>
	       
	          
	          <li class="nav-item"><a href="about.jsp" class="nav-link">About</a></li>
                  <li class="nav-item"><a href="<%=request.getContextPath()%>/LogoutServlet" class="nav-link">Logout</a></li>
	          <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="room.html" id="dropdown04" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Shop</a>
              <div class="dropdown-menu" aria-labelledby="dropdown04">
              	<a class="dropdown-item" href="memberpage.jsp">Shop</a>
                <a class="dropdown-item" href="<%=request.getContextPath()%>/ViewServlet">Cart</a>
                 <a class="dropdown-item" href="events.jsp">Events</a>
              </div>
            </li>
	          <li class="nav-item"><a href="contacts.jsp" class="nav-link">Contact</a></li>
	          <li class="nav-item cart"><a href="<%=request.getContextPath()%>/ViewServlet" class="nav-link"><span class="icon icon-shopping_cart"></span><span class="bag d-flex justify-content-center align-items-center"><small>1</small></span></a></li>
	        </ul>
	      </div>
		  </div>
	  </nav>
    <!-- END nav -->

    <section class="home-slider owl-carousel">

      <div class="slider-item" style="background-image: url(images/deer.jpg);" data-stellar-background-ratio="0.5">
      	<div class="overlay"></div>
        <div class="container">
          <div class="row slider-text justify-content-center align-items-center">

            <div class="col-md-7 col-sm-12 text-center ftco-animate">
            	<h1 class="mb-3 mt-5 bread">Events</h1>
	            <p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home</a></span> <span>Events</span></p>
            </div>

          </div>
        </div>
      </div>
    </section>

    <section class="ftco-section">
      <div class="container">
        <div class="row d-flex">
          <div class="col-md-4 d-flex ftco-animate">
          	<div class="blog-entry align-self-stretch">
              <a href="https://www.youtube.com/watch?v=HPJKxAhLw5I" class="block-20" style="background-image: url('images/treeplant.jpg');">
              </a>
              <div class="text py-4 d-block">
              	<div class="meta">
                  <div><a href="#">Live now!</a></div>
                  <div><a href="#">Admin</a></div>
                  <div><a href="#" class="meta-chat"><span class="icon-chat"></span> 97</a></div>
                </div>
                <h3 class="heading mt-2"><a href="https://www.youtube.com/watch?v=HPJKxAhLw5I">Tree Planting Day</a></h3>
                <p>Help us on our journey to plant 20 million trees on planet earth.</p>
              </div>
            </div>
          </div>
          <div class="col-md-4 d-flex ftco-animate">
          	<div class="blog-entry align-self-stretch">
              <a href="https://www.youtube.com/watch?v=cV2gBU6hKfY" class="block-20" style="background-image: url('images/turtle.jpeg');">
              </a>
              <div class="text py-4 d-block">
              	<div class="meta">
                  <div><a href="#">May 30, 2022</a></div>
                  <div><a href="#">Admin</a></div>
                  <div><a href="#" class="meta-chat"><span class="icon-chat"></span> 12</a></div>
                </div>
                <h3 class="heading mt-2"><a href="https://www.youtube.com/watch?v=cV2gBU6hKfY">Clean Up Drive</a></h3>
                <p>Let's save the turtles by cleaning up our beaches and reducing the waste on the ocean!.</p>
              </div>
            </div>
          </div>
          <div class="col-md-4 d-flex ftco-animate">
          	<div class="blog-entry align-self-stretch">
              <a href="https://www.earthday.org/campaign/the-canopy-project/" class="block-20" style="background-image: url('images/earthday.jpg');">
              </a>
              <div class="text py-4 d-block">
              	<div class="meta">
                  <div><a href="#">June 15, 2022</a></div>
                  <div><a href="#">Admin</a></div>
                  <div><a href="https://www.earthday.org/campaign/the-canopy-project/" class="meta-chat"><span class="icon-chat"></span> 3</a></div>
                </div>
                <h3 class="heading mt-2"><a href="#">Earth day</a></h3>
                <p>Earth day works with global partners to reforest areas in dire need of rehabilitation.</p>
              </div>
            </div>
          </div>
          <div class="col-md-4 d-flex ftco-animate">
          	<div class="blog-entry align-self-stretch">
              <a href="https://www.greenqueen.com.hk/blackpink-all-girl-k-pop-band-with-billions-of-followers-speak-up-climate-change/" class="block-20" style="background-image: url('images/blackpenk.jpg');">
              </a>
              <div class="text py-4 d-block">
              	<div class="meta">
                  <div><a href="#">June 30, 2022</a></div>
                  <div><a href="#">Admin</a></div>
                  <div><a href="https://www.greenqueen.com.hk/blackpink-all-girl-k-pop-band-with-billions-of-followers-speak-up-climate-change/" class="meta-chat"><span class="icon-chat"></span> 4</a></div>
                </div>
                <h3 class="heading mt-2"><a href="#">Blackpink saves Earth</a></h3>
                <p>A collaboration between to save planet earth with Blackpink.</p>
              </div>
            </div>
          </div>
          <div class="col-md-4 d-flex ftco-animate">
          	<div class="blog-entry align-self-stretch">
              <a href="https://www.youtube.com/watch?v=OasbYWF4_S8" class="block-20" style="background-image: url('images/recycle.jpg');">
              </a>
              <div class="text py-4 d-block">
              	<div class="meta">
                  <div><a href="#">July 15, 2022</a></div>
                  <div><a href="#">Admin</a></div>
                  <div><a href="#" class="meta-chat"><span class="icon-chat"></span> 8</a></div>
                </div>
                <h3 class="heading mt-2"><a href="https://www.youtube.com/watch?v=OasbYWF4_S8">Students recycling day</a></h3>
                <p>Helping students learn about recycling and how they can use it in their daily lives.</p>
              </div>
            </div>
          </div>
          <div class="col-md-4 d-flex ftco-animate">
          	<div class="blog-entry align-self-stretch">
              <a href="blog-single.html" class="block-20" style="background-image: url('images/waste.jpg');">
              </a>
              <div class="text py-4 d-block">
              	<div class="meta">
                  <div><a href="#">July 30, 2022</a></div>
                  <div><a href="#">Admin</a></div>
                  <div><a href="https://www.qld.gov.au/environment/pollution/management/waste/recovery/disposal-levy/business/manage-waste" class="meta-chat"><span class="icon-chat"></span> 2</a></div>
                </div>
                <h3 class="heading mt-2"><a href="https://www.qld.gov.au/environment/pollution/management/waste/recovery/disposal-levy/business/manage-waste">Waste management literacy</a></h3>
                <p>A seminar about waste management and how to apply it in our homes..</p>
              </div>
            </div>
          </div>
        </div>
        <div class="row mt-5">
          <div class="col text-center">
            <div class="block-27">

            </div>
          </div>
        </div>
      </div>
    </section>
    
      <footer class="ftco-footer ftco-section img">
        <%@include file="common/footer.jsp"%>
      </footer>
  

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


  <script src="js/jquery.min.js"></script>
  <script src="js/jquery-migrate-3.0.1.min.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/jquery.easing.1.3.js"></script>
  <script src="js/jquery.waypoints.min.js"></script>
  <script src="js/jquery.stellar.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.magnific-popup.min.js"></script>
  <script src="js/aos.js"></script>
  <script src="js/jquery.animateNumber.min.js"></script>
  <script src="js/bootstrap-datepicker.js"></script>
  <script src="js/jquery.timepicker.min.js"></script>
  <script src="js/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="js/google-map.js"></script>
  <script src="js/main.js"></script>
    
  </body>
</html>