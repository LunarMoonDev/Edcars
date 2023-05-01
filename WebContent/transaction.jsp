<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8" />
<link rel="icon" type="image/png" href="assets/img/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>EDCARS|Admin Panel</title>

<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<link href="assets/css/animate.min.css" rel="stylesheet" />

<link href="assets/css/light-bootstrap-dashboard-blue.css"
	rel="stylesheet" type="text/css" title="blue" />
<link href="assets/css/light-bootstrap-dashboard-azure.css"
	rel="stylesheet" type="text/css" title="azure" />
<link href="assets/css/light-bootstrap-dashboard-green.css"
	rel="stylesheet" type="text/css" title="green" />
<link href="assets/css/light-bootstrap-dashboard-orange.css"
	rel="stylesheet" type="text/css" title="orange" />
<link href="assets/css/light-bootstrap-dashboard-purple.css"
	rel="stylesheet" type="text/css" title="purple" />
<link href="assets/css/light-bootstrap-dashboard-red.css"
	rel="stylesheet" type="text/css" title="red" />
<link href="assets/css/light-bootstrap-dashboard-black.css"
	rel="stylesheet" type="text/css" title="black" />

<link href="assets/css/demo.css" rel="stylesheet" />

<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300'
	rel='stylesheet' type='text/css'>
<link href="assets/css/pe-icon-7-stroke.css" rel="stylesheet" />
<script>
	var style_cookie_name = "style";
	var style_cookie_duration = 120;
	var style_domain = document.domain;
	function switch_style(css_title) {
		var i, link_tag;
		for (i = 0, link_tag = document.getElementsByTagName("link"); i < link_tag.length; i++) {
			if ((link_tag[i].rel.indexOf("stylesheet") != -1)
					&& link_tag[i].title) {
				link_tag[i].disabled = true;
				if (link_tag[i].title == css_title) {
					link_tag[i].disabled = false;
				}
			}
			set_cookie(style_cookie_name, css_title, style_cookie_duration,
					style_domain);
		}
	}

	function set_style_from_cookie() {
		var css_title = get_cookie(style_cookie_name);
		if (css_title.length) {
			switch_style(css_title);
		}
	}

	function set_cookie(cookie_name, cookie_value, lifespan_in_days,
			valid_domain) {
		var domain_string = valid_domain ? ("; domain=" + valid_domain) : '';
		document.cookie = cookie_name + "=" + encodeURIComponent(cookie_value)
				+ "; max-age=" + 60 * 60 * 24 * lifespan_in_days + "; path=/"
				+ domain_string;
	}

	function get_cookie(cookie_name) {
		var cookie_string = document.cookie;
		if (cookie_string.length != 0) {
			var cookie_value = cookie_string.match('(^|;)[\s]*' + cookie_name
					+ '=([^;]*)');
			return decodeURIComponent(cookie_value[2]);
		}
		return '';
	}
</script>
</head>

