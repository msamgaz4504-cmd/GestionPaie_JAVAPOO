import java.sql.*;
import java.util.*;
public class EmployeDAO {
    Connection c2 = DBConnection.getConnection();
    public void save(Employe e) {
        try {
            String sql = "INSERT INTO employes VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = c2.prepareStatement(sql);
            ps.setInt(1, e.id);
            ps.setString(2, e.nom);
            ps.setString(3, e.email);
            ps.setString(4, e.departement);
            ps.setDate(5, java.sql.Date.valueOf(e.dateEmbauche));
            if (e instanceof EmployeFixe)
                ps.setString(6, "FIXE");
            else
                ps.setString(6, "HORAIRE");
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public Map<String, Double> getMasseSalarialeParDept() {
        Map<String, Double> map = new HashMap<>();
        try {

            String sql =
                    "SELECT departement, SUM(salaire) AS total " + "FROM employes GROUP BY departement";
            Statement st = c2.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                map.put(rs.getString("departement"), rs.getDouble("total"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return map;
    }
}