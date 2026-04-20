import java.time.LocalDate;
public class EmployeFixe extends Employe {
    double salaireBase;
    double primePerformance;
    public EmployeFixe(int id, String nom, String email,
                       String departement,
                       LocalDate dateEmbauche,
                       double salaireBase,
                       double primePerformance) throws InvalidWorkDataException {
        super(id, nom, email, departement, dateEmbauche);
        if (salaireBase < 3000)
            throw new InvalidWorkDataException("SMIG non respecté");
        this.salaireBase = salaireBase;
        this.primePerformance = primePerformance;
    }
    @Override
    public double calculerSalaireBrut() {
        return salaireBase + primePerformance;
    }
    @Override
    public double calculerPrimeAnciennete() {
        double brut = calculerSalaireBrut();
        int a = getAnciennete();
        if (a < 2) return 0;
        if (a <= 5) return brut * 0.5;
        return brut * 0.10;
    }
}