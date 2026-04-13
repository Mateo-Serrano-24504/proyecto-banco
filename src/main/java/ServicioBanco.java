public class ServicioBanco {
    private Banco banco;

    public ServicioBanco(Banco banco) {
        this.banco = banco;
    }

    public Cuenta obtenerCuenta(String nombrePropietario) {
        return this.banco.obtenerCuenta(nombrePropietario);
    }
}
