package proyectoBanco.banco;

import java.util.function.Function;

// Base de datos en memoria
public class AccesoBaseDeDatos {
    private static final Object lock = new Object();
    private static final BaseDeDatos baseDeDatos = new BaseDeDatos();

    public static <T> T ejecutarSobreBaseDeDatos(Function<BaseDeDatos, T> funcion) {
        synchronized (AccesoBaseDeDatos.lock) {
            return funcion.apply(AccesoBaseDeDatos.baseDeDatos);
        }
    }
}
