create table FINTECH_DEBIT_CARD (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FIRST_NAME varchar(255),
    MIDDLE_NAME varchar(255),
    LAST_NAME varchar(255),
    BIRTHDAY date,
    PHONE_NUMBER varchar(255),
    EMAIL varchar(255),
    ADDRESS varchar(255),
    PASSPORT_NUMBER varchar(6),
    PASSPORT_SERIAL varchar(4),
    PASSPORT_DATE date,
    PASSPORT_ORGANISATION varchar(255),
    --
    primary key (ID)
);