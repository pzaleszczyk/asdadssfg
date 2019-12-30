DROP TABLE ZAM_PROD
DROP TABLE ZAMOWIENIE
DROP TABLE PRODUKT
CREATE TABLE PUBLIC.TEST(TEST INT PRIMARY KEY)
CREATE MEMORY TABLE PUBLIC.PRODUKT(ID BIGINT NOT NULL PRIMARY KEY,CENA DOUBLE,NAZWA VARCHAR(255),VEGE BOOLEAN)
CREATE MEMORY TABLE PUBLIC.ZAMOWIENIE(ID BIGINT NOT NULL PRIMARY KEY,DATA_ZAM VARCHAR(255),WYNOS BOOLEAN)
CREATE MEMORY TABLE PUBLIC.ZAM_PROD(ID INTEGER NOT NULL PRIMARY KEY,ILOSC INTEGER,PRODUKT_ID BIGINT,ZAMOWIENIE_ID BIGINT,CONSTRAINT FKEWNX4P6VFW4I9QWFE3LEDEF2X FOREIGN KEY(PRODUKT_ID) REFERENCES PUBLIC.PRODUKT(ID),CONSTRAINT FKEX2K15T1KA30QPOYMEXERCOYH FOREIGN KEY(ZAMOWIENIE_ID) REFERENCES PUBLIC.ZAMOWIENIE(ID))