public class TestCompte {

    public static void main(String[] args) {
        testCompte();
        System.out.println("---------------------------------------------------------------------");
        testTableauCompte();
    }
    public static void testCompte(){
        char[] numCompte1 = "1111".toCharArray();
        CompteBancaire compte1 = new CompteBancaire("Alice Dupont", 500.0, numCompte1);

        char[] numCompte2 = "2222".toCharArray();
        CompteBancaire compte2 = new CompteBancaire("Bob Martin", 100.0, numCompte2);

        // affichage
        compte1.affiche();
        compte2.affiche();

        // test de la méthode deposer
        System.out.println("\nTest du Dépôt");
        compte1.deposer(150.0);
        compte1.getSolde();

        // test de la méthode retirer
        System.out.println("\nTest du Retrait");
        compte2.retirer(50.0);
        compte2.retirer(500.0); // retrait avec solde insuffisant

        // test de la méthode virementVers
        System.out.println("\n Test du Virement");
        compte1.virementVers(compte2, 100.0);

        // affichage
        compte1.affiche();
        compte2.affiche();
    }

    public static void testTableauCompte() {
        System.out.println("\n Test Tableau de Comptes");

        // création du tableau de 4 comptes
        CompteBancaire[] tabComptes = new CompteBancaire[4];

        for (int i = 0; i < tabComptes.length; i++) {
            String nom = "Compte n°" + (i + 1);
            String num = "C" + (i + 1);

            // chaque compte possède 20 euros
            tabComptes[i] = new CompteBancaire(nom, 20.0, num.toCharArray());
        }

        System.out.println("\nCrédits");
        for (int i = 0; i < tabComptes.length; i++) {
            // créditer les comptes de 100 euro multiplié par l’indice (i)
            double montantCredit = 100.0 * i;
            System.out.print("Compte n°" + (i+1) + " : ");
            tabComptes[i].deposer(montantCredit);
        }

        System.out.println("\nRetrait de 15 euros");
        for (int i = 0; i < tabComptes.length; i++) {
            System.out.print("Compte " + (i+1) + " : ");
            tabComptes[i].retirer(15.0);
        }

        System.out.println("\nAffichage");
        for (CompteBancaire compte : tabComptes) {
            compte.affiche(); // affichage
        }
    }
}

