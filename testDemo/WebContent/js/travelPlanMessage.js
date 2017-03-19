function initial(){
	var currentP=$("#currentP").val();
	var destination=$("#destination").val();
	var dTime=$("#dYear").val()+'-'+$("#dMonth").val()+'-'+$("#dDay").val();
	var atTime=$("#atYear").val()+'-'+$("#atMonth").val()+'-'+$("#atDay").val();
	$.ajax({  
        type:'get',      
        url:'http://localhost:8080/travelPlanWebServiceClent/rest/scenicSpotInfoFWs/scenicSpotInfo',  
        data:{destination:destination},  
        cache:false,  
        dataType:'json',  
        success:function(data){  
       	 var scenicDetailList=data.scenicDetail;
       	 var auxHtml=$('#cloneScenicSpotDetail');
       	 $.each(scenicDetailList,function(index,item){
    				 var clonedAuxHtml = auxHtml.clone();
    				 clonedAuxHtml.find(".image").attr("src",item.imageUrl);
    				 clonedAuxHtml.find(".name").html(item.spotName);
    				 clonedAuxHtml.find(".adress").html(item.address);
    				 clonedAuxHtml.insertAfter(auxHtml);
       	 });
       	 $('#cloneScenicSpotDetail').hide();
        }  
    });  
	 
	    $.ajax({  
		         type:'get',      
		         url:'http://localhost:8080/travelPlanWebServiceClent/rest/starHotelInfoFWs/starHotelInfo',  
		         data:{destination:destination},  
		         cache:false,  
		         dataType:'json',  
		         success:function(data){  
		        	 var hotelDetailList=data.hotelDetailList;
		        	 var auxHtml=$('#cloneHotelDetail');
		        	 $.each(hotelDetailList,function(index,item){
		     				 var clonedAuxHtml = auxHtml.clone();
		     				 clonedAuxHtml.find(".image").attr("src",item.objURL);
		     				 clonedAuxHtml.find(".name").html(item.name);
		     				 clonedAuxHtml.find(".adress").html(item.address);
		     				 clonedAuxHtml.insertAfter(auxHtml);
		        	 });
		        	 $('#cloneHotelDetail').hide();
		         }  
		     }); 
	    $(".trainMessage").load("../plugin/jExpand/jExpandDemo.html");
	
}

function travelMessDisplayFws(){
	var currentP=$("#currentP").val();
	var destination=$("#destination").val();
	var dTime=$("#dYear").val()+'-'+$("#dMonth").val()+'-'+$("#dDay").val();
	var atTime=$("#atYear").val()+'-'+$("#atMonth").val()+'-'+$("#atDay").val();
	$("#cloneScenicSpotDetail").nextAll().remove();
	$.ajax({  
        type:'get',      
        url:'http://localhost:8080/travelPlanWebServiceClent/rest/scenicSpotInfoFWs/scenicSpotInfoNew',  
        data:{destination:destination},  
        cache:false,  
        dataType:'json',  
        success:function(data){  
       	 var scenicDetailList=data.scenicDetail;
       	 var auxHtml=$('#cloneScenicSpotDetail');
       	 $.each(scenicDetailList,function(index,item){
    				 var clonedAuxHtml = auxHtml.clone();
    				 clonedAuxHtml.show();
    				 clonedAuxHtml.find(".image").attr("src",item.imageUrl);
    				 clonedAuxHtml.find(".name").html(item.spotName);
    				 clonedAuxHtml.find(".adress").html(item.address);
    				 clonedAuxHtml.insertAfter(auxHtml);
       	 });
       	 $('#cloneScenicSpotDetail').hide();
        }  
    });  
	 
	$("#cloneHotelDetail").nextAll().remove();
	    $.ajax({  
		         type:'get',      
		         url:'http://localhost:8080/travelPlanWebServiceClent/rest/starHotelInfoFWs/starHotelInfoNew',  
		         data:{destination:destination},  
		         cache:false,  
		         dataType:'json',  
		         success:function(data){  
		        	 var hotelDetailList=data.hotelDetailList;
		        	 var auxHtml=$('#cloneHotelDetail');
		        	 $.each(hotelDetailList,function(index,item){
		     				 var clonedAuxHtml = auxHtml.clone();
		     				 clonedAuxHtml.show();
		     				 clonedAuxHtml.find(".image").attr("src",item.objURL);
		     				 clonedAuxHtml.find(".name").html(item.name);
		     				 clonedAuxHtml.find(".adress").html(item.address);
		     				 clonedAuxHtml.insertAfter(auxHtml);
		        	 });
		        	 $('#cloneHotelDetail').hide();
		         }  
		     }); 
	    $(".trainMessage").empty();
	    $(".trainMessage").load("../plugin/jExpand/jExpandDemo.html");
}

function searchTravelPlanMess(currentP,destination,dTime,atTime){
	
}
function trainMessFRm(){
	 
     
}

