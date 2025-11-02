import java.util.Scanner;
import java.util.Random;

public class algo {

    static double codigo_correcto = 2024;
    static byte intentos_max_codigo = 3;
    static byte intentos_max_captcha = 3;


    public static void main(String[] args) {

        boolean captcha=false, programa_terminado=false;
        int codigo_usuario = 0, captcha_usuario;
        byte captcha1, captcha2, intentos_captcha_usuario = 0, intentos_codigo_usuario = 0;

        Random generador = new Random();
        Scanner scanner = new Scanner(System.in);

        while (codigo_usuario != codigo_correcto && programa_terminado == false){
            System.out.println("Ingrese el ping");
            codigo_usuario = scanner.nextInt();

            if (codigo_usuario == codigo_correcto){
            System.out.println("El pin ingresado es correcto");

                while (intentos_captcha_usuario < intentos_max_captcha && captcha == false){
                    System.out.println("Resuelve el siguiente captcha");
                    captcha1 = (byte) generador.nextInt(10);
                    captcha2 = (byte) generador.nextInt(10);
                    System.out.println("Capcha a resolver: " + captcha1 + " + " + captcha2);
                    captcha_usuario = scanner.nextInt();

                    if (captcha_usuario == (captcha1+captcha2)){
                        System.out.println("Operación completada");
                        captcha = true;
                        programa_terminado = true;

                    } else{
                        intentos_captcha_usuario++;
                        System.out.println("Capcha incorrecto, le quedan " + (intentos_max_captcha-intentos_captcha_usuario));

                        if (intentos_captcha_usuario == intentos_max_captcha){
                            System.out.println("Cuenta bloqueada, maxmimos intentos introducidos");
                            programa_terminado = true;

                        }    
                    }
                }
            } else{
                intentos_codigo_usuario++;
                System.out.println("Codigo incorrecto, le quedan " + (intentos_max_codigo-intentos_codigo_usuario));

                if (intentos_max_codigo == intentos_codigo_usuario){
                    System.out.println("Cuenta bloqueada, maxmimos intentos introducidos");
                    programa_terminado = true;
                }
            }
        
        }
        scanner.close();
    }
}
