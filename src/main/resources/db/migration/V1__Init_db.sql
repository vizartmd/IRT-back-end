create table action (
    id bigint not null auto_increment,
    created_date date,
    action_priority varchar(255),
    action_status varchar(255),
    ticket_id bigint,
    user_id bigint,
    primary key (id)
);

create table developer_ticket (
    user_id bigint not null,
    ticket_id bigint not null,
    primary key (user_id, ticket_id)
);

create table jwt_token (
    id integer not null auto_increment,
    counter bigint,
    primary key (id)
);

create table ticket (
    id bigint not null auto_increment,
    created_date date,
    closed_date date,
    description varchar(255),
    ticket_priority varchar(255),
    ticket_specialty varchar(255),
    ticket_status varchar(255),
    title varchar(255) not null,
    creator_id bigint,
    developer_id bigint,
    primary key (id)
);

create table user (
    id bigint not null auto_increment,
    created_date date,
    email varchar(255) not null,
    first_name varchar(255),
    last_name varchar(255),
    password varchar(255) not null,
    role varchar(255),
    user_specialty varchar(255),
    user_name varchar(255) not null,
    verificationCode varchar(255),
    primary key (id)
);


alter table ticket
    add constraint ticket_title_uk
    unique (title);

alter table user
    add constraint user_email_uk
    unique (email);

alter table user
    add constraint user_name_uk
    unique (user_name);

alter table action
    add constraint action_ticket_fk
    foreign key (ticket_id) references ticket (id);

alter table action
    add constraint action_user_fk
    foreign key (user_id) references user (id);

alter table developer_ticket
    add constraint developer_ticket_fk
    foreign key (ticket_id) references ticket (id);

alter table developer_ticket
    add constraint developer_ticket_user_fk
    foreign key (user_id) references user (id);

alter table ticket
    add constraint ticket_creator_fk
    foreign key (creator_id) references user (id);

alter table ticket
    add constraint ticket_developer_fk
    foreign key (developer_id) references user (id);