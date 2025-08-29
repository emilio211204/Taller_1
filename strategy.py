class EstrategiaImpuesto:
    def calcular(self, monto):
        pass

class ImpuestoEcuador(EstrategiaImpuesto):
    def calcular(self, monto):
        return monto * 0.12

class ImpuestoColombia(EstrategiaImpuesto):
    def calcular(self, monto):
        return monto * 0.19

class Factura:
    def __init__(self, estrategia):
        self.estrategia = estrategia

    def total_con_impuesto(self, monto):
        impuesto = self.estrategia.calcular(monto)
        return monto + impuesto

factura = Factura(ImpuestoEcuador())
print("Total Ecuador:", factura.total_con_impuesto(200))

factura.estrategia = ImpuestoColombia()
print("Total Colombia:", factura.total_con_impuesto(100))