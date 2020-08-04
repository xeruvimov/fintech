package com.iwgdupo.fintech.web.screens.creditcard;

import com.haulmont.cuba.gui.screen.*;
import com.iwgdupo.fintech.entity.CreditCard;

@UiController("fintech_CreditCard.edit")
@UiDescriptor("credit-card-edit.xml")
@EditedEntityContainer("creditCardDc")
@LoadDataBeforeShow
public class CreditCardEdit extends StandardEditor<CreditCard> {
}