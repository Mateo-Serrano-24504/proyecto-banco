package proyectoBanco;

import proyectoBanco.comandos.*;

import java.util.ArrayList;
import java.util.List;

public class Administrador {
    private final Banco banco;
    private final ServicioComando servicioComando;
    private final List<Comando> peticionesPendientes;
    private boolean seguirProcesandoComandos;

    private void crearCuenta(TipoCuenta tipoCuenta, String usuario, String direccion) {
        this.banco.crearCuenta(tipoCuenta, usuario, direccion);
    }

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
        this.crearCuenta(
                comandoCrear.tipoCuenta(),
                comandoCrear.usuario(),
                comandoCrear.direccion()
        );
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

    public void procesarComandos() {
        while (this.seguirProcesandoComandos) {
            this.procesarComando();
        }
    }

    public void solicitarCrearCuenta(TipoCuenta tipoCuenta, String usuario, String direccion) {
        this.peticionesPendientes.add(
                new ComandoCrear(tipoCuenta, usuario, direccion)
        );
    }
    public void solicitarEliminarCuenta(String usuario) {
        this.peticionesPendientes.add(
                new ComandoEliminar(usuario)
        );
    }
}
