public class Calendar {
    public static void main(String[] args) {
        
    }
}


/*

Explaination:

0 - sunday
1 - monday
2 - tuesday
3 - wednesday
4 - thursday
5 - friday
7 - saturday

ODD DAYS:
No. of days cannot form a week is called odd days
To find odd days = ndays%7

365 days -> 52 weeks + 1 day       (Here 1 day is a odd day)
366 days -> 52 weeks + 2 days      (Here 2 days is a odd day) 


years  no.of odd days       
100 - 5 days             
200 - 3 days
300 - 1 days
400 - 0 days

Feb last day = (date/month) ==> 4/4, 6/6, 8/8,10/10,
                                12/12,9/5,11/7,7/11,7/3
                                jan - 3(nonleap) and 4(leap)
                                
eg: if feb 28 - friday
    april 4 - friday
    june 6 - friday
    
Example: 15/08/1947
Step 1: find the refrence date
        1947%4 - not leap year
        
        28/02/1947 --- this is the refrence date
        28%7 = 0 odd days
        month 1 has 31 days(31%7) = 3 odd days
        
Step 2: Find the no. of odd days in Previous year
        1946 -> (1900+46)
                1900 - 400+400+400+400+300 (find odd day for the year which are splited)
                        0 + 0 + 0 + 0 + 1 = 1 odd day
                
                46/4 = 11 leapYear 
                       (46-11) = 35 non leap year
                
                        11 leap year has (11*2)     = 22 odd days
                        35 non leap year has (35*1) = 35 odd days
                                                    ---------------
                                                    = 57 odd days
                                                    ---------------
                                                    
                        57%7 = 1 odd day

Step 3: Add all the odd days
        
        0 + 3 + 1 + 1 = 5 ------> friday
    
Hence the Refrence date 28/02/1947 - friday
        08/08/1947 - friday
        
        08+07(1 week) = 15
        
        15/08/1947 - friday
                                             
*/  