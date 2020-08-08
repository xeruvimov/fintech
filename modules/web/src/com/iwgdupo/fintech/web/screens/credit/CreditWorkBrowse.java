package com.iwgdupo.fintech.web.screens.credit;

import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.iwgdupo.fintech.entity.Credit;
import com.iwgdupo.fintech.entity.CreditCard;
import com.iwgdupo.fintech.entity.RequestStatus;

import javax.inject.Inject;

@UiController("fintech_CreditWork.browse")
@UiDescriptor("credit-work-browse.xml")
@LookupComponent("creditsTable")
@LoadDataBeforeShow
public class CreditWorkBrowse extends StandardLookup<Credit> {
    @Inject
    private CollectionLoader<CreditCard> creditDl;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        creditDl.setParameter("inProgress", RequestStatus.IN_PROGRESS);
        getScreenData().loadAll();
    }
}