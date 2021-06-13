CREATE TABLE EMPLOYE (
    ID_NUMBER varchar primary key,
    ID_TYPE varchar(2) not null,
    NAME varchar not null,
    LAST_NAME varchar not null
);

CREATE TABLE PRODUCT (
    ID_PRODUCT varchar primary key,
    NAME varchar not null,
    DESCRIPTION varchar not null,
        BASEPRICE varchar not null,
            TAXRATE varchar not null,
                PRODUCTSTATUS varchar not null,
                    INVENTORYQUANTITY varchar not null




);