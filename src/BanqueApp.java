import java.util.Scanner;
import java.util.HashMap;

public class BanqueApp {
    static HashMap<String, CompteBancaire> comptes = new HashMap<>();
    static int compteur = 1000;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("════════════════════════════════════════");
        System.out.println("       CompteBancaire — Simulation      ");
        System.out.println("════════════════════════════════════════");
        menuAccueil();
        sc.close();
    }

    static void menuAccueil() {
        while (true) {
            System.out.println("\n[1] Créer un compte");
            System.out.println("[2] Se connecter");
            System.out.println("[0] Quitter");
            System.out.print("\n> ");
            String choix = sc.nextLine().trim();

            if (choix.equals("1")) creerCompte();
            else if (choix.equals("2")) seConnecter();
            else if (choix.equals("0")) { System.out.println("Au revoir."); break; }
            else System.out.println("Entrez 1, 2 ou 0.");
        }
    }

    static void creerCompte() {
        System.out.print("\nVotre nom : ");
        String nom = sc.nextLine().trim();

        System.out.print("Solde initial (€) : ");
        String soldeStr = sc.nextLine().trim();

        try {
            double solde = Double.parseDouble(soldeStr.replace(",", "."));
            if (solde < 0) { System.out.println("Solde invalide."); return; }

            compteur++;
            String numero = String.valueOf(compteur);
            CompteBancaire c = new CompteBancaire(nom, solde, numero.toCharArray());
            comptes.put(numero, c);

            System.out.println("\n✓ Compte créé !");
            System.out.println("Votre numéro de compte : " + numero);
            System.out.println("Conservez-le pour vous connecter.");
            menuCompte(c);

        } catch (NumberFormatException e) {
            System.out.println("Montant invalide.");
        }
    }

    static void seConnecter() {
        if (comptes.isEmpty()) {
            System.out.println("Aucun compte existant. Créez-en un d'abord.");
            return;
        }
        System.out.println("\n— Comptes disponibles —");
        for (CompteBancaire c : comptes.values()) {
            System.out.println("  N° " + new String(c.getAccountNumber()) + " → " + c.getNom());
        }
        System.out.print("\nNuméro de compte : ");
        String num = sc.nextLine().trim();

        CompteBancaire c = comptes.get(num);
        if (c == null) System.out.println("Compte introuvable.");
        else menuCompte(c);
    }

    static void menuCompte(CompteBancaire compte) {
        while (true) {
            System.out.println("\n════════════════════════════════════════");
            System.out.println("  Connecté : " + compte.getNom());
            System.out.println("  N° " + new String(compte.getAccountNumber()) + " | Solde : " + compte.getSoldeValue() + " €");
            System.out.println("════════════════════════════════════════");
            System.out.println("[1] Voir le solde");
            System.out.println("[2] Déposer");
            System.out.println("[3] Retirer");
            System.out.println("[4] Virement");
            System.out.println("[5] Voir tous les comptes");
            System.out.println("[6] Déconnexion");
            System.out.print("\n> ");
            String choix = sc.nextLine().trim();

            if (choix.equals("1")) {
                compte.getSolde();

            } else if (choix.equals("2")) {
                System.out.print("Montant à déposer (€) : ");
                double m = lireMontant();
                if (m > 0) compte.deposer(m);

            } else if (choix.equals("3")) {
                System.out.print("Montant à retirer (€) : ");
                double m = lireMontant();
                if (m > 0) compte.retirer(m);

            } else if (choix.equals("4")) {
                if (comptes.size() < 2) {
                    System.out.println("Aucun autre compte disponible.");
                    continue;
                }
                System.out.println("\n— Comptes disponibles —");
                for (CompteBancaire c : comptes.values()) {
                    if (!new String(c.getAccountNumber()).equals(new String(compte.getAccountNumber()))) {
                        System.out.println("  N° " + new String(c.getAccountNumber()) + " → " + c.getNom());
                    }
                }
                System.out.print("Numéro destinataire : ");
                String dest = sc.nextLine().trim();
                CompteBancaire cDest = comptes.get(dest);
                if (cDest == null) { System.out.println("Compte introuvable."); continue; }
                System.out.print("Montant à virer (€) : ");
                double m = lireMontant();
                if (m > 0) compte.virementVers(cDest, m);

            } else if (choix.equals("5")) {
                System.out.println("\n— Tous les comptes —");
                for (CompteBancaire c : comptes.values()) c.affiche();

            } else if (choix.equals("6")) {
                System.out.println("Déconnecté.");
                break;

            } else {
                System.out.println("Entrez un chiffre entre 1 et 6.");
            }
        }
    }

    static double lireMontant() {
        try {
            return Double.parseDouble(sc.nextLine().trim().replace(",", "."));
        } catch (NumberFormatException e) {
            System.out.println("Montant invalide.");
            return -1;
        }
    }
}