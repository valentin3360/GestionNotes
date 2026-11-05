package gestionnotes;

import java.util.Random;
import java.util.Scanner;

class GestionNotes {

    static final int MAX_TUTEUR = 11;
    
    
    public static void main(String[] args) {

        int[] UE1S1 = remplirTableauAleatoire();
        int[] UE1S2 = remplirTableauAleatoire();
        int[] UE2S1 = remplirTableauAleatoire();
        int[] UE2S2 = remplirTableauAleatoire();
        int[] UE3S1 = remplirTableauAleatoire();
        int[] UE3S2 = remplirTableauAleatoire();

        afficherInfosDesUE(UE1S1, UE1S2, UE2S1, UE2S2, UE3S1, UE3S2);

        
        double[][] moyPEtu = new double[5][3];
        remplirMoy2dAleatoire(moyPEtu);
        boolean[][] absEtu = new boolean[5][3];
        remplirAbsAleatoire(absEtu);
        int[] tuteur = new int[12]; 
        
        
        
        
        choixMenu(UE1S1, UE1S2, UE2S1, UE2S2, UE3S1, UE3S2, moyPEtu, absEtu, tuteur);
        
         
    }

    /**
     * Générer un nombre aléatoire, dans un intervalle donné.
     *
     * @param min la borne inférieure de l'intervalle
     * @param max la borne supérieure de l'intervalle
     * @return le nombre généré
     */
    static int TirageAleatoire(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
/**
 * remplie aléatoirement un tabelau 2D aléatoirement
 * @param moyPEtu 
 */
    static void remplirMoy2dAleatoire(double[][] moyPEtu) {
        for (int i = 0; i < moyPEtu.length; i++) {
            for (int j = 0; j < moyPEtu[i].length; j++) {
                moyPEtu[i][j] = (double) TirageAleatoire(0, 2000) / 100;
            }
        }

    }
    /**
     * on remplis un tableau d'abs de valeur aléatoire
     * 
     */
    static void remplirAbsAleatoire(boolean[][] abs){
        int alea;
      for (int i = 0; i < abs.length; i++) {
            for (int j = 0; j < abs[i].length; j++) {
                alea = TirageAleatoire(0, 100);
                if (alea>50) {
                    abs[i][j] = true;
                } else {
                    abs[i][j] = false;
                }
            }
        }
    }

    /**
     * remplis un tableau de taille aleatoire entre 1 et 10 de nombre aleatoire
     * entre 0 et 20
     *
     * @return
     */
    static int[] remplirTableauAleatoire() {
        int i;
        int[] tab = new int[TirageAleatoire(1, 10)];
        for (i = 0; i < tab.length; i++) {
            tab[i] = TirageAleatoire(0, 20);
        }
        return tab;
    }

    static void choixMenu(int[] UE1S1, int[] UE1S2, int[] UE2S1, int[] UE2S2, int[] UE3S1, int[] UE3S2, double[][] moyPEtu, boolean[][] absEtu, int[] tuteur) {
        int res = quiEstTu();

        switch (res) {
            case 1 ->
                MenuEtu(UE1S1, UE1S2, UE2S1, UE2S2, UE3S1, UE3S2);
            case 2 ->
                MenuDDE(moyPEtu, absEtu, tuteur);
        }
    }

    static void MenuDDE(double[][] moyPEtu, boolean[][] absEtu, int[] tuteur) {
        int rep;

        do {
            System.out.println("""
                                  (1) Informations générales sur les notes et absences
                                  (2) Listing des rattrapages à organiser
                                  (3) Gestion des personnes tutrices
                                  (4) Modification d'une moyenne
                                  (5) Afficher les étudiants maxi
                                  (6) Quitter
                               """);
            rep = lireEntier();
            switch (rep) {
                case 1 -> {
                    
                }
                case 2 -> {
                }
                case 3 -> {
                    System.out.println("vous avez le choix entre 1 et 2 pour plus est moins tutrice");
                    int choix = lireEntier();
                    if(choix == 1){
                        plusTutrice(tuteur);
                    } else if(choix == 2){
                        minusTutrice(tuteur);
                    }
                    
                }
                case 4 -> {
                    modifMoy(moyPEtu);
                    
                }
                case 5 -> {
                        
                }
                case 6 -> {
                    System.out.println("vous avez décider de quitter aurevoir");
                }
                default ->
                    System.out.println("quelque chose d'invalide à été saisie veuille saisir (1,2,3,4,5).");
            }
        } while ((rep > 5 || rep < 1) && rep != 6);
    }

    /**
     * affiche le menu et demandeà l'utilisateur de saisir un appel entre 1 et 5
     */
    static void MenuEtu(int[] UE1S1, int[] UE1S2, int[] UE2S1, int[] UE2S2, int[] UE3S1, int[] UE3S2) {

        int rep;

        do {
            System.out.println("""
                                  1.Afficher les notes d'une UE pour un semestre
                                  2.Statistiques de vos UE
                                  3.Note à obtenir au prochain devoir d'une UE pour avoir la moyenne
                                  4.Afficher si l'année est validée
                                  5.Quitter
                               """);
            rep = lireEntier();
            switch (rep) {
                case 1 -> {
                    afficherNotesUE(UE1S1, UE1S2, UE2S1, UE2S2, UE3S1, UE3S2);
                }
                case 2 -> {
                    afficherInfosDesUE(UE1S1, UE1S2, UE2S1, UE2S2, UE3S1, UE3S2);
                }
                case 3 -> {
                    System.out.println("le numero de l'UE");
                   int  UEn = lireEntier();
                    System.out.println("Le semestre");
                    int UEs = lireEntier();
                   int UE[] = notesUeSem(UEn,UEs, UE1S1, UE1S2, UE2S1, UE2S2, UE3S1, UE3S2);
                    
                    noteObtenir(UE);
                }
                case 4 -> {
                    if (anneeValid(UE1S1, UE1S2, UE2S1, UE2S2, UE3S1, UE3S2)) {
                        System.out.println("vous avez votre année depuis ces notes ");
                    }
                    
                }
                case 5 -> {
                    break;
                }
                default ->
                    System.out.println("quelque chose d'invalide à été saisie veuille saisir (1,2,3,4,5).");
            }
        } while (rep > 5 || rep < 1);
    }

    ///////////////////////////////////////////Partie année valide///////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    static double moyenneDesUE(int[] UE1S1, int[] UE1S2, int[] UE2S1, int[] UE2S2, int[] UE3S1, int[] UE3S2){
        double moyG = 0;
        int[][] listeUE = {UE1S1, UE1S2, UE2S1, UE2S2, UE3S1, UE3S2};  
        for (int i = 0; i < listeUE.length; i++) {
            
                moyG = moyG + moyenne(listeUE[i]);
            
        }
        return moyG;
    }
    
