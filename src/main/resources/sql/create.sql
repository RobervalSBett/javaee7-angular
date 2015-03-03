CREATE SEQUENCE ID START WITH 100
CREATE TABLE PERSON("ID" INTEGER not null primary key, "NAME" VARCHAR(50), "DESCRIPTION" VARCHAR(100), "IMAGEURL" VARCHAR(500))

CREATE SEQUENCE UF;
create domain UF as VARCHAR(2);
/*==============================================================*/
CREATE SEQUENCE Bairros START WITH 1
create table Bairros ("IDBAI" INTEGER not null, 
                      "DESCRIBAI" VARCHAR(60) null, 
constraint PK_BAIRROS primary key (IDBAI))
create unique index BAIRROS_PK on Bairros ("IDBAI");
/*==============================================================*/
CREATE SEQUENCE CIDADES START WITH 1
create table Cidades ("IDCID"      INTEGER  not null,
                      "DESCRICID"  VARCHAR(60) null,
                      "UFCID"      UF  null,
constraint PK_CIDADES primary key (IDCID));
create unique index CIDADES_PK on Cidades (IDCID);
/*==============================================================*/
CREATE SEQUENCE CEPS START WITH 1
create table Ceps ("CEP"       VARCHAR(8)   not null,
                   "IDCID"     INTEGER      not null,
                   "IDBAI"     INTEGER      not null,
                   "LOGRACEP"  VARCHAR(60)  null,
                   "OBSCEP"    VARCHAR(100) null,
constraint PK_CEPS primary key (CEP) );
create unique index CEPS_PK on Ceps (CEP);
create  index ASSOCCEPBAI_FK on Ceps (IDBAI);
create  index ASSOCCEPSCID_FK on Ceps (IDCID);
alter table Ceps
   add constraint FK_CEPS_ASSOCCEPB_BAIRROS foreign key (IDBAI)
      references Bairros (IDBAI)
      on delete restrict on update restrict;
alter table Ceps
   add constraint FK_CEPS_ASSOCCEPS_CIDADES foreign key (IDCID)
      references Cidades (IDCID)
      on delete restrict on update restrict;

/*==============================================================*/
CREATE SEQUENCE AUDITORES START WITH 1
create table Auditores ("IDAUDITOR" INTEGER not null,
                        "NOMEAUDIT" VARCHAR(60) null,
                        "CPFAUDIT"  VARCHAR(8) null,
                        "FONE1AUDIT" VARCHAR(12) null,
                        "FONE2AUDIT" VARCHAR(12) null,
                        "EMAILAUDIT" VARCHAR(100) null,
                        "COMPLEENDAUDIT" VARCHAR(60) null,
                        "OBSAUDIT" VARCHAR(100) null,
                        constraint PK_AUDITORES primary key (IDAUDITOR));
create unique index AUDITORES_PK on Auditores (IDAUDITOR);
create  index ASSOCCERTAUDITORIA_FK on Auditorias (IDCERT);
create  index ASSOCIATION_8_FK on Auditorias (IDCLI);
/*==============================================================*/
CREATE SEQUENCE CLIENTES START WITH 1
create table Clientes ("IDCLI"  INTEGER not null,
                       "RAZAOCLI"  VARCHAR(254) null,
                       "FANTACLI"  VARCHAR(254) null,
                       "COMPLEENDCLI" VARCHAR(254) null,
                       "FONE1CLI" VARCHAR(254) null,
                       "FONE2CLI" VARCHAR(254) null,
                       "EMAILCLI" VARCHAR(254) null,
                       "SITECLI"  VARCHAR(254) null,
                       "CONTATOCLI" VARCHAR(254) null,
                       "CNPJCLI"    VARCHAR(254) null,
                       "INSCRICLI"  VARCHAR(254) null,
                       "OBSCLI"  VARCHAR(254) null,
constraint PK_CLIENTES primary key (IDCLI));
create unique index CLIENTES_PK on Clientes (IDCLI);
/*==============================================================*/
CREATE SEQUENCE COLABORADORES START WITH 1
create table Colaboradores ("IDCOLA"    INTEGER not null,
                            "NOMECOLA"  INTEGER null,
                            "FONE1COLA" INTEGER null,
                            "FONE2COLA" INTEGER null,
                            "EMAILCOLA" INTEGER null,
                            "OBSCOLA"   INTEGER null,
constraint PK_COLABORADORES primary key (IDCOLA));
create unique index COLABORADORES_PK on Colaboradores (IDCOLA);
/*==============================================================*/
CREATE SEQUENCE CERTIFICADORAS START WITH 1
create table Certificadoras ("IDCERT"   INTEGER    not null,
                             "CEP"      VARCHAR(8) not null,
                             "RAZAOCERT" VARCHAR(60) null,
                             "FANTACERT" VARCHAR(60) null,
                             "COMPLEENDCERT" VARCHAR(60)  null,
                             "FONE1CERT"  VARCHAR(12)  null,
                             "FONE2CERT"  VARCHAR(12)  null,
                             "EMAILCERT"  VARCHAR(100) null,
                             "SITECERT"   VARCHAR(100) null,
                             "CONTATOCERT" VARCHAR(60)  null,
                             "CNPJCERT"  VARCHAR(17)  null,
                             "INSCRICERT" VARCHAR(17)  null,
                             "OBSCERT" VARCHAR(100) null,
constraint PK_CERTIFICADORAS primary key (IDCERT));
create unique index CERTIFICADORAS_PK on Certificadoras (IDCERT);
create  index ASSOCIATION_3_FK on Certificadoras (CEP);
alter table Certificadoras
   add constraint FK_CERTIFIC_ASSOCCERT_CEPS foreign key (CEP)
      references Ceps (CEP)
      on delete restrict on update restrict;
