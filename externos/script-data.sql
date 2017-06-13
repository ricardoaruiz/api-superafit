/*Schedule==================================================================================*/
select * from schedule order by week_day, schedule_start;

insert into schedule (week_day, schedule_start, schedule_end) values (1, '06:30','07:30');
insert into schedule (week_day, schedule_start, schedule_end) values (1, '08:30','09:30');
insert into schedule (week_day, schedule_start, schedule_end) values (1, '18:00','19:00');
insert into schedule (week_day, schedule_start, schedule_end) values (2, '06:00','07:00');
insert into schedule (week_day, schedule_start, schedule_end) values (2, '08:00','09:00');
insert into schedule (week_day, schedule_start, schedule_end) values (2, '11:00','12:00');
insert into schedule (week_day, schedule_start, schedule_end) values (3, '06:00','07:00');
insert into schedule (week_day, schedule_start, schedule_end) values (3, '08:00','09:00');
insert into schedule (week_day, schedule_start, schedule_end) values (3, '11:00','12:00');
insert into schedule (week_day, schedule_start, schedule_end) values (3, '13:00','14:00');
insert into schedule (week_day, schedule_start, schedule_end) values (3, '14:00','15:00');
insert into schedule (week_day, schedule_start, schedule_end) values (4, '06:00','07:00');
insert into schedule (week_day, schedule_start, schedule_end) values (4, '08:00','09:00');
insert into schedule (week_day, schedule_start, schedule_end) values (4, '11:00','12:00');
insert into schedule (week_day, schedule_start, schedule_end) values (4, '13:00','14:00');
insert into schedule (week_day, schedule_start, schedule_end) values (4, '14:00','15:00');
insert into schedule (week_day, schedule_start, schedule_end) values (4, '16:00','17:00');
/*==========================================================================================*/


/*Training Type==================================================================================*/
select * from training_type;

insert into training_type (name) values ('Aquecimento');
insert into training_type (name) values ('Técnica');
insert into training_type (name) values ('WOD 1');
insert into training_type (name) values ('WOD 2');
insert into training_type (name) values ('WOD 3');


/*==========================================================================================*/

/*Movement==================================================================================*/
select * from movement;

insert into movement (name, translate, description) values ('Scketch','Scketch','Descrição Scketch');
insert into movement (name, translate, description) values ('Single Under','Corda simples','Descrição Single Under');
insert into movement (name, translate, description) values ('Double Under','Corda dupla','Descrição Double Under');
insert into movement (name, translate, description) values ('Jumping Jacks','Jumping Jacks','Descrição Jumping Jacks');
insert into movement (name, translate, description) values ('Burpee','Burpee','Descrição do Burpee');
insert into movement (name, translate, description) values ('Thruster','Thruster','Descrição Thruster');
insert into movement (name, translate, description) values ('Wall Ball','Bola na Parede','Descrição Wall Ball');
insert into movement (name, translate, description) values ('Pull Up','Barra','Descrição Pull Up');
insert into movement (name, translate, description) values ('Push Up','Flexão de braço','Descrição Push Up');
insert into movement (name, translate, description) values ('Clean and Jerk','Clean and Jerk','Descrição Clean and Jeark');


/*==========================================================================================*/


/*Training==================================================================================*/
select * from training;
select * from training_movement;

delete from training_movement where movement_id > 0;
delete from training where id > 0;

select  t.date data_treino,
		tt.name treino,
		t.qt_round rounds,
		m.name,
		tm.qt_rep repeticoes
from 	training t,
		training_movement tm,
		training_type tt,
		movement m
where t.id = tm.training_id
and t.training_type_id = tt.id
and tm.movement_id = m.id
and t.date = '2017-06-12'
order by t.date, t.sequence, m.name;

/*==========================================================================================*/

