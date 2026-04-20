public interface IPaye {
    double calculerSalaireBrut();
    double calculerPrimeAnciennete();

    default double calculerCharges(double taux){
        return (calculerSalaireBrut() + calculerPrimeAnciennete()) * taux;
    }

    default double calculerNetAPayer(){
        return (calculerSalaireBrut() + calculerPrimeAnciennete()) - calculerCharges(0.20);
    }
}
