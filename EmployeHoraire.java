import java.time.LocalDate;
public class EmployeHoraire extends Employe {
    double tauxHoraire;
    int heuresTravaillees;

    public EmployeHoraire(int id, String nom, String email, String departement, LocalDate dateEmbauche, double tauxHoraire, int heuresTravaillees) throws InvalidWorkDataException {
        super(id, nom, email, departement, dateEmbauche);
        if (heuresTravaillees > 240)
            throw new InvalidWorkDataException("Heures > 240 interdit");
        this.tauxHoraire = tauxHoraire;
        this.heuresTravaillees = heuresTravaillees;
    }
    @Override
    public double calculerSalaireBrut() {
        if (heuresTravaillees <= 180)
            return tauxHoraire * heuresTravaillees;
        int sup = heuresTravaillees - 180;
        return (180 * tauxHoraire) +
                (sup * tauxHoraire * 1.25);
    }
    @Override
    public double calculerPrimeAnciennete() {
        double brut = calculerSalaireBrut();
        int a = getAnciennete();
        if (a < 2) return 0;
        if (a <= 5) return brut * 0.05;
        return brut * 0.10;
    }
}