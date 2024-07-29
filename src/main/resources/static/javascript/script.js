document.addEventListener('DOMContentLoaded', function() {
	const backgrounds = [
		'url(./backround/backround1.jpg)',
		'url(./backround/backround2.jpg)',
		'url(./backround/backround3.jpg)'

	];

	let currentIndex = 0;

	function changeBackground() {
		document.querySelector('.background').style.backgroundImage = backgrounds[currentIndex];
		currentIndex = (currentIndex + 1) % backgrounds.length;
	}

	changeBackground(); // Change background initially

	setInterval(changeBackground, 10000); // Change background every 10 seconds
});

var form = document.forms

$("main").addClass("pre-enter").removeClass("with-hover");
setTimeout(function(){
	$("main").addClass("on-enter");
}, 500);
setTimeout(function(){
	$("main").removeClass("pre-enter on-enter");
	setTimeout(function(){
		$("main").addClass("with-hover");
	}, 50);
}, 3000);

$("h1 a").click(function(){
	$(this).siblings().removeClass("active");
	$(this).addClass("active");
	if ($(this).is("#link-signup")) {
		$("#form-login").removeClass("active");
		$("#intro-login").removeClass("active");
		setTimeout(function(){
			$("#form-signup").addClass("active");
			$("#intro-signup").addClass("active");
		}, 50);
	} else {
		$("#form-signup").removeClass("active");
		$("#intro-signup").removeClass("active");
		setTimeout(function(){
			$("#form-login").addClass("active");
			$("#intro-login").addClass("active");
		}, 50);
	}
});


function openNav() {
	document.getElementById("sidenav").style.width = "150px";}

function closeNav() {
	document.getElementById("sidenav").style.width = "0";
}