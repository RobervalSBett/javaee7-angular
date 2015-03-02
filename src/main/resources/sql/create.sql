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