package com.iwgdupo.fintech.web.screens.credit;

import com.haulmont.cuba.gui.screen.*;
import com.iwgdupo.fintech.entity.Credit;

@UiController("fintech_Credit.edit")
@UiDescriptor("credit-edit.xml")
@EditedEntityContainer("creditDc")
@LoadDataBeforeShow
public class CreditEdit extends StandardEditor<Credit> {
}