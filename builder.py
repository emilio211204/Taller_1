class Computadora:
    def __init__(self):
        self.partes = []

    def agregar_parte(self, parte):
        self.partes.append(parte)

    def mostrar(self):
        return f"Computadora con: {', '.join(self.partes)}"

class ConstructorComputadora:
    def __init__(self):
        self.pc = Computadora()

    def agregar_cpu(self):
        self.pc.agregar_parte("CPU Intel i7")

    def agregar_ram(self):
        self.pc.agregar_parte("16GB RAM")

    def agregar_gpu(self):
        self.pc.agregar_parte("NVIDIA RTX 3060")

    def obtener_computadora(self):
        return self.pc


class Director:
    def construir_gaming_pc(self, constructor):
        constructor.agregar_cpu()
        constructor.agregar_ram()
        constructor.agregar_gpu()

constructor = ConstructorComputadora()
director = Director()
director.construir_gaming_pc(constructor)
pc = constructor.obtener_computadora()
print(pc.mostrar())