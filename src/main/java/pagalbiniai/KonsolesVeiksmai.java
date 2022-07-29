package pagalbiniai;

import entities.Receptai;

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
}
