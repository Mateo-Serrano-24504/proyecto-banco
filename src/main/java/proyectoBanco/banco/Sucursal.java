package proyectoBanco.banco;

import proyectoBanco.banco.concurrencia.GestorCuentasConcurrente;
import proyectoBanco.banco.concurrencia.GestorTransaccionesConcurrente;
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
        var gestorCuentasConcurrente = new GestorCuentasConcurrente(gestorCuentas);
        var servicioGestionCuentas = new ServicioGestionCuentas(gestorCuentasConcurrente);
        var servicioCuentaCliente = new ServicioCuentaCliente(gestorCuentasConcurrente);
        var gestorTransacciones = new GestorTransacciones();
        var gestorTransaccionesConcurrente = new GestorTransaccionesConcurrente(gestorTransacciones);
        var servicioTransaccion = new ServicioTransaccion(gestorTransaccionesConcurrente);

        this.servicioUsuario = new ServicioUsuario(gestorUsuarios);
        this.servicioCliente = new ServicioCliente(gestorUsuarios, servicioCuentaCliente, servicioTransaccion);
        this.servicioGestorCuentas = new ServicioGestorCuentas(gestorUsuarios, servicioGestionCuentas);
    }
}
