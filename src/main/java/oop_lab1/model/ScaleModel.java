package oop_lab1.model;

public class ScaleModel extends CollectibleToy {
    private final String scale;

    public ScaleModel(String name, double price, int minAge, Size size, boolean isLimitedEdition, String scale) {
        super(name, price, minAge, size, isLimitedEdition);
        this.scale = scale;
    }

    public String getScale() { return scale; }

    @Override
    public void play() { System.out.println("Розставляємо модель масштабу " + scale); }

    @Override
    public String toString() {
        String limited = isLimitedEdition() ? "Лімітована" : "Масова";
        return "[Масштабна модель] " + super.toString() + " | Видання: " + limited + " | Масштаб: " + scale;
    }
}