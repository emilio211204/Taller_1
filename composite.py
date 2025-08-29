from abc import ABC, abstractmethod

# Componente base
class ElementoMenu(ABC):
    @abstractmethod
    def mostrar(self, nivel=0):
        pass

# Hoja: Acción individual
class Accion(ElementoMenu):
    def __init__(self, nombre):
        self.nombre = nombre

    def mostrar(self, nivel=0):
        print("  " * nivel + f"Acción: {self.nombre}")

# Compuesto: Menú que contiene otros elementos
class Menu(ElementoMenu):
    def __init__(self, nombre):
        self.nombre = nombre
        self.elementos = []

    def agregar(self, elemento: ElementoMenu):
        self.elementos.append(elemento)

    def mostrar(self, nivel=0):
        print("  " * nivel + f"Menú: {self.nombre}")
        for elem in self.elementos:
            elem.mostrar(nivel + 1)


menu_principal = Menu("Archivo")

nuevo_menu = Menu("Nuevo")
nuevo_menu.agregar(Accion("Documento"))
nuevo_menu.agregar(Accion("Carpeta"))

menu_principal.agregar(nuevo_menu)
menu_principal.agregar(Accion("Abrir"))
menu_principal.agregar(Accion("Guardar"))

menu_edicion = Menu("Edición")
menu_edicion.agregar(Accion("Cortar"))
menu_edicion.agregar(Accion("Pegar"))

root = Menu("Aplicación")
root.agregar(menu_principal)
root.agregar(menu_edicion)

print("Menú de la Aplicación:")
root.mostrar()