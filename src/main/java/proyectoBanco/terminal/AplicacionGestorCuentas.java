package proyectoBanco.terminal;

import proyectoBanco.banco.*;
import proyectoBanco.cuentas.CreadorCuenta;
import proyectoBanco.cuentas.Cuenta;
import proyectoBanco.cuentas.TipoCuenta;
import proyectoBanco.usuarios.Cliente;
import proyectoBanco.usuarios.PerfilUsuario;
import proyectoBanco.usuarios.RolUsuario;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AplicacionGestorCuentas {
    private final ServicioComandoGestorCuentas servicioComandoGestorCuentas;

    public AplicacionGestorCuentas(ServicioComandoGestorCuentas servicioComandoGestorCuentas) {
        this.servicioComandoGestorCuentas = servicioComandoGestorCuentas;
    }

    public boolean manejarComando() {
        var comando = this.servicioComandoGestorCuentas.siguienteComando();
        if (comando == null) {
            return false;
        }
        comando.ejecutar();
        return true;
    }

    public void manejarComandos() {
        while (this.manejarComando());
    }

    public static ServicioBanco crearServicioBanco() {
        var cuentas = new HashMap<String, Cuenta>();
        var creadorCuenta = new CreadorCuenta();
        var gestorCuentas = new GestorCuentas(cuentas, creadorCuenta);
        var gestorTransaccs = new GestorTransacciones(cuentas);
        var gestorRoles = new GestorRoles();
        var gestorUsuarios = new GestorUsuarios(gestorRoles);
        var sucursal = new Sucursal(gestorCuentas, gestorTransaccs);
        return new ServicioBanco(sucursal, gestorUsuarios);
    }

    public static void main(String[] args) {
        var servicioBanco = AplicacionGestorCuentas.crearServicioBanco();

        var perfilGestorCuentas = new PerfilUsuario("Mateo", "123", "24/5/2004");
        var roles = new HashSet<>(Set.of(RolUsuario.GestorCuentas));
        servicioBanco.crearUsuario(perfilGestorCuentas, roles);

        var perfilUsuario1 = new PerfilUsuario("Carlos","hola", "hace mucho");
        var perfilUsuario2 = new PerfilUsuario("Rosa", "lol", "hace relativamente poco");

        var cliente1 = new Cliente(servicioBanco, perfilUsuario1);
        var cliente2 = new Cliente(servicioBanco, perfilUsuario2);

        cliente1.solicitarCrearCuenta(TipoCuenta.CuentaAhorro);
        cliente2.solicitarCrearCuenta(TipoCuenta.CuentaCorriente);

        cliente1.depositar(100);
        cliente1.transferir("Rosa", 100);

        cliente1.solicitarEliminarCuenta();

        var fabrica = new FabricaComandoGestorCuentas(servicioBanco, perfilGestorCuentas);
        var servicioEntrada = new ServicioEntrada(new Scanner(System.in));
        var servicioComandoGestorCuentas = new ServicioComandoGestorCuentas(servicioEntrada, fabrica);
        var app = new AplicacionGestorCuentas(servicioComandoGestorCuentas);

        app.manejarComandos();

        System.out.println("\nEstados de cuenta.\n\nCuenta 1:\n");
        cliente1.actualizarVistaCuenta();
        cliente1.verEstadoCuenta();

        System.out.println("\nCuenta 2:\n");
        cliente2.actualizarVistaCuenta();
        cliente2.verEstadoCuenta();
    }
}