/*==============================================================*/
CREATE SEQUENCE AUDITORIAS START WITH 1
create table Auditorias ("IDAUDIT"  INTEGER not null,
                         "IDCERT"   INTEGER not null,
                         "IDCLI"    INTEGER not null,
                         "DESCRIAUDIT"    VARCHAR(254) null,
                         "DESCRIOBJAUDIT" VARCHAR(254) null,
                         "DTHRCADAUDIT"   DATE      null,
                         "DTHRINIAUDIT"   DATE      null,
                         "DTHRREALIAUDIT" DATE      null,
                         "DTATUALIZA"  DATE         null,
                         "STATUSNC"    VARCHAR(1)   null,
                         "OBSAUDIT"    VARCHAR(100) null,
constraint PK_AUDITORIAS primary key (IDAUDIT));
create unique index AUDITORIAS_PK on Auditorias (IDAUDIT);
create  index ASSOCCERTAUDITORIA_FK on Auditorias (IDCERT);
create  index ASSOCIATION_8_FK on Auditorias (IDCLI);
alter table Auditorias
   add constraint FK_AUDITORI_ASSOCCERT_CERTIFIC foreign key (IDCERT)
      references Certificadoras (IDCERT)
      on delete restrict on update restrict;

alter table Auditorias
   add constraint FK_AUDITORI_ASSOCIATI_CLIENTES foreign key (IDCLI)
      references Clientes (IDCLI)
      on delete restrict on update restrict;
/*==============================================================*/
CREATE SEQUENCE EQUIPEAUDITORES START WITH 1
create table EQUIPEAUDITORES ("IDEQUIPE"   INTEGER not null,
                              "IDAUDITOR"  INTEGER null,
                              "IDAUDIT"    INTEGER not null,
                              "TIPOAUDITOR"   VARCHAR(254) null,
                              "DTHRINCEQUIPE" DATE null,
constraint PK_EQUIPEAUDITORES primary key (IDEQUIPE));
create unique index EQUIPEAUDITORES_PK on EQUIPEAUDITORES (IDEQUIPE);
create  index ASSOCAUDITORIAEQUIPE_FK on EQUIPEAUDITORES (IDAUDIT);
create  index ASSOCAUDITEQUIPE_FK on EQUIPEAUDITORES (IDAUDITOR);
alter table EQUIPEAUDITORES
   add constraint FK_EQUIPEAU_ASSOCAUDI_AUDITORE foreign key (IDAUDITOR)
      references Auditores (IDAUDITOR)
      on delete restrict on update restrict;
alter table EQUIPEAUDITORES
   add constraint FK_EQUIPEAU_ASSOCAUDI_AUDITORI foreign key (IDAUDIT)
      references Auditorias (IDAUDIT)
      on delete restrict on update restrict;
