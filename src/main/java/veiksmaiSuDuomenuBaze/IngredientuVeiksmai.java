package veiksmaiSuDuomenuBaze;

import entities.Ingredientai;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IngredientuVeiksmai {

    public static ArrayList<Ingredientai> grazintiVisusIngredientus(Connection jungtis) {
        ArrayList<Ingredientai> visiIngredientai = new ArrayList<>();
        String sqlUzklausa = "SELECT * FROM ingredientai";

        try {

            PreparedStatement paruostukas = jungtis.prepareStatement(sqlUzklausa);
            ResultSet rezultatas = paruostukas.executeQuery();
            while (rezultatas.next()) {
                int id = rezultatas.getInt("id");
                String pavadinimas = rezultatas.getString("pavadinimas");
                double kaina = rezultatas.getDouble("kaina");
                Ingredientai laikinaIngredientai = new Ingredientai(id, pavadinimas, kaina);
                visiIngredientai.add(laikinaIngredientai);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Nepavyko gauti duomenų  iš DB.");
        }
        return visiIngredientai;
    }

    public static ArrayList<Ingredientai> grazintiIngredientoKaina(Connection jungtis, double x) {
        ArrayList<Ingredientai> ingredientas = new ArrayList<>();
        String sqlUzklausa = "SELECT * FROM ingredientai WHERE kaina < ?";
        try {
            PreparedStatement paruostukas = jungtis.prepareStatement(sqlUzklausa);
            paruostukas.setDouble(1, x);
            ResultSet rezultatas = paruostukas.executeQuery();
            while (rezultatas.next()) {
                ingredientas.add(new Ingredientai(rezultatas.getInt("id"), rezultatas.getString("pavadinimas"), rezultatas.getDouble("kaina")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Nepavyko gauti duomenų  iš DB.");
        }
        return ingredientas;
    }

    public static double grazintiIngredientoKainuVidurki(Connection jungtis) {
        double vidurkis = 0;
        String sqlUzklausa = "SELECT AVG(kaina) FROM ingredientai ";
        try {
            PreparedStatement paruostukas = jungtis.prepareStatement(sqlUzklausa);
            ResultSet rezultatas = paruostukas.executeQuery();
            while (rezultatas.next()) {
                vidurkis = rezultatas.getDouble("AVG(kaina)");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Nepavyko gauti duomenų  iš DB.");
        }
        return vidurkis;
    }

    public static ArrayList<Ingredientai> grazintiTopIngredientus(Connection jungtis, int x) {
        ArrayList<Ingredientai> ingredientas = new ArrayList<>();
        String sqlUzklausa = "SELECT * FROM ingredientai ORDER BY ingredientai.kaina DESC LIMIT ?";
        try {
            PreparedStatement paruostukas = jungtis.prepareStatement(sqlUzklausa);
            paruostukas.setInt(1, x);
            ResultSet rezultatas = paruostukas.executeQuery();
            while (rezultatas.next()) {
                ingredientas.add(new Ingredientai(rezultatas.getInt("id"), rezultatas.getString("pavadinimas"), rezultatas.getDouble("kaina")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Nepavyko gauti duomenų  iš DB.");
        }
        return ingredientas;
    }
}
