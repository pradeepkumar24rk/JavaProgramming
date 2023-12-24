//An Automorphic number is a number whose square “ends” in the same digits as the number itself. Examples: 5*5 = 25, 6*6 = 36, 25*25 = 625

package NumberBasedProblems;

public class AutoMorphicNumber {
    public static void main(String[] args) {
        int n=5;
        int squareNumber=n*n;
        System.out.println(n==squareNumber%10?"True" :"False");
    }
}