    /**
     * verifie di l'année est valide 
     * @param UE1S1
     * @param UE1S2
     * @param UE2S1
     * @param UE2S2
     * @param UE3S1
     * @param UE3S2
     * @return retourne
     */
    static boolean anneeValid(int[] UE1S1, int[] UE1S2, int[] UE2S1, int[] UE2S2, int[] UE3S1, int[] UE3S2){
        boolean res = true;
        boolean[] verif = new boolean[3];
        verif[0]=UEvalid(UE1S1,UE1S2);
        verif[1]=UEvalid(UE2S1,UE2S2);
        verif[2]=UEvalid(UE3S1,UE3S2);
        int c = 0;
        
        for (int i = 0; i < verif.length; i++) {
            if (verif[i]) {
                c++;
            }
        }
        if(!(c>1)){
            res=false;
        }
        System.out.println("tout tes UE sont validé");
        
        double moyG = moyenneDesUE(UE1S1, UE1S2, UE2S1, UE2S2, UE3S1, UE3S2);
        
        if(moyG < 10){
            res = false;
        }
        return res;
    }
    
    static boolean UEvalid(int[] UES1, int[] UES2){
        boolean res = false;
        
        double moy1 = moyenne(UES1);
        double moy2 = moyenne(UES2);
        double moyG = (moy1+moy2)/2;
        
        if (moyG>10) {
            if (moy1>8 && moy2>10) {
                res=true;
            }
            
            if(moy2>8 && moy1>10){
                res=true;
            }
        } 
        
        
        
        return res;
    }
    /**
     * demande à l'utilisateur de saisir un entier
     *
     * @return
     */
    static int lireEntier() {
        Scanner sc = new Scanner(System.in);
        int saisie = sc.nextInt();
        return saisie;
    }
    
