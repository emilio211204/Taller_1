class PagoPayPal:
    def enviar_pago(self, cantidad):
        print(f"Pagando ${cantidad} con PayPal")

class PagoStripe:
    def procesar_pago(self, cantidad):
        print(f"Pagando ${cantidad} con Stripe")

class ProcesadorPago:
    def pagar(self, cantidad):
        pass


class AdaptadorPayPal(ProcesadorPago):
    def __init__(self):
        self.paypal = PagoPayPal()

    def pagar(self, cantidad):
        self.paypal.enviar_pago(cantidad)

class AdaptadorStripe(ProcesadorPago):
    def __init__(self):
        self.stripe = PagoStripe()

    def pagar(self, cantidad):
        self.stripe.procesar_pago(cantidad)


procesador2 = AdaptadorStripe()
procesador2.pagar(230.0)

procesador = AdaptadorPayPal()
procesador.pagar(100.0)