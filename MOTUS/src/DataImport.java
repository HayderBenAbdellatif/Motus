
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author HAYDER
 */
public class DataImport {
    private static String Dict="mot.txt";

     public static String  importermot(int n) {
         
     
        try {
            List<String> listeMots = new ArrayList<>();
            Scanner sc;
            sc = new Scanner(new File(Dict));
            while (sc.hasNextLine()) {
                String ligne = sc.nextLine();
                String[] Data = ligne.split("#");

               for (String s : Data){
                   if(n==s.length())
           
                listeMots.add(s);
            }
            }
               
         Random rand = new Random(); 
  
     
        int i = rand.nextInt(listeMots.size()); 
               sc.close();
               
                return listeMots.get(i);
            
        } catch (FileNotFoundException ex) {
            System.out.println("vérifier votre fichier !" + ex.getMessage());
            
        }
        return null;

    }

    
}
