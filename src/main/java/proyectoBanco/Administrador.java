package proyectoBanco;

import proyectoBanco.comandos.*;

import java.util.ArrayList;
import java.util.List;

public class Administrador {
    private Banco banco;
    private ServicioComando servicioComando;
    private List<Comando> peticionesPendientes;

    private void crearCuenta(TipoCuenta tipoCuenta, String usuario, String direccion) {
        this.banco.crearCuenta(tipoCuenta, usuario, direccion);
    }

    private void eliminarCuenta(String usuario) {
        this.banco.eliminarCuenta(usuario);
    }

    public Administrador(Banco banco, ServicioComando servicioComando) {
        this.banco = banco;
        this.servicioComando = servicioComando;
        this.peticionesPendientes = new ArrayList<>();
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
    public void manejarSalir(ComandoSalir comandoSalir) {
        // Por ahora nada...
    }
    public void manejarListar(ComandoListar comandoListar) {
        System.out.println("Peticiones pendientes:");
        for (var comando : this.peticionesPendientes) {
            System.out.println("    - " + comando.toString());
        }
    }

    public void procesarComando() {
        var comando = this.servicioComando.obtenerComando();
        comando.manejar(this);
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
