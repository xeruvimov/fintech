-- begin FINTECH_DEBIT_CARD
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
    TELEGRAM_USER_ID uuid,
    TYPE_ varchar(255),
    STATUS varchar(50),
    --
    primary key (ID)
)^
-- end FINTECH_DEBIT_CARD
-- begin FINTECH_MESSAGE
create table FINTECH_MESSAGE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TEXT text,
    CUBA_USER_ID uuid,
    DATETIME timestamp,
    TELEGRAM_USER_ID uuid,
    --
    primary key (ID)
)^
-- end FINTECH_MESSAGE
-- begin FINTECH_TELEGRAM_USER
create table FINTECH_TELEGRAM_USER (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TELEGRAM_ID varchar(255),
    USER_TYPE varchar(255),
    NAME varchar(255),
    LAST_NAME varchar(255),
    --
    primary key (ID)
)^
-- end FINTECH_TELEGRAM_USER
-- begin FINTECH_CREDIT_CARD
create table FINTECH_CREDIT_CARD (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TYPE_ varchar(255),
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
    WORK_PLACE varchar(255),
    WORK_EXPERIENCE varchar(255),
    MONTHLY_INCOME varchar(255),
    EMPLOYER_ADDRESS varchar(255),
    EMPLOYER_PHONE_NUMBER varchar(255),
    MARITAL_STATUS varchar(255),
    USER_MESSAGER_ID uuid,
    STATUS varchar(50),
    --
    primary key (ID)
)^
-- end FINTECH_CREDIT_CARD
-- begin FINTECH_CREDIT
create table FINTECH_CREDIT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TYPE_ varchar(255),
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
    WORK_PLACE varchar(255),
    WORK_EXPERIENCE varchar(255),
    MONTHLY_INCOME varchar(255),
    EMPLOYER_ADDRESS varchar(255),
    EMPLOYER_PHONE_NUMBER varchar(255),
    MARITAL_STATUS varchar(255),
    USER_MESSAGER_ID uuid,
    STATUS varchar(50),
    --
    primary key (ID)
)^
-- end FINTECH_CREDIT
