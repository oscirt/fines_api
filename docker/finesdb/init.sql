create table if not exists fines_app.user (
    user_id int not null auto_increment,
    user_name varchar(100),
    user_phone_number char(11) unique,
    user_birth_date date,
    user_login varchar(100) unique,
    user_password varchar(100) unique,
    user_license char(10) unique,
    primary key (user_id)
);

create table if not exists fines_app.fine (
    fine_id int not null auto_increment,
    user_id int not null,
    fine_number int unique,
    fine_vehicle_number char(9),
    fine_start_date date,
    fine_end_date date,
    fine_status tinyint,
    fine_amount decimal(6,2),
    fine_requisites varchar(20),
    primary key (fine_id),
    foreign key (user_id) references fines_app.user(user_id)
);

create table if not exists fines_app.payment (
    payment_id int not null auto_increment,
    user_id int not null,
    payment_number int unique,
    payment_status tinyint,
    payment_date date,
    payment_amount decimal(6,2),
    primary key (payment_id),
    foreign key (user_id) references fines_app.user(user_id)
);

create table if not exists fines_app.vehicle (
    vehicle_id int not null auto_increment,
    user_id int not null,
    vehicle_number char(9) unique,
    vehicle_brand varchar(42),
    vehicle_vin_number char(17) unique,
    primary key (vehicle_id),
    foreign key (user_id) references fines_app.user(user_id)
);

create table if not exists fines_app.message (
    message_id int not null auto_increment,
    user_id int not null,
    message_datetime datetime,
    message_text text,
    primary key (message_id),
    foreign key (user_id) references fines_app.user(user_id)
);