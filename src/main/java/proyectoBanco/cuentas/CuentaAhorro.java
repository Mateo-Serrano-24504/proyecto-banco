package proyectoBanco.cuentas;

public class CuentaAhorro extends Cuenta {
    public CuentaAhorro(String propietario) {
        super.propietario = propietario;
        super.saldo = 0;
    }

    @Override
    public void verBalance() {
        System.out.println("Balance de cuenta.");
        System.out.println("    - Tipo de cuenta: Ahorro");
        System.out.println("    - Propietario: " + this.propietario);
        System.out.println("    - Saldo: " + this.saldo);
    }

    @Override
    public boolean depositar(int cantidad) {
        this.saldo += cantidad;
        return true;
    }

    @Override
    public boolean retirar(int cantidad) {
        if (this.saldo >= cantidad) {
            this.saldo -= cantidad;
            return true;
        }
        return false;
    }
}
