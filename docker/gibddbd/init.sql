create table if not exists gibdd.fine (
    fine_id int not null auto_increment,
    user_id int not null,
    fine_number int unique,
    fine_vehicle_number char(9),
    fine_start_date date,
    fine_end_date date,
    fine_status tinyint,
    fine_amount decimal(6,2),
    fine_requisites varchar(20),
    primary key (fine_id)
);