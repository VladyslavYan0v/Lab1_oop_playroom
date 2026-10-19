package oop_lab1;

import oop_lab1.model.Toy;
import oop_lab1.service.PlayroomService;
import oop_lab1.util.CsvDataLoader;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        PlayroomService playroom = new PlayroomService(2500.0, new CsvDataLoader());

        System.out.println("Завантаження кімнати");
        try {
            playroom.loadToysFromFile("toys_data.csv");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        playroom.getToys().forEach(System.out::println);

        System.out.println("\nВідсортовано за ціною");
        playroom.sortToys(Comparator.comparingDouble(Toy::getPrice));
        playroom.getToys().forEach(System.out::println);

        System.out.println("\nПошук: Ціна до 1000 та розмір medium");
        playroom.findToys(t -> t.getPrice() <= 1000 && t.getSize().name().equals("MEDIUM"))
                .forEach(System.out::println);
    }
}