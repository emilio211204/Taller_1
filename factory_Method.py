from abc import ABC, abstractmethod

class Vehiculo(ABC):
    @abstractmethod
    def conducir(self):
        pass

class Carro(Vehiculo):
    def conducir(self):
        return "Conduciendo un carro"

class Moto(Vehiculo):
    def conducir(self):
        return "Conduciendo una moto"

class Camion(Vehiculo):
    def conducir(self):
        return "Conduciendo un camión"

class FabricaVehiculo:
    def crear_vehiculo(self, tipo):
        if tipo == "carro":
            return Carro()
        elif tipo == "moto":
            return Moto()
        elif tipo == "camion":
            return Camion()
        else:
            raise ValueError("Tipo de vehículo no reconocido")


fabrica = FabricaVehiculo()
vehiculo = fabrica.crear_vehiculo("moto")
print(vehiculo.conducir())

fabrica2 = FabricaVehiculo()
vehiculo2 = fabrica2.crear_vehiculo("camion")
print(vehiculo2.conducir())