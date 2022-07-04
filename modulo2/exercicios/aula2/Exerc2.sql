CREATE SEQUENCE seq_pais
 START WITH     001
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
CREATE SEQUENCE seq_estado
 START WITH     001
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
CREATE SEQUENCE seq_cidade
 START WITH     001
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
CREATE SEQUENCE seq_bairro
 START WITH     001
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
CREATE SEQUENCE seq_endereco
 START WITH     001
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

--BEGIN TRANSACTION;
--PA�SES
INSERT INTO PAIS(ID_PAIS, NOME) VALUES (SEQ_PAIS.nextval,'Brasil');
INSERT INTO PAIS(ID_PAIS, NOME) VALUES (SEQ_PAIS.nextval,'Portugual');
--estados
INSERT INTO ESTADO(ID_ESTADO, ID_PAIS, NOME) VALUES (SEQ_ESTADO.nextval,1,'Piaui'); --1
INSERT INTO ESTADO(ID_ESTADO, ID_PAIS, NOME) VALUES (SEQ_ESTADO.nextval,1,'Ceara'); --2
INSERT INTO ESTADO(ID_ESTADO, ID_PAIS, NOME) VALUES (SEQ_ESTADO.nextval,2,'Coimbra'); --3
INSERT INTO ESTADO(ID_ESTADO, ID_PAIS, NOME) VALUES (SEQ_ESTADO.nextval,2,'Lisboa'); --4


--CIDADES
--estado PIAUI 1
INSERT INTO CIDADE (ID_CIDADE, ID_ESTADO, NOME) VALUES (SEQ_CIDADE.nextval,1,'Teresina');
INSERT INTO CIDADE (ID_CIDADE, ID_ESTADO, NOME) VALUES (SEQ_CIDADE.nextval,1,'Parnaiba');
--estado CEARA 2
INSERT INTO CIDADE (ID_CIDADE, ID_ESTADO, NOME) VALUES (SEQ_CIDADE.nextval,2,'Fortaleza');
INSERT INTO CIDADE (ID_CIDADE, ID_ESTADO, NOME) VALUES (SEQ_CIDADE.nextval,2,'Sobral');
--estado COIMBRA 3
INSERT INTO CIDADE (ID_CIDADE, ID_ESTADO, NOME) VALUES (SEQ_CIDADE.nextval,3,'Coimbra cidade');
INSERT INTO CIDADE (ID_CIDADE, ID_ESTADO, NOME) VALUES (SEQ_CIDADE.nextval,3,'Figueira da Foz');
--estado LISBOA 4
INSERT INTO CIDADE (ID_CIDADE, ID_ESTADO, NOME) VALUES (SEQ_CIDADE.nextval,4,'Sintra');
INSERT INTO CIDADE (ID_CIDADE, ID_ESTADO, NOME) VALUES (SEQ_CIDADE.nextval,4,'Cascais');

