/*Schedule==================================================================================*/
select * from schedule order by week_day, schedule_start;

insert into schedule (week_day, schedule_start, schedule_end) values (1, '06:30','07:30');
insert into schedule (week_day, schedule_start, schedule_end) values (1, '08:30','09:30');
insert into schedule (week_day, schedule_start, schedule_end) values (1, '18:00','19:00');
insert into schedule (week_day, schedule_start, schedule_end) values (2, '06:00','07:00');
insert into schedule (week_day, schedule_start, schedule_end) values (2, '08:00','09:00');
insert into schedule (week_day, schedule_start, schedule_end) values (2, '11:00','12:00');
/*==========================================================================================*/


/*Training Type==================================================================================*/
select * from training_type;

insert into training_type (name) values ('W.O.D.');
insert into training_type (name) values ('AMRAP');
/*==========================================================================================*/

/*Movement==================================================================================*/
select * from movement;

insert into movement (name, translate, description) values ('Burpee','Burpee','Descrição do Burpee');
insert into movement (name, translate, description) values ('Single Under','Corda simples','Descrição Single Under');
insert into movement (name, translate, description) values ('Double Under','Corda dupla','Descrição Double Under');
insert into movement (name, translate, description) values ('Thruster','Thruster','Descrição Thruster');
/*==========================================================================================*/


/*Training==================================================================================*/
select * from training;
select * from training_movement;

insert into training (training_type_id, date, qt_round) values (1, '2017-05-31', 3);
insert into training_movement values (1, 1, 10);
insert into training_movement values (4, 1, 20);

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

/*==========================================================================================*/
