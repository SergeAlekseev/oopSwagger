package oop.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class RepositoryOOP {
    public void addTest(String id, String text) {
        System.out.print("Id - " + id + ", text - " + text);
    }
}