CREATE SEQUENCE ID START WITH 100
CREATE TABLE PERSON("ID" INTEGER not null primary key, "NAME" VARCHAR(50), "DESCRIPTION" VARCHAR(100), "IMAGEURL" VARCHAR(500))

CREATE SEQUENCE UF;
CREATE DOMAIN UF AS VARCHAR(2) 
DEFAULT 'SC' NOT NULL
CHECK (VALUE IN('MG','SP','RJ','AC','AL','AP','AM','BA','CE','DF','ES','GO', 'MA','MS','MT','PA','PB','PE','PI','PR','RN','RO','RR','RS', 'SC','SE','TO' ));

/*==============================================================*/
CREATE SEQUENCE Bairros START WITH 1
create table Bairros ("IDBAI"     INTEGER not null, 
                      "DESCRIBAI" VARCHAR(60) null, 
                      "STATUSBAI" VARCHAR(1) null,
constraint PK_BAIRROS primary key (IDBAI))
create unique index BAIRROS_PK on Bairros ("IDBAI");
/*==============================================================*/
CREATE SEQUENCE CIDADES START WITH 1
create table Cidades ("IDCID"      INTEGER  not null,
                      "DESCRICID"  VARCHAR(60) null,
                      "UFCID"      UF  null,
                      "STATUSCID"  VARCHAR(1) Nnull,
constraint PK_CIDADES primary key (IDCID));
create unique index CIDADES_PK on Cidades (IDCID);

/*==============================================================*/
CREATE SEQUENCE CEPS START WITH 1
create table Ceps ("CEP"       VARCHAR(8)   not null,
                   "IDCID"     INT4         not null,
                   "IDBAI"     INT4         not null,
                   "LOGRACEP"  VARCHAR(60)  null,
                   "OBSCEP"    VARCHAR(100) null,
                   "STATUSCEP" VARCHAR(1)   NULL,
constraint PK_CEPS primary key (CEP) );
create unique index CEPS_PK on Ceps (CEP);
create  index ASSOCCEPBAI_FK on Ceps (IDBAI);
create  index ASSOCCEPSCID_FK on Ceps (IDCID);
alter table Ceps
   add constraint FKBAICEP foreign key (IDBAI)
   references Bairros (IDBAI)
   on delete restrict on update restrict;
alter table Ceps
   add constraint FKCIDCEP foreign key (IDCID)
   references Cidades (IDCID)
   on delete restrict on update restrict;
/*==============================================================*/
CREATE SEQUENCE AUDITORES START WITH 1
create table Auditores ("IDAUDITOR" INT4          not null,
                        "CEP"        VARCHAR(8)   null,
                        "NOMEAUDIT"  VARCHAR(60)   null,
                        "CPFAUDIT"   VARCHAR(11)    null,
                        "FONE1AUDIT" VARCHAR(12)  null,
                        "FONE2AUDIT" VARCHAR(12)  null,
                        "EMAILAUDIT" VARCHAR(100) null,
                        "TIPOAUDIT"  VARCHAR(1)   null,
                        "COMPLEENDAUDIT" VARCHAR(60) null,
                        "OBSAUDIT" VARCHAR(100) null,
                        "STATUSAUDITORES" VARCHAR(1)
                        constraint PK_AUDITORES primary key (IDAUDITOR));
create unique index AUDITORES_PK on Auditores (IDAUDITOR);
alter table Auditores
   add constraint FKAUDITORESCEP foreign key (CEP)
   references Ceps (CEP)
   on delete restrict on update restrict;

/*==============================================================*/
CREATE SEQUENCE CLIENTES START WITH 1
create table Clientes ("IDCLI"        int4         not null,
                       "CEP"          VARCHAR(8)   not null,
                       "RAZAOCLI"     VARCHAR(60)  null,
                       "FANTACLI"     VARCHAR(60)  null,
                       "COMPLEENDCLI" VARCHAR(60)  null,
                       "FONE1CLI"     VARCHAR(12)  null,
                       "FONE2CLI"     VARCHAR(12)  null,
                       "EMAILCLI"     VARCHAR(100) null,
                       "SITECLI"      VARCHAR(100) null,
                       "CONTATOCLI"   VARCHAR(60)  null,
                       "CNPJCLI"      VARCHAR(14)  null,
                       "INSCRICLI"    VARCHAR(14)  null,
                       "OBSCLI"       VARCHAR(100) null,
                       "STATUSCLI"    VARCHAR(1)   null,
constraint PK_CLIENTES primary key (IDCLI));
create unique index CLIENTES_PK on Clientes (IDCLI);
alter table Clientes
   add constraint FKCLICEP foreign key (CEP)
   references Ceps (CEP)
   on delete restrict on update restrict;
