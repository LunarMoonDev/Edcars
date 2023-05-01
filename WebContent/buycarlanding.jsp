<!DOCTYPE html>
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
<title>EDCARS|Fill up form</title>
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
<script type="text/javascript">
        function GenerateCaptcha() {
            var chr1 = Math.ceil(Math.random() * 9) + '';
            var chr2 = Math.ceil(Math.random() * 9) + '';
            var chr3 = Math.ceil(Math.random() * 9) + '';
            var chr4 = Math.ceil(Math.random() * 9) + '';
            var chr5 = Math.ceil(Math.random() * 9) + '';
            var chr6 = Math.ceil(Math.random() * 9) + '';
            var chr7 = Math.ceil(Math.random() * 9) + '';

            var captchaCode = chr1 + ' ' + chr2 + ' ' + chr3 + ' ' + chr4 + ' ' + chr5 + ' ' + chr6 + ' ' + chr7;
            document.getElementById("txtCaptcha").value = captchaCode
        }

        function ValidCaptcha() {
            var str1 = removeSpaces(document.getElementById('txtCaptcha').value);
            var str2 = removeSpaces(document.getElementById('txtCompare').value);

            if (str1 == str2) return true;
            else {
                alert("Wrong captcha! Please input again correct code.")
                return false;
            }
        }

        function removeSpaces(string) {
            return string.split(' ').join('');
        }

    </script>
</head>

<body onload="GenerateCaptcha();">
	<div class=slider>
		<section id="dropdown-menu-0">

			<nav
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

			</nav>

		</section>
		<section
			class="mbr-section mbr-section--relative mbr-section--short-paddings mbr-after-navbar"
			id="msg-box1-2" style="background-color: rgb(60, 60, 60);">
			<div
				class="mbr-section__container mbr-section__container--isolated container"
				style="padding-top: 60px; padding-bottom: 60px;">
				<div class="row">
					<div class="mbr-box mbr-box--fixed mbr-box--adapted">
						<div
							class="mbr-box__magnet mbr-box__magnet--top-left mbr-section__left col-sm-8">
							<div
								class="mbr-section__container mbr-section__container--middle">
								<div
									class="mbr-header mbr-header--auto-align mbr-header--wysiwyg">
									<h3 class="mbr-header__text">SET A MEETING SCHEDULE!</h3>
								</div>
							</div>
							<div class="mbr-section__container">
								<div>
									<p style="color: white;">Please fill out the following form
										and set a preferred schedule to see and negotiate onsite with
										the company</p>
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
			id="form1-3" style="background-color: rgb(239, 239, 239);">

			<div
				class="mbr-section__container mbr-section__container--std-padding container"
				style="padding-top: 93px; padding-bottom: 93px;">
				<div class="row">
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-8 col-sm-offset-2">
								<form action="SendBuyerMail.html" method="post">
									<div class="form-group">
										<input type="text" class="form-control" name="name"
											required="" pattern="[A-Za-z]+" placeholder="Enter full name"
											data-form-field="Name">
									</div>
									<div class="form-group">
										<input type="tel" class="form-control" name="phone"
											required placeholder="Enter Phone Number" data-form-field="Phone">
									</div>
									<div class="form-group">
										<textarea class="form-control" name="carSpecs" rows="4"
											placeholder="Car specification" readonly
											data-form-field="Message">${carSpecs}</textarea>
									</div>
									<div class="form-group">
										<input type="text" class="form-control" disabled
											placeholder="Specify the time and date of the transaction">
										<input type="time" class="form-control" name="time"
											required data-form-field="time"> <input type="date"
											required class="form-control" name="date" data-form-field="date">
									</div>
									<div class="form-group">
										<textarea class="form-control" name="message" rows="7"
											placeholder="Please type here any kind of queries or questions about company or the car."
											required data-form-field="Message"></textarea>
									</div>
									<div class="form-inline" align="center">
										<input type="text" disabled class="form-control"
											id="txtCaptcha"
											style="text-align: center; border: none; font-weight: bold; font-family: Calibri" />
										<input type="button" class="btn b" id="btnrefresh"
											value="Refresh" onclick="GenerateCaptcha();" /> <input
											type="text" class="form-control" id="txtCompare" required />

									</div>
									<br> <br>
									<div class="mbr-buttons mbr-buttons--right">
										<button type="submit"
											class="mbr-buttons__btn btn btn-lg btn-info">SEND</button>
									</div>
								</form>
							</div>
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
