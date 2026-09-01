public class CuentaCorriente extends Cuenta {

    private double sobregiro;

    public CuentaCorriente(
            String numero,
            double saldoInicial,
            double sobregiro) {

        super(numero, saldoInicial);
        this.sobregiro = sobregiro;
    }

    public double getSobregiro() {
        return sobregiro;
    }

    @Override
    public void retirar(double monto) {

        if (monto <= 0) {
            throw new IllegalArgumentException(
                    "El monto debe ser mayor que cero");
        }

        if (monto > getSaldo() + sobregiro) {
            throw new IllegalArgumentException(
                    "Se excedió el límite de sobregiro");
        }

        disminuirSaldo(monto);
    }

    @Override
    public void aplicarBeneficio() {
        // No aplica beneficio
    }
}