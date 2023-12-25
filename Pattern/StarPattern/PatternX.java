package Pattern.StarPattern;

public class PatternX {
    public static void main(String[] args) {
        int n = 7;
        for(int i = 1;i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                    System.out.print(i==j || j==((n+1)-i)?"*": " ");
            }
            System.out.println();
        }
    }
}
// Input
// n = 7    ##input should be old number length

//Output
// *     *
//  *   *
//   * *
//    *
//   * *
//  *   *
// *     *