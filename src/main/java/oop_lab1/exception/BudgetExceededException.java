package oop_lab1.exception;

public class BudgetExceededException extends RuntimeException {
    public BudgetExceededException(String message) { super(message); }
}