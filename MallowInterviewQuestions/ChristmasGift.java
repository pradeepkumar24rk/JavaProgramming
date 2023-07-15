import java.util.*;

public class ChristmasGift {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }
        int totalGifts = sc.nextInt();
        String firstKid = sc.next();
        String secondKid = sc.next();
        sc.close();
        
        
        int firstKidIndex = -1;
        int secondKidIndex = -1;
        for (int i = 0; i < n; i++) {
            if (names[i].equals(firstKid)) {
                firstKidIndex = i;
            }
            if (names[i].equals(secondKid)) {
                secondKidIndex = i;
            }
        }

        boolean clockwise;
        if ((firstKidIndex + 2) % n == secondKidIndex) {
            clockwise = true;
            System.out.println("Clockwise");
        } else {
            clockwise = false;
            System.out.println("Anti-Clockwise");
        }

        int[] giftCount = new int[n];
        giftCount[firstKidIndex]++;
        giftCount[secondKidIndex]++;
        totalGifts -= 2;

        int currentKidIndex = secondKidIndex;
        while (totalGifts > 0) {
            if (clockwise) {
                currentKidIndex = (currentKidIndex + 2) % n;
            } else {
                currentKidIndex -= 2;
                if (currentKidIndex < 0) {
                    currentKidIndex += n;
                }
            }
            giftCount[currentKidIndex]++;
            totalGifts--;
        }

        int maxGifts = 0;
        for (int i = 0; i < n; i++) {
            maxGifts = Math.max(maxGifts, giftCount[i]);
        }
        
        if(clockwise)
            for (int i = 0; i < n; i++) {
                if (giftCount[i] == maxGifts) {
                    System.out.println(names[i] + "-" + maxGifts);
                }
            }
        else
            for (int i = n-1; i > 0; i--) {
                if (giftCount[i] == maxGifts) {
                    System.out.println(names[i] + "-" + maxGifts);
                }
            }
            

        System.out.println(names[currentKidIndex]);
    }
   
}


// input

// 5
// nick
// joe
// john
// noah
// doman
// 13
// doman
// john

// output

// Anti-Clockwise
// nick-3
// john-3
// doman-3
// nick
