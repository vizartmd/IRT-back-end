
insert into user ( created_date, email, first_name, last_name, password, role, user_specialty, user_name)
    values( '2021-09-01', 'victorR@gmail.com', 'victor', 'robu', '$2a$12$/PmzyqoLcV65p7Ep6N/e6ONm1Rokp/GR3yRWw3/4L9l7aIDrtyljO', 'ADMIN', 'BACKEND', 'victor.r');

insert into user ( created_date, email, first_name, last_name, password, role, user_specialty, user_name)
    values( '2021-10-23', 'andreiC@gmail.com', 'andrei', 'cazacu', '$2a$12$5JZSLX.Q0upow.y3tGgneulpM6c0LhPWHW8hl3ULjSF6KIMpmiFeC', 'ADMIN', 'BACKEND', 'andrei.c');

insert into user ( created_date, email, first_name, last_name, password, role, user_specialty, user_name)
    values( '2021-11-12', 'andreiG@gmail.com', 'andrei', 'grabavenco', '$2a$12$pH.QCBhhbHTNlFqXlKThaemMgCiR5t9RD6UrABEkbluXkgvHNy5AS', 'ADMIN', 'BACKEND', 'andrei.g');

insert into user ( created_date, email, first_name, last_name, password, role, user_specialty, user_name)
    values( '2021-08-05', 'sandra.rusu17@gmail.com', 'sandra', 'rusu', '$2a$12$VnvyAiMZj70aoKauPB1oquWEZSF5LD4D9LiFaQxPK52urQXuRWUWK', 'ADMIN', 'BACKEND', 'sandra.r');

insert into user ( created_date, email, first_name, last_name, password, role, user_specialty, user_name)
    values( '2021-11-18', 'cristianU@gmail.com', 'cristian', 'ursache', '$2a$12$4WfHRcd6T8.9Bpe9BXPDh.TfXfVs/zH/QOwqsPlXwwiUR4z9wSPsu', 'ADMIN', 'BACKEND', 'cristian.u');

insert into user ( created_date, email, first_name, last_name, password, role, user_specialty, user_name)
    values( '2021-11-18', 'jhon@gmail.com', 'jhon', 'anderson', '$2a$12$Zke51KOrCPpc46NzgTTDdeyAlh7eCWBiMeXXivArXz0W0rkZ5F64y', 'USER', 'FRONTEND', 'jhon.a');

insert into user ( created_date, email, first_name, last_name, password, role, user_specialty, user_name)
    values( '2021-11-18', 'steve@gmail.com', 'steve', 'smith', '$2a$12$D9zMPf/zl2NJf1W3tgR48.LoWkQd34GtKsmAoEu4wvFtIIYanwaD2', 'USER', 'FRONTEND', 'steve.s');

insert into user ( created_date, email, first_name, last_name, password, role, user_specialty, user_name)
    values( '2021-11-18', 'michele@gmail.com', 'michele', 'clarke', '$2a$12$qGxRdS18Zlhu.sS6td41nuD5EVRBc1GS3oLvQkaDi9k.c8MAs530G', 'ADMIN', 'BACKEND', 'michele.c');

insert into user ( created_date, email, first_name, last_name, password, role, user_specialty, user_name)
    values( '2021-11-18', 'anna@gmail.com', 'anna', 'pietersen', '$2a$12$swHICG8CLXC1nfWliE2iQesJGsUYZYq3snQpZ2v2e63Kg4xamALxe', 'ADMIN', 'BACKEND', 'anna.p');

insert into user ( created_date, email, first_name, last_name, password, role, user_specialty, user_name)
    values( '2021-11-18', 'tom@gmail.com', 'tom', 'taylor', '$2a$12$p.Vd7cL6JhrWiRGBdBYVj.1yXWnliBIs2UGKfFaldTSTwexzxPude', 'ADMIN', 'BACKEND', 'tom.t');



insert into ticket (created_date, closed_date, description, ticket_priority, ticket_specialty, ticket_status, title, creator_id, developer_id)
        values('2021-11-18', null, 'Implement registration and authentication. Only the admin should have the permission to sign up a user', 'MEDIUM', 'FRONTEND', 'ASSIGNED', 'Registration and Authentication', '1', '9');

insert into ticket (created_date, closed_date, description, ticket_priority, ticket_specialty, ticket_status, title, creator_id, developer_id)
        values('2021-11-20', null, 'Create entities for User, Email, Ticket and Action', 'LOW', 'BACKEND', 'BACKLOG', 'Create project entities', '2', null);

insert into ticket (created_date, closed_date, description, ticket_priority, ticket_specialty, ticket_status, title, creator_id, developer_id)
        values('2021-11-23', '2021-11-25', 'Implement Change Password and Forgot Password feature. A validation code would be sent to users email. After that, user would be able to update his password, by inserting the validation code and a new password', 'HIGH', 'BACKEND', 'CLOSED', 'Forgot password feature', '2', '8');

insert into ticket (created_date, closed_date, description, ticket_priority, ticket_specialty, ticket_status, title, creator_id, developer_id)
        values('2021-11-06', null, 'Change the design of the profile page. There should be two containers, one should contain users information and the other one should contain the password update form', 'MEDIUM', 'FRONTEND', 'ASSIGNED', 'Change profile style', '3', '7');

insert into ticket (created_date, closed_date, description, ticket_priority, ticket_specialty, ticket_status, title, creator_id, developer_id)
        values('2021-10-20', '2021-11-04', 'Create a user list with all the users. There should be three buttons, one to view the user, other one to edit the user, and one to delete the user. Add filtration and pagination to the table ', 'HIGH', 'FRONTEND', 'CLOSED', 'Create user list', '4', '8');

insert into ticket (created_date, closed_date, description, ticket_priority, ticket_specialty, ticket_status, title, creator_id, developer_id)
        values('2021-11-09', null, 'Create the services for User, Email, Ticket and Action', 'MEDIUM', 'BACKEND', 'FINISHED', 'Create project services', '4', '9');

insert into ticket (created_date, closed_date, description, ticket_priority, ticket_specialty, ticket_status, title, creator_id, developer_id)
        values('2021-11-02', '2021-11-03', 'Create unit tests for methods from User and Ticket services', 'HIGH', 'BACKEND', 'ASSIGNED', 'Create unit test', '3', '9');

insert into ticket (created_date, closed_date, description, ticket_priority, ticket_specialty, ticket_status, title, creator_id, developer_id)
        values('2021-09-20', null, 'Implement edit user feature. There should be validations for all fields, and only after all of them are filled up, the admin can press the edit user button', 'LOW', 'FRONTEND', 'ASSIGNED', 'Edit user feature', '1', '8');

insert into ticket (created_date, closed_date, description, ticket_priority, ticket_specialty, ticket_status, title, creator_id, developer_id)
        values('2021-08-20', null, 'Implement CRUD operations for User, Ticket and Action entities', 'LOW', 'BACKEND', 'ASSIGNED', 'CRUD operations', '1', '7');

insert into ticket (created_date, closed_date, description, ticket_priority, ticket_specialty, ticket_status, title, creator_id, developer_id)
        values('2021-10-29', '2021-11-01', 'Create controllers and implement rest endpoints for all the entities ', 'HIGH', 'BACKEND', 'FINISHED', 'Rest endpoints', '1', '7');