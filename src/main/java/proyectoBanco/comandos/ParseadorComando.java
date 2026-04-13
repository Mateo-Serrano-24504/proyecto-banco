package proyectoBanco.comandos;

import proyectoBanco.TipoCuenta;

public class ParseadorComando {
    private TipoCuenta obtenerTipoCuenta(String tipoCuenta) {
        if (tipoCuenta.equals("corriente")) {
            return TipoCuenta.CuentaCorriente;
        }
        return null;
    }

    private ComandoCrear parsearCrear(String[] args) {
        return new ComandoCrear(
                this.obtenerTipoCuenta(args[1]),
                args[2],
                args[3]
        );
    }
    private ComandoEliminar parsearEliminar(String[] args) {
        return new ComandoEliminar(args[1]);
    }
    private ComandoSalir parsearSalir(String[] _args) {
        return new ComandoSalir();
    }
    private ComandoListar parsearListar(String[] args) {
        return new ComandoListar();
    }

    public Comando parsearComando(String linea) {
        var argumentos = linea.split(" ");
        var comando = argumentos[0];

        switch (comando) {
            case "crear" -> {
                return this.parsearCrear(argumentos);
            }
            case "eliminar" -> {
                return this.parsearEliminar(argumentos);
            }
            case "salir" -> {
                return this.parsearSalir(argumentos);
            }
            case "listar" -> {
                return this.parsearListar(argumentos);
            }
            default -> {
                return null;
            }
        }
    }
}
