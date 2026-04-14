package proyectoBanco.banco.comandos;

import proyectoBanco.banco.GestorCuentas;
import proyectoBanco.cuentas.TipoCuenta;

public class ComandoEliminarCuenta implements Comando {
    private final GestorCuentas gestorCuentas;
    private final String propietario;

    public ComandoEliminarCuenta(
            GestorCuentas gestorCuentas,
            String propietario
    ) {
        this.gestorCuentas = gestorCuentas;
        this.propietario = propietario;
    }

    @Override
    public void ejecutar() {
        this.gestorCuentas.eliminarCuenta(this.propietario);
    }

    @Override
    public String toString() {
        return "Eliminar cuenta - Propietario: " + this.propietario;
    }
}
