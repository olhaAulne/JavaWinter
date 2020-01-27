package com.taxi.domain;

public class Account {
    private final Integer id;
    private final User user;
    private final String name;
    private final String surname;
    private final String telephoneNumber;
    private final Integer sale;

    public Account(Integer id, User user, String name, String surname, String telephoneNumber, Integer sale) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.surname = surname;
        this.telephoneNumber = telephoneNumber;
        this.sale = sale;
    }

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Integer getDiscount() {
        return sale;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name=" + name + " " + surname +
                ", telephone=" + telephoneNumber +
                ", sale=" + sale +
                '}';
    }
}