    static double lireReel() {
        Scanner sc = new Scanner(System.in);
        double saisie = sc.nextDouble();
        return saisie;
    }

    /**
     * affiche les notes de l'UE correspondant à l'aide de l'entrée utilisateur
     * pour obtenir l'UE et la sem et de la fonction notesUeSem
     *
     * @param UE1S1
     * @param UE1S2
     * @param UE2S1
     * @param UE2S2
     * @param UE3S1
     * @param UE3S2
     */
    static void afficherNotesUE(int[] UE1S1, int[] UE1S2, int[] UE2S1, int[] UE2S2, int[] UE3S1, int[] UE3S2) {
        int selectUE;
        int selectSem;

        System.out.println("quel UE est concerné");
        selectUE = lireEntier();
        selectSem = lireEntier();

        System.out.print("NOtes de l'UE" + selectUE + "au semestre" + selectSem + ":");
        int[] rep = notesUeSem(selectUE, selectSem, UE1S1, UE1S2, UE2S1, UE2S2, UE3S1, UE3S2);
        for (int i = 0; i < rep.length; i++) {
            System.out.print(rep[i] + " ");
        }
        System.out.println("");
    }

    /**
     * retourne le bon UE selon la semaine et le numéro de l'UE
     *
     * @param Ue
     * @param Sem
     * @param UE1S1
     * @param UE1S2
     * @param UE2S1
     * @param UE2S2
     * @param UE3S1
     * @param UE3S2
     * @return retourne l'UE correspondant au sem et à son numero
     */
    static int[] notesUeSem(int Ue, int Sem, int[] UE1S1, int[] UE1S2, int[] UE2S1, int[] UE2S2, int[] UE3S1, int[] UE3S2) {
        int[] rep = {};
        switch (Ue) {
            case 1 -> {
                switch (Sem) {
                    case 1 ->
                        rep = UE1S1;
                    case 2 ->
                        rep = UE1S2;
                }

            }

            case 2 -> {
                switch (Sem) {
                    case 1 ->
                        rep = UE2S1;
                    case 2 ->
                        rep = UE2S2;
                }

            }

            case 3 -> {
                switch (Sem) {
                    case 1 ->
                        rep = UE3S1;
                    case 2 ->
                        rep = UE3S2;
                }

            }
        }
        return rep;
    }

    /**
     * donne la moyenne des notes
     *
     * @param tab
     * @return return la moyenne des valeurs d'un tableau
     */
    static double moyenne(int[] tab) {
        double moyenne = 0;
        for (int i = 0; i < tab.length; i++) {
            moyenne = moyenne + tab[i];
        }
        return moyenne / tab.length;
    }

    /**
     * retourne le min d'un tableau
     *
     * @param tab
     * @return
     */
    static int min(int[] tab) {
        int min = tab[0];

        for (int i = 0; i < tab.length; i++) {
            if (min > tab[i]) {
                min = tab[i];

            }
        }

        return min;
    }
    
    
    /**
     * return le maximun d'un tableau
     * @param tab
     * @return 
     */
    static int max(int[] tab) {
        int max = tab[0];

        for (int i = 0; i < tab.length; i++) {
            if (max < tab[i]) {
                max = tab[i];
            }
        }

        return max;
    }

