package proyectoBanco.gestorCuentas;

import proyectoBanco.banco.*;
import proyectoBanco.banco.servicios.*;
import proyectoBanco.cuentas.CreadorCuenta;
import proyectoBanco.cuentas.Cuenta;
import proyectoBanco.cuentas.TipoCuenta;
import proyectoBanco.usuarios.Cliente;
import proyectoBanco.usuarios.PerfilUsuario;
import proyectoBanco.usuarios.RolUsuario;
import proyectoBanco.usuarios.UsuarioGestorCuentas;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AplicacionGestorCuentas {
    public final Scanner scanner;
    public final ServicioEntrada servicioEntrada;
    public final HashMap<String, Cuenta> cuentas;
    public final CreadorCuenta creadorCuenta;
    public final GestorCuentas gestorCuentas;
    public final GestorTransacciones gestorTransacciones;
    public final GestorRoles gestorRoles;
    public final GestorUsuarios gestorUsuarios;
    public final ServicioCuentaCliente servicioCuentaCliente;
    public final ServicioTransaccion servicioTransaccion;
    public final ServicioGestionCuentas servicioGestionCuentas;
    public final ServicioCliente servicioCliente;
    public final ServicioGestorCuentas servicioGestorCuentas;
    public final ServicioUsuario servicioUsuario;

    public ServicioComandoGestorCuentas servicioComandoGestorCuentas;

    public AplicacionGestorCuentas() {
        this.scanner = new Scanner(System.in);
        this.servicioEntrada = new ServicioEntrada(scanner);
        this.cuentas = new HashMap<String, Cuenta>();
        this.creadorCuenta = new CreadorCuenta();
        this.gestorCuentas = new GestorCuentas(cuentas, creadorCuenta);
        this.gestorTransacciones = new GestorTransacciones(cuentas);
        this.gestorRoles = new GestorRoles();
        this.gestorUsuarios = new GestorUsuarios(gestorRoles);
        this.servicioCuentaCliente = new ServicioCuentaCliente(gestorCuentas);
        this.servicioTransaccion = new ServicioTransaccion(gestorTransacciones);
        this.servicioGestionCuentas = new ServicioGestionCuentas(gestorCuentas);
        this.servicioCliente = new ServicioCliente(gestorUsuarios, servicioCuentaCliente, servicioTransaccion);
        this.servicioGestorCuentas = new ServicioGestorCuentas(gestorUsuarios, servicioGestionCuentas);
        this.servicioUsuario = new ServicioUsuario(gestorUsuarios);

        this.servicioComandoGestorCuentas = null;
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

    public static void main(String[] args) {
        var aplicacion = new AplicacionGestorCuentas();

        var perfilGestorCuentas = new PerfilUsuario("Mateo", "123", "24/5/2004");
        var roles = new HashSet<>(Set.of(RolUsuario.GestorCuentas));
        var rolCliente = new HashSet<>(Set.of(RolUsuario.Cliente));

        var fabrica = new FabricaComandoGestorCuentas(
                aplicacion.servicioGestorCuentas,
                perfilGestorCuentas
        );
        aplicacion.servicioComandoGestorCuentas = new ServicioComandoGestorCuentas(
                aplicacion.servicioEntrada,
                fabrica
        );

        aplicacion.servicioUsuario.crearUsuarioSiNoExiste(perfilGestorCuentas, roles);
        var usuarioGestorCuentas = new UsuarioGestorCuentas(
                perfilGestorCuentas,
                aplicacion.servicioGestorCuentas
        );

        var perfilUsuario1 = new PerfilUsuario("Carlos","hola", "hace mucho");
        var perfilUsuario2 = new PerfilUsuario("Rosa", "lol", "hace relativamente poco");

        aplicacion.servicioUsuario.crearUsuarioSiNoExiste(perfilUsuario1, rolCliente);
        aplicacion.servicioUsuario.crearUsuarioSiNoExiste(perfilUsuario2, rolCliente);

        var cliente1 = new Cliente(perfilUsuario1, aplicacion.servicioCliente);
        cliente1.solicitarCrearCuenta(TipoCuenta.CuentaAhorro);
        cliente1.solicitarCrearCuenta(TipoCuenta.CuentaCorriente);

        aplicacion.manejarComandos();

        cliente1.verEstadoCuenta();

        usuarioGestorCuentas.verOperacionesPendientes();
    }
}
