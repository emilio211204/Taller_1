import java.util.ArrayList;
import java.util.List;

abstract class ElementoMenu {
    public abstract void mostrar(int nivel);
}

class Accion extends ElementoMenu {
    private String nombre;

    public Accion(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void mostrar(int nivel) {
        System.out.println("  ".repeat(nivel) + "Acción: " + nombre);
    }
}

class Menu extends ElementoMenu {
    private String nombre;
    private List<ElementoMenu> elementos = new ArrayList<>();

    public Menu(String nombre) {
        this.nombre = nombre;
    }

    public void agregar(ElementoMenu elemento) {
        elementos.add(elemento);
    }

    @Override
    public void mostrar(int nivel) {
        System.out.println("  ".repeat(nivel) + "Menú: " + nombre);
        for (ElementoMenu elem : elementos) {
            elem.mostrar(nivel + 1);
        }
    }
}

public class composite {
    public static void main(String[] args) {
        Menu menuPrincipal = new Menu("Archivo");

        Menu nuevoMenu = new Menu("Nuevo");
        nuevoMenu.agregar(new Accion("Documento"));
        nuevoMenu.agregar(new Accion("Carpeta"));

        menuPrincipal.agregar(nuevoMenu);
        menuPrincipal.agregar(new Accion("Abrir"));
        menuPrincipal.agregar(new Accion("Guardar"));

        Menu menuEdicion = new Menu("Edición");
        menuEdicion.agregar(new Accion("Cortar"));
        menuEdicion.agregar(new Accion("Pegar"));

        Menu root = new Menu("Aplicación");
        root.agregar(menuPrincipal);
        root.agregar(menuEdicion);

        System.out.println("Menú de la Aplicación:");
        root.mostrar(0);
    }
}