    /**
     * affiche les infos des UE avec chaque UE
     * @param UE1S1
     * @param UE1S2
     * @param UE2S1
     * @param UE2S2
     * @param UE3S1
     * @param UE3S2 
     */
    static void afficherInfosDesUE(int[] UE1S1, int[] UE1S2, int[] UE2S1, int[] UE2S2, int[] UE3S1, int[] UE3S2) {
//moyenne(UE1S1), min(UE1S1), max(UE1S1), moyenne(UE1S2), min(UE1S2), max(UE1S2)
        int[] UE = UE1S1;
        double moyUES1 = moyenne(UE);
        double minUES1 = min(UE);
        double maxUES1 = max(UE);
        UE = UE1S2;
        double moyUES2 = moyenne(UE);
        double minUES2 = min(UE);
        double maxUES2 = max(UE);
        System.out.println("""
                                                       S1                  |                      S2
                           ----------------------------------------------------------------------------------------------------""");
        System.out.printf("UE1| moy : %.2f    min : %.2f    max : %.2f \t| moy : %.2f    min : %.0f    max : %.0f \n", moyUES1, minUES1, maxUES1, moyUES2, minUES2, maxUES2);
        UE = UE2S1;
        moyUES1 = moyenne(UE);
        minUES1 = min(UE);
        maxUES1 = max(UE);
        UE = UE2S2;
        moyUES2 = moyenne(UE);
        minUES2 = min(UE);
        maxUES2 = max(UE);
        System.out.printf("UE2| moy : %.2f    min : %.2f    max : %.2f \t| moy : %.2f    min : %.0f    max : %.0f \n", moyUES1, minUES1, maxUES1, moyUES2, minUES2, maxUES2);

        UE = UE3S1;
        moyUES1 = moyenne(UE);
        minUES1 = min(UE);
        maxUES1 = max(UE);
        UE = UE3S2;
        moyUES2 = moyenne(UE);
        minUES2 = min(UE);
        maxUES2 = max(UE);
        System.out.printf("UE2| moy : %.2f    min : %.2f    max : %.2f \t| moy : %.2f    min : %.0f    max : %.0f", moyUES1, minUES1, maxUES1, moyUES2, minUES2, maxUES2);

    }

    /**
     * donne la note à obtenir pour avoir la moyenne grace au prochain ds
     * @param tab 
     */
    static void noteObtenir(int[] tab) {
        double moy = moyenne(tab);
        double noteObtenir = 0;
        int somme = 0;
        if (tab.length == 10) {
            System.out.println("Déjà 10 notes");
        } else {
            noteObtenir = tab.length * 10;
            for (int i = 0; i < tab.length; i++) {
                somme = somme + tab[i];

            }
            noteObtenir = noteObtenir - somme;

            if (noteObtenir > 20) {
                System.out.println("impossible tu n'auras pas la moyenne");

            } else if (noteObtenir <= 0) {
                System.out.println("ne tinquiete pas de cela tu auras la moyenne ");
            } else {
                System.out.println("il va te faloir" + noteObtenir);
            }
        }

    }

    /**
     * message d'erreur
     */
    static void erreur() {
        System.out.println("une valeur invalide à été saisie");
    }

    
    /**
     * on demande de choisir entre le choix 1 est le 2
     * @return 
     */
    static int quiEstTu() {
        int res = 0;

        do {
            System.out.println("Qui es tu ?");
            System.out.println("1) etudiant 2) DDE");
            res = lireEntier();
            if (!(res == 1 || res == 2)) {
                erreur();
            }
        } while (!(res == 1 || res == 2));
        return res;
    }
    
    

    static void affichageDDE(double[][] noteEtu, boolean[][] absEtu) {

        affichageDDENoteEtudiant(noteEtu);
        affichageDDEAbsEtudiant(absEtu);
        affichageDDEmoyEtudiant(noteEtu);

    }

    static void affichageDDENoteEtudiant(double[][] tab) {
        System.out.println("******************** Notes des Etudiants ***************");
        for (int i = 0; i < tab.length; i++) {
            System.out.println("Etudiant" + (i + 1) + "\t");
            for (int j = 0; j < tab[i].length; j++) {
                System.out.println("UE" + (j + 1) + "\t");
                System.out.println(tab[i][j] + "\t");
                System.out.println(" ");

            }
            System.out.println("");
        }

        System.out.println("");
    }

    static void affichageDDEAbsEtudiant(boolean[][] tab) {
        System.out.println("******************** Abscence des Etudiants ***************");
        for (int i = 0; i < tab.length; i++) {
            System.out.println("Etudiant" + (i + 1) + "\t");
            for (int j = 0; j < tab[i].length; j++) {
                System.out.println("UE" + (j + 1) + "\t");
                if (tab[i][j] == true) {
                    System.out.print("o" + "\t");
                } else {
                    System.out.print("x" + "\t");
                }
                System.out.println(" ");

            }
            System.out.println("");
        }

        System.out.println("");
    }

    static void affichageDDEmoyEtudiant(double[][] tab) {
        System.out.println("******************** Moyennes des UE ***************");

        double UE1moy = 0;
        double UE2moy = 0;
        double UE3moy = 0;

        for (int i = 0; i < tab.length; i++) {
            UE1moy = UE1moy + tab[i][0];
        }
        System.out.println("moyenne de l'UE1 : " + UE1moy);

        for (int i = 0; i < tab.length; i++) {
            UE2moy = UE2moy + tab[i][1];
        }
        System.out.println("moyenne de l'UE2 : " + UE2moy);

        for (int i = 0; i < tab.length; i++) {
            UE2moy = UE2moy + tab[i][2];
        }
        System.out.println("moyenne de l'UE3 : " + UE3moy);

    }

