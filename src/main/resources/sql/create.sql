CREATE SEQUENCE ID START WITH 100
CREATE TABLE PERSON("ID" INTEGER not null primary key, "NAME" VARCHAR(50), "DESCRIPTION" VARCHAR(100), "IMAGEURL" VARCHAR(500))

/*==============================================================*/
/* Table: Bairros                                               */
/*==============================================================*/
CREATE SEQUENCE Bairro START WITH 1
create table Bairros ("IDBAI" INTEGER not null, "DESCRIBAI" VARCHAR(254) null, constraint PK_BAIRROS primary key (IDBAI))

/*==============================================================*/
/* Index: BAIRROS_PK                                            */
/*==============================================================*/
create unique index BAIRROS_PK on Bairros ("IDBAI");