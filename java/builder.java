import java.util.ArrayList;
import java.util.List;

class Computadora {
    private List<String> partes = new ArrayList<>();

    public void agregarParte(String parte) {
        partes.add(parte);
    }

    public String mostrar() {
        return "Computadora con: " + String.join(", ", partes);
    }
}

class ConstructorComputadora {
    private Computadora pc;

    public ConstructorComputadora() {
        this.pc = new Computadora();
    }

    public void agregarCPU() {
        pc.agregarParte("CPU Intel i7");
    }

    public void agregarRAM() {
        pc.agregarParte("16GB RAM");
    }

    public void agregarGPU() {
        pc.agregarParte("NVIDIA RTX 3060");
    }

    public Computadora obtenerComputadora() {
        return pc;
    }
}


class Director {
    public void construirGamingPC(ConstructorComputadora constructor) {
        constructor.agregarCPU();
        constructor.agregarRAM();
        constructor.agregarGPU();
    }
}


public class builder{
    public static void main(String[] args) {
        ConstructorComputadora constructor = new ConstructorComputadora();
        Director director = new Director();

        director.construirGamingPC(constructor);

        Computadora pc = constructor.obtenerComputadora();
        System.out.println(pc.mostrar());
    }
}