/*==============================================================*/
CREATE SEQUENCE COLABORADORES START WITH 1
create table Colaboradores ("IDCOLA"     INT4         not null,
                            "NOMECOLA"   VARCHAR(60)  null,
                            "FONE1COLA"  VARCHAR(12)  null,
                            "FONE2COLA"  VARCHAR(12)  null,
                            "EMAILCOLA"  VARCHAR(100) null,
                            "OBSCOLA"    VARCHAR(100) null,
                            "STATUSCOLA" VARCHAR(1)   null,
constraint PK_COLABORADORES primary key (IDCOLA));
create unique index COLABORADORES_PK on Colaboradores (IDCOLA);
/*==============================================================*/
CREATE SEQUENCE CERTIFICADORAS START WITH 1
create table Certificadoras ("IDCERT"        INT4    not null,
                             "CEP"           VARCHAR(8) not null,
                             "RAZAOCERT"     VARCHAR(60) null,
                             "FANTACERT"     VARCHAR(60) null,
                             "COMPLEENDCERT" VARCHAR(60)  null,
                             "FONE1CERT"     VARCHAR(12)  null,
                             "FONE2CERT"     VARCHAR(12)  null,
                             "EMAILCERT"     VARCHAR(100) null,
                             "SITECERT"      VARCHAR(100) null,
                             "CONTATOCERT"   VARCHAR(60)  null,
                             "CNPJCERT"      VARCHAR(14)  null,
                             "INSCRICERT"    VARCHAR(14)  null,
                             "OBSCERT"       VARCHAR(100) null,
                             "STATUSCERT"    VARCHAR(1)   null,
constraint PK_CERTIFICADORAS primary key (IDCERT));
create unique index CERTIFICADORAS_PK on Certificadoras (IDCERT);
create  index ASSOCCERTICEPS_FK on Certificadoras (CEP);
alter table Certificadoras
   add constraint FKCEPCERTI foreign key (CEP)
   references Ceps (CEP)
   on delete restrict on update restrict;
/*==============================================================*/

CREATE SEQUENCE AUDITORIAS START WITH 1
create table Auditorias ("IDAUDIT"          INT4         not  null,
                         "IDCERT"           INT4         not  null,
                         "IDCLI"            INT4         not  null,
                         "DESCRIAUDIT"      VARCHAR(254) null,
                         "DESCRIOBJAUDIT"   VARCHAR(254) null,
                         "DTHRCADAUDIT"     TIMESTAMP    null,
                         "DTHRINIAUDIT"     TIMESTAMP    null,
                         "DTHRREALIAUDIT"   TIMESTAMP    null,
                         "DTATUALIZA"       TIMESTAMP    null,
                         "STATUSNC"         VARCHAR(1)   null,
                         "OBSAUDIT"         VARCHAR(100) null,
constraint PK_AUDITORIAS primary key (IDAUDIT));
create unique index AUDITORIAS_PK on Auditorias (IDAUDIT);
create  index ASSOCCERTAUDITORIA_FK on Auditorias (IDCERT);
create  index ASSOCCLIAUDIT_FK on Auditorias (IDCLI);
alter table Auditorias
   add constraint FKCERTAUDIT foreign key (IDCERT)
   references Certificadoras (IDCERT)
   on delete restrict on update restrict;

alter table Auditorias
   add constraint FKCLIAUDIT foreign key (IDCLI)
   references Clientes (IDCLI)
   on delete restrict on update restrict;
/*==============================================================*/
CREATE SEQUENCE EQUIPEAUDITORES START WITH 1
create table EQUIPEAUDITORES ("IDEQUIPE"      INT4 not null,
                              "IDAUDITOR"     INT4 null,
                              "IDAUDIT"       INT4 not null,
                              "TIPOAUDITOR"   VARCHAR(1) null,
                              "DTHRINCEQUIPE" TIMESTAMP null,
                              "STATUSEQUIPE"  VARCHAR(1) null,
constraint PK_EQUIPEAUDITORES primary key (IDEQUIPE));
create unique index EQUIPEAUDITORES_PK on EQUIPEAUDITORES (IDEQUIPE);
create  index ASSOCAUDITORIAEQUIPE_FK on EQUIPEAUDITORES (IDAUDIT);
create  index ASSOCAUDITEQUIPE_FK on EQUIPEAUDITORES (IDAUDITOR);
alter table EQUIPEAUDITORES
   add constraint FKAUDITORESEQUIPE foreign key (IDAUDITOR)
   references Auditores (IDAUDITOR)
   on delete restrict on update restrict;
