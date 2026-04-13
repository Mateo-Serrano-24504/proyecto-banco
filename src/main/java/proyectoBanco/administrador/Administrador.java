package proyectoBanco.administrador;

import proyectoBanco.Banco;
import proyectoBanco.comandos.*;
import proyectoBanco.cuentas.TipoCuenta;

import java.util.ArrayList;
import java.util.List;

public class Administrador {
    private final Banco banco;
    private final ServicioComando servicioComando;
    private final List<Comando> peticionesPendientes;
    private boolean seguirProcesandoComandos;
    private final Manejador manejador;

    private void procesarComando() {
        var comando = this.servicioComando.obtenerComando();
        comando.manejar(this.manejador);
    }

    public Administrador(Banco banco, ServicioComando servicioComando) {
        this.banco = banco;
        this.servicioComando = servicioComando;
        this.peticionesPendientes = new ArrayList<>();
        this.seguirProcesandoComandos = true;
        this.manejador = new Manejador(this, this.peticionesPendientes);
    }

    public void crearCuenta(TipoCuenta tipoCuenta, String usuario) {
        switch (tipoCuenta) {
            case TipoCuenta.CuentaCorriente -> {
                this.banco.crearCuentaCorriente(usuario);
            }
            case TipoCuenta.CuentaAhorro -> {
                this.banco.crearCuentaAhorro(usuario);
            }
            default -> { /* Simplemente se saltea */ }
        }
    }
    public void eliminarCuenta(String usuario) {
        this.banco.eliminarCuenta(usuario);
    }

    public void procesarComandos() {
        while (this.seguirProcesandoComandos) {
            this.procesarComando();
        }
    }
    public void dejarDeManejar() {
        this.seguirProcesandoComandos = false;
    }

    public void solicitarCrearCuenta(TipoCuenta tipoCuenta, String usuario) {
        this.peticionesPendientes.add(
                new ComandoCrear(tipoCuenta, usuario)
        );
    }
    public void solicitarEliminarCuenta(String usuario) {
        this.peticionesPendientes.add(
                new ComandoEliminar(usuario)
        );
    }
}
