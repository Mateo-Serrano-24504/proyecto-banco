package proyectoBanco.usuarios;

import proyectoBanco.banco.ServicioBanco;
import proyectoBanco.cuentas.Cuenta;
import proyectoBanco.cuentas.CuentaCorriente;

import java.util.ArrayList;
import java.util.List;

public class GestorCuentas extends Usuario {
    private final List<Cuenta> perfileslUsuarios;

    public GestorCuentas(
            ServicioBanco servicioBanco,
            CredencialesUsuario credencialesUsuario
    ) {
        super(servicioBanco, credencialesUsuario);
        this.perfileslUsuarios = new ArrayList<>();
    }

    public boolean crearCuenta() {
        return false;
    }
    public boolean eliminarCuenta() {
        return false;
    }
    public Cuenta obtenerCuenta() {
        return new CuentaCorriente("");
    }
    public void iterarCuentas() {}
}
