insert into Shift (startTime, endTime, month, day, year)
	values ('0800', '1600', 'November', 27, 2017);
insert into Shift (startTime, endTime, month, day, year)
	values ('1601', '1159', 'November', 27, 17);
    
insert into Person (name) values ('Declan McManus');
insert into Person (name) values ('Claire Fraser');

insert into Address (number, street, city, state, zipcode)
	values (33, 'Pony Street', 'Dublin', 'OH', '45000');
    
insert into HasAddress (persID, aID) values (1, 1);
	
	