package proyectoBanco.banco;

import proyectoBanco.banco.servicios.*;
import proyectoBanco.cuentas.CreadorCuenta;

public class Sucursal {
    public final ServicioUsuario servicioUsuario;
    public final ServicioCliente servicioCliente;
    public final ServicioGestorCuentas servicioGestorCuentas;

    public Sucursal() {
        var gestorRoles = new GestorRoles();
        var gestorUsuarios = new GestorUsuarios(gestorRoles);
        var creadorCuenta = new CreadorCuenta();
        var gestorCuentas = new GestorCuentas(creadorCuenta);
        var servicioGestionCuentas = new ServicioGestionCuentas(gestorCuentas);
        var servicioCuentaCliente = new ServicioCuentaCliente(gestorCuentas);
        var gestorTransacciones = new GestorTransacciones();
        var servicioTransaccion = new ServicioTransaccion(gestorTransacciones);

        this.servicioUsuario = new ServicioUsuario(gestorUsuarios);
        this.servicioCliente = new ServicioCliente(gestorUsuarios, servicioCuentaCliente, servicioTransaccion);
        this.servicioGestorCuentas = new ServicioGestorCuentas(gestorUsuarios, servicioGestionCuentas);
    }
}
