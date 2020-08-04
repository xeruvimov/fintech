package com.iwgdupo.fintech.web.screens.creditcard;

import com.haulmont.cuba.gui.screen.*;
import com.iwgdupo.fintech.entity.CreditCard;

@UiController("fintech_CreditCard.browse")
@UiDescriptor("credit-card-browse.xml")
@LookupComponent("creditCardsTable")
@LoadDataBeforeShow
public class CreditCardBrowse extends StandardLookup<CreditCard> {
}