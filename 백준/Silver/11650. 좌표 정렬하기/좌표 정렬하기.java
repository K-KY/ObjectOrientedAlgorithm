import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        
        List<Coordinate> cdt = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            cdt.add(new Coordinate(sc.nextInt(), sc.nextInt()));
        }
        
        cdt.sort(Comparator.comparingInt(Coordinate::getX).thenComparingInt(Coordinate::getY));
        
        
        for (int i = 0; i < cdt.size(); i++) {
            Coordinate coord = cdt.get(i);
            System.out.println(coord.getX() + " " + coord.getY());
        }
        
        
    }
}

class Coordinate {
    private final int x;
    private final int y;
    
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY() {
        return y;
    }
}