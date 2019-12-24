package com.company.controller;

import com.company.model.entity.tax.IndividualTaxes;
import com.company.model.entity.tax.Taxes;
import com.company.view.TaxView;

import java.io.IOException;

public class ControllerRu {
    public static void taxControllerRU (TaxView view, IndividualTaxes model) throws IOException {
        view.viewData("==================== Все цели платежа  ====================\n");
        view.viewCollection(model.purposeOfPayments());
        view.viewData("============ Все цели платежа отсортированные по цене =============\n");
        view.viewCollection(model.purposeOfPayments(new Taxes.ByCost()));
        view.viewData("=========== Все цели платежа отсортированные по назначению ============\n");
        view.viewCollection(model.purposeOfPayments(new Taxes.ByPurpose()));
        view.viewData("==================================================================\n");
        view.viewData(ConvertToString.convertInt(model.count(),"Колличество платежей"));
        view.viewData(ConvertToString.convertLong(model.calculateAll()/100, "Общая сумма налога"));
    }
}
