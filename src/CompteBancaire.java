public class CompteBancaire {
    // Attributs
    private String nom;
    private double solde;
    private char[] accountnumber; // Numéro de compte sous forme de tableau de caractères

    // Constructeur
    public CompteBancaire(String n0, double s0, char[] a0) {
        this.nom = n0;
        this.solde = s0;
        this.accountnumber = a0;
    }

    // Méthodes
    public void getSolde() {
        System.out.println("Le solde de " + this.nom + " (N° de compte: " + new String(this.accountnumber) + ") est de : " + this.solde + " €");
    }

    public void affiche() {
        System.out.print("Compte Propriétaire : " + this.nom);
        System.out.print(" | Numéro : " + new String(this.accountnumber));
        System.out.println(" | Solde : " + this.solde + " €");
    }

    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            System.out.println("Dépôt de " + montant + " € effectué. Nouveau solde : " + solde + " €");
        } else {
            System.out.println("Erreur: Le montant du dépôt doit être positif. Solde : " + solde + " €");
        }
    }

    public void retirer(double montant) {
        if (montant > 0 && montant <= solde) {
            solde -= montant;
            System.out.println("Retrait de " + montant + " € effectué. Nouveau solde : " + solde + " €");
        } else if (montant > solde) {
            // Traitement de l'erreur demandé
            System.out.println("Solde insuffisant pour effectuer ce retrait ! (Solde actuel: " + solde + " €)");
        } else {
            System.out.println("Erreur: Le montant du retrait doit être positif.");
        }
    }

    public void virementVers(CompteBancaire compteDestination, double montant) {
        if (montant > 0 && montant <= this.solde) {
            this.solde -= montant;
            compteDestination.solde += montant;

            System.out.println("Virement de " + montant + " € effectué de " + this.nom + " vers " + compteDestination.nom + ".");
            this.getSolde(); // Afficher le nouveau solde du compte source
            compteDestination.getSolde(); // Afficher le nouveau solde du compte destination
        } else if (montant > this.solde) {
            System.out.println("Virement échoué: Solde insuffisant pour effectuer ce virement !");
        } else {
            System.out.println("Virement échoué: Le solde ne permet pas cette transaction.");
        }
    }

    public char[] getAccountNumber() {
        return this.accountnumber;
    }
}