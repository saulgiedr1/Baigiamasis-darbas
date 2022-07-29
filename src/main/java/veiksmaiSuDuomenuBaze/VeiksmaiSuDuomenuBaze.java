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
    public static Connection prisijungtiPrieDuombenuBazesReceptaiDb() {
        try {
            return DriverManager.getConnection(DB_NUORODA, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Nepavyko prisijungti prie DB.");
        }
        return null;
    }

}