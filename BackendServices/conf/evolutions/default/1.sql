# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table answer (
  id                        bigint auto_increment not null,
  op1                       varchar(255),
  op2                       varchar(255),
  op3                       varchar(255),
  op4                       varchar(255),
  ans                       varchar(255),
  constraint pk_answer primary key (id))
;

create table company (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  ceo                       varchar(255),
  constraint pk_company primary key (id))
;

create table question (
  id                        bigint auto_increment not null,
  desc                      varchar(255),
  constraint pk_question primary key (id))
;

create table service_type (
  id                        bigint auto_increment not null,
  type                      varchar(255),
  constraint pk_service_type primary key (id))
;


create table company_service_type (
  company_id                     bigint not null,
  service_type_id                bigint not null,
  constraint pk_company_service_type primary key (company_id, service_type_id))
;



alter table company_service_type add constraint fk_company_service_type_company_01 foreign key (company_id) references company (id) on delete restrict on update restrict;

alter table company_service_type add constraint fk_company_service_type_service_type_02 foreign key (service_type_id) references service_type (id) on delete restrict on update restrict;

# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table answer;

drop table company;

drop table company_service_type;

drop table question;

drop table service_type;

SET FOREIGN_KEY_CHECKS=1;

