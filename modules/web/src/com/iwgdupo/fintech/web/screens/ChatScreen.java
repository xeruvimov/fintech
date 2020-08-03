package com.iwgdupo.fintech.web.screens;

import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import com.iwgdupo.fintech.entity.Message;
import com.iwgdupo.fintech.entity.TelegramUser;
import com.iwgdupo.fintech.service.ChatService;

import javax.inject.Inject;
import java.util.List;

@UiController("fintech_ChatScreen")
@UiDescriptor("chat-screen.xml")
public class ChatScreen extends Screen {
    @Inject
    private ChatService chatService;
    @Inject
    private UiComponents uiComponents;
    @Inject
    private VBoxLayout vboxMessages;
    @Inject
    private TextField<String> messageTextField;
    @Inject
    protected CollectionLoader<TelegramUser> telegramUsersDl;

    private TelegramUser currentUser;

    @Subscribe("telegramUsersTable")
    public void onTelegramUsersTableSelection(Table.SelectionEvent<TelegramUser> event) {
        vboxMessages.removeAll();
        currentUser = event.getSelected().iterator().next();
        showMessages(currentUser.getMessages());
    }

    @Subscribe
    protected void onAfterInit(AfterInitEvent event) {
        telegramUsersDl.load();
    }

    private void showMessages(List<Message> messageList) {
        for (Message message : messageList) {
            showMessage(message);
        }
    }

    private void showMessage(Message message) {
        HBoxLayout boxLayout = uiComponents.create(HBoxLayout.NAME);

        Label<String> name = uiComponents.create(Label.NAME);
        if (message.getCubaUser() != null) {
            name.setValue(message.getCubaUser().getName() + ":");
        } else {
            name.setValue(message.getTelegramUser().getTelegramId() + ":");
        }

        Label<String> text = uiComponents.create(Label.NAME);
        text.setValue(message.getText());

        Label<String> date = uiComponents.create(Label.NAME);
        date.setValue(message.getDatetime().toString());

        boxLayout.add(name, text, date);

        boxLayout.setSpacing(true);

        vboxMessages.add(boxLayout);
    }

    public void onSendButtonClick() {
        if (currentUser != null) {
            chatService.sendMessage(currentUser.getTelegramId(), messageTextField.getValue());
        }
    }

    public void onTimerToReloadMsgClick(Timer source) {
        telegramUsersDl.load();
    }
}