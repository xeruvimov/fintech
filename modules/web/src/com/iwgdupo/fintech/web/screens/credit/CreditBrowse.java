package com.iwgdupo.fintech.web.screens.credit;

import com.haulmont.cuba.gui.screen.*;
import com.iwgdupo.fintech.entity.Credit;

@UiController("fintech_Credit.browse")
@UiDescriptor("credit-browse.xml")
@LookupComponent("creditsTable")
@LoadDataBeforeShow
public class CreditBrowse extends StandardLookup<Credit> {
}