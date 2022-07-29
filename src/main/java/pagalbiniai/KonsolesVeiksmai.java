package pagalbiniai;

import entities.Receptai;

import java.util.Scanner;

public class KonsolesVeiksmai {

    private static final Scanner skaitytuvas = new Scanner(System.in);

    public static Receptai ivestiReceptusPerKonsole() {

        System.out.println("Iveskite recepto pavadinima");
        skaitytuvas.nextLine();
        String pavadinimas = skaitytuvas.nextLine();
        System.out.println("Iveskite recepto kaina");
        double kaina = skaitytuvas.nextDouble();
        skaitytuvas.nextLine();
        System.out.println("Iveskite nurodymus");
        String nurodymai = skaitytuvas.nextLine();

        System.out.println("Nurodymai = " + nurodymai);
        System.out.println("Kaina = " + kaina);
        System.out.println("Pavadinimas = " + pavadinimas);

        return new Receptai(pavadinimas, kaina, nurodymai);
    }

    public static int meniuPasirinkimai() {
        System.out.println("Meniu pasirinkimai");
        System.out.println("1 - Išvesti visus receptus ");
        System.out.println("2 - Išvesti visus igredientus ");
        System.out.println("3 - Išvesti visų ingredientų kainų vidurkį");
        System.out.println("4 - Ingredientai , pigesni už ivedama kaina");
        System.out.println("5 - Kelis brangiausius? ");
        System.out.println("6 - Kelinto recepto?");
        System.out.println("7 - Ivesti recepto duomenis");
        System.out.println("8 - Receptai, brangesni uz ivedama kaina");

        return skaitytuvas.nextInt();

    }

    public static double nuskaitytiIgredientusPigesniusUz() {
        System.out.println("Iveskite, uz kiek pigesnius ingredientus rodyti");

        return skaitytuvas.nextDouble();
    }

    public static int nuskaitytiBrangiausiuIgredientuTop() {
        System.out.println("Iveskite, kelis brangieusius ingredientus rodyti");

        return skaitytuvas.nextInt();
    }

    public static int nuskaitytiNtojoReceptoIngredientus() {
        System.out.println("Iveskite, recepto id, kurio ingredientus rodyti");

        return skaitytuvas.nextInt();
    }

    public static double nuskaitytiReceptusBrangesniusUz() {
        System.out.println("Iveskite, uz kiek brangesnius receptus  rodyti");

        return skaitytuvas.nextDouble();


    }
}
