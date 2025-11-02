import java.util.Scanner;
import java.util.Random;

public class examen14 {

    static int codigo_correcto = 2580;
    static byte intentos_max_codigo = 3;
    static byte intentos_max_verificacion = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random generador = new Random();

        int codigo_usuario = 0, codigo_verificacion_usuario = 0;
        byte intentos_codigo_usuario = 0, codigo_verificacion = 0, intentos_verificacion_usuario = 0;
        boolean sigue_aplicacion = true;

        System.out.println("=== SISTEMA DE CONTROL NUMÉRICO ===");

        while (codigo_usuario != codigo_correcto && intentos_codigo_usuario < intentos_max_codigo){
            System.out.print("Introduce el código de acceso: ");
            codigo_usuario = scanner.nextInt();

            if (codigo_usuario != codigo_correcto){
                System.out.println();
                intentos_codigo_usuario++;
                System.out.println("Código incorrecto. Intentos restantes: " + (intentos_max_codigo-intentos_codigo_usuario));
                
                if (intentos_max_codigo == intentos_codigo_usuario){
                    System.out.println("Acceso denegado. Sistema bloqueado");
                    sigue_aplicacion = false;
                }
            }   
        }

        if (sigue_aplicacion == true){
            System.out.println("Código correcto");
            System.out.println();

            codigo_verificacion = (byte) (generador.nextInt(90) + 10);
            System.out.println("Código temporal generado: " + codigo_verificacion);

            while (codigo_verificacion_usuario != codigo_verificacion && intentos_verificacion_usuario < intentos_max_verificacion){
                System.out.print("Introduce el código temporal: ");
                codigo_verificacion_usuario = (byte) scanner.nextInt();

                if (codigo_verificacion_usuario != codigo_verificacion){
                    intentos_verificacion_usuario++;
                    System.out.println("Incorrecto. Intentos restante: " + (intentos_max_verificacion-intentos_verificacion_usuario));

                    if (intentos_max_verificacion == intentos_verificacion_usuario){
                        System.out.println("Verificacción fallida. Sistema bloqueado.");
                        sigue_aplicacion = false;
                    }
                }
                
            }

            if (sigue_aplicacion == true){
                System.out.println("Acceso concedido.");
            }
            
        }
        
        scanner.close();
    }
}