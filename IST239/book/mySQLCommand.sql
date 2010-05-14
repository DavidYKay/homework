-- create the college table
create table College(
  collegeId char(4) not null,
  name varchar(25) not null, 
  since date, 
  deanId char(9));

-- insert new rows
insert into College values('Law', 'Law', null, 111223333);
insert into College values('Educ', 'Education', null, 111224444);

select * from College;

-- commit tansaction
commit;