class pattern1
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