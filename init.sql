CREATE USER 'admin'@'%' IDENTIFIED BY 'password';
GRANT ALL ON *.* TO 'admin'@'%';

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

ALTER TABLE productdetails ADD CONSTRAINT productdetails_pk PRIMARY KEY ( productid,colorid );

CREATE TABLE products (
    productid    INTEGER NOT NULL,
    modelname    VARCHAR(40) NOT NULL,
    casename     VARCHAR(50) NOT NULL,
    description  VARCHAR(120) NOT NULL,
    price        DOUBLE NOT NULL,
    amount       INTEGER NOT NULL,
    date       DATETIME NOT NULL,
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

INSERT INTO brands (brandid,brandname) VALUES ( 1,'casecoolors');

INSERT INTO colors (colorid,colorname,colorcode) 
VALUES(1,'Deep Space Sparkle','#475D68'),
(2,'Madder Lake','#C3343A'),
(3,'Bittersweet','#FE6E65'),
(4,'Davys Grey','#474747'),
(5,'Rifle Green','#444C3F'),
(6,'Alabaster','#F2EEE4'),
(7,'Tea Green','#C4E2BE');
