package math;

class Math {

    public static void main(String[] args) {  

    //Use the // to create single line comments to either add info or to take out code for debugging

    System.out.println("Hello world!");

    //We will be using System.out.println and System.out.print throughout the year. Try using both below to see what the difference is!






    //ANSWER:



    //Throughout the year this year we will need to store information. For that we will be using VARIABLES!

    //Java is an Object-Oriented programming language. All variables we use this year will either be OBJECTS or PRIMITIVES

    //There are 8 primitives in Java: int, byte, short, long, float, double, boolean, char

    //For AP we need to know: int, double, boolean

    //List examples of the types below and give definition
    //int (integer): a thing use to store whole number without any decimal points
    //double: numbers with decimals
    //boolean: can hold two values, which are true and false.

    //For now we are just going to work with primitive

    //Create 3 variables of each of the above types (USE GOOD CODING PRACTICE WHEN CREATING THE VARIABLES
    boolean negative = false;

    int  num1 = 100;

    double num2 = 19.72;




    //MATH TIME!

    //What are the math operators that we can use?
    //+ - * / %

    //Try doing some math operations with numbers. How can we check to see if the math worked?
    int num3 = 5;
    int num4 = 10;
    int product = num3*num4;
        
        
    //Create codes that will print the following:

    //Odd integers from 1 to 100, inclusive of both:
    int sum = 0; 
    for(int i = 1; i <= 100; i++)
      if (i % 2 !=0 ) sum += i; // sum = sum + i;



    //All multiples of 3 from 1 to 100

    for(int i = 1; i <= 100; i++)
            
            if (i % 3 == 0)
                System.out.println(i);





    //Starting at 1000, print on the same line (with a - [hypthen] between each) all of the numbers that end in 0 going down to 0
    for (int i = 1000; i >= 0; i -= 10) {
            System.out.print(i);
            if (i > 0) { // Avoid printing a hyphen after the last number (0)
                System.out.print("-");}}

            }}

