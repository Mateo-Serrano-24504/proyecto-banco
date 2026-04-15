package proyectoBanco.banco;

import proyectoBanco.cuentas.Cuenta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

// Base de datos en memoria
public class BaseDeDatos {
    private static final Object lock = new Object();
    private static final Map<String, Cuenta> cuentas = new HashMap<>();

    private static <T> T realizarOperacion(Function<Map<String, Cuenta>, T> funcion) {
        synchronized (BaseDeDatos.lock) {
            return funcion.apply(BaseDeDatos.cuentas);
        }
    }
}
