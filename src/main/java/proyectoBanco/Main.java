package proyectoBanco;

import proyectoBanco.administrador.Administrador;
import proyectoBanco.banco.Sucursal;
import proyectoBanco.comandos.ServicioComando;
import proyectoBanco.cuentas.CreadorCuenta;
import proyectoBanco.cuentas.TipoCuenta;
import proyectoBanco.banco.ServicioBanco;
import proyectoBanco.usuarios.PerfilUsuario;
import proyectoBanco.usuarios.Usuario;

class Main {
    public static void main(String[] args) {
        var creadorCuenta = new CreadorCuenta();
        var sucursal = new Sucursal(creadorCuenta);
        var servicioComando = new ServicioComando();
        var administrador = new Administrador(sucursal, servicioComando);
        var servicioBanco = new ServicioBanco(sucursal);

        sucursal.cambiarAdministrador(administrador);

        var perfil1 = new PerfilUsuario("Mateo", "1234seguro", "hoy");
        var perfil2 = new PerfilUsuario("Carlos", "000noseguro", "ayer");

        var usuario1 = new Usuario(perfil1, servicioBanco);
        var usuario2 = new Usuario(perfil2, servicioBanco);

        usuario1.solicitarCrearCuenta(TipoCuenta.CuentaCorriente);
        usuario2.solicitarCrearCuenta(TipoCuenta.CuentaAhorro);

        administrador.procesarComandos();

        usuario1.actualizarCuenta();
        usuario2.actualizarCuenta();

        usuario1.verEstadoCuenta();
        usuario2.verEstadoCuenta();

        usuario1.depositar(100);

        usuario1.transferir("Carlos", 200);

        System.out.println("\n\nLuego de la transferencia\n");
        usuario1.verEstadoCuenta();
        usuario2.verEstadoCuenta();
    }
}
