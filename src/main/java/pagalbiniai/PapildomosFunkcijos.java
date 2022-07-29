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




}
