package pagalbiniai;

import entities.Ingredientai;
import entities.Receptai;
import veiksmaiSuDuomenuBaze.IngredientuVeiksmai;

import java.sql.Connection;
import java.util.Scanner;

public class KonsolesVeiksmai {

    private static final Scanner skaitytuvas = new Scanner(System.in);

    public static Receptai ivestiReceptusPerKonsole() {
        System.out.println("Įveskite recepto pavadinimą");
        skaitytuvas.nextLine();
        String pavadinimas = skaitytuvas.nextLine();
        System.out.println("Įveskite recepto kainą");
        double kaina = skaitytuvas.nextDouble();
        skaitytuvas.nextLine();
        System.out.println("Įveskite nurodymus");
        String nurodymai = skaitytuvas.nextLine();
        System.out.println("Nurodymai = " + nurodymai);
        System.out.println("Kaina = " + kaina);
        System.out.println("Pavadinimas = " + pavadinimas);
        return new Receptai(pavadinimas, kaina, nurodymai);
    }

    public static int meniuPasirinkimai() {
        System.out.println("Meniu pasirinkimai:");
        System.out.println("1 - Išvesti visus receptus;");
        System.out.println("2 - Išvesti visus igredientus;");
        System.out.println("3 - Išvesti visų ingredientų kainų vidurkį;");
        System.out.println("4 - Ingredientai, pigesni už įvedama kainą;");
        System.out.println("5 - Kelis brangiausius ingredientus rodyti? ");
        System.out.println("6 - Kelinto recepto ingredientus rodyti?");
        System.out.println("7 - Įvesti recepto duomenis;");
        System.out.println("8 - Receptai, brangesni už įvedamą kainą;");
        System.out.println("9 - Receptai, kurių pavadinimas prasideda raide arba raidėmis..;");
        System.out.println("10 - Įtraukti naują ingredientą (Nebus sujungtas su jokiu receptu. Jeigu norite sujungimo, naudokite 7 meniu punktą);");
        return skaitytuvas.nextInt();
    }

    public static double nuskaitytiIgredientusPigesniusUz() {
        System.out.println("Įveskite, už kiek pigesnius ingredientus rodyti");
        return skaitytuvas.nextDouble();
    }

    public static int nuskaitytiBrangiausiuIgredientuTop() {
        System.out.println("Įveskite, kelis brangiausius ingredientus rodyti");
        return skaitytuvas.nextInt();
    }

    public static int nuskaitytiNtojoReceptoIngredientus() {
        System.out.println("Įveskite, recepto id, kurio ingredientus rodyti");
        return skaitytuvas.nextInt();
    }

    public static double nuskaitytiReceptusBrangesniusUz() {
        System.out.println("Įveskite, už kokią kainą brangesnius receptus  rodyti");
        return skaitytuvas.nextDouble();
    }

    public static String nuskaitytiReceptaKurioPavadinimasPrasideda() {
        System.out.println("Įveskite recepto pavadinimo pirmą raidę arba pirmąsias kelias raides");
        skaitytuvas.nextLine();
        return skaitytuvas.nextLine();
    }

    public static int nuskaitytiIngredientoId(Connection jungtis) {
        System.out.println("-----------------------------------------");
        System.out.println("Čia duomenų bazėje esantys ingredientai.Jeigu nors vieno reikiamo nėra,reikia jį įvesti, paspaudžiant 0 (nulis) .Jeigu yra sąraše, spauskite jų ID numerį;");
        System.out.println("-----------------------------------------");
        PapildomosFunkcijos.isvestiIngredientuListaEilutemis(IngredientuVeiksmai.grazintiVisusIngredientus(jungtis));
        return skaitytuvas.nextInt();
    }

    public static Ingredientai nuskaitytiIngredienta() {
        skaitytuvas.nextLine();
        System.out.println("Įveskite ingrediento pavadinimą: ");
        String pavadinimas = skaitytuvas.nextLine();
        System.out.println("Įveskite ingrediento kainą: ");
        double kaina = skaitytuvas.nextDouble();
        return new Ingredientai(pavadinimas, kaina);
    }
    public static int testiIngredientuIvedima() {
        System.out.println("Jeigu tęsite ingredientų įvedimą, spauskite 1, jeigu baigėte, spauskite bet kokį skaičių");
        return skaitytuvas.nextInt();
    }
}
