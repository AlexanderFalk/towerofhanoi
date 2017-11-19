import java.util.Scanner;
import java.util.Stack;

public class Main {

    private static int PLATES;

    private static Stack<String>[] TOWER = new Stack[4];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TOWER[1] = new Stack<>();
        TOWER[2] = new Stack<>();
        TOWER[3] = new Stack<>();
         /* Accepting number of disks */
        System.out.println("Enter number of disks");
        int num = scan.nextInt();
        PLATES = num;
        build(num);
    }

    public static void build(int n)
    {
        String disks = "";
        for (int i = 0; i < n; i++) {
            disks += "##";
        }
        System.out.println(disks);
        for (int d = 0; d < n; d++)
        {
            disks = disks.substring(0, n - d);
            TOWER[1].push(disks);

        }

        animate();
        move(PLATES, 1, 2, 3);
    }


    private static void move(int numberOfdisks, int source, int auxiliary, int target) {

        if (numberOfdisks > 0) {

            move(numberOfdisks -1, source, target, auxiliary);
            String temp = TOWER[source].pop();
            TOWER[target].push(temp);
            animate();
            move(numberOfdisks-1, auxiliary, source, target);

        }
    }

    private static void animate() {
        System.out.println(String.format("%-10s | %-10s | %-10s ", "SOURCE", "AUXILIARY", "TARGET"));
        System.out.println("--------------------------------------");
        for (int i = PLATES - 1; i >= 0 ; i--) {
            String disk1 = " ", disk2 = " ", disk3 = " ";
            try {
                disk1 = TOWER[1].get(i);
            }catch (Exception e){}

            try {
                disk2 = TOWER[2].get(i);
            }catch (Exception e){}

            try {
                disk3 = TOWER[3].get(i);
            }catch (Exception e){}
            System.out.println(String.format("%-10s | %-10s | %-10s ", disk1, disk2, disk3));
        }
        System.out.println("\n");
    }
}
