public class CompteBancaire {
    private String nom;
    private double solde;
    private char[] accountnumber;

    public CompteBancaire(String n0, double s0, char[] a0) {
        this.nom = n0;
        this.solde = s0;
        this.accountnumber = a0;
    }

    public void getSolde() {
        System.out.println("Solde de " + this.nom + " (N° " + new String(this.accountnumber) + ") : " + this.solde + " €");
    }

    public void affiche() {
        System.out.println("Propriétaire : " + this.nom + " | N° : " + new String(this.accountnumber) + " | Solde : " + this.solde + " €");
    }

    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            System.out.println("+" + montant + " € déposés. Nouveau solde : " + solde + " €");
        } else {
            System.out.println("Erreur : montant invalide.");
        }
    }

    public void retirer(double montant) {
        if (montant > 0 && montant <= solde) {
            solde -= montant;
            System.out.println("−" + montant + " € retirés. Nouveau solde : " + solde + " €");
        } else if (montant > solde) {
            System.out.println("Solde insuffisant. (Solde actuel : " + solde + " €)");
        } else {
            System.out.println("Erreur : montant invalide.");
        }
    }

    public void virementVers(CompteBancaire dest, double montant) {
        if (montant > 0 && montant <= this.solde) {
            this.solde -= montant;
            dest.solde += montant;
            System.out.println("Virement de " + montant + " € vers " + dest.nom + ".");
            this.getSolde();
            dest.getSolde();
        } else if (montant > this.solde) {
            System.out.println("Virement échoué : solde insuffisant.");
        } else {
            System.out.println("Virement échoué : montant invalide.");
        }
    }

    public String getNom() { return this.nom; }
    public double getSoldeValue() { return this.solde; }
    public char[] getAccountNumber() { return this.accountnumber; }
}