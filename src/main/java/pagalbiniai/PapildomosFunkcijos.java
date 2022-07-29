package pagalbiniai;

import entities.Ingredientai;
import entities.Receptai;

import java.util.ArrayList;
import java.util.Scanner;

public class PapildomosFunkcijos {
    public PapildomosFunkcijos() {
    }

    public static void isvestiReceptuListaEilutemis(ArrayList<Receptai> receptas) {
        for (Receptai receptai : receptas) {
            System.out.println("receptai = " + receptai);
        }
    }

    //-------------------------------------------
    public static void isvestiIngredientuListaEilutemis(ArrayList<Ingredientai> ingredientas) {
        for (Ingredientai ingredientai : ingredientas) {
            System.out.println("ingredientai = " + ingredientai);
        }
    }

    //----------------------------------------
    public static Receptai nuskaitytiReceptusIsKonsoles(){
        Scanner skaitytuvas = new Scanner(System.in);
        System.out.println("Iveskite recepto pavadinima");
        String pavadinimas = skaitytuvas.nextLine();
        System.out.println("Iveskite recepto kaina");
        double kaina = skaitytuvas.nextDouble();
        System.out.println("Iveskite nurodymus");
        skaitytuvas.nextLine();
        String nurodymai = skaitytuvas.nextLine();


        System.out.println("nurodymai = " + nurodymai);
        System.out.println("kaina = " + kaina);
        System.out.println("pavadinimas = " + pavadinimas);

        return new Receptai(pavadinimas, kaina, nurodymai);

    }



}
