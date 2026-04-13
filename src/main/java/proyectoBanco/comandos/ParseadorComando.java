package proyectoBanco.comandos;

import proyectoBanco.cuentas.TipoCuenta;

public class ParseadorComando {
    private TipoCuenta obtenerTipoCuenta(String tipoCuenta) {
        switch (tipoCuenta) {
            case "corriente" -> {
                return TipoCuenta.CuentaCorriente;
            }
            case "ahorro" -> {
                return TipoCuenta.CuentaAhorro;
            }
            default -> {
                return null;
            }
        }
    }

    private ComandoCrear parsearCrear(String[] args) {
        return new ComandoCrear(
                this.obtenerTipoCuenta(args[1]),
                args[2]
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
    private Comando parsearManejar(String[] args) {
        if (args.length == 1) {
            return new ComandoManejarTodos();
        }
        var indice = Integer.parseInt(args[1]);
        return new ComandoManejarPeticicon(indice);
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
            case "manejar" -> {
                return this.parsearManejar(argumentos);
            }
            default -> {
                return null;
            }
        }
    }
}
