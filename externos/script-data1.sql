/*Usuario*/
insert into user values ('rruiz','123456',1);
/*Role*/
insert into role (name) values ('ADMIN');
/*User Role*/
insert into user_role values ('rruiz',1);
/*Training Type*/
insert into training_type (name, sequence) values ('Aquecimento',1);
insert into training_type (name, sequence) values ('Técnica',2);
insert into training_type (name, sequence) values ('WOD 1',3);
insert into training_type (name, sequence) values ('WOD 2',4);
insert into training_type (name, sequence) values ('WOD 3',5);
/*Movement*/
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