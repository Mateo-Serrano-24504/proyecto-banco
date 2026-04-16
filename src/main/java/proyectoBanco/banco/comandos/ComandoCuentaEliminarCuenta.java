package proyectoBanco.banco.comandos;

import proyectoBanco.banco.GestorCuentas;
import proyectoBanco.banco.concurrencia.GestorCuentasConcurrente;

public class ComandoCuentaEliminarCuenta implements ComandoCuenta {
    private final GestorCuentasConcurrente gestorCuentasConcurrente;
    private final String propietario;

    public ComandoCuentaEliminarCuenta(
            GestorCuentasConcurrente gestorCuentasConcurrente,
            String propietario
    ) {
        this.gestorCuentasConcurrente = gestorCuentasConcurrente;
        this.propietario = propietario;
    }

    @Override
    public void ejecutar() {
        this.gestorCuentasConcurrente.eliminarCuenta(this.propietario);
    }

    @Override
    public String toString() {
        return "Eliminar cuenta - Propietario: " + this.propietario;
    }
}
