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
);