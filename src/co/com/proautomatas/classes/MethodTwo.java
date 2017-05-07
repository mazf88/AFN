package co.com.proautomatas.classes;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

/**
 * Class that has the two method, in which the output shows step by step
 * the evolution of the States in the processed string.
 * @author mazapatafr
 */
public class MethodTwo {
    
    public void methodTwo() throws IOException {
        
        Util util = new Util();
        //each line in the file that contains the definition of the automaton is obtained
        List<String> file = util.getFileWithDefinition();
        //you get each line of the file that contains the strings to be tested by the Automat
        List<String> test = util.getFileWithTest();
        
        HashMap<String,String> states = new HashMap<>();
        HashMap<String,String> words = new HashMap<>();
        HashMap<String,String> end = new HashMap<>();
        //transition matrix
        String[][] matrix = null;
        //Creates instance of AFD
        Afn automato = new Afn();
        
        
        try (FileWriter fileResponse = util.getFileForWriteResultMethodTwo()) {
            //The result of the test is written in file
            PrintWriter response = new PrintWriter(fileResponse);
            
            for(int line = 0; line < file.size();line++){
                int i;
                
                if(line == 0){
                    String[] split = file.get(line).split(" ");
                    for(i =0;i < split.length;i++){
                        System.out.println("agregando estado: " + split[i]);
                        response.printf("agregando estado: " + split[i] +"%n");
                        states.put(split[i],String.valueOf(i));
                    }
                }
                
                else if(line == 1){
                    String[] split = file.get(line).split(" ");
                    for(i =0;i < split.length;i++){
                        System.out.println("agregando simbolo: " + split[i]);
                        response.printf("agregando simbolo: " + split[i] +"%n");
                        words.put(split[i],String.valueOf(i));
                    }
                    matrix = new String[states.size()][words.size()];
                }
                
                else if(line > 1 && line <file.size()-2){
                    String[] split = file.get(line).split(" ");
                    for(i =0;i < split.length;i++){
                        System.out.println("Fila: "+(line-2)+ " columna: "+i+" add: " +split[i]);
                        response.printf("Fila: "+(line-2)+ " columna: "+i+" add: " +split[i] +"%n");
                        matrix[line-2][i] = split[i];
                    }
                }
                
                else if(line == file.size()-2){
                    automato.setNextState(file.get(line));
                    automato.setInitialSate(file.get(line));
                }
                
                else if(line == file.size()-1){
                    String[] split = file.get(line).split(" ");
                    for(i =0;i < split.length;i++){
                        System.out.println("Estados finales: " + split[i]);
                        response.printf("Estados finales: " + split[i] +"%n");
                        end.put(split[i],String.valueOf(i));
                    }
                }
            }
            
            for(int line = 0; line < test.size();line++){
                String[] split = test.get(line).split(" ");
                for (String split1 : split) {
                    automato.setNextState(matrix[Integer.parseInt(states.get(automato.getNextState()))][Integer.parseInt(split1)]);
                    System.out.println("Del estado " + automato.getInitialSate() + " procesando el simbolo : "+split1+" pasó al estado: "+ automato.getNextState());
                    response.printf("Del estado " + automato.getInitialSate() + " procesando el simbolo : "+split1+" pasó al estado: "+ automato.getNextState() +"%n");
                }
                if(end.get(automato.getNextState()) == null){
                    response.printf("La palabra NO fue aceptada, el estado "+automato.getNextState()+" no es estado de aceptación. "+"%n");
                    System.out.println("La palabra NO fue aceptada, el estado "+automato.getNextState()+" no es estado de aceptación.");
                }
                else{
                    String string = "";
                    for (String split1 : split) {
                        String word = split1;
                        string = string + word ;
                    }
                    response.printf("Linea "+(line+1)+": "+"La palabra "+string+", fue aceptada%n");
                    System.out.println("Linea "+(line+1)+": "+"La palabra "+string+", fue aceptada");
                }
                automato.setNextState(automato.getInitialSate());
            }
        }catch(IOException exception){
            exception.printStackTrace();
        }
    }
}
