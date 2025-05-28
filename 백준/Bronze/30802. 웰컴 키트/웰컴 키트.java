import java.util.*;

public class Main {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int party = Integer.parseInt(sc.nextLine());
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int tMin = sc.nextInt();
        int pMin = sc.nextInt();

        int tSum = 0;
        int pSum = 0;

        for (int i = 0; i < arr.length; i++) {
            tSum+=(int)Math.ceil((double)arr[i]/tMin);
        }


        System.out.println(tSum);
        System.out.println(party / pMin + " " + (party - pMin * ((int)party / pMin)));
    }

}