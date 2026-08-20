import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        System.out.println("===== TALLER 1 - POO =====");

        // ==========================================
        // HERENCIA Y POLIMORFISMO
        // ==========================================

        System.out.println("\n--- CUENTAS ---");

        Cuenta cuenta = new CuentaCorriente(
                "001",
                new BigDecimal("100000"),
                new BigDecimal("50000")
        );

        System.out.println(
                "Saldo inicial: $" + cuenta.getSaldo()
        );

        cuenta.depositar(new BigDecimal("20000"));

        System.out.println(
                "Saldo después del depósito: $" + cuenta.getSaldo()
        );

        cuenta.debitar(new BigDecimal("140000"));

        System.out.println(
                "Saldo después del débito: $" + cuenta.getSaldo()
        );


        // ==========================================
        // POLIMORFISMO MEDIANTE INTERFAZ
        // ==========================================

        System.out.println("\n--- PAGOS ---");

        Pedido pedido = new Pedido(
                new BigDecimal("75000")
        );

        CheckoutService checkout = new CheckoutService();


        Pago pagoTarjeta =
                new PagoTarjeta("123456789");

        Pago pagoTransferencia =
                new PagoTransferencia("987654321");

        Pago pagoEfectivo =
                new PagoEfectivo();


        checkout.finalizarCompra(
                pedido,
                pagoTarjeta
        );

        System.out.println();

        checkout.finalizarCompra(
                pedido,
                pagoTransferencia
        );

        System.out.println();

        checkout.finalizarCompra(
                pedido,
                pagoEfectivo
        );


        // ==========================================
        // DEMOSTRACIÓN DE EXCEPCIÓN
        // ==========================================

        System.out.println("\n--- EXCEPCIÓN ---");

        try {

            cuenta.debitar(new BigDecimal("100000"));

        } catch (SaldoInsuficienteException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }
}