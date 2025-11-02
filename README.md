# Chuleta de Java: Conceptos Básicos

Resumen de los conceptos fundamentales de Java extraídos de ejercicios prácticos, ideal para consultas rápidas.

## 1. Estructura Básica de un Programa

Todo programa en Java necesita una estructura mínima para funcionar.

### `import`
Permite usar clases ya existentes de Java. Siempre va al principio del archivo.
```java
import java.util.Scanner; // Para leer datos del teclado
import java.util.Random;  // Para generar números aleatorios
import java.text.DecimalFormat; // Para formatear números decimales java
```
`public class NombreClase`


Es el contenedor principal de tu programa. El nombre del fichero .java debe coincidir con NombreClase.

```java
public class Ejercicio2 {
    // ... aquí va el resto del código
}
```

`public static void main(String[] args)`
Es el punto de entrada del programa. El código dentro de este método es lo primero que se ejecutará.

```Java
public static void main(String[] args) {
    // Tu programa empieza aquí
}
```
## 2. Variables y Tipos de Datos
Las variables son contenedores para guardar información. Cada una tiene un tipo de dato específico.
`int`: Para números enteros.
```java
int numero_usuario = 0;
```
`float`: Para números decimales (precisión simple). Se debe añadir una f al final del número.

```Java
float precioManzana = 1.5f;
```
`double`: Para números decimales con mayor precisión.

```Java
double lectura_inicial = 1.0d;
```
`char`: Para un único carácter. Se usan comillas simples ' '.

```Java
char fidelizado = 'S';
```
`boolean`: Para valores de verdadero (true) o falso (false).

```Java
boolean programa_terminado = false;
```
## 3. Leer Datos del Teclado (Clase Scanner)
Para que el programa sea interactivo, se utiliza la clase Scanner.
Crear el `Scanner`: Se instancia una sola vez, normalmente al principio del `main`.

```Java
Scanner teclado = new Scanner(System.in);
```
Leer datos: Se usa el método correspondiente al tipo de dato esperado.
`teclado.nextInt();` (para `int`)
`teclado.nextDouble();` (para `double`)
`teclado.nextLine().charAt(0);` (para `char`)
Cerrar el `Scanner`: Al final del programa, es una buena práctica liberar los recursos.

```Java
teclado.close();
```
Limpiar el buffer: Después de leer un número (`nextInt()`, `nextDouble()`, etc.), si se va a leer texto o un `char`, es necesario consumir el salto de línea residual.
```Java
int opcionUsuario = teclado.nextInt();
teclado.nextLine(); // Limpia el buffer
char fidelizado = teclado.nextLine().charAt(0);
```

## 4. Condicionales (Tomar Decisiones)
Permiten ejecutar diferentes bloques de código según si se cumple una condición.

### Estructuras Condicionales (`if`, `else if`, `else`)

`if`: Ejecuta el código si la condición es verdadera.

```Java
if (numero > max) {
    max = numero;
}
```
`if-else`: Ejecuta el bloque if si la condición es verdadera; si no, ejecuta el bloque else.

```Java
if (numero % 2 == 0) {
    numero = numero / 2;
} else {
    numero = numero * 3 + 1;
}
```
`if-else if-else`: Encadena múltiples condiciones. Se ejecuta solo el primer bloque cuya condición sea verdadera.

```Java
if (tipoEmpleado == 1) {
    sueldoBase = 1100;
} else if (tipoEmpleado == 2) {
    sueldoBase = 1500;
} else {
    sueldoBase = 1700;
}
```
### Operadores Lógicos: Para combinar condiciones.

`&&` (Y Lógico): Ambas condiciones deben ser verdaderas.

`||` (O Lógico): Al menos una de las condiciones debe ser verdadera.

### El Operador de Módulo (`%`)

Calcula el resto de una división entera.
Ejemplos:
10 % 3 devuelve 1 (porque 10 dividido entre 3 es 3, con un resto de 1).
8 % 2 devuelve 0 (porque 8 es divisible exactamente entre 2).
```java
// Si el resto de dividir entre 2 es 0, el número es par.
if (numero % 2 == 0) {
    System.out.println("El número es par.");
} else {
    System.out.println("El número es impar.");
}
```

## 5. Bucles (Repetir Tareas)
Ejecutan un bloque de código varias veces.
### Bucle `while`
Se repite mientras la condición sea verdadera. Ideal cuando no se sabe el número exacto de iteraciones.
Menú de opciones (control por centinela):

```Java
while (opcionUsuario != 4) {
    // ... pedir y procesar opción
}
```
Validación de datos:

```Java
while (numero <= 0) {
    System.out.println("Error: El número tiene que ser mayor que 0.");
    numero = teclado.nextInt();
}
```
### Bucle `for`
Se usa cuando se conoce el número exacto de iteraciones.

```Java
// for (inicialización; condición; acción por vuelta)
for (int dia = 1; dia <= 7; dia++) {
    System.out.println("Introduzca la temperatura del día " + dia + ":");
    // ...
}
```

## 6. Patrones Comunes en Algoritmos

-   **Contadores**: Variables que se incrementan para contar eventos.
    ```java
    votos_uno++; // Incrementa en 1 el valor de la variable
    ```
-   **Acumuladores**: Variables que suman valores en cada iteración de un bucle.
    ```java
    totalAPagar = totalAPagar + precioCafe;
    ```
-   **Calcular Máximo y Mínimo**: Se inicializan las variables en la primera iteración y luego se comparan y actualizan en las siguientes.
    ```java
    if (dia == 1) {
        temperaturaMinima = temperatura;
        temperaturaMaxima = temperatura;
    }

    if (temperatura > temperaturaMaxima) {
        temperaturaMaxima = temperatura;
    }
    if (temperatura < temperaturaMinima) {
        temperaturaMinima = temperatura;
    }
    ```

## 7. Clases Útiles Adicionales

-   **`Random`**: Para generar números aleatorios.
    ```java
    Random generador = new Random();
    int numeroAleatorio = generador.nextInt(10); // Genera un nº entero entre 0 y 9
    ```
-   **`DecimalFormat`**: Para formatear la salida de números decimales.
    ```java
    DecimalFormat df = new DecimalFormat("#.00"); // Define el formato con dos decimales
    System.out.println("TOTAL: " + df.format(total) + " €");
    ```
-   **Casting (Conversión de tipos)**: Obliga a una variable a comportarse como si fuera de otro tipo. Esencial para divisiones con resultado decimal.
    ```java
    // Si divides dos `int`, el resultado es `int`. Para obtener decimales,
    // uno de los operandos debe ser `float` o `double`.
    float porcentaje = ((float) votos_uno / total_votos) * 100;
    ```
