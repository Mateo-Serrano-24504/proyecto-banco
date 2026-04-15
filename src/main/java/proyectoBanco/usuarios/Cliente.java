package proyectoBanco.usuarios;

import proyectoBanco.banco.ServicioBanco;
import proyectoBanco.banco.servicios.ServicioCliente;
import proyectoBanco.cuentas.Cuenta;
import proyectoBanco.cuentas.TipoCuenta;

public class Cliente extends Usuario {
    private final ServicioCliente servicioCliente;

    public Cliente(PerfilUsuario perfilUsuario, ServicioCliente serviciocliente) {
        super(perfilUsuario);
        this.servicioCliente = serviciocliente;
    }

    public boolean solicitarCrearCuenta(TipoCuenta tipoCuenta) {
        return this.servicioCliente.solicitarCrearCuenta(super.perfilUsuario.generarCredenciales(), tipoCuenta);
    }
    public boolean solicitarEliminarCuenta() {
        return this.servicioCliente.solicitarEliminarCuenta(super.perfilUsuario.generarCredenciales());
    }
    public boolean depositar(int cantidad) {
        return this.servicioCliente.depositar(super.perfilUsuario.generarCredenciales(), cantidad);
    }
    public boolean retirar(int cantidad) {
        return this.servicioCliente.retirar(super.perfilUsuario.generarCredenciales(), cantidad);
    }
    public boolean transferir(String receptor, int cantidad) {
        return this.servicioCliente.transferir(super.perfilUsuario.generarCredenciales(), receptor, cantidad);
    }
    public void verEstadoCuenta() {
        this.servicioCliente.obtenerEstadoCuenta(
                super.perfilUsuario.generarCredenciales()
        ).verBalance();
    }
}
