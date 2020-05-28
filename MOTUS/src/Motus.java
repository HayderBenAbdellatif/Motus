
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 */

public class Motus {
     
    public static void main(String[] args) {

        String ANSI_RESET = "\u001B[0m";
        String ANSI_BLACK = "\u001B[30m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_PURPLE = "\u001B[35m";
        String ANSI_CYAN = "\u001B[36m";
        String ANSI_WHITE = "\u001B[37m";

        System.out.println(ANSI_RED + "___MOTUS___ " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "LES INSTRUCTIONS DU JEU SONT : " + ANSI_RESET);
        System.out.println("Si La lettre est en" + ANSI_RED + " ROUGE " + ANSI_RESET + "cela indique qu'elle est n'existe pas dans ce mot");
        System.out.println("Si La lettre est en" + ANSI_GREEN + " VERT " + ANSI_RESET + "cela indique qu'elle est bien placée");
        System.out.println("Si La lettre est en" + ANSI_YELLOW + " JAUNE " + ANSI_RESET + "cela indique qu'elle existe dans ce mot mais elle est mal placée");
        System.out.println(ANSI_BLUE + "Le jeu commence maintenant. Bonne chance ! " + ANSI_RESET);

        //l'importation du mot à deviner de fichier
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
      
        int n;
         
        System.out.println("veuillez saisir le nombre des lettres : ");
        
        n = sc.nextInt();
        
       
        DataImport data = new DataImport();
        
        String mdv = data.importermot(n);
        

        mdv = mdv.toUpperCase();

        System.out.println("Indication : La première lettre du mot a deviner est :   " + ANSI_GREEN + mdv.charAt(0) + ANSI_RESET);
        boolean test = false;
        String ligne;
         int v =0;
        //déroulement du jeu en "n-1" tour au maximum
        for (int j = 1; j < n; j++) {

            String ch = "";
            System.out.println("L'essai num :  " + j + "   .Veuillez entrer votre prédiction pour le mot : ");
            //lecture du mot entré par le joueur
            ligne = sc1.nextLine();
            ligne = ligne.toUpperCase();
            int score=0;
            if (!ligne.equals(mdv) ) {
                if (mdv.length() == ligne.length()) {

                    ch = "";

                    for (int i = 0; i < n; i++) {

                        if (mdv.contains(Character.toString(ligne.charAt(i)))) {
                            if (mdv.charAt(i) == ligne.charAt(i)) {

                                ch = ch + ANSI_GREEN + ligne.charAt(i) + ANSI_RESET;
                                
                            } else {

                                ch = ch + ANSI_YELLOW + ligne.charAt(i) + ANSI_RESET;
                                
                            }

                        } else {
                            ch = ch + ANSI_RED + ligne.charAt(i) + ANSI_RESET;
                          
                        }
                          
                    }

                } else {
                    System.out.println("Attention ! Merci de taper un mot de longueur " + mdv.length());
                    j = j - 1;
                }
                System.out.println(ch);
            }
           else {
                System.out.println(ANSI_BLUE + "BRAVO , vous avez trouvez le mot : " + ANSI_GREEN + mdv + ANSI_RESET);
                test = true;
                
                break;
            }
        }
        if (!test) {
            System.out.println(ANSI_RED + "Game Over ! " + ANSI_RESET);
     
        }
    }

}
