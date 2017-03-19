function gpInit(){
	/*$("#processL").empty();
	$("#processL").load("lib/FormBeautify/gaProgressLNiceForm.html");
	$("#processR").empty();
	$("#processR").load("lib/FormBeautify/gaProgressRNiceForm.html");*/
	$.ajax({  
        type:'get',      
        url:'http://localhost:8080/travelPlanWebServiceClent/rest/algorithmPerform/getGroup',  
        data:{generation:'1'}, 
        cache:false,  
        dataType:'json',  
        success:function(data){  
       	 var auxGroup=data.auxGroup;
       /*	 var auxHtml=$('#cloneWsInfoResult');*/
		$.each(auxGroup.orginChromList, function(index, item) {
			if(index>10){
				return true;
			} 
				var gene = [];
				gene = item.gene;
				var $dl = $("<dl></dl>");
				for ( var j = 0; j < gene.length; j++) {
					var $gaGrid = $("<div class='geneGrid'>" + gene[j]
							+ "</div>");
					$dl.append($gaGrid);
				}
				$(".processL").append($dl);

				$(".processL").append(
						"<div class='fitnessGrid'>" + item.fitnessV
								+ "</div>");

				/*
				 * var clonedAuxHtml = auxHtml.clone();
				 * clonedAuxHtml.show();
				 * clonedAuxHtml.find(".wsType").text(item.wsType);
				 * clonedAuxHtml.find(".wsName").text(item.wsName);
				 * clonedAuxHtml.find(".wsURL").text(item.wsURL);
				 * clonedAuxHtml.insertAfter(auxHtml);
				 */
			});
		
		$.each(auxGroup.crossChromList, function(index, item) {
			if(index>10){
				return true;
			} 
			var gene = [];
			gene = item.gene;
			var $dl = $("<dl></dl>");
			for ( var j = 0; j < gene.length; j++) {
				var $gaGrid = $("<div class='geneGrid'>" + gene[j]
						+ "</div>");
				$dl.append($gaGrid);
			}
			$(".processR").append($dl);

			$(".processR").append(
					"<div class='fitnessGrid'>" + item.fitnessV
							+ "</div>");

			/*
			 * var clonedAuxHtml = auxHtml.clone();
			 * clonedAuxHtml.show();
			 * clonedAuxHtml.find(".wsType").text(item.wsType);
			 * clonedAuxHtml.find(".wsName").text(item.wsName);
			 * clonedAuxHtml.find(".wsURL").text(item.wsURL);
			 * clonedAuxHtml.insertAfter(auxHtml);
			 */
		});

		/*	$('#cloneWsInfoResult').hide();*/
		}
	}); 
	
	
	
	/*for(var i=0;i<5;i++){
		var $dl=$("<dl></dl>");
		for(var j=0;j<21;j++){
			var $gaGrid=$("<div class='geneGrid'>1</div>");
			 $dl.append($gaGrid);
		}
		$(".processL").append($dl);
		
		$(".processL").append("<div class='fitnessGrid'>123</div>");
	}*/
}

