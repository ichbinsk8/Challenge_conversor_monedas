package Principal;

import Modelos.ConexionAPI;
import Modelos.ConversionOpcionAString;
import Modelos.Filtro;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConexionAPI conexion = new ConexionAPI();
        ConversionOpcionAString convertidorOpcion = new ConversionOpcionAString();


        while (true) {
            System.out.println("***********************\n");
            System.out.println("Sea bienvenido/a al conversor de Moneda = \n\n" +
                    "1) Dólar => Peso argentino \n" +
                    "2) Peso argentino => Dólar \n" +
                    "3) Dólar => Real brasileño \n" +
                    "4) Real brasileño => Dólar \n" +
                    "5) Dólar => Peso colombiano \n" +
                    "6) Peso colombiano => Dólar \n" +
                    "7) Salir\n" +
                    "Elija una opción válida: \n" +
                    "***********************");

            try {
                int opcion = Integer.valueOf(lectura.nextLine());

                if (opcion == 7) {
                    System.out.println("Gracias por usar el conversor. ¡Hasta luego!");
                    break;
                }
                // Obtener la moneda base y la moneda de destino
                Map<String, String> monedas = convertidorOpcion.Conversion(opcion);
                String moneda = monedas.get("moneda");  // Moneda base (origen)
                String monedaConverir = monedas.get("monedaConverir");  // Moneda de conversión (destino)

                // Solicitar al usuario el valor a convertir
                System.out.println("Por favor ingrese la cantidad a convertir: ");
                double valor = Double.parseDouble(lectura.nextLine());

                // Realizar la conexión a la API
                Filtro filtro = conexion.crearConexion(moneda, valor, monedaConverir);


            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        lectura.close();
    }
}
