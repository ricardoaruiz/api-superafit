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

insert into training_type (name) values ('W.O.D.');
insert into training_type (name) values ('AMRAP');
/*==========================================================================================*/

/*Movement==================================================================================*/
select * from movement;

insert into movement (name, translate, description) values ('Burpee','Burpee','Descrição do Burpee');
insert into movement (name, translate, description) values ('Single Under','Corda simples','Descrição Single Under');
insert into movement (name, translate, description) values ('Double Under','Corda dupla','Descrição Double Under');
insert into movement (name, translate, description) values ('Thruster','Thruster','Descrição Thruster');

insert into movement (name, translate, description) values ('M5','M5','Descrição M5');
insert into movement (name, translate, description) values ('M6','M6','Descrição M6');
insert into movement (name, translate, description) values ('M7','M7','Descrição M7');
insert into movement (name, translate, description) values ('M8','M8','Descrição M8');
insert into movement (name, translate, description) values ('M9','M9','Descrição M9');
insert into movement (name, translate, description) values ('M10','M10','Descrição M10');

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
order by t.date, m.name;

/*==========================================================================================*/

