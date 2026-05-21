package org.example;

public class PalindromeNumber {

    static void main() {
        System.out.println(PalindromeNumber.isPalindrome(1000000001));
    }

    public static boolean isPalindrome(int x) {
        if(x<0)
            return false;
        else if(x<10)
            return true;
        else{
            boolean notCompleted= true;
            Long y = 1l;
           while(notCompleted){
               if(x>y){
                   y = y*10;
               }else{
                   y= y/10;
                   notCompleted = false;
               }
           }

           do{
               if(x%10 != x/y){
                   return false;
               }else{
                   x = x%y.intValue();
                   x = x/10;
                   y = y/100;
               }
           }while(y>=10);

        }
        return true;
    }
}
