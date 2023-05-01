<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="Utility.DBConnectionUtil"%>
<%@ page import="Model.inventoryBean"%>
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
<title>EDCARS|View Cars</title>
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
<script
	src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.13/js/dataTables.bootstrap.min.js"></script>
<script>
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>
</head>

<body>
	<section id="dropdown-menu-8"> <nav
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
		class="mbr-section mbr-section--relative mbr-section--short-paddings mbr-after-navbar"
		id="msg-box1-n" style="background-color: rgb(60, 60, 60);">



	<div
		class="mbr-section__container mbr-section__container--isolated container"
		style="padding-top: 60px; padding-bottom: 60px;">
		<div class="row">
			<div class="mbr-box mbr-box--fixed mbr-box--adapted">
				<div
					class="mbr-box__magnet mbr-box__magnet--top-left mbr-section__left col-sm-8">
					<div class="mbr-section__container mbr-section__container--middle">
						<div class="mbr-header mbr-header--auto-align mbr-header--wysiwyg">
							<h3 class="mbr-header__text">VIEW AND BUY CARS</h3>
						</div>
					</div>
					<div class="mbr-section__container">
						<div>
							<p style="color: white;">View or buy our cars available right
								now!</p>
						</div>
					</div>
				</div>
				<div
					class="mbr-box__magnet mbr-box__magnet--top-left mbr-section__right col-sm-4">

				</div>
			</div>
		</div>
	</div>

	</section>

	<section
		class="mbr-section mbr-section--relative mbr-section--fixed-size"
		id="features1-i" style="background-color: rgb(204, 204, 204);">


	<div
		class="mbr-section__container container mbr-section__container--std-top-padding"
		style="padding-top: 93px;">
		<div class="mbr-section__row row">
			<div class="mbr-section__col col-xs-12 col-sm-12">
				<%
					Connection con = DBConnectionUtil.getDBConnection();
					inventoryBean ib = new inventoryBean();

					ResultSet resultset = ib.view(con);
				%>

				<table id="example" class="table" cellspacing="0" width="100%">
					<THEAD>
						<TR>
							<TH>Car Brand</TH>
							<TH>Car Model</TH>
							<TH>Car Type</TH>
							<TH>Car Colour</TH>
							<TH>Car Year</TH>
							<TH>Car Price</TH>
							<TH>Car Image</TH>
							<TH></TH>
						</TR>
					</THEAD>
					<tbody>
						<%
							while (resultset.next()) {
						%>

						<TR>

							<TD><%=resultset.getString("carBrand")%></TD>
							<TD><%=resultset.getString("carModel")%> ></TD>
							<TD><%=resultset.getString("carType")%></TD>
							<TD><%=resultset.getString("carColour")%></TD>
							<TD><%=resultset.getInt("carYear")%></TD>
							<TD><%=resultset.getDouble("carPrice")%></TD>
							<td><img
								src=<%="ViewCarsServlet?your_id=" + resultset.getString("plateNumber")%>
								height="200" width="350" /></td>
							<td>
								<form action="sendBuyRequest.html" method="post">
									<input type="hidden" name="carBrand"
										value=<%=resultset.getString("carBrand")%>> <input
										type="hidden" name="carModel"
										value=<%=resultset.getString("carModel")%>> <input
										type="hidden" name="carType"
										value=<%=resultset.getString("carType")%>> <input
										type="hidden" name="carColour"
										value=<%=resultset.getString("carColour")%>> <input
										type="hidden" name="carYear"
										value=<%=resultset.getInt("carYear")%>> <input
										type="hidden" name="carPrice"
										value=<%=resultset.getDouble("carPrice")%>> <input
										type="submit" value="BUY" class="btn btn-info btn-fill" />
								</form>
							</td>
						</TR>

						<%
							}
						%>


					</tbody>
				</table>

			</div>
		</div>

	</div>

	</section>

	<script type="text/javascript" src="floating-j-menu/floating-j-menu.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/smooth-scroll/SmoothScroll.js"></script>
	<script src="assets/mobirise/js/script.js"></script>
	<script src="assets/dropdown-menu/script.js"></script>
</body>

</html>