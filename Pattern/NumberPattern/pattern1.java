package Pattern.NumberPattern;
public class pattern1
{
    public static void main(String[]args)
    {
        String s="";
        for(int i=1;i<=7;i++)
        {
            s+=i;
            System.out.println(s);
        }
        for(int i=1;i<=s.length();i++)
            System.out.println(s.substring(0,s.length()-i));
    }
}

//output
// 1
// 12
// 123
// 1234
// 12345
// 123456
// 1234567
// 123456
// 12345
// 1234
// 123
// 12
// 1