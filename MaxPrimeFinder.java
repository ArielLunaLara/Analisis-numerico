import java.util.ArrayList;
import java.util.Scanner;

public class MaxPrimeFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el tamaño del ArrayList: ");
        int n = scanner.nextInt();
        
        ArrayList<Integer> arrayList = new ArrayList<>();
        System.out.println("Ingrese los elementos del ArrayList:");
        for (int i = 0; i < n; i++) {
            arrayList.add(scanner.nextInt());
        }
        
        int maxPrime = encontrarMaxPrime(arrayList);

        System.out.println("El número primo más grande es: " + maxPrime);

        scanner.close();
    }

    public static int encontrarMaxPrime(ArrayList<Integer> arrayList) {
        int maxPrime = -1;

        for (int num : arrayList) {
            if (esPrimo(num) && num > maxPrime) {
                maxPrime = num;
            }
        }

        return maxPrime;
    }

    public static boolean esPrimo(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

