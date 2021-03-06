<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WSC Management</title>
<link href="lib/css/style.css" type="text/css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="lib/css/travelPlan.css">
<script type="text/javascript" src="js/travelPlanWsComp.js"></script>

<!-- jquery file -->
<script language="javascript" type="text/javascript"
	src="lib/jquery/pggrid/jquery.min.js"></script>
<script language="javascript" type="text/javascript"
	src="lib/jquery/pggrid/jquery-ui.min.js"></script>
<link rel="stylesheet" href="lib/jquery/pggrid/jquery-ui.css" />

<!-- niceform file -->
<link rel="stylesheet" type="text/css" media="all"
	href="lib/FormBeautify/niceforms-default.css" />
<script language="javascript" type="text/javascript"
	src="lib/FormBeautify/niceforms.js"></script>
	
<!-- hightChart file -->
<script language="javascript" type="text/javascript" src="lib/hightChart/highcharts.js"></script>
	
<!--jqgrid file  -->
<link id="uiThemes" rel="stylesheet" type="text/css" media="screen"
	href="plugin/jpgrid/jqGrid-master/css/jquery-ui-1.7.1.custom.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="plugin/jpgrid/jqGrid-master/css/ui.jqgrid.css" />
<script src="plugin/jpgrid/jqGrid-master/js/i18n/grid.locale-cn.js"
	type="text/javascript"></script>
<script src="plugin/jpgrid/jqGrid-master/js/jquery.jqGrid.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
    $(function(){
    	travelPlanInit();
     });

</script>
</head>
<body>
	<div class="global">
		<div class="symbol">
			<h1>WebService Composition Management</h1>
		</div>
		<div class="botton">
			<a class="  button   button-khaki" href="#"><span id="Discovery">Discovery</span></a>
			<a class="  button   button-blue" href="#"><span id="Selection">Selection</span></a>
			<a class="  button   button-brown" href="#"><span id="Result">ResAnalyze</span></a>
			<a class="  button   button-blue" href="#"><span id="Binding">Binding</span></a>
		</div>
		<div id="result" class="result">
			<div id="requirment" class="requirment">
			</div>
			<div id="WsDetail" class="detail">
				
			</div>
		</div>
		<div class="bottom">bottom</div>
	</div>
</body>
</html>