    ////////////////////////////////////////////utilitaire///////////////////////////////////////////////////////
    
    static int nombreIntervalle(int min, int max) {
        int res = -1;
        System.out.println("On vous demande de lire un entier entre " + min + "et " + max);
        do {
            res = lireEntier();
        } while (res < min || res > max);

        return res;
    }

    ////////////////////////////////////////////partie tuteur///////////////////////////////////////////////////////
    
    static void modifMoy(double[][] moy){
        int choix;
        int choix2;
        System.out.println("veuilez choisir un etudiant parmis les " + moy.length);
        choix = lireEntier();
        System.out.println("veuilez choisir un etudiant parmis les " + moy.length);
        choix2 = lireEntier();
        for (int i = 0; i < moy.length; i++) {
            for (int j = 0; j < moy[i].length; j++) {
                if (choix == i && choix2 == j) {
                    System.out.println("veuillez modifier la moyenne");
                    moy[i][j] = lireReel();
                }
            }
        }
        System.out.println("fonction bien effectué");
    }
    
    
    static boolean estPresent(int idEtu, int[] tab) {
    
        int c = 0;
        boolean trouve = false;

        while (!trouve && c < tab.length) {
            if (tab[c] == idEtu) {
                trouve = true;
                System.out.println("la personne est déjà tutrice");
            }
            c++;
        }

        return trouve;
    }

    /**
     * La fonction ajoute un utilisateur donner par l'utilisateur à l'aide d'un
     *
     * @param tab
     */
    static void plusTutrice(int[] tab) {

        boolean trouve = false;
        int c = 0;
        int personne;
        boolean present;
        System.out.println("qui voulez vous ajouter ");
        personne = nombreIntervalle(1, 100);
        present = estPresent(personne, tab);
        if (tab[MAX_TUTEUR] != 0) {
            System.out.println("toute les cases du tableau sont remplis");

        } else if (!present) {
            while (c < tab.length && !trouve) {
                if (tab[c] == 0) {
                    tab[c] = personne;
                    trouve = true;
                }
                c++;
            }

        }

    }

    /**
     * cette fonction retire un tuteur donné par la variable personne entre 1 et
     * 100 et le retire à la bonne position avant de boucher le "trou"
     *
     * @param tab liste des tuteur de 0 à 11 soit 12
     */
    static void minusTutrice(int[] tab) {
        System.out.println("veuillez donner l'id d'un tuteur présent");
        int personne = nombreIntervalle(1, 100);

        int c = 0;
        boolean trouve = false;

        while (!trouve && c < tab.length) {
            if (tab[c] == personne) {
                tab[c] = 0;
                // decalage vers la gauche de tel facon à remplir le trou créé par le 0 
                decalageGaucheAPartirPoint(c, tab);
                trouve = true;

            }
            c++;
        }

    }

    /**
     * effectue un decalage vers la gauche à partir de depart
     *
     * @param depart point de départ du décalage
     * @param tab liste des tuteur de 0 à 11 soit 12
     */
    static void decalageGaucheAPartirPoint(int depart, int[] tab) {

        for (int i = depart; i < tab.length - 1; i++) {

            tab[i] = tab[i + 1];
            tab[i + 1] = 0;

        }

    }


//////////////////////////////////////////////////A la fin ci tes le goat////////////////////
    /* memo pour quand tu va le relire moi du future (bosse stp flemme de rater S1 S2 par flemme ) ne pas oublier de faire ce que le prof a dit c'est à dire au lieu de
 faire un tab.lenght et de tout parcourir tu parcour que le nb de tuteur connu ce qui évite de parcourir tout le tableau à chaque fois
    pour ça tu auras besoins d'une fonction nb tuteur qui prend une var tuteur à 0 et returne +1 ou moinstuteur qui retourne -1 du nb de tuteur et tu parcours jusqu'aux nb de tuteur 
    grace à  i < nbtuteur : i++ au lieu de i < tab.length-1; i++

*/
    
    
    
    
    
}
