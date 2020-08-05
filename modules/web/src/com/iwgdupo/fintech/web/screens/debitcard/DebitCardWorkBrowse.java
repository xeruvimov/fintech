package com.iwgdupo.fintech.web.screens.debitcard;

import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.iwgdupo.fintech.entity.DebitCard;
import com.iwgdupo.fintech.entity.RequestStatus;

import javax.inject.Inject;

@UiController("fintech_DebitCardWork.browse")
@UiDescriptor("debit-card-work-browse.xml")
@LookupComponent("debitCardsTable")
@LoadDataBeforeShow
public class DebitCardWorkBrowse extends StandardLookup<DebitCard> {
    @Inject
    private CollectionLoader<DebitCard> debitCardsDl;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        debitCardsDl.setParameter("inProgress", RequestStatus.IN_PROGRESS);
    }
}