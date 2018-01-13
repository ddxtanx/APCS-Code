package chap56;

public class Prime {

        public static boolean isPrime(int n)
        {
            if(n==2){
                return true;
            }
            for(int x = 2; x<n; x++){
                if(n%x == 0){
                    return false;
                }
            }
            return true;


        }


}
