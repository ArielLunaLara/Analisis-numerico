import java.util.ArrayList;

public class SubsetsOfSize4 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8}; //Aqui podemos modificar el tamano de entrada
        
        System.out.println("Subconjuntos de tamaño 4:");
        printSubsetsOfSizeK(nums, 4);
    }

    public static void printSubsetsOfSizeK(int[] nums, int k) {
        if (nums.length < k) {
            System.out.println("El conjunto debe tener al menos 4 elementos.");
            return;
        }
        
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        generateSubsets(nums, k, 0, new ArrayList<Integer>(), subsets);
        
        for (ArrayList<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }

    private static void generateSubsets(int[] nums, int k, int start, 
    ArrayList<Integer> current, ArrayList<ArrayList<Integer>> subsets) {
        if (current.size() == k) {
            subsets.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            generateSubsets(nums, k, i + 1, current, subsets);
            current.remove(current.size() - 1);
        }
    }
}
    