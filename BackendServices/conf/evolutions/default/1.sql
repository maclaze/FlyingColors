# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table company (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  ceo                       varchar(255),
  constraint pk_company primary key (id))
;

create table service_type (
  id                        bigint auto_increment not null,
  type                      varchar(255),
  constraint pk_service_type primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table company;

drop table service_type;

SET FOREIGN_KEY_CHECKS=1;

