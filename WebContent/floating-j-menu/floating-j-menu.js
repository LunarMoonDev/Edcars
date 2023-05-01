// Begin Script - jQuery Floating Menu V 2.0 2016



var FMpath = "white"	// MENU IMAGE PATH | black | white |



document.write('<div id="menuJF" class="printhide"><div id="menu-HT"><div id="sizer">');


// START ICON LINKS


document.write('<a href="#" class="increase"><img src="floating-j-menu/icons-'+FMpath+'/plus.png" border="0" class="menu-floating-tab" title="Increase Font Size"></a>');


document.write('<a href="#" class="decrease"><img src="floating-j-menu/icons-'+FMpath+'/minus.png" border="0" class="menu-floating-tab" title="Decrease Font Size"></a>');


document.write('<a href="#" class="reset"><img src="floating-j-menu/icons-'+FMpath+'/reset.png" border="0" class="menu-floating-tab" title="Reset Font Size"></a>');



// COPY AND PASTE ABOVE LINE TO ADD A NEW BUTTON
// END ICON LINKS


document.write('</div></div></div>');






// START FLOATING SCRIPT
// 2016 © Allwebco Design Corporation
// YOU DO NOT NEED TO EDIT BELOW THIS LINE

var menuPosition = $('#menuJF').css;

// START SCRIPT - ANIMATION SPEED IS MICROSECONDS

function FloatMenu(){
	var animationSpeed=1500;
	var animationEasing='easeOutQuint';
	var scrollAmount=$(document).scrollTop();
	var newPosition=menuPosition+scrollAmount;
	if($(window).height()<$('#menuJF').height()+$('#menuJF .menu-HT').height()){
		$('#menuJF').css('top',menuPosition);
	} else {
		$('#menuJF').stop().animate({top: newPosition}, animationSpeed, animationEasing);
	}
}
$(window).load(function() {
	menuPosition=$('#menuJF').position().top;
	FloatMenu();
});
$(window).scroll(function () { 
	FloatMenu();
});

