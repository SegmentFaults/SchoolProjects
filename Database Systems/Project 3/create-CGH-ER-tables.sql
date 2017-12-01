use testdb;

create table Person (
	persID mediumint not null unique auto_increment,
	name varchar(30),
	primary key(persID)
);

create table Patient (
	pID mediumint not null unique auto_increment,
	persID mediumint,
	primary key (pID),
	foreign key (persID)references Person(persID)
);

create table Address (
	aID mediumint not null unique auto_increment,
	number mediumint,
	street varchar(30),
	city varchar(20),
	state char(2),
	zipcode char(5),
	primary key (aID)
);

create table HasAddress (
	persID mediumint,
	aID mediumint,
	primary key (persID, aID),
	foreign key (persID)references Person(persID),
	foreign key (aID) references Address(aID)
);

create table Shift (
	sID mediumint not null unique auto_increment,
	startTime char(4),
	endTime char(4),
	month varchar(10),
	day tinyint,
	year tinyint,
	primary key (sID)	
);

create table visits (
	pID mediumint,
	sID mediumint,
	result varchar(25),
	primary key (pID, sID),
	foreign key (pID)references Patient(pID),
	foreign key (sID)references Shift(sID)
);
	