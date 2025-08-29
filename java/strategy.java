interface EstrategiaImpuesto {
    double calcular(double monto);
}

class ImpuestoEcuador implements EstrategiaImpuesto {
    @Override
    public double calcular(double monto) {
        return monto * 0.12;
    }
}

class ImpuestoColombia implements EstrategiaImpuesto {
    @Override
    public double calcular(double monto) {
        return monto * 0.19;
    }
}


class Factura {
    private EstrategiaImpuesto estrategia;

    public Factura(EstrategiaImpuesto estrategia) {
        this.estrategia = estrategia;
    }

    public void setEstrategia(EstrategiaImpuesto estrategia) {
        this.estrategia = estrategia;
    }

    public double totalConImpuesto(double monto) {
        double impuesto = estrategia.calcular(monto);
        return monto + impuesto;
    }
}

public class strategy {
    public static void main(String[] args) {
        Factura factura = new Factura(new ImpuestoEcuador());
        System.out.println("Total Ecuador: " + factura.totalConImpuesto(200));

        factura.setEstrategia(new ImpuestoColombia());
        System.out.println("Total Colombia: " + factura.totalConImpuesto(100));
    }
}
