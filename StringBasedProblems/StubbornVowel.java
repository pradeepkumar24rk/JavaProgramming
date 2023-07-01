package StringBasedProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StubbornVowel {

    static String substring(char[] c, int i, int j) {
        String s = "";
        for (int k = i; k < j; k++)
            s += c[k];
        return s;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = "missingword";
        char c[] = s.toCharArray();
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<String>();
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        int i = 0;
        while (i < c.length - 1) {
            int j = i + 1;
            if (c[i] != 'a' && c[i] != 'e' && c[i] != 'i' && c[i] != 'o' && c[i] != 'u') {
                while (j < c.length && c[j] != 'a' && c[j] != 'e' && c[j] != 'i' && c[j] != 'o' && c[j] != 'u')
                    j++;
                String sub = substring(c, i, j);
                list.add(sub);
                if (j < c.length) {
                    list2.add(String.valueOf(c[j]));
                    list3.add(j);
                }
            } else {
                list2.add(String.valueOf(c[i]));
                list3.add(i);
                i++;
            }
            i = j + 1;
        }

        System.out.println(list);
        System.out.println(list2);
        System.out.println(list3);

        // int k=0,l=list.size()-1;
        String rk = "";
        // while(k<list.size()){
        // if(!(list.get(k).equals("a") && list.get(k).equals("e") &&
        // list.get(k).equals("i") && list.get(k).equals("o") &&
        // list.get(k).equals("u"))){
        // if(!(list.get(l).equals("a") && list.get(l).equals("e") &&
        // list.get(l).equals("i") && list.get(l).equals("o") &&
        // list.get(l).equals("u"))){
        // rk+=list.get(l);
        // }
        // l--;
        // }
        // else{
        // rk+=list.get(k);
        // }
        // k++;
        // }

        // System.out.println(rk);

        if (list3.get(1) == 0) {
            int u = list.size() - 1, p = 0;
            while (u >= 0) {
                rk += list2.get(p) + list.get(u);
                u--;
                p++;
            }
        } else {
            int u = list.size() - 1, p = 0;
            while (u >= 0) {
                rk += list.get(u);
                if (p < list2.size())
                    rk += list2.get(p);
                u--;
                p++;
            }
        }
        System.out.println(rk);
        sc.close();
    }
}
