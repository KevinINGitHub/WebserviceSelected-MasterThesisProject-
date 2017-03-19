<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Travel Plan</title>
<!-- travelPlan file -->
<link href="/testDemo/lib/css/travelPlanDisplay.css" type="text/css"
	rel="stylesheet">
<script type="text/javascript" src="/testDemo/js/travelPlanMessage.js"></script>

<!-- jquery file -->
<script language="javascript" type="text/javascript"
	src="/testDemo/lib/jquery/pggrid/jquery.min.js"></script>
<script language="javascript" type="text/javascript"
	src="/testDemo/lib/jquery/pggrid/jquery-ui.min.js"></script>
<link rel="stylesheet" href="/testDemo/lib/jquery/pggrid/jquery-ui.css" />

<!-- niceform file -->
<link rel="stylesheet" type="text/css" media="all"
	href="/testDemo/lib/FormBeautify/niceforms-default.css" />
<script language="javascript" type="text/javascript"
	src="/testDemo/lib/FormBeautify/niceforms.js"></script>
	
<script type="text/javascript">
$(function(){
	initial();
	$("#tpSubmit").click(function(){
		travelMessDisplayFws();
	});
}); 

</script>
</head>
<body>
	<div class="global">
		<div class="symbol">title</div>
		<div class="searchMessage">
			<div class="niceF">
 				<%@include file="/lib/FormBeautify/searchNiceForm.html"%>
			</div>
			
		</div>
		<div class="travelMessage">
			<div class="scenicSpotList">
			scenicSpot
				<div id="cloneScenicSpotDetail"  class="scenicSpotDetail">
				<div class="basicMess">
					<div class="image1"><img class="image" src=""></div>
					<div class="abstract">
						<div class="mainMess">
							<div class="name">name</div>
							<div class="adress">adress</div>
							<div class="auxIcon">
							<span>pic1</span>
							<span>pic2</span>
							</div>
						</div>
						<div class="price">price</div>

					</div>
				</div>
				<!-- <div class="detail">
					<div class="expand">
						<span><a href="#">expandIcon</a></span>
					</div>
					<div class="typeDetail">
					<table>
					table
					
					</table>
					</div>
				</div> -->
			</div>
			</div>
			<div id="HotelDetailList" class="HotelDetailList">
			HotelDetailList
				<div id="cloneHotelDetail" class="hotelDetail">
					<div class="basicMess">
					<div class="image1"><img class="image" src=""></div>
					<div class="abstract">
						<div class="mainMess">
							<div class="name">name</div>
							<div class="adress">adress</div>
							<div class="auxIcon">
							<span>pic1</span>
							<span>pic2</span>
							</div>
						</div>
						<div class="price">price</div>

					</div>
				</div>
				<!-- <div class="detail">
					<div class="expand">
						<span>expandIcon</span>
					</div>
					<div class="typeDetail">
					<table>
					table
					
					</table>
					</div>
				</div> -->
				</div>
				

			</div>
			<div class="trainMessage">
				<%-- <%@include file="/plugin/jExpand/jExpandDemo.html"%> --%>
			</div>
		</div>
		<div class="bottom">bottom</div>
	</div>
</body>
</html>