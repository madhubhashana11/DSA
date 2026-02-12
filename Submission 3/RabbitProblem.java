public class RabbitProblem {

    public static int findSurvivor(int n, int k) {
        if (n == 1)
            return 1;
        else
            return (findSurvivor(n - 1, k) + k - 1) % n + 1;
    }

    public static void main(String[] args) {
        int n = 7;  // number of rabbits
        int k = 3;  // every 3rd rabbit eliminated

        int survivor = findSurvivor(n, k);
        System.out.println("Last surviving rabbit: " + survivor);
    }
}
