create table e_patient(p_id varchar2(20) primary key ,first_name varchar2(30) not null,last_name varchar2(30) not null,gender varchar2(10) not null,age varchar2(10) not null,address varchar2(100),contact_number varchar2(10),health_insurance_number varchar2(20));
create table e_hcp(hcp_name varchar2(30),hcp_id varchar(20) primary key,license_number varchar2(30),address varchar2(100) not null,contact varchar2(10) not null,emergency_contact varchar2(10),email_id varchar2(30));
insert into e_hcp values('reddy','hcp1','545','4584','945154','34535','r@r.com','anything',1);
insert into e_hcp_login values('hcp1','anything',1,'asdb','sdfs');
alter table e_hcp add password varchar2(30) not null;
create table e_dependents(d_id varchar2(10) primary key,p_id varchar2(20), constraint fk_p_id foreign key(p_id) references e_patient(p_id),first_name varchar2(30),last_name varchar2(30),gender varchar2(20),relationship varchar2(30),age varchar2(10),address varchar2(100),health_insurance_number varchar2(20),contact_number varchar2(10));
create table e_patient_login(p_id varchar2(20),constraint fk_pl_id foreign key(p_id) references e_patient(p_id),password varchar2(30) not null,number_visits int,security_question varchar2(100),security_answer varchar2(100) );
create table e_hcp_login(hcp_id varchar2(20),constraint fk_hcp_id foreign key(hcp_id) references e_hcp(hcp_id),password varchar2(30),number_login int,security_question varchar2(100),security_answer varchar2(100));
create table e_patient_register_via_hcp(hcp_id varchar2(20),constraint fk_hcp_register_id foreign key(hcp_id) references e_hcp(hcp_id),p_id varchar2(20),constraint fk_p_register_id foreign key(p_id) references e_patient(p_id));
alter table e_patient_register_via_hcp add medical_complaint varchar2(30);
alter table e_patient_register_via_hcp add refer_doctor varchar2(30);
alter table e_patient_register_via_hcp modify medical_complaint varchar2(100);
create table e_lab_service_providers(name varchar2(30),address varchar2(100),zip_code varchar2(10),city varchar2(50),state varchar2(50),contact_number number(10),alternate_contact_number number(10),email varchar2(30),category varchar2(20));
alter table e_lab_service_providers add lab_id varchar2(30) primary key ;
alter table e_lab_service_providers add password varchar2(30);
alter table e_hcp add serial_no int default(100);
delete from e_hcp;
select r.hcp_name from e_hcp r;
select * from e_lab_service;
create table e_lab_service(lab_id varchar2(30),constraint fk_lab_id foreign key(lab_id) references e_lab_service_providers(lab_id),test_name varchar2(30),test_code varchar2(30),test_description varchar2(100),test_duration number(10,3),cost_of_the_test int,lab_or_home varchar2(20));
create table e_lab_schedule(test_code varchar2(30),test_name varchar2(30),schedule_date varchar2(30),schedule_duration varchar2(50));
alter table e_lab_schedule add city varchar2(30);
alter table e_lab_schedule  add lab_service_provider_name varchar2(50);
alter table e_patient add bill int default (0);
alter table e_patient add serial_no int default(0);
alter table e_dependents add serial_no int default(0);
/*
 * starts the rest of testing part of query
 */
select * from e_dependents;
select * from e_lab_service_providers;
select * from e_lab_schedule;
update e_lab_schedule set city='Hyderabad' where city='hyderabad';

insert into e_lab_service_providers values('rajat','vikas nagar','260221','lucknow','up','945101875','94582426','r@gmail.com','special','1002','jsdhn');
insert into e_lab_service_providers values('amma','vikas nagar','260221','dehradun','up','945101875','94582426','r@gmail.com','special','1005','jsdhn');
insert into e_lab_service_providers values('amma','amrita nagar','260221','lucknow','up','945101875','94582426','r@gmail.com','special','1003','jsdhn');
insert into e_lab_service_providers values('sanjay','indira nagar','260221','kakinada','up','945101875','94582426','r@gmail.com','special','1004','jsdhn');

