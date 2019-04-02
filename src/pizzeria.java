import java.util.ArrayList;
import java.util.Scanner;

public class pizzeria {

    public static void preparerPizza(pizza quellePizza)
    {
        System.out.println("La pizza " + quellePizza.pizzaName() + " est préparée...");
    }

    public static void cuirePizza(pizza quellePizza)
    {
        System.out.println("La pizza " + quellePizza.pizzaName() + " est cuite...");
    }

    public static void miseEnBoitePizza(pizza quellePizza)
    {
        System.out.println("La pizza " + quellePizza.pizzaName() + " est mise en boîte...");
    }

    public static void main(String[] args)
    {
        System.out.println("Bienvenue à la pizzeria Kidepote");

        String choixPizza = "";
        pizza pizzaChoisie = null;
        pizzaFactory pizzaFactory = new pizzaFactory();

        Scanner scanner = new Scanner(System.in);

        ArrayList<pizza> commande = new ArrayList<>();
        int totalDu = 0;

        do
        {
            System.out.println("\nQuelle pizza voulez-vous commander ?");
            System.out.println("[1] Pizza aux fromages");
            System.out.println("[2] Pizza 4 saisons");
            System.out.println("[3] Pizza aux poireaux");
            System.out.println("[4] Pizza fraises/jambon");
            System.out.println("[X] Quitter");

            choixPizza = scanner.nextLine();

            pizzaChoisie = pizzaFactory.getPizza(choixPizza);

            if (pizzaChoisie != null)
            {
                preparerPizza(pizzaChoisie);
                cuirePizza(pizzaChoisie);
                miseEnBoitePizza(pizzaChoisie);
                System.out.println("La pizza " + pizzaChoisie.pizzaName() + " est prête.");
                System.out.println("Ca fait " + pizzaChoisie.prix() + " €");
                
                commande.add(pizzaChoisie);
                totalDu += pizzaChoisie.prix();
            }

        }
        while(!choixPizza.toUpperCase().equals("X"));

        System.out.println("\n--------------------------------------------------------");
        System.out.println("Recapitulatif de la commande :");
        commande.forEach(pizzaCommandee -> System.out.println(pizzaCommandee.pizzaName()
                + ", " + pizzaCommandee.prix() + " €"));

        System.out.println("\nPrix total de la commande : " + totalDu + " €");
        System.out.println("Merci de votre visite.");
    }
}