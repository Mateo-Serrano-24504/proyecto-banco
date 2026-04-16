package proyectoBanco.banco.concurrencia;

import proyectoBanco.banco.AccesoBaseDeDatos;
import proyectoBanco.banco.GestorTransacciones;

public class GestorTransaccionesConcurrente {
    private final GestorTransacciones gestorTransacciones;

    public GestorTransaccionesConcurrente(GestorTransacciones gestorTransacciones) {
        this.gestorTransacciones = gestorTransacciones;
    }

    public boolean manejarDeposito(String usuario, int saldo) {
        return AccesoBaseDeDatos.ejecutarSobreBaseDeDatos(
                bdd -> this.gestorTransacciones.manejarDeposito(
                        bdd.cuentas, usuario, saldo
                )
        );
    }
    public boolean manejarRetiro(String usuario, int saldo) {
        return AccesoBaseDeDatos.ejecutarSobreBaseDeDatos(
                bdd -> this.gestorTransacciones.manejarRetiro(
                        bdd.cuentas, usuario, saldo
                )
        );
    }
    public boolean manejarTransferencia(String usuario, String receptor, int saldo) {
        return AccesoBaseDeDatos.ejecutarSobreBaseDeDatos(
                bdd -> this.gestorTransacciones.manejarTransferencia(
                        bdd.cuentas, usuario, receptor, saldo
                )
        );
    }
}
