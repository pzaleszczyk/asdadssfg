delete from zamprod;
delete from zamowienie;
delete from produkt;
ALTER TABLE zamprod ALTER COLUMN id RESTART WITH 1;
ALTER TABLE zamowienie ALTER COLUMN id RESTART WITH 1;
ALTER TABLE produkt ALTER COLUMN id RESTART WITH 1;

insert into zamowienie(datazam, wynos) values (2003-12-12, true)
insert into zamowienie(datazam, wynos) values (2000-12-22, true)
insert into zamowienie(datazam, wynos) values (2002-12-30, true)
insert into zamowienie(datazam, wynos) values (2003-10-16, FALSE)
insert into zamowienie(datazam, wynos) values (2012-08-12, FALSE)
insert into zamowienie(datazam, wynos) values (2002-04-02, FALSE)
;
insert into PRODUKT(CENA,NAZWA,VEGE) VALUES(15.0,'KEBAB MIESNY',FALSE)
insert into PRODUKT(CENA,NAZWA,VEGE) VALUES(12.2,'KEBAB MALY',FALSE)
insert into PRODUKT(CENA,NAZWA,VEGE) VALUES(17.5,'KEBAB DUZY',FALSE)
insert into PRODUKT(CENA,NAZWA,VEGE) VALUES(16.0,'KEBAB WARZYWO',TRUE)
;
INSERT INTO ZAMPROD(ILOSC, prod, zam) VALUES(10,1,1)
INSERT INTO ZAMPROD(ILOSC, prod, zam) VALUES(11,2,1)
INSERT INTO ZAMPROD(ILOSC, prod, zam) VALUES(4,3,1)
INSERT INTO ZAMPROD(ILOSC, prod, zam) VALUES(20,1,4)
INSERT INTO ZAMPROD(ILOSC, prod, zam) VALUES(1,1,3)
INSERT INTO ZAMPROD(ILOSC, prod, zam) VALUES(2,4,4)
INSERT INTO ZAMPROD(ILOSC, prod, zam) VALUES(1,4,3)
INSERT INTO ZAMPROD(ILOSC, prod, zam) VALUES(1,1,5)
INSERT INTO ZAMPROD(ILOSC, prod, zam) VALUES(2,4,6)
INSERT INTO ZAMPROD(ILOSC, prod, zam) VALUES(1,4,3)
;