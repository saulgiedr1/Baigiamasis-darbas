

import entities.Receptai;
import entities.Ingredientai;
import pagalbiniai.PapildomosFunkcijos;
import veiksmaiSuDuomenuBaze.VeiksmaiSuDuomenuBaze;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class PagrindinePrograma {
    public static void main(String[] args) {
        Connection jungtis= null;
        try {

            jungtis = VeiksmaiSuDuomenuBaze.prisijungtiPrieDuombenuBazesReceptaiDb();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Nepavyko prisijungti prie duomenų bazės.");
        }
        try {
            ArrayList<Receptai> visiReceptai=VeiksmaiSuDuomenuBaze.grazintiVisusReceptus(jungtis);

            PapildomosFunkcijos.isvestiReceptuListaEilutemis(visiReceptai);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("------------------");
        ArrayList<Receptai> receptuKaina=VeiksmaiSuDuomenuBaze.grazintiKaina(jungtis, 20);

        System.out.println("Kuriu kaina yra didesnė už x");

        System.out.println("------------------");

        PapildomosFunkcijos.isvestiReceptuListaEilutemis(receptuKaina);

        System.out.println("------------------");

       Receptai pridetiRecepta = new Receptai("Bestrogenas",25.69,"Iškepti");
        VeiksmaiSuDuomenuBaze.pridetiRecepta(jungtis, pridetiRecepta);


        //---------------------------------------------------------

        try {
            ArrayList<Ingredientai> visiIngredientai=VeiksmaiSuDuomenuBaze.grazintiVisusIngredientus(jungtis);

            PapildomosFunkcijos.isvestiIngredientuListaEilutemis(visiIngredientai);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }







    }
}
