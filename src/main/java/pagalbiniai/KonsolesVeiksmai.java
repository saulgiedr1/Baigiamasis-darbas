package pagalbiniai;

import entities.Receptai;

import java.util.Scanner;

public class KonsolesVeiksmai {

    private static final Scanner skaitytuvas = new Scanner(System.in);
    public static Receptai ivestiReceptusPerKonsole(){

        System.out.println("Iveskite recepto pavadinima");
        String pavadinimas = skaitytuvas.nextLine();
        System.out.println("Iveskite recepto kaina");
        double kaina = skaitytuvas.nextDouble();
        System.out.println("Iveskite nurodymus");
        skaitytuvas.nextLine();
        String nurodymai = skaitytuvas.nextLine();

        System.out.println("Nurodymai = " + nurodymai);
        System.out.println("Kaina = " + kaina);
        System.out.println("Pavadinimas = " + pavadinimas);

        return new Receptai(pavadinimas, kaina, nurodymai);
    }

}
