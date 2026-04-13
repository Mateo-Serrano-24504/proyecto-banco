package proyectoBanco.comandos;

import java.util.Scanner;

public class ServicioComando {
    private final Scanner lector;
    private final ParseadorComando parseadorComando;

    public ServicioComando() {
        this.lector = new Scanner(System.in);
        this.parseadorComando = new ParseadorComando();
    }

    public Comando obtenerComando() {
        System.out.print("Ingrese comando:\n> ");
        return this.parseadorComando.parsearComando(this.lector.nextLine());
    }
}
