package proyectoBanco.banco;

import proyectoBanco.cuentas.Cuenta;
import proyectoBanco.cuentas.TipoCuenta;
import proyectoBanco.usuarios.CredencialesUsuario;

public class ServicioBanco {
    private final Sucursal sucursal;
    private final GestorUsuarios gestorUsuarios;

    private boolean verificar(CredencialesUsuario credencialesUsuario) {
        return this.gestorUsuarios.verificarCredencialesUsuario(credencialesUsuario);
    }

    public ServicioBanco(Sucursal sucursal, GestorUsuarios gestorUsuarios) {
        this.sucursal = sucursal;
        this.gestorUsuarios = gestorUsuarios;
    }

    // Operaciones de cliente
    public boolean solicitarCrearCuenta(TipoCuenta tipoCuenta, CredencialesUsuario credencialesUsuario) {
        if (!this.verificar(credencialesUsuario)) return false;
        this.sucursal.solicitarCrearCuenta(tipoCuenta, credencialesUsuario);
        return true;
    }
    public boolean solicitarEliminarCuenta(CredencialesUsuario credencialesUsuario) {
        if (!this.verificar(credencialesUsuario)) return false;
        this.sucursal.solicitarEliminarCuenta(credencialesUsuario);
        return true;
    }
    public Cuenta obtenerEstadoCuenta(CredencialesUsuario credencialesUsuario) {
        if (!this.verificar(credencialesUsuario)) return null;
        return this.sucursal.obtenerEstadoCuenta(credencialesUsuario);
    }
    public boolean depositar(int cantidad, CredencialesUsuario credencialesUsuario) {
        if (!this.verificar(credencialesUsuario)) return false;
        return this.sucursal.intentarHacerDeposito(cantidad, credencialesUsuario);
    }
    public boolean retirar(int cantidad, CredencialesUsuario credencialesUsuario) {
        if (!this.verificar(credencialesUsuario)) return false;
        return this.sucursal.intentarHacerRetiro(cantidad, credencialesUsuario);
    }
    public boolean transferir(String receptor, int cantidad, CredencialesUsuario credencialesUsuario) {
        if (!this.verificar(credencialesUsuario)) return false;
        return this.sucursal.intentarHacerTransferencia(
                receptor,
                cantidad,
                credencialesUsuario
        );
    }
}