/*==============================================================*/
CREATE SEQUENCE CHECKLIST START WITH 1
create table CheckList ( "IDPONTOCTRL" INTEGER not null,
                         "IDCOLA"   INTEGER not null,
                         "IDAUDIT"  INTEGER not null,
                         "IDEQUIPE" INTEGER not null,
                         "DOCPROCESSO"   VARCHAR(12) null,
                         "DESCRICHKLIST" VARCHAR(254) null,
                         "DTHRREALICHKLIST" DATE null,
                         "DTATUALIZA"  DATE null,
                         "OBSCHKLIST"  VARCHAR(254) null,
constraint PK_CHECKLIST primary key (IDPONTOCTRL));
create unique index CHECKLIST_PK on CheckList (IDPONTOCTRL);
create  index ASSOCAUDITORIACHKLIST_FK on CheckList (IDAUDIT);
create  index ASSOCEQUICHKLIST_FK on CheckList (IDEQUIPE);
create  index ASSOCCOLACHKLST_FK on CheckList (IDCOLA);
alter table CheckList
   add constraint FK_CHECKLIS_ASSOCAUDI_AUDITORI foreign key (IDAUDIT)
      references Auditorias (IDAUDIT)
      on delete restrict on update restrict;
alter table CheckList
   add constraint FK_CHECKLIS_ASSOCCOLA_COLABORA foreign key (IDCOLA)
      references Colaboradores (IDCOLA)
      on delete restrict on update restrict;
alter table CheckList
   add constraint FK_CHECKLIS_ASSOCEQUI_EQUIPEAU foreign key (IDEQUIPE)
      references EQUIPEAUDITORES (IDEQUIPE)
      on delete restrict on update restrict;
/*==============================================================*/
CREATE SEQUENCE NAOCONFORMIDADES START WITH 1
create table NaoConformidadeds (
                                "IDNC"          INTEGER     not null,
                                "IDCOLA"        INTEGER     not null,
                                "IDPONTOCTRL"   INTEGER      not null,
                                "DTHRCADNC"     DATE         null,
                                "DTPREVRESOLNC" DATE         null,
                                "DTATUALIZA"    DATE         null,
                                "DESCRINC"      VARCHAR(254) null,
                                "SUGESTAONC"    VARCHAR(254) null,
                                "STATUSNC"      VARCHAR(1)   null,
                                "OBSNC"         VARCHAR(100) null,
constraint PK_NAOCONFORMIDADEDS primary key (IDNC));
create unique index NAOCONFORMIDADEDS_PK on NaoConformidadeds (IDNC);
create  index ASSOCCHKNC_FK on NaoConformidadeds (IDPONTOCTRL);
create  index ASSOCCOLANC_FK on NaoConformidadeds (IDCOLA);
alter table NaoConformidadeds
   add constraint FK_NAOCONFO_ASSOCCHKN_CHECKLIS foreign key (IDPONTOCTRL)
      references CheckList (IDPONTOCTRL)
      on delete restrict on update restrict;

alter table NaoConformidadeds
   add constraint FK_NAOCONFO_ASSOCCOLA_COLABORA foreign key (IDCOLA)
      references Colaboradores (IDCOLA)
      on delete restrict on update restrict;

/*==============================================================*/
CREATE SEQUENCE OCORRENCIAS START WITH 1
create table Ocorrencias (
                          "IDOCORRE"     INTEGER      not null,
                          "IDPONTOCTRL"  INTEGER      not null,
                          "IDCOLA"       INTEGER      not null,
                          "DTHROCORRE"   DATE         null,
                          "DTATUALIZA"   DATE         null,
                          "DESCRIOCORRE" VARCHAR(254) null,
                          "SUGESOCORRE"  VARCHAR(254) null,
                          "OBSOCORRE"    VARCHAR(100) null,
constraint PK_OCORRENCIAS primary key (IDOCORRE));
create unique index OCORRENCIAS_PK on Ocorrencias (IDOCORRE);
create  index ASSOCCHKOCO_FK on Ocorrencias (IDPONTOCTRL);
create  index ASSOCCOLAOCO_FK on Ocorrencias (IDCOLA);
alter table Ocorrencias
   add constraint FK_OCORRENC_ASSOCCHKO_CHECKLIS foreign key (IDPONTOCTRL)
      references CheckList (IDPONTOCTRL)
      on delete restrict on update restrict;

alter table Ocorrencias
   add constraint FK_OCORRENC_ASSOCCOLA_COLABORA foreign key (IDCOLA)
      references Colaboradores (IDCOLA)
      on delete restrict on update restrict;