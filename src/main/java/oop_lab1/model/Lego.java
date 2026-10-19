package oop_lab1.model;

public class Lego extends EducationalToy {
    private final String theme;

    public Lego(String name, double price, int minAge, Size size, int numberOfParts, String theme) {
        super(name, price, minAge, size, numberOfParts);
        this.theme = theme;
    }

    public String getTheme() { return theme; }

    @Override
    public void play() { System.out.println("Збираємо Lego: " + theme); }

    @Override
    public String toString() { return "[Lego] " + super.toString() + " | Деталей: " + getNumberOfParts(); }
}