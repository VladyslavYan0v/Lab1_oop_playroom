package oop_lab1.model;

public abstract class Toy {
    private final String name;
    private final double price;
    private final int minAge;
    private final Size size;

    public Toy(String name, double price, int minAge, Size size) {
        this.name = name;
        this.price = price;
        this.minAge = minAge;
        this.size = size;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getMinAge() { return minAge; }
    public Size getSize() { return size; }

    public abstract void play();

    @Override
    public String toString() {
        return String.format("'%s' | Ціна: %.2f | Вік: %d+ | Розмір: %s", name, price, minAge, size);
    }
}