CREATE TABLE EMPLOYEE (
    ID_NUMBER varchar primary key,
    ID_TYPE varchar(2) not null,
    NAME varchar not null,
    LAST_NAME varchar not null
);

CREATE TABLE PRODUCT (
    ID_PRODUCT varchar primary key,
    NAME varchar not null,
    DESCRIPTION varchar not null,
    BASE_PRICE varchar not null,
    TAX_RATE varchar not null,
    PRODUCT_STATUS varchar not null,
    INVENTORY_QUANTITY varchar not null

);