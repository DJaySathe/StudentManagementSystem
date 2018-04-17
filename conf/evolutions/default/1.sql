# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table student (
  id                            integer auto_increment not null,
  name                          varchar(255),
  date_of_birth                 datetime(6),
  contact                       varchar(255),
  constraint pk_student primary key (id)
);


# --- !Downs

drop table if exists student;

