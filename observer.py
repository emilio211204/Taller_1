from abc import ABC, abstractmethod


class Observador(ABC):
    @abstractmethod
    def actualizar(self, temperatura):
        pass


class SensorTemperatura:
    def __init__(self):
        self._observadores = []
        self._temperatura = None

    def agregar_observador(self, observador):
        self._observadores.append(observador)

    def eliminar_observador(self, observador):
        self._observadores.remove(observador)

    def notificar(self):
        for obs in self._observadores:
            obs.actualizar(self._temperatura)

    def set_temperatura(self, nueva_temp):
        print(f"\n[Sensor] Nueva temperatura detectada: {nueva_temp}°C")
        self._temperatura = nueva_temp
        self.notificar()


class Pantalla:
    def actualizar(self, temperatura):
        print(f"[Pantalla] Temperatura actual: {temperatura}°C")

class Alarma:
    def actualizar(self, temperatura):
        if temperatura > 50:
            print(f"[Alarma] ¡Temperatura peligrosa!: {temperatura}°C")
        else:
            print(f"[Alarma] Temperatura normal")

class RegistroBD:
    def actualizar(self, temperatura):
        print(f"[Base de Datos] Registro guardado: {temperatura}°C")


sensor = SensorTemperatura()

pantalla = Pantalla()
alarma = Alarma()
bd = RegistroBD()

sensor.agregar_observador(pantalla)
sensor.agregar_observador(alarma)
sensor.agregar_observador(bd)


sensor.set_temperatura(30)
sensor.set_temperatura(55)