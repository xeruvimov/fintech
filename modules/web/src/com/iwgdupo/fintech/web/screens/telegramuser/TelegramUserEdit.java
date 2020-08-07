package com.iwgdupo.fintech.web.screens.telegramuser;

import com.haulmont.cuba.gui.screen.*;
import com.iwgdupo.fintech.entity.TelegramUser;

@UiController("fintech_TelegramUser.edit")
@UiDescriptor("telegram-user-edit.xml")
@EditedEntityContainer("telegramUserDc")
@LoadDataBeforeShow
public class TelegramUserEdit extends StandardEditor<TelegramUser> {
}