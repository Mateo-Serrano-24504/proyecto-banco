package proyectoBanco.terminal;

import java.util.Scanner;

public class ServicioEntrada {
    private final Scanner scanner;

    public ServicioEntrada(Scanner scanner) {
        this.scanner = scanner;
    }

    public String leer() {
        System.out.println("> ");
        return this.scanner.nextLine();
    }
}
