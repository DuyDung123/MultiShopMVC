<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<meta name="keywords" content="Grocery Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />

<script type="application/x-javascript">
	
	addEventListener("load", function() {
			setTimeout(hideURLbar, 0); }, false);
			function hideURLbar(){ window.scrollTo(0,1); 
	} 


</script>
<link href="<c:url value='/template/web/css/bootstrap.css'/>" rel="stylesheet" type="text/css">
<link href="<c:url value='/template/web/css/style.css'/>" rel="stylesheet" type="text/css">
<link href="<c:url value='/template/web/css/style2.css'/>" rel="stylesheet" type="text/css">
<link href="<c:url value='/template/web/css/font-awesome.css'/>" rel="stylesheet" type="text/css">

<script src="<c:url value='/template/web/js/jquery-1.11.1.min.js'/>"></script>

<link href='//fonts.googleapis.com/css?family=Ubuntu:400,300,300italic,400italic,500,500italic,700,700italic' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>


<link href="<c:url value='/template/web/css/flexslider.css'/>" rel="stylesheet" type="text/css">
<link href="<c:url value='/template/web/css/easy-responsive-tabs.css'/>" rel="stylesheet" type="text/css">
<link href="<c:url value='/template/web/css/creditly.css'/>" rel="stylesheet" type="text/css">

<!-- start-smoth-scrolling -->
<script src="<c:url value='/template/web/js/move-top.js'/>"></script>
<script src="<c:url value='/template/web/js/easing.js'/>"></script>

<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
</head>
<body>
	<!-- Navigation -->
	<%@ include file="/common/web/header.jsp" %>
	<%@ include file="/common/web/banner.jsp" %>

	<dec:body/>

	<!-- Footer -->
	<%@ include file="/common/web/footer.jsp" %>

	<!-- Bootstrap core JavaScript -->
<script src="<c:url value='/template/web/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/template/web/js/jquery.flexslider.js'/>"></script>
<script>
$(document).ready(function(){
    $(".dropdown").hover(            
        function() {
            $('.dropdown-menu', this).stop( true, true ).slideDown("fast");
            $(this).toggleClass('open');        
        },
        function() {
            $('.dropdown-menu', this).stop( true, true ).slideUp("fast");
            $(this).toggleClass('open');       
        }
    );
});
</script>
<!-- here stars scrolling icon -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
			*/
								
			$().UItoTop({ easingType: 'easeOutQuart' });
								
			});
	</script>
<!-- //here ends scrolling icon -->
<script src="<c:url value='/template/web/js/minicart.js'/>"></script>
<script>
		paypal.minicart.render();

		paypal.minicart.cart.on('checkout', function (evt) {
			var items = this.items(),
				len = items.length,
				total = 0,
				i;

			// Count the number of each item in the cart
			for (i = 0; i < len; i++) {
				total += items[i].get('quantity');
			}

			if (total < 3) {
				alert('The minimum order quantity is 3. Please add more to your shopping cart before checking out');
				evt.preventDefault();
			}
		});

	</script>
</body>
</html>