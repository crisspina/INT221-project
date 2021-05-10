CREATE USER 'user'@'%' IDENTIFIED BY 'password' ;

GRANT select, insert, update, delete on products to 'user'@'%';

GRANT select, insert, update, delete on productdetails to 'user'@'%';

GRANT select on colors to 'user'@'%';

GRANT select on brands to 'user'@'%';

CREATE TABLE brands (
    brandid    INTEGER NOT NULL,
    brandname  VARCHAR(20) NOT NULL
);

ALTER TABLE brands ADD CONSTRAINT brands_pk PRIMARY KEY ( brandid );

CREATE TABLE colors (
    colorid    INTEGER NOT NULL,
    colorname  VARCHAR(20) NOT NULL,
    colorcode  VARCHAR(7) NOT NULL
);

ALTER TABLE colors ADD CONSTRAINT colors_pk PRIMARY KEY ( colorid );

CREATE TABLE productdetails (
    productid  INTEGER NOT NULL,
    colorid    INTEGER NOT NULL
);

ALTER TABLE productdetails ADD CONSTRAINT productdetails_pk PRIMARY KEY ( productid,
                                                                          colorid );

CREATE TABLE products (
    productid    INTEGER NOT NULL,
    modelname    VARCHAR(40) NOT NULL,
    casename     VARCHAR(50) NOT NULL,
    description  VARCHAR(120) NOT NULL,
    price        FLOAT(6) NOT NULL,
    amount       INTEGER NOT NULL,
    date       DATE NOT NULL,
    image        VARCHAR(100) NOT NULL,
    brandid      INTEGER NOT NULL
);

ALTER TABLE products ADD CONSTRAINT products__UN UNIQUE ( casename ) ;

ALTER TABLE products ADD CONSTRAINT products_pk PRIMARY KEY ( productid );

ALTER TABLE productdetails
    ADD CONSTRAINT productdetails_colors_fk FOREIGN KEY ( colorid )
        REFERENCES colors ( colorid );

ALTER TABLE productdetails
    ADD CONSTRAINT productdetails_products_fk FOREIGN KEY ( productid )
        REFERENCES products ( productid );

ALTER TABLE products
    ADD CONSTRAINT products_brands_fk FOREIGN KEY ( brandid )
        REFERENCES brands ( brandid );



INSERT INTO brands ( brandid,brandname) VALUES ( 1,'casecoolors');


INSERT INTO products
VALUES(1,'iPhone12 ProMax','Rifle Green Case','DEFENSiFY antimicrobial coating eliminates 99% of bacteria',50.00,1000 ,'2021-01-01','RifleGreenCase.jpg',1);
INSERT INTO products
VALUES(2,'iPhone12 ProMax','Madder Lake Case','DEFENSiFY antimicrobial coating eliminates 99% of bacteria',50.00,1500 ,'2021-01-10','MadderLake.jpg',1);
INSERT INTO products
VALUES(3,'iPhone12 ProMax','Bittersweet Case','DEFENSiFY antimicrobial coating eliminates 99% of bacteria',50.00,1800 ,'2021-03-20','Bittersweet.jpg',1);
INSERT INTO products
VALUES(4,'iPhone12 ProMax','Davys Grey Case','DEFENSiFY antimicrobial coating eliminates 99% of bacteria',50.00,2200 ,'2021-03-26','DavysGreyCase.jpg',1);
INSERT INTO products
VALUES(5,'iPhone12 ProMax','Deep Space Sparkle Case','DEFENSiFY antimicrobial coating eliminates 99% of bacteria',50.00,2200 ,'2021-04-03','DeepSpaceSparkleV2.jpg',1);
INSERT INTO products
VALUES(6,'iPhone12 ProMax','Alabaster Case','DEFENSiFY antimicrobial coating eliminates 99% of bacteria',50.00,1600 ,'2021-04-10','Alabaster.jpg',1);
INSERT INTO products
VALUES(7,'iPhone12 ProMax','Tea Green Case','DEFENSiFY antimicrobial coating eliminates 99% of bacteria',50.00,1200 ,'2021-04-18','TeaGreen.jpg',1);



INSERT INTO colors VALUES(1,'Deep Space Sparkle','#475D68');
INSERT INTO colors VALUES(2,'Madder Lake','#C3343A');
INSERT INTO colors VALUES(3,'Bittersweet','#FE6E65');
INSERT INTO colors VALUES(4,'Davys Grey','#474747');
INSERT INTO colors VALUES(5,'Rifle Green','#444C3F');
INSERT INTO colors VALUES(6,'Alabaster','#F2EEE4');
INSERT INTO colors VALUES(7,'Tea Green','#C4E2BE');


INSERT INTO productdetails VALUES(1,1);
INSERT INTO productdetails VALUES(2,2);
INSERT INTO productdetails VALUES(3,3);
INSERT INTO productdetails VALUES(4,4);
INSERT INTO productdetails VALUES(5,5);
INSERT INTO productdetails VALUES(6,6);
INSERT INTO productdetails VALUES(7,7);

