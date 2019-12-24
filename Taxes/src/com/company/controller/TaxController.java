package com.company.controller;

import com.company.model.DataSourse;
import com.company.model.entity.tax.IndividualTaxes;
import com.company.view.TaxView;
import com.company.view.InputData;

import java.io.IOException;

public class TaxController {
    private IndividualTaxes model ;
    private TaxView view = new TaxView();

    public void run() throws IOException {
        view.viewData("Choose language/Выберите язык UK/RU-> ");
        try{
        Lang lang = Lang.valueOf(InputData.input().toUpperCase());
            switch (lang){
                case UK: {
                    model= DataSourse.getIndividualTaxesUK();
                    ControllerUK.taxControllerUK(view, model);
                    break;
                }
                case RU: {
                    model= DataSourse.getIndividualTaxesRU();
                    ControllerRu.taxControllerRU(view, model);
                    break;
                }
            }
        }
        catch (Throwable t) {
            view.viewData("Incorrect language/Неверный язык!!!");
        }
    }
}
