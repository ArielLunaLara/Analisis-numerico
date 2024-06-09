import java.util.ArrayList;
import java.util.Scanner;

public class MinNumbersFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el tamaño del ArrayList: ");
        int n = scanner.nextInt();
        
        ArrayList<Integer> arrayList = new ArrayList<>();
        System.out.println("Ingrese los elementos del ArrayList:");
        for (int i = 0; i < n; i++) {
            arrayList.add(scanner.nextInt());
        }
        
        System.out.print("Ingrese el valor de m: ");
        int m = scanner.nextInt();

        ArrayList<Integer> minNumbers = encontrarMenores(arrayList, m);

        System.out.println("Los " + m + " números más pequeños son: " + minNumbers);

        scanner.close();
    }

    public static ArrayList<Integer> encontrarMenores(ArrayList<Integer> arrayList, int m) {
        ArrayList<Integer> minNumbers = new ArrayList<>();
        
        for (int num : arrayList) {
            if (minNumbers.size() < m) {
                minNumbers.add(num);
            } else {
                int maxIndex = 0;
                for (int i = 1; i < minNumbers.size(); i++) {
                    if (minNumbers.get(i) > minNumbers.get(maxIndex)) {
                        maxIndex = i;
                    }
                }
                if (num < minNumbers.get(maxIndex)) {
                    minNumbers.set(maxIndex, num);
                }
            }
        }

        return minNumbers;
    }
}
