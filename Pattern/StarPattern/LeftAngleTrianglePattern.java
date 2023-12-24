package Pattern.StarPattern;

public class LeftAngleTrianglePattern {
    public static void main(String[] args) {
        int n = 10;
        for(int i=1;i<=n;i++) {
             for(int j = 1;j<i;j++){
                System.out.print("  ");
            }
            for(int j=i;j<=n;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
