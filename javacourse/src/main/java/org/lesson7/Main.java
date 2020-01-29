package org.lesson7;

public class Main {
    public static void main(String[] args) {

        //Client.builder()
        final Client client = new Client.ClientBuilder()
                .withEmail("alex@gmail.com")
                .withCode(100)
                .withPassword("password")
                .build();

        System.out.println(client);

    }
}
