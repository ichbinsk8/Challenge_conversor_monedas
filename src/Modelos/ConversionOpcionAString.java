package Modelos;

import java.util.HashMap;
import java.util.Map;

public class ConversionOpcionAString {

    public Map<String, String> Conversion(int opcion) {
        Map<String, String> monedas = new HashMap<>();
        String moneda = "";
        String monedaConverir = "";

        switch (opcion) {
            case 1:
                moneda = "USD";  // Opción 1 se convierte en "USD" a ARS
                monedaConverir = "ARS";
                break;
            case 2:
                moneda = "ARS";  // Opción 2 se convierte en "ARS" a USD
                monedaConverir = "USD";
                break;
            case 3:
                moneda = "USD";  // Opción 3 se convierte en "USD" a BRL
                monedaConverir = "BRL";
                break;
            case 4:
                moneda = "BRL";  // Opción 4 se convierte en "BRL" a USD
                monedaConverir = "USD";
                break;
            case 5:
                moneda = "USD";  // Opción 5 se convierte en "USD" a COP
                monedaConverir = "COP";
                break;
            case 6:
                moneda = "COP";  // Opción 6 se convierte en "COP" a USD
                monedaConverir = "USD";
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }

        monedas.put("moneda", moneda);
        monedas.put("monedaConverir", monedaConverir);
        return monedas;
    }
}

