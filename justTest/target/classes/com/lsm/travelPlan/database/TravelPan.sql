create table TP_TRAINTICKET(
	TICKET_ID int(10),
	TICKET_PRICE int(10)

);

create table station_info(
	arriTime varchar(15),
	istmp varchar(15),
	sort int(8),
	interval1 varchar(15),
	station varchar(15),
	arriCity varchar(15),
	deptStationInfo varchar(15),
	code varchar(15),
	deptTimeRange varchar(15),
	arriStation varchar(15),
	dayAfter int(3),
	intervalSort int(5),
	deptTime varchar(15),
	deptStation varchar(15),
	ticketType varchar(15),
	arriTimeRange varchar(8),
	arriStationInfo varchar(8),
	deptCity varchar(8),
	trainType varchar(8),
	arriCity_py varchar(15),
	deptCity_py varchar(15),
	stationType varchar(8),
	tType varchar(8)
	
);

create table trainDetail(
	stationNumber int(3),
	stationName varchar(8),
	arriTime varchar(8),
	driverTime varchar(8),
	stayTime varchar(8),
	mileage int(8),
	hardseat varchar(5),
	hardsleeper varchar(8),
	softsleeper varchar(8)
	
);

create table startToDest(
	trainType varchar(8),
	trainNo varchar(8),
	startStation varchar(15),
	endStation varchar(15),
	startTime varchar(15),
	endTime varchar(15),
	duration varchar(20),
	seatInfos varchar(50)
	
);


show tables;

create table scenicInfo(
id varchar(5)COLLATE utf8_unicode_ci,
spotName varchar(15)COLLATE utf8_unicode_ci,
description varchar(50)COLLATE utf8_unicode_ci,
province varchar(8)COLLATE utf8_unicode_ci,
city varchar(6)COLLATE utf8_unicode_ci,
address varchar(20)COLLATE utf8_unicode_ci,
detail varchar(1024)COLLATE utf8_unicode_ci
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

create table starHotelInfo(
name varchar(20),
province varchar(15), 
address varchar(50),
objURL varchar(100),
tele  varchar(15)
);


DELIMITER &&
CREATE PROCEDURE initWSinfo3(IN wsNum int)
begin
	DECLARE j INT DEFAULT 1;
	truncate webserviceinfo;
	while j<wsNum+1 do
		insert into webserviceinfo(wsName,wsURL,wsType,responseTime,price,reliability,available)
		values(concat('ScenicSpotWebService',j),concat('http://localhost:8080/travelPlanWebService/services/ScenicSpotWebService',j)
			,'scenicSpotInfo',truncate(rand()*4.5+0.5,2),round(rand()*40+60),truncate(rand()*0.4+0.5,2),truncate(rand()*0.2+0.8,2));
		insert into webserviceinfo(wsName,wsURL,wsType,responseTime,price,reliability,available)
		values(concat('StarHotelWebService',j),concat('http://localhost:8080/travelPlanWebService/services/StarHotelWebService',j)
			,'starHotelInfo',truncate(rand()*4.5+0.5,2),round(rand()*40+60),truncate(rand()*0.4+0.5,2),truncate(rand()*0.2+0.8,2));
		insert into webserviceinfo(wsName,wsURL,wsType,responseTime,price,reliability,available)
		values(concat('TrainTicketWebService',j),concat('http://localhost:8080/travelPlanWebService/services/TrainTicketWebService',j)
			,'trainTicketInfo',truncate(rand()*4.5+0.5,2),round(rand()*40+60),truncate(rand()*0.4+0.5,2),truncate(rand()*0.2+0.8,2));
		set j=j+1;
	end while;
end &&
DELIMITER;



