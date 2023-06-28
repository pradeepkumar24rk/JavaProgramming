//output
//tce jo++rpwen

public class ReverseString {
    public static void main(String[] args) {
        String s = "new pr++oject?";
        char ch[] = s.toCharArray();
        int i = 0, j = ch.length - 1;
        while (i < j) {
            if (!((ch[i] >= 'a' && ch[i] <= 'z') || (ch[i] >= 'A' && ch[i] <= 'Z')))
                i++;
            if (!((ch[j] >= 'a' && ch[j] <= 'z') || (ch[j] >= 'A' && ch[j] <= 'Z')))
                j--;
            if (((ch[i] >= 'a' && ch[i] <= 'z') || (ch[i] >= 'A' && ch[i] <= 'Z'))
                    && ((ch[j] >= 'a' && ch[j] <= 'z') || (ch[j] >= 'A' && ch[j] <= 'Z'))) {
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;
                i++;
                j--;
            }
        }
        System.out.println(String.valueOf(ch));
    }
}
