package com.iwgdupo.fintech.web.screens.debitcard;

import com.haulmont.cuba.gui.screen.*;
import com.iwgdupo.fintech.entity.DebitCard;

@UiController("fintech_DebitCard.edit")
@UiDescriptor("debit-card-edit.xml")
@EditedEntityContainer("debitCardDc")
@LoadDataBeforeShow
public class DebitCardEdit extends StandardEditor<DebitCard> {
    //todo сделать скрин для дебетовых в работе
}