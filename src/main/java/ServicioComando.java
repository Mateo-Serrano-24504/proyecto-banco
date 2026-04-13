import java.util.Scanner;

public class ServicioComando {
    private Scanner lector;

    public ServicioComando() {
        this.lector = new Scanner(System.in);
    }

    public String obtenerComando() {
        System.out.print("Ingrese comando:\n> ");
        return this.lector.nextLine();
    }
}
