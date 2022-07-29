

import entities.Receptai;
import entities.Ingredientai;
import pagalbiniai.KonsolesVeiksmai;
import pagalbiniai.PapildomosFunkcijos;
import veiksmaiSuDuomenuBaze.VeiksmaiSuDuomenuBaze;
import java.sql.Connection;
import java.util.ArrayList;

public class PagrindinePrograma {
    public static void main(String[] args) {
        Connection jungtis = VeiksmaiSuDuomenuBaze.prisijungtiPrieDuombenuBazesReceptaiDb();

        int pasirinkimas = KonsolesVeiksmai.meniuPasirinkimai();

        switch (pasirinkimas) {
            case 1:
                ArrayList<Receptai> visiReceptai = VeiksmaiSuDuomenuBaze.grazintiVisusReceptus(jungtis);
                PapildomosFunkcijos.isvestiReceptuListaEilutemis(visiReceptai);
                break;
            case 2:
                ArrayList<Ingredientai> visiIngredientai = VeiksmaiSuDuomenuBaze.grazintiVisusIngredientus(jungtis);
                PapildomosFunkcijos.isvestiIngredientuListaEilutemis(visiIngredientai);
                break;

            case 3:
                double vidurkis = VeiksmaiSuDuomenuBaze.grazintiIngredientoKainuVidurki(jungtis);
                System.out.println("Ingredientu kainu vidurkis yra = " + vidurkis);
                break;
            case 4:
                double mazesneIngredientuKaina = KonsolesVeiksmai.nuskaitytiIgredientusPigesniusUz();
                ArrayList<Ingredientai> igredientuKaina = VeiksmaiSuDuomenuBaze.grazintiIngredientoKaina(jungtis, mazesneIngredientuKaina);
                PapildomosFunkcijos.isvestiIngredientuListaEilutemis(igredientuKaina);
                break;
            case 5:
                int ingredientuTopai = KonsolesVeiksmai.nuskaitytiBrangiausiuIgredientuTop();
                ArrayList<Ingredientai> igredientuTop = VeiksmaiSuDuomenuBaze.grazintiTopIngredientus(jungtis, ingredientuTopai);
                PapildomosFunkcijos.isvestiIngredientuListaEilutemis(igredientuTop);
                break;
            case 6:
                int visiReceptoIgredientai = KonsolesVeiksmai.nuskaitytiNtojoReceptoIngredientus();
                ArrayList<Ingredientai> receptoIngredientai = VeiksmaiSuDuomenuBaze.grazintiReceptoIngredientus(jungtis, visiReceptoIgredientai);
                PapildomosFunkcijos.isvestiIngredientuListaEilutemis(receptoIngredientai);
                break;
            case 7:
                Receptai naujasReceptas = KonsolesVeiksmai.ivestiReceptusPerKonsole();
                VeiksmaiSuDuomenuBaze.pridetiRecepta(jungtis, naujasReceptas);
                break;
            case 8:
                double brangesniReceptai = KonsolesVeiksmai.nuskaitytiReceptusBrangesniusUz();
                ArrayList<Receptai> receptuKaina = VeiksmaiSuDuomenuBaze.grazintiKaina(jungtis, brangesniReceptai);
                PapildomosFunkcijos.isvestiReceptuListaEilutemis(receptuKaina);
        }
    }
}


