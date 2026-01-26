package warmup;

public class Main {
     public static void main(String[] args){ //problem number 2(answer might be hard to see but it's rihgt next to @lamegoat950)
   int num1;
   int num2 = 0;
   int num3 = 1;
   for (int i = 0; i < 14; i++) {
            num1 = num2;
           num2 = num3;
          num3 = num1 + num2;

  if(num3 % 2 == 0) {
        int plus = 0;
        plus = plus + num3;
       System.out.print(plus);
   }
}
}
}


