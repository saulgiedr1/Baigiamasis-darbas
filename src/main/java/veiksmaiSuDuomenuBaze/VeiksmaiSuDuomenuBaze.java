package veiksmaiSuDuomenuBaze;

import entities.Ingredientai;
import entities.Receptai;

import java.sql.*;
import java.util.ArrayList;

public class VeiksmaiSuDuomenuBaze {
    public static final String DB_NUORODA = "jdbc:mysql://localhost:3306/receptai_db?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8&characterEncoding=utf8";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "";

    public VeiksmaiSuDuomenuBaze() {

    }

    public static Connection prisijungtiPrieDuombenuBazesReceptaiDb() throws SQLException {
        return DriverManager.getConnection(DB_NUORODA, DB_USER, DB_PASSWORD);
    }

    public static ArrayList<Receptai> grazintiVisusReceptus(Connection jungtis) throws SQLException {
        ArrayList<Receptai> visiReceptai = new ArrayList<>();
        String sqlUzklausa = "SELECT * FROM receptai";

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

    //------------------------------------------------
    public static ArrayList<Ingredientai> grazintiVisusIngredientus(Connection jungtis) throws SQLException {
        ArrayList<Ingredientai> visiIngredientai = new ArrayList<>();
        String sqlUzklausa = "SELECT * FROM ingredientai";

        PreparedStatement paruostukas = jungtis.prepareStatement(sqlUzklausa);
        ResultSet rezultatas = paruostukas.executeQuery();
        while (rezultatas.next()) {
            int id = rezultatas.getInt("id");
            String pavadinimas = rezultatas.getString("pavadinimas");
            double kaina = rezultatas.getDouble("kaina");


            Ingredientai laikinaIngredientai = new Ingredientai(id, pavadinimas, kaina);
            visiIngredientai.add(laikinaIngredientai);
        }
        return visiIngredientai;
    }

    //--------------------------------------------------------
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
            System.out.println("Nepavyko pasiekti duomenų.");
        }
        return ingredientas;
    }

//---------------------------------------------------------

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
            System.out.println("Nepavyko pasiekti duomenų.");
        }
        return vidurkis;
    }
    //------------------------------------------------

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
            System.out.println("Nepavyko pasiekti duomenų.");
        }
        return ingredientas;
    }

    //------------------------------------------------
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

}