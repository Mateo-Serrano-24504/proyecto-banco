package proyectoBanco.banco.comandos;

import proyectoBanco.banco.GestorCuentas;
import proyectoBanco.cuentas.TipoCuenta;
import proyectoBanco.usuarios.CredencialesUsuario;

public class ComandoCrearCuenta implements Comando {
    private final GestorCuentas gestorCuentas;
    private final String propietario;
    private final TipoCuenta tipoCuenta;

    public ComandoCrearCuenta(
            GestorCuentas gestorCuentas,
            String propietario,
            TipoCuenta tipoCuenta
    ) {
        this.gestorCuentas = gestorCuentas;
        this.propietario = propietario;
        this.tipoCuenta = tipoCuenta;
    }

    @Override
    public void ejecutar() {
        this.gestorCuentas.crearCuenta(this.propietario, this.tipoCuenta);
    }

    @Override
    public String toString() {
        return "Crear cuenta - TC: " + this.tipoCuenta + " - Propietario: " + this.propietario;
    }
}