<body onload="set_style_from_cookie()">

	<div class="wrapper">
		<div class="sidebar" data-color data-image="assets/img/sidebar.jpg">
			<div class="sidebar-wrapper">
				<div class="logo">
					<a href="#" class="simple-text"> EDCARS | ADMIN PANEL </a>
				</div>

				<ul class="nav">
					<li><a href="index.html"> <i class="pe-7s-graph"></i>
							<p>Overview</p>
					</a></li>
					<li><a href="generateTables.html"> <i class="pe-7s-note2"></i>
							<p>Manage Inventory</p>
					</a></li>
					<li class="active"><a href="transaction.jsp"> <i
							class="pe-7s-ribbon"></i>
							<p>Transaction</p>
					</a></li>
					<li><a href="faqsResult.html"> <i class="pe-7s-science"></i>
							<p>Manage Website</p>
					</a></li>
				</ul>
			</div>
		</div>

		<div class="main-panel">
			<nav class="navbar navbar-default navbar-fixed">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#navigation-example-2">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">Transaction</a>
					</div>
					<div class="collapse navbar-collapse">
						<ul class="nav navbar-nav navbar-right">
							<li><a href="login.html"> Log out </a></li>
						</ul>
					</div>
				</div>
			</nav>


			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="header">
									<h4 class="title">Transaction Form</h4>
								</div>
								<div class="content">
									<form action="searchCar.jsp">
										<div class="row">
											<div class="col-md-12">
												<label>Vehicle</label>
												<div class="input-group">
													<input type="text" class="form-control" value="${car}">
													<span class="input-group-btn">
														<button class="btn btn-secondary" type="submit">Search!</button>
													</span>
												</div>
											</div>
										</div>
									</form>
									<hr>
									<form action="transaction.html" method="post">
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>Car ID</label> <input type="text"
														class="form-control" value="${plateNumber}" name="carId"
														readonly>
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Make:</label> <input type="text"
														class="form-control" value="${carBrand}" name="make"
														readonly>
												</div>
											</div>
										</div>
										<!--  -->
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>Series: </label> <input type="text"
														class="form-control" value="${carModel}" name="series"
														readonly>

												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Type of body: </label> <input type="text"
														class="form-control" value="${bodyType}" name="bodyType"
														readonly>
												</div>
											</div>
										</div>
										<!--  -->
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>Year model</label> <input type="text"
														class="form-control" value="${carYear}" name="yearModel"
														readonly>
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Motor no: </label> <input type="text"
														class="form-control" value="${motorNo}" name="motorNo"
														readonly>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>Chassis no: </label> <input type="text"
														class="form-control" value="${serialNo}" name="chassisNo"
														readonly>
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>File no: </label> <input type="text"
														class="form-control" value="${fileNo}" name="fileNo"
														readonly>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>C.R. No: </label> <input type="text"
														class="form-control" value="${crNo}" name="crNo" readonly>
												</div>
											</div>
										</div>
										<hr>
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>Driver's License ID</label> <input type="text"
														pattern="([A-Z]{1}[0-9]{2}-[0-9]{2}-[0-9]{6})"
														title="Format A12-34-567890" class="form-control"
														name="dLicense" required>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>First Name</label> <input type="text"
														pattern="[A-Za-z ]+" title="Letters only!"
														class="form-control" placeholder="First Name"
														name="firstName" required>
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Middle Name</label> <input type="text"
														pattern="[A-Za-z ]+" title="Letters only!"
														class="form-control" placeholder="Middle Initial"
														name="middleName" required>
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Last Name</label> <input type="text"
														pattern="[A-Za-z ]+" title="Letters only!"
														class="form-control" placeholder="Last Name"
														name="lastName" required>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-8">
												<div class="form-group">
													<label>Address</label> <input type="text"
														pattern="[A-Za-z0-9, #-]{500}+([A-Za-z0-9, #-]{500})?"
														title="Allowed characters: A-Z, a-z, 0-9,  , #, -"
														class="form-control" placeholder="Home Address"
														name="houseDivision" required>
												</div>
											</div>
											<div class="col-md-2">
												<div class="form-group">
													<label>House Number</label> <input type="text"
														pattern="[A-Z0-9 ]+"
														title="Uppercase letters and numbers only!"
														class="form-control" placeholder="Home Address"
														name="houseNumber" required>
												</div>
											</div>
											<div class="col-md-2">
												<div class="form-group">
													<label>Zip Code</label> <input type="text"
														pattern="[0-9]{4}" title="Format: 1234"
														class="form-control" placeholder="Home Address"
														name="zipCode" required>
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-6">
												<div class="form-group">
													<label>Total Fee</label> <input type="text"
														class="form-control" value="${totalFee}" name="totalFee"
														readonly>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label>Amount of Payment</label> <input type="text"
														class="form-control" name="amount" pattern="[0-9]+"
														title="Enter only valid price!" required>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-6">
												<div class="form-group">
													<label>Type of payment</label> <input type="text"
														pattern="(Cash)|(Cheque)"
														title="Input only Cash or Cheque!" class="form-control"
														name="type" required>
												</div>
											</div>
										</div>
										<button type="submit" class="btn btn-info btn-fill pull-right">Submit
											Form</button>
										<div class="clearfix"></div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

<script src="assets/js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
<script src="assets/js/bootstrap-checkbox-radio-switch.js"></script>
<script src="assets/js/chartist.min.js"></script>
<script src="assets/js/bootstrap-notify.js"></script>
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
<script src="assets/js/light-bootstrap-dashboard.js"></script>
<script src="assets/js/demo.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		demo.initChartist();

	});
</script>

</html>
