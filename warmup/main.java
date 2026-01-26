package warmup;

public class main {
     public static void main(String[] args){
    //problem number 1
int sum = 0;
for(int i = 1; i < 1000;i++) {
  if((i % 3 == 0)||(i % 5 == 0)) {
    sum += i;
  } 
          System.out.print(sum + " ");
  }
}
}