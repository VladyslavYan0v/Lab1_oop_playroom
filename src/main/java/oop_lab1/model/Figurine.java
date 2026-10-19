package oop_lab1.model;

public class Figurine extends CollectibleToy {
    private final String franchise;

    public Figurine(String name, double price, int minAge, Size size, boolean isLimitedEdition, String franchise) {
        super(name, price, minAge, size, isLimitedEdition);
        this.franchise = franchise;
    }

    public String getFranchise() { return franchise; }

    @Override
    public void play() { System.out.println("Граємо фігуркою з " + franchise); }

    @Override
    public String toString() {
        String limited = isLimitedEdition() ? "Лімітована" : "Масова";
        return "[Фігурка] " + super.toString() + " | Видання: " + limited + " | Франшиза: " + franchise;
    }
}