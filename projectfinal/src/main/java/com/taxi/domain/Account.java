package com.taxi.domain;

public class Account {
    private final Integer id;
    private final User user;
    private final Integer discount;

    public Account(Integer id, User user, Integer discount) {
        this.id = id;
        this.user = user;
        this.discount = discount;
    }

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Integer getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", discount=" + discount +
                '}';
    }
}
