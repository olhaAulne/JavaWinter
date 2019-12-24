package com.company.model.entity.property;

import com.company.text.ConsoleText;
import com.company.text.Text;

import java.io.IOException;

public class PropertySaleAPI implements Property {

  private final Text text;

  public PropertySaleAPI() {
    this(new ConsoleText());
  }

  public PropertySaleAPI(Text text) {
    this.text = text;
  }


  @Override
  public long cost() throws IOException {
    // remove to front
    System.out.println("input cost in cent:");
      return Long.parseLong(this.text.context());

  }

  @Override
  public String name() throws IOException {
    // remove to front
    System.out.println("input name:");
      return this.text.context();
  }

}
