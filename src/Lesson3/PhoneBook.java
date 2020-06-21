package Lesson3;

import java.util.*;

public class PhoneBook  {

    HashMap<String, HashSet<String>> pb;

    public PhoneBook() {
        this.pb = new HashMap<>();
    }

    public void addContact(String name, String phone) {
        HashSet<String> phonebook = pb.getOrDefault(name, new HashSet<>());
        phonebook.add(phone);
        pb.put(name, phonebook);
    }

    public void getAndPrintContact(String name) {
        System.out.println("Contact " + name + " / Phone number " + pb.getOrDefault(name, new HashSet<>()));
    }
}