package proyectoBanco.banco;

import java.util.function.Function;

// Base de datos en memoria
public class AccesoBaseDeDatos {
    private static final Object lock = new Object();
    private static final BaseDeDatos baseDeDatos = new BaseDeDatos();

    private static <T> T ejecutarSobreCuentas(Function<BaseDeDatos, T> funcion) {
        synchronized (AccesoBaseDeDatos.lock) {
            return funcion.apply(AccesoBaseDeDatos.baseDeDatos);
        }
    }
}
