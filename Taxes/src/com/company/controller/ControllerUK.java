package com.company.controller;

import com.company.model.DataSourse;
import com.company.model.entity.tax.IndividualTaxes;
import com.company.model.entity.tax.Taxes;
import com.company.view.TaxView;

import java.io.IOException;

public class ControllerUK {
    public static void taxControllerUK (TaxView view, IndividualTaxes model) throws IOException {
        view.viewData("==================== ALL purpose of Payments ====================\n");
        view.viewCollection(model.purposeOfPayments());
        view.viewData("============ ALL purpose of Payments sorted by cost =============\n");
        view.viewCollection(model.purposeOfPayments(new Taxes.ByCost()));
        view.viewData("=========== ALL purpose of Payments sorted by purpose ============\n");
        view.viewCollection(model.purposeOfPayments(new Taxes.ByPurpose()));
        view.viewData("==================================================================\n");
        view.viewData(ConvertToString.convertInt(model.count(),"Count of taxes"));
        view.viewData(ConvertToString.convertLong(model.calculateAll()/100, "All taxes"));
    }
}
