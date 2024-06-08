import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class EncontrarMinMax {

    public static int[] encontrarMinMax(ArrayList<Integer> arr) {
        if (arr == null || arr.size() == 0) {
            throw new IllegalArgumentException("El arreglo no puede ser nulo o estar vacío");
        }
        
        int minimoGlobal, maximoGlobal;
        int n = arr.size();

        // Inicializar mínimo y máximo
        if (n % 2 == 0) {
            minimoGlobal = Math.min(arr.get(0), arr.get(1));
            maximoGlobal = Math.max(arr.get(0), arr.get(1));
            for (int i = 2; i < n; i += 2) {
                int minimoLocal = Math.min(arr.get(i), arr.get(i + 1));
                int maximoLocal = Math.max(arr.get(i), arr.get(i + 1));
                if (minimoLocal < minimoGlobal) {
                    minimoGlobal = minimoLocal;
                }
                if (maximoLocal > maximoGlobal) {
                    maximoGlobal = maximoLocal;
                }
            }
        } else {
            minimoGlobal = maximoGlobal = arr.get(0);
            for (int i = 1; i < n - 1; i += 2) {
                int minimoLocal = Math.min(arr.get(i), arr.get(i + 1));
                int maximoLocal = Math.max(arr.get(i), arr.get(i + 1));
                if (minimoLocal < minimoGlobal) {
                    minimoGlobal = minimoLocal;
                }
                if (maximoLocal > maximoGlobal) {
                    maximoGlobal = maximoLocal;
                }
            }
            if (arr.get(n - 1) < minimoGlobal) {
                minimoGlobal = arr.get(n - 1);
            }
            if (arr.get(n - 1) > maximoGlobal) {
                maximoGlobal = arr.get(n - 1);
            }
        }

        return new int[] {minimoGlobal, maximoGlobal};
    }

    public static void main(String[] args) {
        Random random = new Random();
        int n = 10; // Ejemplo de tamaño
        ArrayList<Integer> arr = new ArrayList<>(n);
        
        for (int i = 0; i < n; i++) {
            arr.add(random.nextInt(100)); // Agregar números aleatorios entre 0 y 99
        }

        System.out.println("Arreglo: " + arr);
        int[] minMax = encontrarMinMax(arr);
        System.out.println("Mínimo: " + minMax[0] + ", Máximo: " + minMax[1]);
    }
}
