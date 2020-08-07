package com.iwgdupo.fintech.web.screens;

import com.haulmont.cuba.core.global.MetadataTools;
import com.haulmont.cuba.core.global.Sort;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.iwgdupo.fintech.entity.Message;
import com.iwgdupo.fintech.entity.TelegramUser;
import com.iwgdupo.fintech.service.ChatService;

import javax.inject.Inject;
import java.util.Collection;

@UiController("fintech_ChatScreen")
@UiDescriptor("chat-screen.xml")
public class ChatScreen extends Screen {
    @Inject
    private ChatService chatService;
    @Inject
    private UiComponents uiComponents;
    @Inject
    private MetadataTools metadataTools;
    @Inject
    private VBoxLayout vboxMessages;
    @Inject
    private TextField<String> messageTextField;
    @Inject
    protected CollectionLoader<TelegramUser> telegramUsersDl;
    @Inject
    private ScrollBoxLayout scrollMessagesBox;
    @Inject
    private CollectionLoader<Message> messagesDl;
    @Inject
    private CollectionContainer<Message> messagesDc;

    private TelegramUser currentUser;
    private int currentShowedMessageNumber = 0;

    @Subscribe("telegramUsersTable")
    public void onTelegramUsersTableSelection(Table.SelectionEvent<TelegramUser> event) {
        vboxMessages.removeAll();
        currentUser = event.getSelected().iterator().next();

        messagesDl.setParameter("tlgId", currentUser.getMsgId());
        messagesDl.load();
        showMessages(messagesDc.getMutableItems());
        currentShowedMessageNumber = messagesDc.getMutableItems().size();
    }

    @Subscribe
    protected void onAfterInit(AfterInitEvent event) {
        messageTextField.addEnterPressListener(enterPressEvent -> onSendButtonClick());

        messagesDl.setSort(Sort.by("datetime"));
        telegramUsersDl.load();
    }

    private void showMessages(Collection<? extends Message> messageList) {
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
            name.setValue(message.getTelegramUser().getMsgId() + ":");
        }
        name.setAlignment(Component.Alignment.TOP_RIGHT);
        name.setWidth("120px");

        Label<String> text = uiComponents.create(Label.NAME);
        text.setValue(message.getText());
        text.setAlignment(Component.Alignment.TOP_LEFT);
        text.setWidth("450px");

        Label<String> date = uiComponents.create(Label.NAME);
        date.setValue(message.getDatetime().toString());
        date.setAlignment(Component.Alignment.TOP_RIGHT);

        boxLayout.add(name, text, date);

        boxLayout.setSpacing(true);
        boxLayout.setWidth("100%");
        boxLayout.setExpandRatio(text, 1f);

        vboxMessages.add(boxLayout);
    }

    public void onSendButtonClick() {
        if (currentUser != null) {
            chatService.sendMessage(currentUser, messageTextField.getValue());
            messageTextField.clear();
        }
    }

    public void onTimerToReloadMsgClick(Timer source) {
        telegramUsersDl.load();
        loadMessages();
    }

    private void loadMessages() {
        if (currentUser != null) {
            messagesDl.load();

            for (; currentShowedMessageNumber < messagesDc.getMutableItems().size(); currentShowedMessageNumber++) {
                showMessage(messagesDc.getMutableItems().get(currentShowedMessageNumber));
            }
        }
    }

    @Install(to = "telegramUsersTable.fullNameUser", subject = "columnGenerator")
    private Component telegramUsersTableFullNameUserColumnGenerator(TelegramUser telegramUser) {
        Label<String> component = uiComponents.create(Label.NAME);
        component.setValue(metadataTools.getInstanceName(telegramUser));
        return component;
    }
}