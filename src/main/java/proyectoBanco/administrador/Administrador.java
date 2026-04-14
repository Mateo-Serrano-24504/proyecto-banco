package proyectoBanco.administrador;

import proyectoBanco.banco.Sucursal;
import proyectoBanco.comandos.*;
import proyectoBanco.cuentas.TipoCuenta;
import proyectoBanco.usuarios.CredencialesUsuario;

import java.util.ArrayList;
import java.util.List;

public class Administrador {
    private final Sucursal sucursal;
    private final ServicioComando servicioComando;
    private final List<Comando> peticionesPendientes;
    private boolean seguirProcesandoComandos;
    private final Manejador manejador;

    private void procesarComando() {
        var comando = this.servicioComando.obtenerComando();
        if (comando == null) {
            return;
        }
        comando.manejar(this.manejador);
    }

    public Administrador(Sucursal sucursal, ServicioComando servicioComando) {
        this.sucursal = sucursal;
        this.servicioComando = servicioComando;
        this.peticionesPendientes = new ArrayList<>();
        this.seguirProcesandoComandos = true;
        this.manejador = new Manejador(this, this.peticionesPendientes);
    }

    public void crearCuenta(TipoCuenta tipoCuenta, CredencialesUsuario credenciales) {
        this.sucursal.crearCuenta(tipoCuenta, credenciales);
    }
    public void eliminarCuenta(CredencialesUsuario credenciales) {
        this.sucursal.eliminarCuenta(credenciales);
    }

    public void procesarComandos() {
        while (this.seguirProcesandoComandos) {
            this.procesarComando();
        }
    }
    public void dejarDeManejar() {
        this.seguirProcesandoComandos = false;
    }

    public void solicitarCrearCuenta(TipoCuenta tipoCuenta, CredencialesUsuario credenciales) {
        this.peticionesPendientes.add(
                new ComandoCrear(
                        tipoCuenta,
                        credenciales.usuario(),
                        credenciales.contr()
                )
        );
    }
    public void solicitarEliminarCuenta(CredencialesUsuario credenciales) {
        this.peticionesPendientes.add(
                new ComandoEliminar(credenciales.usuario(), credenciales.contr())
        );
    }
}
