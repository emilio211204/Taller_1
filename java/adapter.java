class PagoPayPal {
    public void enviarPago(double cantidad) {
        System.out.println("Pagando $" + cantidad + " con PayPal");
    }
}

class PagoStripe {
    public void procesarPago(double cantidad) {
        System.out.println("Pagando $" + cantidad + " con Stripe");
    }
}

interface ProcesadorPago {
    void pagar(double cantidad);
}

class AdaptadorPayPal implements ProcesadorPago {
    private PagoPayPal paypal;

    public AdaptadorPayPal() {
        this.paypal = new PagoPayPal();
    }

    @Override
    public void pagar(double cantidad) {
        paypal.enviarPago(cantidad);
    }
}


class AdaptadorStripe implements ProcesadorPago {
    private PagoStripe stripe;

    public AdaptadorStripe() {
        this.stripe = new PagoStripe();
    }

    @Override
    public void pagar(double cantidad) {
        stripe.procesarPago(cantidad);
    }
}

public class adapter {
    public static void main(String[] args) {
        ProcesadorPago procesador1 = new AdaptadorPayPal();
        procesador1.pagar(100.0);

        ProcesadorPago procesador2 = new AdaptadorStripe();
        procesador2.pagar(230.0);
    }
}
