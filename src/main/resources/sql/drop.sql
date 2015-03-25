DROP TABLE PERSON
DROP SEQUENCE ID

drop index BAIRROS_PK
drop table Bairros
DROP SEQUENCE Bairros

drop index CIDADES_PK
drop table Cidades
DROP SEQUENCE CIDADES

drop index ASSOCCEPSCID_FK
drop index ASSOCCEPBAI_FK
drop index CEPS_PK
drop constraint FKBAICEP
drop constraint FKCIDCEP
drop table Ceps
DROP SEQUENCE CEPS

drop index AUDITORES_PK
drop constraint FKAUDITORESCEP
drop table Auditores
DROP SEQUENCE AUDITORES

drop index CLIENTES_PK
drop constraint FKCLICEP
drop table Clientes
DROP SEQUENCE CLIENTES

drop index COLABORADORES_PK
drop table Colaboradores
DROP SEQUENCE COLABORADORES

drop index ASSOCCERTICEPS_FK
drop index CERTIFICADORAS_PK
drop constraint FKCEPCERTI
drop table Certificadoras
DROP SEQUENCE CERTIFICADORAS

drop index ASSOCCERTAUDITORIA_FK
drop index ASSOCCLIAUDIT_FK
drop index AUDITORIAS_PK
drop constraint FKCERTAUDIT
drop constraint FKCLIAUDIT
drop table Auditorias
DROP SEQUENCE AUDITORIAS


drop index ASSOCAUDITORIAEQUIPE_FK
drop index ASSOCAUDITEQUIPE_FK
drop index AUDITORIAS_PK
drop constraint FKAUDITORESEQUIPE
drop constraint FKAUDITEQUIPE
drop table EQUIPEAUDITORES
DROP SEQUENCE EQUIPEAUDITORES



drop index ASSOCAUDITORIACHKLIST_FK
drop index ASSOCEQUICHKLIST_FK
drop index ASSOCCOLACHKLST_FK
drop index CHECKLIST_PK
drop constraint FKAUDITCHKLIST
drop constraint FKCOLACHKLIST
drop constraint FKEQUIPECHKLIST
drop table CheckList
DROP SEQUENCE CHECKLIST



drop index ASSOCCHKNC_FK
drop index ASSOCCOLANC_FK
drop index NAOCONFORMIDADEDS_PK
drop constraint FKCHKLISTNC
drop constraint FKCOLANC
drop table NaoConformidades
DROP SEQUENCE NAOCONFORMIDADES



drop index ASSOCCHKOCO_FK
drop index ASSOCCOLAOCO_FK
drop index OCORRENCIAS_PK
drop constraint FKCHKLISTOCO
drop constraint FKCOLAOCO
drop table Ocorrencias
DROP SEQUENCE OCORRENCIAS


drop domain UF
CREATE SEQUENCE UF
