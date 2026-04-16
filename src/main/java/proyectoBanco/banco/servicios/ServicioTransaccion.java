package proyectoBanco.banco.servicios;

import proyectoBanco.banco.GestorTransacciones;
import proyectoBanco.banco.concurrencia.GestorTransaccionesConcurrente;
import proyectoBanco.usuarios.CredencialesUsuario;

public class ServicioTransaccion {
    private final GestorTransaccionesConcurrente gestorTransaccionesConcurrente;

    public ServicioTransaccion(GestorTransaccionesConcurrente gestorTransaccionesConcurrente) {
        this.gestorTransaccionesConcurrente = gestorTransaccionesConcurrente;
    }

    public boolean depositar(CredencialesUsuario credenciales, int cantidad) {
        return this.gestorTransaccionesConcurrente.manejarDeposito(credenciales.usuario(), cantidad);
    }
    public boolean retirar(CredencialesUsuario credenciales, int cantidad) {
        return this.gestorTransaccionesConcurrente.manejarRetiro(credenciales.usuario(), cantidad);
    }
    public boolean transferir(CredencialesUsuario credenciales, String receptor, int cantidad) {
        return this.gestorTransaccionesConcurrente.manejarTransferencia(credenciales.usuario(), receptor, cantidad);
    }
}
