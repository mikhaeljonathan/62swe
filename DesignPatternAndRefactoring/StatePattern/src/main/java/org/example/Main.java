package org.example;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        GumballMachine gumballMachine = new GumballMachine(5);
        // NO_QUARTER
        gumballMachine.insertQuarter();
        // HAS_QUARTER
        gumballMachine.insertQuarter();
        // HAS_QUARTER
        gumballMachine.turnCrank();
        // SOLD
    }
}