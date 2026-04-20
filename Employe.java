import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public abstract class Employe implements IPaye{
    int id;
    String nom;
    String email;
    String departement;
    LocalDate dateEmbauche;

    public Employe(int id, String nom, String email, String departement, LocalDate dateEmbauche){
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.departement = departement;
        this.dateEmbauche = dateEmbauche;
    }
    public int getAnciennete(){
        return (int) ChronoUnit.YEARS.between(dateEmbauche, LocalDate.now());
    }
}
