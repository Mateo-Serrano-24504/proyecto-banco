package proyectoBanco.administrador;

import proyectoBanco.comandos.*;

import java.util.List;

public class Manejador {
    private final Administrador administrador;
    private final List<Comando> peticionesPendientes;

    public Manejador(Administrador administrador, List<Comando> peticionesPendientes) {
        this.administrador = administrador;
        this.peticionesPendientes = peticionesPendientes;
    }

    public void manejarCrear(ComandoCrear comandoCrear) {
        this.administrador.crearCuenta(comandoCrear.tipoCuenta(), comandoCrear.usuario());
    }
    public void manejarEliminar(ComandoEliminar comandoEliminar) {
        this.administrador.eliminarCuenta(comandoEliminar.usuario());
    }
    public void manejarSalir(ComandoSalir _comandoSalir) {
        this.administrador.dejarDeManejar();
    }
    public void manejarListar(ComandoListar _comandoListar) {
        System.out.println("Comandos pendientes:");
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
    public void manejarManejarTodos(ComandoManejarTodos _comandoManejarTodos) {
        while (!this.peticionesPendientes.isEmpty()) {
            this.peticionesPendientes.removeFirst().manejar(this);
        }
    }
}
