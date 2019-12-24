package com.company.model;

import com.company.model.entity.job.PrimaryJob;
import com.company.model.entity.job.SecondaryJob;
import com.company.model.entity.job.StandardJob;
import com.company.model.entity.job.TaxJob;
import com.company.model.entity.property.PropertySale;
import com.company.model.entity.property.TaxPropertySale;
import com.company.model.entity.royalty.RoyaltySimply;
import com.company.model.entity.royalty.TaxRoyalty;
import com.company.model.entity.tax.IndividualTaxes;

/**
 * Class for data insert
 */

public class DataSourse {
    public static IndividualTaxes getIndividualTaxesUK(){
        IndividualTaxes taxes = new IndividualTaxes()
                .with(new TaxJob(new PrimaryJob(new StandardJob(120_000_00, "Lead"), "IBM")))
                .with(new TaxJob(new SecondaryJob(new StandardJob(90_000_00, "PM"))))
                .with(new TaxRoyalty(new RoyaltySimply(10_000_00, "My song")))
                .with(new TaxPropertySale(new PropertySale("Flat 4 room", 300_000_00)))
                .with(new TaxPropertySale(new PropertySale("Country house", 250_000_00)));
        return taxes;
    }

    public static IndividualTaxes getIndividualTaxesRU(){
        IndividualTaxes taxes = new IndividualTaxes()
                .with(new TaxJob(new PrimaryJob(new StandardJob(120_000_00, "Управляющий"), "IBM")))
                .with(new TaxJob(new SecondaryJob(new StandardJob(90_000_00, "Менеджер проектов"))))
                .with(new TaxRoyalty(new RoyaltySimply(10_000_00, "Автор песни")))
                .with(new TaxPropertySale(new PropertySale("Квартира 4 комнаты", 300_000_00)))
                .with(new TaxPropertySale(new PropertySale("Загородный дом", 250_000_00)));
        return taxes;
    }
}
