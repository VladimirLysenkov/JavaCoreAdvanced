package Lesson3;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        PhoneBook phonebook = new PhoneBook();
        phonebook.addContact("Petya", "32424342");
        phonebook.addContact("Vasya", "54353454");
        phonebook.addContact("Roma", "23442344");
        phonebook.addContact("Vova", "45345543");
        phonebook.addContact("Petya", "54334554");
        phonebook.addContact("Vova", "86787688");

        phonebook.getAndPrintContact("Petya");
        phonebook.getAndPrintContact("Vasya");
        phonebook.getAndPrintContact("Roma");
        phonebook.getAndPrintContact("Vova");


        String[] auto = {"BMW", "Kia", "Audi", "Ford", "Honda", "BMW", "Opel", "Nissan", "Skoda", "Toyota", "Kia", "BMW"};
        HashMap<String, Integer> brand = new HashMap<>();
        for (String x : auto) {
            brand.put(x, brand.getOrDefault(x,0)+1);
        }
        System.out.println(brand);
    }




}


