import java.util.ArrayList;
import java.util.List;

interface Observador {
    void actualizar(int temperatura);
}

class SensorTemperatura {
    private List<Observador> observadores = new ArrayList<>();
    private int temperatura;

    public void agregarObservador(Observador obs) {
        observadores.add(obs);
    }

    public void eliminarObservador(Observador obs) {
        observadores.remove(obs);
    }

    public void notificar() {
        for (Observador obs : observadores) {
            obs.actualizar(temperatura);
        }
    }

    public void setTemperatura(int nuevaTemp) {
        System.out.println("\n[Sensor] Nueva temperatura detectada: " + nuevaTemp + "°C");
        this.temperatura = nuevaTemp;
        notificar();
    }
}

class Pantalla implements Observador {
    @Override
    public void actualizar(int temperatura) {
        System.out.println("[Pantalla] Temperatura actual: " + temperatura + "°C");
    }
}

class Alarma implements Observador {
    @Override
    public void actualizar(int temperatura) {
        if (temperatura > 50) {
            System.out.println("[Alarma] ¡Temperatura peligrosa!: " + temperatura + "°C");
        } else {
            System.out.println("[Alarma] Temperatura normal");
        }
    }
}

class RegistroBD implements Observador {
    @Override
    public void actualizar(int temperatura) {
        System.out.println("[Base de Datos] Registro guardado: " + temperatura + "°C");
    }
}

public class observer {
    public static void main(String[] args) {
        SensorTemperatura sensor = new SensorTemperatura();

        Pantalla pantalla = new Pantalla();
        Alarma alarma = new Alarma();
        RegistroBD bd = new RegistroBD();

        sensor.agregarObservador(pantalla);
        sensor.agregarObservador(alarma);
        sensor.agregarObservador(bd);

        sensor.setTemperatura(30);
        sensor.setTemperatura(55);
    }
}