-- BAIRROS
--cidade1 bairro1 Teresina
INSERT INTO BAIRRO(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES(SEQ_CIDADE.nextval, 1, 1, 'Centro');
--cidade1 bairro2
INSERT INTO BAIRRO(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES(SEQ_CIDADE.nextval, 1, 1, 'Agua Mineral');
--c2 b1 Parnaiba
INSERT INTO BAIRRO(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES(SEQ_CIDADE.nextval, 2, 1, 'Sabia');
--c2 b2
INSERT INTO BAIRRO(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES(SEQ_CIDADE.nextval, 2, 1, 'Beira rio');
--c3 b1 Fortaleza
INSERT INTO BAIRRO(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES(SEQ_CIDADE.nextval, 3, 2, 'Aldeota');
--c3 b2
INSERT INTO BAIRRO(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES(SEQ_CIDADE.nextval, 3, 2, 'Iracema');
--c4 b1 Sobral
INSERT INTO BAIRRO(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES(SEQ_CIDADE.nextval, 4, 2, 'Industrial');
--c4 b2
INSERT INTO BAIRRO(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES(SEQ_CIDADE.nextval, 4, 2, 'Morro');

--c5 b1 Coimbra cidade
INSERT INTO BAIRRO(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES(SEQ_CIDADE.nextval, 5, 3, 'Centro');
--c5 b2
INSERT INTO BAIRRO(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES(SEQ_CIDADE.nextval, 5, 3, 'Lago');
--c6 b1 Figueira
INSERT INTO BAIRRO(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES(SEQ_CIDADE.nextval, 6, 3, 'Sagui');
--c6 b2
INSERT INTO BAIRRO(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES(SEQ_CIDADE.nextval, 6, 3, 'Beira rio');
--c7 b1 Sintra
INSERT INTO BAIRRO(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES(SEQ_CIDADE.nextval, 7, 4, 'Seriema');
--c7 b2
INSERT INTO BAIRRO(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES(SEQ_CIDADE.nextval, 7, 4, 'Ribeirao');
--c8 b1 Cascais
INSERT INTO BAIRRO(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES(SEQ_CIDADE.nextval, 8, 4, 'Industrial');
--c8 b2
INSERT INTO BAIRRO(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES(SEQ_CIDADE.nextval, 8, 4, 'Rio seco');


--ENDERECOS
--e1 b1
INSERT INTO ENDERECO(ID_ENDERECO, ID_BAIRRO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(SEQ_ENDERECO.nextval, 1,'Rua 12',134, 'perto de nada', 64000-999 );
--e2 b1
INSERT INTO ENDERECO(ID_ENDERECO, ID_BAIRRO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(SEQ_ENDERECO.nextval, 1,'Rua quarenta',4455, '', 64000-999 );

--e1 b2
INSERT INTO ENDERECO(ID_ENDERECO, ID_BAIRRO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(SEQ_ENDERECO.nextval, 2,'Avenida larga',774, '-', 64000-879 );
--e2 b2
INSERT INTO ENDERECO(ID_ENDERECO, ID_BAIRRO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(SEQ_ENDERECO.nextval, 2,'Rua nova',445, '', 64087-655 );

--e1 b3
INSERT INTO ENDERECO(ID_ENDERECO, ID_BAIRRO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(SEQ_ENDERECO.nextval, 3,'Rua 12',134, 'perto de nada', 64000-999 );
--e2 b3
INSERT INTO ENDERECO(ID_ENDERECO, ID_BAIRRO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(SEQ_ENDERECO.nextval, 3,'Rua quarenta',4455, '', 64000-999 );

--e1 b4
INSERT INTO ENDERECO(ID_ENDERECO, ID_BAIRRO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(SEQ_ENDERECO.nextval, 4,'Rua 12',134, 'perto de nada', 64000-999 );
--e2 b4
INSERT INTO ENDERECO(ID_ENDERECO, ID_BAIRRO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(SEQ_ENDERECO.nextval, 4,'Rua quarenta',4455, '', 64000-999 );

--e1 b5
INSERT INTO ENDERECO(ID_ENDERECO, ID_BAIRRO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(SEQ_ENDERECO.nextval, 5,'Rua 12',134, 'perto de nada', 64000-999 );
--e2 b5
INSERT INTO ENDERECO(ID_ENDERECO, ID_BAIRRO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(SEQ_ENDERECO.nextval, 5,'Rua quarenta',4455, '', 64000-999 );

--e1 b6
INSERT INTO ENDERECO(ID_ENDERECO, ID_BAIRRO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(SEQ_ENDERECO.nextval, 6,'Rua 12',134, 'perto de nada', 64000-999 );
--e2 b6
INSERT INTO ENDERECO(ID_ENDERECO, ID_BAIRRO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(SEQ_ENDERECO.nextval, 6,'Rua quarenta',4455, '', 64000-999 );

--e1 b7
INSERT INTO ENDERECO(ID_ENDERECO, ID_BAIRRO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(SEQ_ENDERECO.nextval, 7,'Rua 12',134, 'perto de nada', 64000-999 );
--e2 b7
INSERT INTO ENDERECO(ID_ENDERECO, ID_BAIRRO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(SEQ_ENDERECO.nextval, 7,'Rua quarenta',4455, '', 64000-999 );

--e1 b8
INSERT INTO ENDERECO(ID_ENDERECO, ID_BAIRRO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(SEQ_ENDERECO.nextval, 8,'Rua 12',134, 'perto de nada', 64000-999 );
--e2 b8
INSERT INTO ENDERECO(ID_ENDERECO, ID_BAIRRO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(SEQ_ENDERECO.nextval, 8,'Rua quarenta',4455, '', 64000-999 );

--e1 b9
INSERT INTO ENDERECO(ID_ENDERECO, ID_BAIRRO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(SEQ_ENDERECO.nextval, 9,'Rua 12',134, 'perto de nada', 64000-999 );
--e2 b9
INSERT INTO ENDERECO(ID_ENDERECO, ID_BAIRRO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(SEQ_ENDERECO.nextval, 9,'Rua quarenta',4455, '', 64000-999 );

--e1 b10
INSERT INTO ENDERECO(ID_ENDERECO, ID_BAIRRO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(SEQ_ENDERECO.nextval, 10,'Rua 12',134, 'perto de nada', 64000-999 );
--e2 b10
INSERT INTO ENDERECO(ID_ENDERECO, ID_BAIRRO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(SEQ_ENDERECO.nextval, 10,'Rua quarenta',4455, '', 64000-999 );

--e1 b11
INSERT INTO ENDERECO(ID_ENDERECO, ID_BAIRRO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(SEQ_ENDERECO.nextval, 11,'Rua 12',134, 'perto de nada', 64000-999 );
--e2 b11
INSERT INTO ENDERECO(ID_ENDERECO, ID_BAIRRO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(SEQ_ENDERECO.nextval, 11,'Rua quarenta',4455, '', 64000-999 );

--e1 b12
INSERT INTO ENDERECO(ID_ENDERECO, ID_BAIRRO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(SEQ_ENDERECO.nextval, 12,'Rua 12',134, 'perto de nada', 64000-999 );
--e2 b12
INSERT INTO ENDERECO(ID_ENDERECO, ID_BAIRRO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(SEQ_ENDERECO.nextval, 12,'Rua quarenta',4455, '', 64000-999 );

--e1 b13
INSERT INTO ENDERECO(ID_ENDERECO, ID_BAIRRO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(SEQ_ENDERECO.nextval, 13,'Rua 12',134, 'perto de nada', 64000-999 );
--e2 b13
INSERT INTO ENDERECO(ID_ENDERECO, ID_BAIRRO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(SEQ_ENDERECO.nextval, 13,'Rua quarenta',4455, '', 64000-999 );

--e1 b14
INSERT INTO ENDERECO(ID_ENDERECO, ID_BAIRRO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(SEQ_ENDERECO.nextval, 14,'Rua 12',134, 'perto de nada', 64000-999 );
--e2 b14
INSERT INTO ENDERECO(ID_ENDERECO, ID_BAIRRO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(SEQ_ENDERECO.nextval, 14,'Rua quarenta',4455, '', 64000-999 );

--e1 b15
INSERT INTO ENDERECO(ID_ENDERECO, ID_BAIRRO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(SEQ_ENDERECO.nextval, 15,'Rua 12',134, 'perto de nada', 64000-999 );
--e2 b15
INSERT INTO ENDERECO(ID_ENDERECO, ID_BAIRRO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(SEQ_ENDERECO.nextval, 15,'Rua quarenta',4455, '', 64000-999 );

--e1 b16
INSERT INTO ENDERECO(ID_ENDERECO, ID_BAIRRO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(SEQ_ENDERECO.nextval, 16,'Rua 12',134, 'perto de nada', 64000-999 );
--e2 b16
INSERT INTO ENDERECO(ID_ENDERECO, ID_BAIRRO, LOGRADOURO, NUMERO, COMPLEMENTO, CEP) VALUES(SEQ_ENDERECO.nextval, 16,'Rua quarenta',4455, '', 64000-999 );

--ROLLBACK; --retorna para o begin transaction  desfazendo tudo que foi feito
--COMMIT;