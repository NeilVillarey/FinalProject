<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
	      <a class="navbar-brand" href="index.jsp">Eco<small>Hero</small></a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>
	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
	          <li class="nav-item active"><a href="home.jsp" class="nav-link"><% out.println(getServletContext().getInitParameter("header-home")); %></a></li>
	          <li class="nav-item"><a href="home.jsp" class="nav-link"><% out.println(getServletContext().getInitParameter("header-products")); %></a></li>
	          <li class="nav-item"><a href="home.jsp" class="nav-link"><% out.println(getServletContext().getInitParameter("header-services")); %></a></li>
	          <li class="nav-item"><a href="about.jsp" class="nav-link"><% out.println(getServletContext().getInitParameter("header-about")); %></a></li>
	        </ul>
	      </div>
            </div>
	  </nav>
                  
                  