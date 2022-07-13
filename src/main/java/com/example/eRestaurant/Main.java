package com.example.eRestaurant;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = List.of("ilias","Abdo","Reda","Salma","Salah","Hamid");
        list.stream().filter(x->x.startsWith("S")).sorted().forEach(System.out::println);
    }
}
