
 CREATE PROCEDURE saveHotelImage() 
 BEGIN
	
 END ;
 
 UPDATE starhotelinfo INNER JOIN hotelimage ON starhotelinfo.id = hotelimage.id
SET starhotelinfo.objURL = hotelimage.objURL;
 
 
 
