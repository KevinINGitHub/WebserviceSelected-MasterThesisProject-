function wsInfoJpgrid() {
	$("#hightChart").remove();
	jQuery("#gridTable")
			.jqGrid(
					{
						url : 'http://localhost:8080/travelPlanWebServiceClent/rest/wsResult/webServiceInfo',
						datatype : "json",
						colNames : [ 'wsName', 'wsType', 'price',
								'responseTime', 'reliability', 'available',
								'wsURL' ],
						colModel : [ {
							name : 'wsName',
							index : 'wsName',
							align : "center",
						// width : '150'
						}, {
							name : 'wsType',
							index : 'wsType ',
							align : "center",
						// width : '150'
						}, {
							name : 'price',
							index : 'price',
							// width : '100',
							align : "center"
						}, {
							name : 'responseTime',
							index : 'responseTime',
							// width : '100',
							align : "center"
						}, {
							name : 'reliability',
							index : 'reliability',
							// width : '100',
							align : "center"
						}, {
							name : 'available',
							index : 'available',
							// width : '100',
							align : "center",
							sortable : false
						}, {
							name : 'wsURL',
							index : 'wsURL',
							width : '720'
						} ],
						rowNum : 10,
						rowList : [ 10, 20, 30 ],
						pager : '#gridPager',
						sortname : 'wsName',
						mtype : "get",
						width : 940,
						shrinkToFit : true,
						height : 300,
						viewrecords : true,
						sortorder : "desc",
						caption : "Travel Plan WebService"
					}).navGrid('#gridPager', {
				edit : true,
				add : true,
				del : true
			});
}

function searchWsInfoJpgrid() {
	var wsType=$("#wsType").val();
	var wsNumber=$("#wsNumber").val();
	var priceMin=$("#priceMin").val();
	var priceMax=$("#priceMax").val();
	var responseTimeMin=$("#responseTimeMin").val();
	var responseTimeMax=$("#responseTimeMax").val();
	var reliableMin=$("#reliableMin").val();
	var reliableMax=$("#reliableMax").val();
	var availablyMin=$("#availablyMin").val();
	var availablyMax=$("#availablyMax").val();
	$("#WsDetail").empty();
	var item = '<div id="jqgrid"><table id="gridTable"></table><div id="gridPager"></div></div>';
	$("#WsDetail").append(item);
	var PostData={wsType:wsType,wsNumber:wsNumber,priceMin:priceMin,priceMax:priceMax,
			responseTimeMin:responseTimeMin,responseTimeMax:responseTimeMax,reliableMin:reliableMin,reliableMax:reliableMax};
	jQuery("#gridTable")
			.jqGrid(
					{
						url : 'http://localhost:8080/travelPlanWebServiceClent/rest/wsResult/searchWsList',
						datatype : "json",
						postData: PostData,
						colNames : [ 'wsName', 'wsType', 'price',
								'responseTime', 'reliability', 'available',
								'wsURL' ],
						colModel : [ {
							name : 'wsName',
							index : 'wsName',
							align : "center",
						// width : '150'
						}, {
							name : 'wsType',
							index : 'wsType ',
							align : "center",
						// width : '150'
						}, {
							name : 'price',
							index : 'price',
							// width : '100',
							align : "center"
						}, {
							name : 'responseTime',
							index : 'responseTime',
							// width : '100',
							align : "center"
						}, {
							name : 'reliability',
							index : 'reliability',
							// width : '100',
							align : "center"
						}, {
							name : 'available',
							index : 'available',
							// width : '100',
							align : "center",
							sortable : false
						}, {
							name : 'wsURL',
							index : 'wsURL',
							width : '720'
						} ],
						rowNum : 10,
						rowList : [ 10, 20, 30 ],
						pager : '#gridPager',
						sortname : 'wsName',
						mtype : "get",
						width : 940,
						shrinkToFit : true,
						height : 300,
						viewrecords : true,
						sortorder : "desc",
						caption : "Travel Plan WebService"
					}).navGrid('#gridPager', {
				edit : true,
				add : true,
				del : true
			});
}

function highcharts() {
	$('#hightChart').highcharts({
		chart : {
			type : 'bar'
		},
		title : {
			text : 'Fruit Consumption'
		},
		xAxis : {
			categories : [ 'Apples', 'Bananas', 'Oranges' ]
		},
		yAxis : {
			title : {
				text : 'Fruit eaten'
			}
		},
		series : [ {
			name : 'Jane',
			data : [ 1, 0, 4 ]
		}, {
			name : 'John',
			data : [ 5, 7, 3 ]
		} ]
	});
}

