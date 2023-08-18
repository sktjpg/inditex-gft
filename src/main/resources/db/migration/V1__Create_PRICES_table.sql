DROP TABLE IF EXISTS PRICES;

CREATE TABLE PRICES(
    ID DECIMAL(14,0) PRIMARY KEY,
    BRAND_ID INT NOT NULL,
    START_DATE TIMESTAMP without time zone NOT NULL,
    END_DATE TIMESTAMP without time zone NOT NULL,
    PRICE_LIST INT NOT NULL,
    PRODUCT_ID INT NOT NULL,
    PRIORITY INT NOT NULL,
    PRICE DECIMAL(10, 2) NOT NULL,
    CURR VARCHAR(3) NOT NULL
);

CREATE SEQUENCE price_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


INSERT INTO PRICES (ID, BRAND_ID, START_DATE, END_DATE, PRODUCT_ID, PRICE_LIST, PRIORITY, PRICE, CURR)
VALUES
    (1, 1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 35455, 0, 35.50, 'EUR'),
    (2, 1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 2, 35455, 1, 25.45, 'EUR'),
    (3, 1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 3, 35455, 1, 30.50, 'EUR'),
    (4, 1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 4, 35455, 1, 38.95, 'EUR');