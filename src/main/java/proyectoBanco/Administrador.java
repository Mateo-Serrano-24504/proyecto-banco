package proyectoBanco;

import proyectoBanco.comandos.*;
import proyectoBanco.cuentas.TipoCuenta;

import java.util.ArrayList;
import java.util.List;

public class Administrador {
    private final Banco banco;
    private final ServicioComando servicioComando;
    private final List<Comando> peticionesPendientes;
    private boolean seguirProcesandoComandos;

    private void eliminarCuenta(String usuario) {
        this.banco.eliminarCuenta(usuario);
    }

    private void procesarComando() {
        var comando = this.servicioComando.obtenerComando();
        comando.manejar(this);
    }

    public Administrador(Banco banco, ServicioComando servicioComando) {
        this.banco = banco;
        this.servicioComando = servicioComando;
        this.peticionesPendientes = new ArrayList<>();
        this.seguirProcesandoComandos = true;
    }

    public void manejarCrear(ComandoCrear comandoCrear) {
        switch (comandoCrear.tipoCuenta()) {
            case TipoCuenta.CuentaCorriente -> {
                this.banco.crearCuentaCorriente(
                        comandoCrear.usuario()
                );
            }
            case TipoCuenta.CuentaAhorro -> {
                this.banco.crearCuentaAhorro(
                        comandoCrear.usuario()
                );
            }
            default -> { /* Simplemente se saltea */ }
        }
    }
    public void manejarEliminar(ComandoEliminar comandoEliminar) {
        this.eliminarCuenta(comandoEliminar.usuario());
    }
    public void manejarSalir(ComandoSalir _comandoSalir) {
        this.seguirProcesandoComandos = false;
    }
    public void manejarListar(ComandoListar _comandoListar) {
        System.out.println("Peticiones pendientes:");
        for (var comando : this.peticionesPendientes) {
            System.out.println("    - " + comando.toString());
        }
    }
    public void manejarManejarPeticion(ComandoManejarPeticicon comandoRemoverPeticicon) {
        var indice = comandoRemoverPeticicon.indicePeticion();
        if (indice < 0 || indice >= this.peticionesPendientes.size()) {
            return;
        }
        var comando = this.peticionesPendientes.get(indice);
        this.peticionesPendientes.remove(indice);
        comando.manejar(this);
    }

    public void procesarComandos() {
        while (this.seguirProcesandoComandos) {
            this.procesarComando();
        }
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