insert into e_lab_service values('1002','heart test','001','heart patient','25','520','lab');
insert into e_lab_service values('1001','heart test','001','heart patient','25','520','lab');
insert into e_lab_service values('1003','blood test','001','patient','25','6500','lab');
insert into e_lab_service values('1005','blood test','001','patient','25','6540','lab');
insert into e_lab_service values('1002','blood test','001','patient','25','900','lab');
insert into e_lab_service values('1004','blood test','001','patient','25','6500','lab');

insert into e_lab_schedule values('001','heart test','25/02/2015','12:30-2:30');
delete from e_lab_schedule;
select * from e_lab_schedule;
insert into e_lab_schedule values('001','heart test','25/02/2015','12:30-2:30','hyderabad','reddylabs');
insert into e_lab_schedule values('001','blood test','25/02/2015','9:30-11:30','lucknow','rajat');

insert into e_lab_schedule values('001','heart test','25/02/2015','9:30-11:30','lucknow','rajat');
insert into e_lab_schedule values('001','heart test','25/02/2015','9:30-11:30','hyderabad','reddylabs');

select r.name,s.test_name from E_LAB_SERVICE_PROVIDERS r inner join E_LAB_SERVICE s on r.lab_id=s.lab_id;
update e_lab_service set cost_of_the_test=1100 where lab_id='1001';
select r.name,r.address,r.state,r.city,s.test_name,s.test_code,s.test_description,s.cost_of_the_test,s.lab_or_home from e_lab_service_providers r  inner join e_lab_service s on s.lab_id=r.lab_id where s.test_name  like '%test%' and r.name in (select name from e_lab_service_providers where name in (select name from E_LAB_SERVICE_PROVIDERS)) order by s.cost_of_the_test ;
select * from e_dependents;
update e_dependents set first_name='rajat yo',last_name='kuch bhi',relationship='spouse',age='45',address='lucknow',gender='male',health_insurance_number='7854',contact_number='87455' where (p_id='p1' and d_id='d3');
select * from e_hcp;
select * from e_hcp_login;
select * from e_patient_register_via_hcp;
select * from e_patient e join e_patient_register_via_hcp h on e.p_id=h.p_id where h.hcp_id='hcp8';

select * from E_DEPENDENTS where p_id='p3' and d_id='d4';
update E_DEPENDENTS set age=12 where p_id='p1' and d_id='d3';
select * from e_dependents;
select * from e_hcp_login;
select * from e_patient_login;
delete from E_DEPENDENTS where p_id='p17';
delete from E_PATIENT_LOGIN where p_id='p17';
delete from e_patient where p_id='p17';
select p_id from e_dependents where p_id='p17';
select * from e_patient;
select * from e_hcp;
update e_patient_login set security_question='2',security_answer='blue' where p_id='p33';

update e_hcp_login set security_question='2',security_answer='blue' where hcp_id='hcp20';


select epl.p_id,epl.password,ep.contact_number from e_patient_login epl inner join e_patient ep on epl.p_id=ep.p_id where (epl.P_ID = '123' or ep.contact_number ='123' ) and epl.password= 'ghvghv';
select * from e_patient;
SELECT * from E_hcp_LOGIN;
select * from e_patient e join e_patient_register_via_hcp h on e.p_id=h.p_id where h.hcp_id='hcp23';
select ep.p_id, ep.first_name, ep.last_name, ep.gender, ep.age, ep.address, ep.contact_number, ep.health_insurance_number, ep.bill,epvh.medical_complaint,epvh.refer_doctor from e_patient ep inner join e_patient_register_via_hcp epvh on ep.p_id=epvh.p_id where ep.p_id ='p29';

select hcp_Id,Password from e_hcp_login;


/*

lsp starts from here

*/

create table e_lsp(lsp_name varchar2(50),lsp_id varchar2(50),password varchar2(50),city varchar2(50));
create table e_lsp_login(lsp_id varchar2(50),password varchar2(50));
create table e_lsp_heatlh_package(lsp_id varchar2(50),lsp_name varchar2(50),health_package_name varchar2(50),test_name varchar2(50),test_code varchar2(50),test_description varchar2(50),cost varchar2(50),serial_no int );

alter table e_lsp add email varchar2(50);
alter table e_lsp add contact varchar2(50);
alter table e_lsp drop column city;
alter table e_lsp add address varchar2(100);
alter table e_lsp drop column password;

select * from e_lsp;
