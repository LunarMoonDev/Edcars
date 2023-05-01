<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<script>
	function printPage(id) {
		var html = "<html>";
		html += document.getElementById(id).innerHTML;

		html += "</html>";

		var printWin = window.open();
		printWin.document.write(html);
		printWin.document.close();
		printWin.focus();
		printWin.print();
		printWin.close();
	}
</script>
<style>
img {
	max-width: 100%;
	height: auto;
	width: auto\9;
	/* ie8 */
}
</style>
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
									<h4 class="title">Deed of Sale of Motor Vehicle</h4>
								</div>
								<div class="content">
									<div id="deed">
										<h1 align="center"
											style="text-align: center; margin-top: 0; margin-bottom: 0">
											<b><span style="font-family: &amp; amp;"><font
													size="3">DEED OF SALE OF MOTOR VEHICLE</font></span></b>
										</h1>
										<p class="MsoNormal" align="center"
											style="text-align: center; margin-top: 0; margin-bottom: 0">
											<b><span
												style="font-size: 14.0pt; font-family: &amp; amp;">&nbsp;</span></b>
										</p>
										<p class="MsoNormal" style="margin-top: 0; margin-bottom: 0">
											<span style="font-family: &amp; amp;">KNOW ALL MEN BY
												THESE PRESENTS:</span>
										</p>
										<p class="MsoNormal" style="margin-top: 0; margin-bottom: 0">
											<span style="font-family: &amp; amp;">&nbsp;</span>
										</p>
										<p class="MsoNormal" style="margin-top: 0; margin-bottom: 0">
											<span style="font-size: 11.0pt; font-family: &amp; amp;">
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; That
												I, <b> ${nameSeller}, </b>Filipino, of legal age, a resident
												of <b> ${addressSeller} </b>, is the lawful owner of a
												certain motor vehicle which is more particularly described
												as follows:
											</span><span style="font-family: &amp; amp;">&nbsp;</span>
										</p>
										<p class="MsoNormal" style="margin-top: 0; margin-bottom: 0">&nbsp;</p>
										<div align="center">
											<table class="MsoNormalTable" border="1" cellspacing="0"
												cellpadding="0"
												style="border-collapse: collapse; border: medium none">
												<tbody>
													<tr>
														<td width="259" valign="top"
															style="width: 2.7in; border: 1.0pt solid windowtext; padding-left: 5.4pt; padding-right: 5.4pt; padding-top: 0in; padding-bottom: 0in">
															<p class="MsoNormal"
																style="margin-top: 0; margin-bottom: 0">
																<span style="font-size: 10.0pt; font-family: &amp; amp;">
																	MAKE&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																	: ${make}</span>
															</p>
														</td>
														<td width="348" valign="top"
															style="width: 261.0pt; border-left: medium none; border-right: 1.0pt solid windowtext; border-top: 1.0pt solid windowtext; border-bottom: 1.0pt solid windowtext; padding-left: 5.4pt; padding-right: 5.4pt; padding-top: 0in; padding-bottom: 0in">
															<p class="MsoNormal"
																style="margin-top: 0; margin-bottom: 0">
																<span style="font-size: 10.0pt; font-family: &amp; amp;">
																	MOTOR
																	NO.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																	&nbsp;&nbsp;&nbsp; : ${motorNo} </span>
															</p>
														</td>
													</tr>
													<tr>
														<td width="259" valign="top"
															style="width: 2.7in; border-left: 1.0pt solid windowtext; border-right: 1.0pt solid windowtext; border-top: medium none; border-bottom: 1.0pt solid windowtext; padding-left: 5.4pt; padding-right: 5.4pt; padding-top: 0in; padding-bottom: 0in">
															<p class="MsoNormal"
																style="margin-top: 0; margin-bottom: 0">
																<span style="font-size: 10.0pt; font-family: &amp; amp;">
																	SERIES&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																	: ${seriesNo} </span>
															</p>
														</td>
														<td width="348" valign="top"
															style="width: 261.0pt; border-left: medium none; border-right: 1.0pt solid windowtext; border-top: medium none; border-bottom: 1.0pt solid windowtext; padding-left: 5.4pt; padding-right: 5.4pt; padding-top: 0in; padding-bottom: 0in">
															<p class="MsoNormal"
																style="margin-top: 0; margin-bottom: 0">
																<span style="font-size: 10.0pt; font-family: &amp; amp;">
																	SERIAL/CHASSIS NO.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :
																	${chassisNo} </span>
															</p>
														</td>
													</tr>
													<tr>
														<td width="259" valign="top"
															style="width: 2.7in; border-left: 1.0pt solid windowtext; border-right: 1.0pt solid windowtext; border-top: medium none; border-bottom: 1.0pt solid windowtext; padding-left: 5.4pt; padding-right: 5.4pt; padding-top: 0in; padding-bottom: 0in">
															<p class="MsoNormal"
																style="margin-top: 0; margin-bottom: 0">
																<span style="font-size: 10.0pt; font-family: &amp; amp;">
																	TYPE OF BODY&nbsp;&nbsp;&nbsp; : ${bodyType} </span>
															</p>
														</td>
														<td width="348" valign="top"
															style="width: 261.0pt; border-left: medium none; border-right: 1.0pt solid windowtext; border-top: medium none; border-bottom: 1.0pt solid windowtext; padding-left: 5.4pt; padding-right: 5.4pt; padding-top: 0in; padding-bottom: 0in">
															<p class="MsoNormal"
																style="margin-top: 0; margin-bottom: 0">
																<span style="font-size: 10.0pt; font-family: &amp; amp;">
																	PLATE
																	NO.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																	: ${plateNumber} </span>
															</p>
														</td>
													</tr>
													<tr>
														<td width="259" valign="top"
															style="width: 2.7in; border-left: 1.0pt solid windowtext; border-right: 1.0pt solid windowtext; border-top: medium none; border-bottom: 1.0pt solid windowtext; padding-left: 5.4pt; padding-right: 5.4pt; padding-top: 0in; padding-bottom: 0in">
															<p class="MsoNormal"
																style="margin-top: 0; margin-bottom: 0">
																<span style="font-size: 10.0pt; font-family: &amp; amp;">
																	YEAR MODEL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :
																	${yearModel} </span>
															</p>
														</td>
														<td width="348" valign="top"
															style="width: 261.0pt; border-left: medium none; border-right: 1.0pt solid windowtext; border-top: medium none; border-bottom: 1.0pt solid windowtext; padding-left: 5.4pt; padding-right: 5.4pt; padding-top: 0in; padding-bottom: 0in">
															<p class="MsoNormal"
																style="margin-top: 0; margin-bottom: 0">
																<span style="font-size: 10.0pt; font-family: &amp; amp;">
																	FILE
																	NO.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																	: </span> ${fileNo}
															</p>
														</td>
													</tr>
													<tr>
														<td width="259" valign="top"
															style="width: 2.7in; border-left: 1.0pt solid windowtext; border-right: 1.0pt solid windowtext; border-top: medium none; border-bottom: 1.0pt solid windowtext; padding-left: 5.4pt; padding-right: 5.4pt; padding-top: 0in; padding-bottom: 0in">
															<p class="MsoNormal"
																style="margin-top: 0; margin-bottom: 0">
																<span style="font-size: 10.0pt; font-family: &amp; amp;">
																	&nbsp;</span>
															</p>
														</td>
														<td width="348" valign="top"
															style="width: 261.0pt; border-left: medium none; border-right: 1.0pt solid windowtext; border-top: medium none; border-bottom: 1.0pt solid windowtext; padding-left: 5.4pt; padding-right: 5.4pt; padding-top: 0in; padding-bottom: 0in">
															<p class="MsoNormal"
																style="margin-top: 0; margin-bottom: 0">
																<span style="font-size: 10.0pt; font-family: &amp; amp;">
																	C.R.
																	NO.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																	: ${crNo} </span>
															</p>
														</td>
													</tr>
												</tbody>
											</table>
										</div>
										<p class="MsoNormal" style="margin-top: 0; margin-bottom: 0">&nbsp;</p>
										<p class="MsoNormal" style="margin-top: 0; margin-bottom: 0">
											<span style="font-size: 10.0pt; font-family: &amp; amp;">&nbsp;</span><span
												style="font-family: &amp; amp;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											</span> <span style="font-size: 11.0pt; font-family: &amp; amp;">That
												for and in consideration of the sum of<b> ${moneyWord}</b> (<b>P${fee}</b>)
												<b>PESOS,</b> Philippine Currency, receipt whereof is hereby
												acknowledged to my entire satisfaction, I hereby sell,
												transfer and convey by way of Absolute Sale unto<b>
													${nameBuyer}</b>, Filipino, of legal age, and resident of
												${addressBuyer}, the above described motor vehicle, free
												from all liens and encumbrances.
											</span>
										</p>
										<p class="MsoNormal" style="margin-top: 0; margin-bottom: 0">
											<span style="font-size: 11.0pt; font-family: &amp; amp;">&nbsp;</span>
										</p>
										<p class="MsoNormal" style="margin-top: 0; margin-bottom: 0">
											<span style="font-size: 11.0pt; font-family: &amp; amp;">
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; IN
												WITNESS WHEREOF, we have hereunto affixed our hands this____
												day of _______________ at ________________.</span>
										</p>
										<p class="MsoNormal" style="margin-top: 0; margin-bottom: 0">
											<span style="font-size: 11.0pt; font-family: &amp; amp;">&nbsp;</span>
										</p>
										<p class="MsoNormal" style="margin-top: 0; margin-bottom: 0">
											<span style="font-size: 11.0pt; font-family: &amp; amp;">&nbsp;</span>
										</p>
										<p class="MsoNormal" style="margin-top: 0; margin-bottom: 0">
											<b> <span
												style="font-size: 11.0pt; font-family: &amp; amp;">&nbsp;</span></b>
										</p>
										<p class="MsoNormal" style="margin-top: 0; margin-bottom: 0"
											align="center">
											<b> <span
												style="font-size: 11.0pt; font-family: &amp; amp;">
													${nameBuyer}
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													${nameSeller}</span></b>
										</p>
										<p class="MsoNormal" style="margin-top: 0; margin-bottom: 0"
											align="center">
											<span style="font-size: 11.0pt; font-family: &amp; amp;">
												Vendee&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Vendor</span>
										</p>
										<p class="MsoNormal" style="margin-top: 0; margin-bottom: 0"
											align="center">
											<span style="font-size: 11.0pt; font-family: &amp; amp;">&nbsp;</span>
										</p>
										<p class="MsoNormal" align="center"
											style="text-align: center; margin-top: 0; margin-bottom: 0">
											<span style="font-size: 11.0pt; font-family: &amp; amp;">Signed
												in the presence of:</span>
										</p>
										<p class="MsoNormal" align="center"
											style="text-align: center; margin-top: 0; margin-bottom: 0">
											<span style="font-size: 11.0pt; font-family: &amp; amp;">&nbsp;</span>
										</p>
										<p class="MsoNormal" style="margin-top: 0; margin-bottom: 0"
											align="center">
											<span style="font-size: 11.0pt; font-family: &amp; amp;">&nbsp;</span>
										</p>
										<p class="MsoNormal" style="margin-top: 0; margin-bottom: 0"
											align="center">
											<span style="font-size: 11.0pt; font-family: &amp; amp;">
												_____________________________&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												______________________________</span>
										</p>
										<p class="MsoNormal" style="margin-top: 0; margin-bottom: 0"
											align="center">
											<span style="font-size: 11.0pt; font-family: &amp; amp;">&nbsp;</span>
										</p>
										<h2 align="center"
											style="text-align: center; margin-top: 0; margin-bottom: 0">
											<span
												style="font-size: 11.0pt; font-family: &amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; quot; Times New Roman&amp;amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; amp; quot;; font-weight: 700">ACKNOWLEDGEMENT</span>
										</h2>
										<p class="MsoNormal" align="center"
											style="text-align: center; margin-top: 0; margin-bottom: 0">
											<span style="font-size: 11.0pt; font-family: &amp; amp;">&nbsp;</span>
										</p>
										<p class="MsoNormal" style="margin-top: 0; margin-bottom: 0">
											<span style="font-size: 11.0pt; font-family: &amp; amp;">Republic
												of the Philippines )</span>
										</p>
										<p class="MsoNormal" style="margin-top: 0; margin-bottom: 0">
											<span style="font-size: 11.0pt; font-family: &amp; amp;">
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;)
												S.S</span>
										</p>
										<p class="MsoNormal" style="margin-top: 0; margin-bottom: 0">&nbsp;</p>
										<p class="MsoNormal" style="margin-top: 0; margin-bottom: 0">
											<span style="font-size: 11.0pt; font-family: &amp; amp;">BEFORE
												ME, personally appeared:</span>
										</p>
										<p class="MsoNormal" style="margin-top: 0; margin-bottom: 0">&nbsp;</p>
										<p class="MsoNormal" style="margin-top: 0; margin-bottom: 0"
											align="center">
											<span style="font-size: 11.0pt; font-family: &amp; amp;">
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<b>Name&nbsp;</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												&nbsp; <b>CTC Number</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <b>Date/Place Issued</b>
											</span>
										</p>
										<p class="MsoNormal" style="margin-top: 0; margin-bottom: 0"
											align="center">&nbsp;</p>
										<p class="MsoNormal" style="margin-top: 0; margin-bottom: 0"
											align="center">
											<span style="font-size: 11.0pt; font-family: &amp; amp;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												${nameSeller}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												_____________&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;_________________</span>
										</p>
										<p class="MsoNormal" style="margin-top: 0; margin-bottom: 0"
											align="center">
											<span style="font-size: 11.0pt; font-family: &amp; amp;">&nbsp;&nbsp;
												${nameBuyer}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;_____________&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												&nbsp;&nbsp;&nbsp; _________________</span>
										</p>
										<p class="MsoNormal" style="margin-top: 0; margin-bottom: 0">&nbsp;</p>
										<p class="MsoNormal" style="margin-top: 0; margin-bottom: 0">
											<span style="font-size: 11.0pt; font-family: &amp; amp;">Known
												to me and to me known to be the same persons who executed
												the foregoing instrument and acknowledged to me that the
												same is their free and voluntary act and deed.</span>
										</p>
										<p class="MsoNormal" style="margin-top: 0; margin-bottom: 0">&nbsp;</p>
										<p class="MsoNormal" style="margin-top: 0; margin-bottom: 0">
											<span style="font-size: 11.0pt; font-family: &amp; amp;">WITNESS
												MY HAND AND SEAL, on the date and place first above written.</span>
										</p>
										<p class="MsoNormal" style="margin-top: 0; margin-bottom: 0">
											<span style="font-size: 11.0pt; font-family: &amp; amp;">
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											</span>
										</p>
										<p class="MsoNormal" style="margin-top: 0; margin-bottom: 0">
											<span style="font-size: 11.0pt; font-family: &amp; amp;">
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												Notary Public</span>
										</p>
										<p class="MsoNormal" style="margin-top: 0; margin-bottom: 0">&nbsp;</p>
										<p class="MsoNormal" style="margin-top: 0; margin-bottom: 0">
											<span style="font-size: 11.0pt; font-family: &amp; amp;">Doc.&nbsp;No.______;</span>
										</p>
										<p class="MsoNormal" style="margin-top: 0; margin-bottom: 0">
											<span style="font-size: 11.0pt; font-family: &amp; amp;">Page
												No. ______;</span>
										</p>
										<p class="MsoNormal" style="margin-top: 0; margin-bottom: 0">
											<span style="font-size: 11.0pt; font-family: &amp; amp;">Book
												No.______;</span>
										</p>
										<p class="MsoNormal" style="margin-top: 0; margin-bottom: 0">
											<span style="font-size: 11.0pt; font-family: &amp; amp;">Series
												of&nbsp;20___.</span>
										</p>
										<p class="MsoNormal" style="margin-top: 0; margin-bottom: 0">&nbsp;</p>
									</div>
									<button type="submit" class="btn btn-info btn-fill pull-right"
										onclick="printPage('deed');">Print Deed of Sale</button>
									<div class="clearfix"></div>
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
