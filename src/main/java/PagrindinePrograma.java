

import entities.Receptai;
import entities.Ingredientai;
import pagalbiniai.KonsolesVeiksmai;
import pagalbiniai.PapildomosFunkcijos;
import veiksmaiSuDuomenuBaze.IngredientuVeiksmai;
import veiksmaiSuDuomenuBaze.VeiksmaiSuDuomenuBaze;
import veiksmaiSuDuomenuBaze.ReceptuVeiksmai;
import java.sql.Connection;
import java.util.ArrayList;

public class PagrindinePrograma {
    public static void main(String[] args) {
        Connection jungtis = VeiksmaiSuDuomenuBaze.prisijungtiPrieDuombenuBazesReceptaiDb();

        int pasirinkimas = KonsolesVeiksmai.meniuPasirinkimai();

        switch (pasirinkimas) {
            case 1:
                assert jungtis != null;
                ArrayList<Receptai> visiReceptai = ReceptuVeiksmai.grazintiVisusReceptus(jungtis);
                PapildomosFunkcijos.isvestiReceptuListaEilutemis(visiReceptai);
                break;
            case 2:
                assert jungtis != null;
                ArrayList<Ingredientai> visiIngredientai = IngredientuVeiksmai.grazintiVisusIngredientus(jungtis);
                PapildomosFunkcijos.isvestiIngredientuListaEilutemis(visiIngredientai);
                break;

            case 3:
                assert jungtis != null;
                double vidurkis = IngredientuVeiksmai.grazintiIngredientoKainuVidurki(jungtis);
                System.out.println("Ingredientų kainų vidurkis yra = " + vidurkis);
                break;
            case 4:
                assert jungtis != null;
                double mazesneIngredientuKaina = KonsolesVeiksmai.nuskaitytiIgredientusPigesniusUz();
                ArrayList<Ingredientai> igredientuKaina = IngredientuVeiksmai.grazintiIngredientoKaina(jungtis, mazesneIngredientuKaina);
                PapildomosFunkcijos.isvestiIngredientuListaEilutemis(igredientuKaina);
                break;
            case 5:
                assert jungtis != null;
                int ingredientuTopai = KonsolesVeiksmai.nuskaitytiBrangiausiuIgredientuTop();
                ArrayList<Ingredientai> igredientuTop = IngredientuVeiksmai.grazintiTopIngredientus(jungtis, ingredientuTopai);
                PapildomosFunkcijos.isvestiIngredientuListaEilutemis(igredientuTop);
                break;
            case 6:
                assert jungtis != null;
                int visiReceptoIgredientai = KonsolesVeiksmai.nuskaitytiNtojoReceptoIngredientus();
                ArrayList<Ingredientai> receptoIngredientai = ReceptuVeiksmai.grazintiReceptoIngredientus(jungtis, visiReceptoIgredientai);
                PapildomosFunkcijos.isvestiIngredientuListaEilutemis(receptoIngredientai);
                break;
            case 7:
                assert jungtis != null;
                Receptai naujasReceptas = KonsolesVeiksmai.ivestiReceptusPerKonsole();
                ReceptuVeiksmai.pridetiRecepta(jungtis, naujasReceptas);
                break;
            case 8:
                assert jungtis != null;
                double brangesniReceptai = KonsolesVeiksmai.nuskaitytiReceptusBrangesniusUz();
                ArrayList<Receptai> receptuKaina = ReceptuVeiksmai.grazintiKaina(jungtis, brangesniReceptai);
                PapildomosFunkcijos.isvestiReceptuListaEilutemis(receptuKaina);
                break;
            case 9:
                assert jungtis != null;
                String receptoPavadinimas = KonsolesVeiksmai.nuskaitytiReceptaKurioPavadinimasPrasideda();
                ArrayList<Receptai> receptuPavadinimai = ReceptuVeiksmai.grazintiPavadinimaPagalPradzia(jungtis, receptoPavadinimas);
                PapildomosFunkcijos.isvestiReceptuListaEilutemis(receptuPavadinimai);
                break;
        }
    }
}


