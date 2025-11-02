import java.text.DecimalFormat;
import java.util.Scanner;

public class examen13  {

    static float tarifa_domestica = 0.15f;
    static float tarifa_industrial = 0.1f;
    static float iva = 0.21f;

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.00");

        double lectura_inicial = 1, lectura_final = 0, consumo_total, importe_base, iva_sobre_el_consumo, total;
        byte tarifa_seleccion_usuario = 0;

        while (lectura_inicial > lectura_final){
            System.out.println("CALCULADORA DE CONSUMO ELÉCTRICO");
            System.out.println();
            System.out.print("Introduce la lectura inicial (kWh): ");
            lectura_inicial = scanner.nextDouble();
            System.out.println();
            System.out.print("Introduce la lectura final (kWh): ");
            lectura_final = scanner.nextDouble();
            System.out.println();

            while (!(tarifa_seleccion_usuario == 1 || tarifa_seleccion_usuario == 2)){
                System.out.print("Tipo de tarifa (1 - Doméstica, 2 - Industrial): ");
                tarifa_seleccion_usuario = (byte) scanner.nextDouble();
            }

            if (lectura_inicial > lectura_final){
                System.out.println("Error de validacion la tarifa inical no puede ser mayor a la final, introduzca de nuevo los datos");
                System.out.println();
            }

            else {
                consumo_total = lectura_final - lectura_inicial;
                System.out.println();
                System.out.println("--- RECIBO DE CONSUMO ---");
                System.out.println("Consumo total: " + consumo_total + " kWh");
                if (tarifa_seleccion_usuario == 1){
                    System.out.println("Tarifa aplicada: Doméstica");
                    System.out.println("Precio por kWh: " + tarifa_domestica + " €");
                    importe_base = tarifa_domestica * consumo_total;
                }

                else{
                    System.out.println("Tarifa aplicada: Industrial");
                    System.out.println("Precio por kWh: " + tarifa_industrial + " €");
                    importe_base = tarifa_industrial * consumo_total;
                }

                System.out.println("Importe base: " + df.format(importe_base) + " €");
                iva_sobre_el_consumo = importe_base*iva;
                System.out.println("IVA (21%): " + df.format(iva_sobre_el_consumo) + " €");
                total = iva_sobre_el_consumo + importe_base;
                System.out.println("TOTAL A PAGAR: " + df.format(total) + " €");
                System.out.println();


            }
        }


        scanner.close();
    }
}