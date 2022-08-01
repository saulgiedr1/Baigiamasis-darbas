package veiksmaiSuDuomenuBaze;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReceptuIngredientuVeiksmai {

    public static void sujungtiReceptaSuIngredientu(Connection jungtis, int receptoId, int ingredientoId){
        String sqlUzklausa = "INSERT INTO receptai_ingredientai( receptas_id, Ingredientas_id )VALUES(?, ?)";
        try {
            PreparedStatement paruostukas = jungtis.prepareStatement(sqlUzklausa);
            paruostukas.setInt(1, receptoId);
            paruostukas.setInt(2, ingredientoId);
            paruostukas.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

