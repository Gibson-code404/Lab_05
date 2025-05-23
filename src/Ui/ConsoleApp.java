package ui; // Beachte: Package klein schreiben (Java-Konvention)

import postfix.Infix;
import postfix.Postfix;

import java.util.Scanner;

public class ConsoleApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("🔢 Reverse Polish Notation Rechner");
        System.out.println("Bitte gib einen Infix-Ausdruck ein (z. B. 3 + 4 * (2 - 1)):");
        System.out.print("> ");

        String infix = input.nextLine();

        try {
            String postfix = Infix.toPostfix(infix);
            double result = Postfix.evaluate(postfix);

            System.out.println("📤 Postfix: " + postfix);
            System.out.printf("✅ Ergebnis: %.2f\n", result); // 2 Nachkommastellen

        } catch (Exception e) {
            System.out.println("❌ Fehler: " + e.getMessage());
        }

        input.close();
    }
}
