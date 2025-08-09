import java.util.*;

public class Calculator {
    public static void main(String[] args){
        double num2 = 0;
        Scanner sc = new Scanner(System.in);
        String Operation;
        

        do{
            System.out.print("Enter the number : ");
            Double num1 = sc.nextDouble();
            sc.nextLine();
            System.out.print("Operations are : +, -, *, /, ^, sqrt, ln and enter 'close' to close the calculator. \nEnter the operation: ");
            Operation = sc.nextLine();

            if(!Operation.equals("ln") && !Operation.equals("sqrt") && !Operation.equals("close")){
                System.out.print("Enter the next number : ");
                num2 = sc.nextDouble();
                System.out.println();
            }
            switch (Operation) {
                
                case "+":
                    System.out.println("sum of " + num1 + ", " + num2 + " = " + (num1+num2));
                    break;

                case "-":
                System.out.println( num1 + " - " + num2 + " = " + (num1-num2));
                    break;

                case "*":
                System.out.println( num1 + " * " + num2 + " = " + (num1*num2));
                    break;
                
                case "^":
                System.out.println(num1 +" ^ " + num2 +" = " + Math.pow(num1, num2));
                break;

                case "/":
                    if(num2 != 0){
                        System.out.println( num1 + " / " + num2 + " = " + (num1/num2));
                        break;
                    }else{
                        System.out.println("Can't divide by zero");
                        break;
                    }
                
                case "sqrt":
                System.out.println("Square root of "+ num1 + " is :" + Math.sqrt(num1));
                    break;

                case "ln":
                    if(num1 >0){
                        System.out.println("ln(" + num1 + ") = " + Math.log(num1));
                        break;
                    }else{
                        System.out.println("Can't use ln on zero or negative number");
                        break;
                    }

                case "close":
                    System.out.println("Phir milenge chalte chalte..!!");
                    break;
                
                default:
                    System.out.println("Dekh raha hai Binod! Kaise ulta seedha operation daalke calculator ko paresaan kar rahe hai ..!");
                    break;
            }
        }
        while(!Operation.equals("close"));

        sc.close();
    }
}
