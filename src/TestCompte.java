public class TestCompte {
    public static void main(String[] args) {
        testCompte();
        System.out.println("─".repeat(60));
        testTableauCompte();
    }

    public static void testCompte() {
        CompteBancaire c1 = new CompteBancaire("Alice Dupont", 500.0, "1111".toCharArray());
        CompteBancaire c2 = new CompteBancaire("Bob Martin", 100.0, "2222".toCharArray());

        c1.affiche();
        c2.affiche();

        System.out.println("\n— Test Dépôt —");
        c1.deposer(150.0);
        c1.getSolde();

        System.out.println("\n— Test Retrait —");
        c2.retirer(50.0);
        c2.retirer(500.0);

        System.out.println("\n— Test Virement —");
        c1.virementVers(c2, 100.0);

        c1.affiche();
        c2.affiche();
    }

    public static void testTableauCompte() {
        System.out.println("\n— Test Tableau de Comptes —");
        CompteBancaire[] tab = new CompteBancaire[4];

        for (int i = 0; i < tab.length; i++) {
            tab[i] = new CompteBancaire("Compte n°" + (i + 1), 20.0, ("C" + (i + 1)).toCharArray());
        }

        System.out.println("\nCrédits :");
        for (int i = 0; i < tab.length; i++) {
            System.out.print("Compte n°" + (i + 1) + " : ");
            tab[i].deposer(100.0 * i);
        }

        System.out.println("\nRetraits de 15 € :");
        for (int i = 0; i < tab.length; i++) {
            System.out.print("Compte n°" + (i + 1) + " : ");
            tab[i].retirer(15.0);
        }

        System.out.println("\nAffichage final :");
        for (CompteBancaire c : tab) c.affiche();
    }
}