function highchartsLine() {
	
	$('#hightChart').highcharts(
			{
				title : {
					text : 'Monthly Average Temperature',
					x : -20
				},
				subtitle : {
					text : 'Source: WorldClimate.com',
					x : -20
				},
				xAxis : {
					categories : [ 'Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
							'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec' ]
				},
				yAxis : {
					title : {
						text : 'Temperature (°„C)'
					},
					plotLines : [ {
						value : 0,
						width : 1,
						color : '#808080'
					} ]
				},
				tooltip : {
					valueSuffix : '°„C'
				},
				legend : {
					layout : 'vertical',
					align : 'right',
					verticalAlign : 'middle',
					borderWidth : 0
				},
				series : [
						{
							name : 'Tokyo',
							data : [ 7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2,
									26.5, 23.3, 18.3, 13.9, 9.6 ]
						},
						{
							name : 'New York',
							data : [ -0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8,
									24.1, 20.1, 14.1, 8.6, 2.5 ]
						},
						{
							name : 'Berlin',
							data : [ -0.9, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6,
									17.9, 14.3, 9.0, 3.9, 1.0 ]
						},
						{
							name : 'London',
							data : [ 3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0,
									16.6, 14.2, 10.3, 6.6, 4.8 ]
						} ]
			});

}
function hightchartsAjax(){
	$.getJSON('http://localhost:8080/travelPlanWebServiceClent/rest/wsResult/wsSelectionResult', function (csv) {
		var sgaOptVs=csv.algSelectRs[0].item;
		var fegaOptVs=csv.algSelectRs[1].item;
		var standGA=[];
		var fuzzyEliteGA=[];
		for(var i=0;i<sgaOptVs.length;i++){
			standGA[i]=parseFloat(sgaOptVs[i]);
			fuzzyEliteGA[i]=parseFloat(fegaOptVs[i]);
		}
		
		/*var optimalVs=csv.algSelectRs;
		var float=new Array();
		$.each(optimalVs,function(item,index){
			
			$.each(item,function(item1,index){
				alert(index);
			});
			
			float[index]=new Array();
			for(var j=0;j<item.length;j++){
				float[index][j]=parseFloat(item[j])
				alert(item[j]);
				alert(j);
			}
			alert("entered!!!");
		});*/

		
		$('#hightChart').highcharts(
				{
					 /* chart: {
	                        renderTo: 'container_validatestatics',
	                        type: 'line'
	                    },*/
					marker:{  
                    enabled:false
                    },
					title : {
						text : 'WebService Selection Result',
						x : -20
					},
					/*subtitle : {
						text : 'Source: WorldClimate.com',
						x : -20
					},*/
					xAxis : {
						categories : []
					},
					yAxis : {
						title : {
							text : 'optimalQos'
						},
						plotLines : [ {
							value : 0,
							width : 1,
							color : '#808080'
						} ]
					},
					tooltip : {
						valueSuffix : '°„C'
					},
					legend : {
						layout : 'vertical',
						align : 'right',
						verticalAlign : 'middle',
						borderWidth : 0
					},
					series : 
							[{
								name : 'standGenetic',
								data : standGA
							},
							{
								name : 'fuzzyEliteGenetic',
								data : fuzzyEliteGA
							}]
				});
    });
}
function travelPlanInit() {
	$("#requirment").empty();
	$("#requirment").load("lib/FormBeautify/wsDiscoveryNiceForm.html");
	var item = '<div id="jqgrid"><table id="gridTable"></table><div id="gridPager"></div></div>';
	$("#WsDetail").append(item);
	wsInfoJpgrid();
	$("#Result").click(function() {
		$("#result").empty();
		var item = '<div id="hightChart" style=""></div>';
		$("#result").append(item);
		hightchartsAjax();
	});
	$("#Discovery")
			.click(
					function() {
						$("#result").empty();
						$("#result").append('<div id="requirment" class="requirment"></div><div id="WsDetail" class="detail"></div>');
						$("#requirment").empty();
						$("#requirment").load("lib/FormBeautify/wsDiscoveryNiceForm.html");
						var item = '<div id="jqgrid"><table id="gridTable"></table><div id="gridPager"></div></div>';
						$("#WsDetail").append(item);
						wsInfoJpgrid();
					});
	$("#Selection")
	.click(
			function() {
				$("#result").empty();
				$("#result").append('<div id="requirment" class="requirment"></div><div id="WsDetail" class="detail"></div>');
				$("#requirment").empty();
				$("#requirment").load("lib/FormBeautify/wsSelectNiceForm.html");
				$("#WsDetail").load("lib/FormBeautify/wsResultNiceForm.html");
				wsInfoJpgrid();
			});
	
	$("#Binding")
	.click(
			function() {
				 $.ajax({  
			         type:'get',      
			         url:'http://localhost:8080/travelPlanWebServiceClent/rest/wsResult/bdSelectOptWs',  
			         cache:false,  
			         dataType:'json',  
			         success:function(data){  
			        	 alert("Binding Successful!!!");
			         }  
			     }); 
			});
}
function selectOptWs(){
	var algorithm=$("#algorithm").val();
	var constrPrice=$("#constrPrice").val();
	var constrResponseTime=$("#constrResponseTime").val();
	var constrReliable=$("#constrReliable").val();
	var constrAvailably=$("#constrAvailably").val();
	$("#cloneWsInfoResult").nextAll().remove();
	$("#cloneWsInfoResult").hide();
	 $.ajax({  
         type:'get',      
         url:'http://localhost:8080/travelPlanWebServiceClent/rest/wsResult/selectOptimalWs',  
         data:{algorithm:algorithm,constrPrice:constrPrice,constrResponseTime:constrResponseTime,
     		constrReliable:constrReliable,constrAvailably:constrAvailably}, 
         cache:false,  
         dataType:'json',  
         success:function(data){  
        	 var wsInfoResult=data.swr.wsInfoResult;
        	 var auxHtml=$('#cloneWsInfoResult');
        	 $.each(wsInfoResult,function(index,item){
     				 var clonedAuxHtml = auxHtml.clone();
     				 clonedAuxHtml.show();
     				 clonedAuxHtml.find(".wsType").text(item.wsType);
     				 clonedAuxHtml.find(".wsName").text(item.wsName);
     				 clonedAuxHtml.find(".wsURL").text(item.wsURL);
     				 clonedAuxHtml.insertAfter(auxHtml);
        	 });
        	 $('#cloneWsInfoResult').hide();
         }  
     }); 
}
















