package com.company.model.entity.royalty;

public class RoyaltySimply implements Royalty {

  private final long cost;
  private final String description;

  public RoyaltySimply(long cost, String description) {
    this.cost = cost;
    this.description = description;
  }

  @Override
  public long cost() {
    return this.cost;
  }

  @Override
  public String description() {
    return this.description;
  }
}