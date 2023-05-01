<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="Utility.DBConnectionUtil"%>
<%@ page import="Model.faqsBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<script src="assets/js/dw_event.js" type="text/javascript"></script>
<script src="assets/js/dw_cookies.js" type="text/javascript"></script>
<script src="assets/js/dw_sizerdx.js" type="text/javascript"></script>
<script type="text/javascript">
	dw_Event.add(window, 'load', dw_fontSizerDX.init);
</script>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="assets/images/i.png" type="image/x-icon">
<meta name="description" content="">
<title>EDCARS|FAQs</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:700,400&amp;subset=cyrillic,latin,greek,vietnamese">
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/mobirise/css/style.css">
<link rel="stylesheet" href="assets/dropdown-menu/style.css">
<link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css"
	type="text/css">
<script type="text/javascript"
	src="floating-j-menu/jquery-1.11.3.min.js"></script>
<script type="text/javascript"
	src="floating-j-menu/jquery.easing.1.3.js"></script>
<link rel="stylesheet" href="floating-j-menu/floating-j-menu.css"
	type="text/css">
</head>

<body style="background-color: rgb(76, 105, 114);">
	<div class=slider>
		<section id="dropdown-menu-c"> <nav
			class="navbar navbar-dropdown bg-color transparent navbar-fixed-top">

		<div class="container">

			<div class="navbar-brand">
				<a href="index.html" class="navbar-logo"><img
					src="assets/images/i.png" title="EDCARS"></a> <a
					class="text-white" href="index.html">EDCARS</a>
			</div>

			<button class="navbar-toggler pull-xs-right hidden-md-up"
				type="button" data-toggle="collapse"
				data-target="#exCollapsingNavbar">
				<img src="assets/images/hamburger.png" width="27px">
			</button>

			<ul
				class="nav-dropdown collapse pull-xs-right navbar-toggleable-sm nav navbar-nav"
				id="exCollapsingNavbar">
				<li class="nav-item"><a class="nav-link link"
					href="viewcars.jsp">VIEW CARS</a></li>
				<li class="nav-item"><a class="nav-link link"
					href="interestedseller.html">INTERESTED SELLER</a></li>
				<li class="nav-item"><a class="nav-link link" href="faqs.jsp">FAQs</a></li>
			</ul>

		</div>

		</nav> </section>
		<section
			class="mbr-section mbr-section--relative mbr-section--fixed-size mbr-after-navbar"
			id="testimonials1-e" style="background-color: rgb(76, 105, 114);">
		<div>
			<div
				class="mbr-section__container mbr-section__container--std-padding container"
				style="padding-top: 93px; padding-bottom: 93px;">
				<div class="row">
					<div class="col-sm-12">
						<h2 class="mbr-section__header">FREQUENTLY ASKED
							QUESTIONS(FAQs)</h2>
						<br>
						<br>
						<br>
						<%
							Connection con = DBConnectionUtil.getDBConnection();
							faqsBean ib = new faqsBean();

							ResultSet resultset = ib.view(con);
						%>
						<table id="example" class="table" style="color: white"
							cellspacing="0" width="100%">
							<THEAD>
								<TR>
									<TH>Question</TH>
									<TH>Answer</TH>
								</TR>
							</THEAD>
							<tbody>
								<%
									while (resultset.next()) {
								%>
								<TR>

									<TD><%=resultset.getString("Faqs_Question")%></td>
									<TD><%=resultset.getString("Faqs_Answer")%></TD>
								</TR>
								<%
									}
								%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		</section>
	</div>

	<script type="text/javascript" src="floating-j-menu/floating-j-menu.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/smooth-scroll/SmoothScroll.js"></script>
	<!--[if lte IE 9]>
    <script src="assets/jquery-placeholder/jquery.placeholder.min.js"></script>
  <![endif]-->
	<script src="assets/mobirise/js/script.js"></script>
	<script src="assets/dropdown-menu/script.js"></script>
	<script src="assets/formoid/formoid.min.js"></script>

</body>

</html>