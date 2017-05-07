package co.com.proautomatas.classes;

import java.io.IOException;
import java.util.Scanner;

/**
 * Main Class responsible, carry the program with two options.
 * @author mazapatafr
 */
public class Main {
    
    static Scanner scanner = new Scanner(System.in); //Serves to collect text by console
    static int select = -1; //choice of the user
    static int num1 = 0, num2 = 0; //Variables
    
    /**
     * Main Class responsible, carry the program with two options.
     * @author mazapatafr
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        //While the option chosen is 0, we asked to the user
        while(select != 0){
            
            //Try catch to prevent completion of the program if there is an error
            try{
                System.out.println("Bienvenido al programa de lectura y validacion de AFD, por favor seleccione:\n"
                        + "\n1) Salida Sencilla" +
                        "\n2) Salida con paso a paso\n" +
                        "0) Salir");
                //Pick up a variable by console
                select = Integer.parseInt(scanner.nextLine());
                
                //Show a newline
                System.out.println("\n");
                
                //Switch for choice
                switch(select){
                    case 1:
                        MethodOne methodOne = new MethodOne();
                        methodOne.methodOne();
                        break;
                    case 2:
                        MethodTwo methodTwo = new MethodTwo();
                        methodTwo.methodTwo();
                        break;
                    default:
                        System.out.println("Ha salido del programa de validacion de cadenas para AFD");
                        break;
                }
                
                System.out.println("\n");
                
            }catch(NumberFormatException | IOException e){
                System.out.println("Uoop! Error!");
            }
        }
    }
}

