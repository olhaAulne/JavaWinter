package com.company.model.entity.property;

public class PropertySale implements Property {

  private final String name;
  private final long cost;

  public PropertySale(String name, long cost) {
    this.name = name;
    this.cost = cost;
  }

  @Override
  public long cost() {
    return this.cost;
  }

  @Override
  public String name() {
    return this.name;
  }
}
