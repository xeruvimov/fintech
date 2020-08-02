alter table FINTECH_DEBIT_CARD rename column telegramm_id to telegramm_id__u80924 ;
alter table FINTECH_DEBIT_CARD add column TELEGRAM_USER_ID uuid ;
