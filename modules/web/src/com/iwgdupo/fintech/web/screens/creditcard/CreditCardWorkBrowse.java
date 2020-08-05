package com.iwgdupo.fintech.web.screens.creditcard;

import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.iwgdupo.fintech.entity.CreditCard;
import com.iwgdupo.fintech.entity.RequestStatus;

import javax.inject.Inject;

@UiController("fintech_CreditCardWork.browse")
@UiDescriptor("credit-card-work-browse.xml")
@LookupComponent("creditCardsTable")
@LoadDataBeforeShow
public class CreditCardWorkBrowse extends StandardLookup<CreditCard> {
    @Inject
    private CollectionLoader<CreditCard> creditCardsDl;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        creditCardsDl.setParameter("inProgress", RequestStatus.IN_PROGRESS);
        getScreenData().loadAll();
    }
}