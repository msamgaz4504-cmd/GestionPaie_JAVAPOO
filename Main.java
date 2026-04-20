import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        try {
            EmployeFixe e1 = new EmployeFixe(1, "Meryem", "meryem@gmail.com", "IT", LocalDate.of(2020, 1, 10), 40000, 3000);
            EmployeHoraire e2 = new EmployeHoraire(2, "Sara", "sara@gmail.com", "RH", LocalDate.of(2022, 3, 5), 20, 200);
            System.out.println("Salaire Meryem = " + e1.calculerNetAPayer());
            System.out.println("Salaire Sara = " + e2.calculerNetAPayer());
            EmployeDAO dao = new EmployeDAO();
            dao.save(e1);
            dao.save(e2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}