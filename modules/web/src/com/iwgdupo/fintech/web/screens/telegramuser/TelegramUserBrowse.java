package com.iwgdupo.fintech.web.screens.telegramuser;

import com.haulmont.cuba.gui.screen.*;
import com.iwgdupo.fintech.entity.TelegramUser;

@UiController("fintech_TelegramUser.browse")
@UiDescriptor("telegram-user-browse.xml")
@LookupComponent("telegramUsersTable")
@LoadDataBeforeShow
public class TelegramUserBrowse extends StandardLookup<TelegramUser> {
}