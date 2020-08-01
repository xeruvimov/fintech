package com.iwgdupo.fintech.web.screens.debitcard;

import com.haulmont.cuba.gui.screen.*;
import com.iwgdupo.fintech.entity.DebitCard;

@UiController("fintech_DebitCard.browse")
@UiDescriptor("debit-card-browse.xml")
@LookupComponent("debitCardsTable")
@LoadDataBeforeShow
public class DebitCardBrowse extends StandardLookup<DebitCard> {
}