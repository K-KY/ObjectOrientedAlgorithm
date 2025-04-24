import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        int participants = in.nextInt();
        List<Staff> staffs = new ArrayList<>();
        double cut = total * 0.05;
        for (int i = 0; i < participants; i++) {
            String line = in.next();
            int score = in.nextInt();
            if (score >= cut) {
                staffs.add(new Staff(line, score));
            }
        }

        for (int i = 0; i < 14; i++) {
            Staff staff = staffs.stream()
                    .max(Comparator.comparingDouble(s -> s.getStaffItem(0))).get();
            staff.upScore();
            staff.popStaffItem();
        }
        staffs
                .stream()
                .sorted(Comparator.comparingInt((Staff::getStaffNameToInt)))
                .forEach(s -> System.out.println(s.getStaffName() + " " + s.getScore()));
    }
}

class Staff {
    private final String staffName;
    private final int staffScore;
    private final List<Double> staffItems = new ArrayList<>();
    private int score;

    public Staff(String staffName, int staffScore) {
        this.staffName = staffName;
        this.staffScore = staffScore;
        calculateItems(staffItems);
    }

    private void calculateItems(List<Double> staffItems) {
        for (int i = 1; i <= 14; i++) {
            staffItems.add(Math.ceil((double) staffScore / i));
        }
    }

    public int getScore() {
        return score;
    }

    public double popStaffItem() {
        if (staffItems.isEmpty()) {
            return 0.0;
        }
        return staffItems.remove(0);
    }

    public double getStaffItem(int index) {
        return staffItems.get(index);
    }

    public void upScore() {
        score++;
    }

    public int getStaffNameToInt() {
        return staffName.charAt(0);
    }

    public String getStaffName() {
        return staffName;
    }
}