alter table EQUIPEAUDITORES
   add constraint FKAUDITEQUIPE foreign key (IDAUDIT)
   references Auditorias (IDAUDIT)
   on delete restrict on update restrict;
/*==============================================================*/
CREATE SEQUENCE CHECKLIST START WITH 1
create table CheckList ( "IDPONTOCTRL"      INT4         not null,
                         "IDCOLA"           INT4         not null,
                         "IDAUDIT"          INT4         not null,
                         "IDEQUIPE"         INT4         not null,
                         "DOCPROCESSO"      VARCHAR(12)  null,
                         "DESCRICHKLIST"    VARCHAR(254) null,
                         "DTHRREALICHKLIST" TIMESTAMP    null,
                         "DTATUALIZA"       TIMESTAMP    null,
                         "OBSCHKLIST"       VARCHAR(254) null,
                         "STATUSCHKLIST"    VARCHAR(1)   null,
constraint PK_CHECKLIST primary key (IDPONTOCTRL));
create unique index CHECKLIST_PK on CheckList (IDPONTOCTRL);
create  index ASSOCAUDITORIACHKLIST_FK on CheckList (IDAUDIT);
create  index ASSOCEQUICHKLIST_FK on CheckList (IDEQUIPE);
create  index ASSOCCOLACHKLST_FK on CheckList (IDCOLA);
alter table CheckList
   add constraint FKAUDITCHKLIST foreign key (IDAUDIT)
   references Auditorias (IDAUDIT)
   on delete restrict on update restrict;
alter table CheckList
   add constraint FKCOLACHKLIST foreign key (IDCOLA)
   references Colaboradores (IDCOLA)
   on delete restrict on update restrict;
alter table CheckList
   add constraint FKEQUIPECHKLIST foreign key (IDEQUIPE)
   references EQUIPEAUDITORES (IDEQUIPE)
   on delete restrict on update restrict;
/*==============================================================*/
CREATE SEQUENCE NAOCONFORMIDADES START WITH 1
create table NaoConformidadeds (
                                "IDNC"          INT4         not null,
                                "IDCOLA"        INT4         not null,
                                "IDPONTOCTRL"   INT4         not null,
                                "DTHRCADNC"     TIMESTAMP    null,
                                "DTPREVRESOLNC" TIMESTAMP    null,
                                "DTATUALIZA"    TIMESTAMP    null,
                                "DESCRINC"      VARCHAR(254) null,
                                "SUGESTAONC"    VARCHAR(254) null,
                                "STATUSNC"      VARCHAR(1)   null,
                                "OBSNC"         VARCHAR(100) null,
constraint PK_NAOCONFORMIDADEDS primary key (IDNC));
create unique index NAOCONFORMIDADEDS_PK on NaoConformidadeds (IDNC);
create  index ASSOCCHKNC_FK on NaoConformidadeds (IDPONTOCTRL);
create  index ASSOCCOLANC_FK on NaoConformidadeds (IDCOLA);
alter table NaoConformidadeds
   add constraint FKCHKLISTNC foreign key (IDPONTOCTRL)
   references CheckList (IDPONTOCTRL)
   on delete restrict on update restrict;
alter table NaoConformidadeds
   add constraint FKCOLANC foreign key (IDCOLA)
   references Colaboradores (IDCOLA)
   on delete restrict on update restrict;

/*==============================================================*/
CREATE SEQUENCE OCORRENCIAS START WITH 1
create table Ocorrencias (
                          "IDOCORRE"     INT4         not null,
                          "IDPONTOCTRL"  INT4         not null,
                          "IDCOLA"       INT4         not null,
                          "DTHROCORRE"   TIMESTAMP    null,
                          "DTATUALIZA"   TIMESTAMP    null,
                          "DESCRIOCORRE" VARCHAR(254) null,
                          "SUGESOCORRE"  VARCHAR(254) null,
                          "OBSOCORRE"    VARCHAR(100) null,
                          "STATUSOCORRE" VARCHAR(1)   null,
constraint PK_OCORRENCIAS primary key (IDOCORRE));
create unique index OCORRENCIAS_PK on Ocorrencias (IDOCORRE);
create  index ASSOCCHKOCO_FK on Ocorrencias (IDPONTOCTRL);
create  index ASSOCCOLAOCO_FK on Ocorrencias (IDCOLA);
alter table Ocorrencias
   add constraint FKCHKLISTOCO foreign key (IDPONTOCTRL)
   references CheckList (IDPONTOCTRL)
   on delete restrict on update restrict;
alter table Ocorrencias
   add constraint FKCOLAOCO foreign key (IDCOLA)
   references Colaboradores (IDCOLA)
   on delete restrict on update restrict;