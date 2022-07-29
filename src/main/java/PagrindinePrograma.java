

import entities.Receptai;
import entities.Ingredientai;
import pagalbiniai.PapildomosFunkcijos;
import veiksmaiSuDuomenuBaze.VeiksmaiSuDuomenuBaze;
import java.sql.Connection;
import java.util.ArrayList;

public class PagrindinePrograma {
    public static void main(String[] args) {
        Connection jungtis = VeiksmaiSuDuomenuBaze.prisijungtiPrieDuombenuBazesReceptaiDb();

        ArrayList<Receptai> visiReceptai = VeiksmaiSuDuomenuBaze.grazintiVisusReceptus(jungtis);
        PapildomosFunkcijos.isvestiReceptuListaEilutemis(visiReceptai);

        System.out.println("------------------");
        ArrayList<Receptai> receptuKaina = VeiksmaiSuDuomenuBaze.grazintiKaina(jungtis, 20);
        System.out.println("Receptai, kuriu kaina yra didesnė už x");

        System.out.println("------------------");

        PapildomosFunkcijos.isvestiReceptuListaEilutemis(receptuKaina);

        System.out.println("------------------");

        // Receptai pridetiRecepta = new Receptai("Bestrogenas", 25.69, "Iškepti");
        // VeiksmaiSuDuomenuBaze.pridetiRecepta(jungtis, pridetiRecepta);


        //---------------------------------------------------------


        ArrayList<Ingredientai> visiIngredientai = VeiksmaiSuDuomenuBaze.grazintiVisusIngredientus(jungtis);
        PapildomosFunkcijos.isvestiIngredientuListaEilutemis(visiIngredientai);
        //----------------------------------------------------------

        System.out.println("------------------");
        ArrayList<Ingredientai> igredientuKaina = VeiksmaiSuDuomenuBaze.grazintiIngredientoKaina(jungtis, 3);
        System.out.println("Ingredientai, kuriu kaina yra mažesnė už x");

        System.out.println("------------------");

        PapildomosFunkcijos.isvestiIngredientuListaEilutemis(igredientuKaina);

        //---------------------------------------

        System.out.println("------------------");
        double vidurkis = VeiksmaiSuDuomenuBaze.grazintiIngredientoKainuVidurki(jungtis);
        System.out.println("Ingredientu kainu vidurkis yra = " + vidurkis);

        System.out.println("------------------");

        //------------------------------------

        System.out.println("------------------");
        ArrayList<Ingredientai> igredientuTop = VeiksmaiSuDuomenuBaze.grazintiTopIngredientus(jungtis, 5);
        System.out.println("Ingredientai, kuriu kaina yra didzausia x");

        System.out.println("------------------");

        PapildomosFunkcijos.isvestiIngredientuListaEilutemis(igredientuTop);

        //-----------------------------------
        System.out.println("------------------");
        ArrayList<Ingredientai> receptoIngridientai = VeiksmaiSuDuomenuBaze.grazintiReceptoIngredientus(jungtis, 6);
        System.out.println("Ingredientai, ieinantys i n-taji recepta ");

        System.out.println("------------------");

        PapildomosFunkcijos.isvestiIngredientuListaEilutemis(receptoIngridientai);

        //Ivedimas per konsole----------------

        System.out.println("------------------");

        Receptai naujasReceptas = PapildomosFunkcijos.nuskaitytiReceptusIsKonsoles();
        VeiksmaiSuDuomenuBaze.pridetiRecepta(jungtis, naujasReceptas);


    }
}
