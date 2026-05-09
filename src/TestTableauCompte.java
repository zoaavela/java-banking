public static void main(String[] args) {
    System.out.println("Programme Tableau de Comptes");

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