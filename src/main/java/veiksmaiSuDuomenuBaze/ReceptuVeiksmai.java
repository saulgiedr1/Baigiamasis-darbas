package veiksmaiSuDuomenuBaze;
import entities.Ingredientai;
import entities.Receptai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReceptuVeiksmai {

    public static ArrayList<Receptai> grazintiVisusReceptus(Connection jungtis) {
        ArrayList<Receptai> visiReceptai = new ArrayList<>();
        String sqlUzklausa = "SELECT * FROM receptai";

        try {

            PreparedStatement paruostukas = jungtis.prepareStatement(sqlUzklausa);
            ResultSet rezultatas = paruostukas.executeQuery();
            while (rezultatas.next()) {
                int id = rezultatas.getInt("id");
                String pavadinimas = rezultatas.getString("pavadinimas");
                double kaina = rezultatas.getDouble("kaina");
                String nurodymai = rezultatas.getString("nurodymai");
                Receptai laikinaReceptai = new Receptai(id, pavadinimas, kaina, nurodymai);
                visiReceptai.add(laikinaReceptai);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Nepavyko gauti duomenų  iš DB");
        }

        return visiReceptai;
    }
    public static ArrayList<Receptai> grazintiKaina(Connection jungtis, double x) {
        ArrayList<Receptai> receptas = new ArrayList<>();
        String sqlUzklausa = "SELECT * FROM receptai WHERE kaina > ?";
        try {
            PreparedStatement paruostukas = jungtis.prepareStatement(sqlUzklausa);
            paruostukas.setDouble(1, x);
            ResultSet rezultatas = paruostukas.executeQuery();
            while (rezultatas.next()) {
                receptas.add(new Receptai(rezultatas.getInt("id"), rezultatas.getString("pavadinimas"), rezultatas.getDouble("kaina"), rezultatas.getString("nurodymai")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Nepavyko pasiekti duomenų.");
        }
        return receptas;
    }
    public static ArrayList<Ingredientai> grazintiReceptoIngredientus(Connection jungtis, int n) {
        ArrayList<Ingredientai> ingredientas = new ArrayList<>();
        String sqlUzklausa = "SELECT ingredientai.id,ingredientai.pavadinimas,ingredientai.kaina\n" +
                "FROM receptai\n" +
                "JOIN receptai_ingredientai ON receptai.id=receptai_ingredientai.receptas_id\n" +
                "JOIN ingredientai ON ingredientai.id=receptai_ingredientai.ingredientas_id\n" +
                "WHERE receptai.id = ?; ";
        try {
            PreparedStatement paruostukas = jungtis.prepareStatement(sqlUzklausa);
            paruostukas.setInt(1, n);
            ResultSet rezultatas = paruostukas.executeQuery();
            while (rezultatas.next()) {
                ingredientas.add(new Ingredientai(rezultatas.getInt("id"), rezultatas.getString("pavadinimas"), rezultatas.getDouble("kaina")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Nepavyko pasiekti duomenų.");
        }
        return ingredientas;
    }
    public static void pridetiRecepta(Connection jungtis, Receptai receptai) {
        String sqlUzklausa = "INSERT INTO receptai(pavadinimas,kaina,nurodymai) VALUES (?, ?, ?)";
        try {
            PreparedStatement paruostukas = jungtis.prepareStatement(sqlUzklausa);
            paruostukas.setString(1, receptai.getPavadinimas());
            paruostukas.setDouble(2, receptai.getKaina());
            paruostukas.setString(3, receptai.getNurodymai());
            paruostukas.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Nepavyko įdėti duomenų į duomenų bazę");
        }
    }
}
