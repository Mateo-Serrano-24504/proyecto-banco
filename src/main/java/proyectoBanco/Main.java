package proyectoBanco;

import proyectoBanco.administrador.Administrador;
import proyectoBanco.banco.*;
import proyectoBanco.comandos.ServicioComando;
import proyectoBanco.cuentas.CreadorCuenta;
import proyectoBanco.cuentas.Cuenta;
import proyectoBanco.cuentas.TipoCuenta;
import proyectoBanco.usuarios.Cliente;
import proyectoBanco.usuarios.PerfilUsuario;
import proyectoBanco.usuarios.RolUsuario;
import proyectoBanco.usuarios.UsuarioGestorCuentas;

import java.util.HashMap;
import java.util.HashSet;

class Main {
    public static void main(String[] args) {
        var creadorCuenta = new CreadorCuenta();
        var cuentas = new HashMap<String, Cuenta>();
        var gestorCuentas = new GestorCuentas(cuentas, creadorCuenta);
        var gestorRoles = new GestorRoles();
        var gestorUsuarios = new GestorUsuarios(gestorRoles);
        var gestorTransacciones = new GestorTransacciones(cuentas);
        var sucursal = new Sucursal(gestorCuentas, gestorTransacciones);
        var servicioBanco = new ServicioBanco(sucursal, gestorUsuarios);

        var perfil1 = new PerfilUsuario("Mateo", "1234seguro", "hoy");
        var perfil2 = new PerfilUsuario("Carlos", "000noseguro", "ayer");
        var perfilFalso1  = new PerfilUsuario("Mateo", "1234inseguro", "hoy");
        var perfilFalso2  = new PerfilUsuario("Hernan", "000noseguro", "ayer");
        var perfilGestor = new PerfilUsuario("Ulises", "gestor444", "mañana");

        var usuarioGestorCuentas = new UsuarioGestorCuentas(servicioBanco, perfilGestor.generarCredenciales());

        servicioBanco.crearCuenta(perfil1, TipoCuenta.CuentaAhorro);
        servicioBanco.crearCuenta(perfil2, TipoCuenta.CuentaCorriente);

        var rolesGestor = new HashSet<RolUsuario>();
        rolesGestor.add(RolUsuario.GestorCuentas);
        servicioBanco.crearUsuario(perfilGestor, rolesGestor);

        usuarioGestorCuentas.verOperacionesPendientes();
        usuarioGestorCuentas.resolverOperacion(0);
        usuarioGestorCuentas.resolverOperacion(0);

        var clienteFalso1 = new Cliente(servicioBanco, perfilFalso1.generarCredenciales());
        clienteFalso1.actualizarVistaCuenta();
        clienteFalso1.verEstadoCuenta();

        var clienteFalso2 = new Cliente(servicioBanco, perfilFalso2.generarCredenciales());
        clienteFalso2.actualizarVistaCuenta();
        clienteFalso2.verEstadoCuenta();

        System.out.println("\n\nAntes de la transferencia:\n");
        var cliente1 = new Cliente(servicioBanco, perfil1.generarCredenciales());
        cliente1.actualizarVistaCuenta();
        cliente1.verEstadoCuenta();

        var cliente2 = new Cliente(servicioBanco, perfil2.generarCredenciales());
        cliente2.actualizarVistaCuenta();
        cliente2.verEstadoCuenta();

        cliente2.depositar(100);
        cliente2.transferir("Mateo", 200);
        cliente2.transferir("Mateo", 200);

        System.out.println("\nDespués de la transferencia:\n");

        cliente1.actualizarVistaCuenta();
        cliente1.verEstadoCuenta();

        cliente2.actualizarVistaCuenta();
        cliente2.verEstadoCuenta();
    }
}
