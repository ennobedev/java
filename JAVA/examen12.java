import java.util.Scanner;

public class examen12  {

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero_usuario = 0;

        int votos_uno = 0;
        int votos_dos = 0;
        int votos_tres = 0;
        
        System.out.println("1. Pedro Sachez");
        System.out.println("2. Santiago Abascal");
        System.out.println("3. José María Gómez");
        System.out.println("4. Finalizar votacion");

        while (numero_usuario != 4){

            System.out.print("Introduzca su voto: ");
            numero_usuario = scanner.nextInt();
            System.out.println();


            if (numero_usuario == 1){
                votos_uno++;
            }

            else if (numero_usuario == 2){
                votos_dos++;
            }

            else if (numero_usuario == 3){
                votos_tres++;
            }

            else {
                System.out.println("Valor introducido incorrecto");
            }
        }

        System.out.println("--- Resultados ---");
        
        int total_votos = votos_uno + votos_dos + votos_tres;

        float porcentaje_uno = ((float) votos_uno / total_votos) * 100;
        float porcentaje_dos = ((float) votos_dos / total_votos) * 100;
        float porcentaje_tres = ((float) votos_tres / total_votos) * 100;

        System.out.println("Total de votos: " + total_votos);
        System.out.println();
        System.out.println("Candidato A: " + votos_uno + " votos " + " (" + porcentaje_uno + "%)");
        System.out.println("Candidato B: " + votos_dos + " votos " + " (" + porcentaje_dos + "%)");
        System.out.println("Candidato C: " + votos_tres + " votos " + " (" + porcentaje_tres + "%)");

        System.out.println();
        System.out.print("Resultado: ");

        if (porcentaje_uno > porcentaje_dos && porcentaje_uno > porcentaje_tres){
            System.out.println("Ha ganado el candidato A.");
        }

        else if (porcentaje_dos > porcentaje_uno && porcentaje_dos > porcentaje_tres){
            System.out.println("Ha ganado el candidato B.");
        }

        else if (porcentaje_uno > porcentaje_dos && porcentaje_tres > porcentaje_dos){
            System.out.println("Ha ganado el candidato C.");
        }

        else if (porcentaje_uno == porcentaje_dos && porcentaje_uno == porcentaje_tres){
            System.out.println("Se ha producido un empate entre los tres candidatos.");
        }

        else if (porcentaje_uno == porcentaje_dos){
            System.out.println("Empate entre el Candidato A y Candidato B.");
        }

        else if (porcentaje_uno == porcentaje_tres){
            System.out.println("Empate entre el Candidato A y Candidato C.");
        }

        else if (porcentaje_dos == porcentaje_tres){
            System.out.println("Empate entre el Candidato B y Candidato C.");
        }

        scanner.close();
    }
}