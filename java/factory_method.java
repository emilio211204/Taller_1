abstract class Vehiculo {
    public abstract String conducir();
}

class Carro extends Vehiculo {
    @Override
    public String conducir() {
        return "Conduciendo un carro";
    }
}

class Moto extends Vehiculo {
    @Override
    public String conducir() {
        return "Conduciendo una moto";
    }
}

class Camion extends Vehiculo {
    @Override
    public String conducir() {
        return "Conduciendo un camión";
    }
}


class FabricaVehiculo {
    public Vehiculo crearVehiculo(String tipo) {
        switch (tipo.toLowerCase()) {
            case "carro":
                return new Carro();
            case "moto":
                return new Moto();
            case "camion":
                return new Camion();
            default:
                throw new IllegalArgumentException("Tipo de vehículo no reconocido");
        }
    }
}


public class factory_method {
    public static void main(String[] args) {
        FabricaVehiculo fabrica = new FabricaVehiculo();

        Vehiculo vehiculo1 = fabrica.crearVehiculo("moto");
        System.out.println(vehiculo1.conducir());

        Vehiculo vehiculo2 = fabrica.crearVehiculo("camion");
        System.out.println(vehiculo2.conducir());
    }
}
