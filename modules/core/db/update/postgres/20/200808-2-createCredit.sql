alter table FINTECH_CREDIT add constraint FK_FINTECH_CREDIT_ON_USER_MESSAGER foreign key (USER_MESSAGER_ID) references FINTECH_TELEGRAM_USER(ID);
create index IDX_FINTECH_CREDIT_ON_USER_MESSAGER on FINTECH_CREDIT (USER_MESSAGER_ID);
