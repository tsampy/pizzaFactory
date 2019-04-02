public class pizzaFactory {

    public pizza getPizza(String typePizza)
    {
        switch (typePizza.toUpperCase())
        {
            case "1":
                return new pizzaFromages();
            case "2":
                return new pizza4Saisons();
            case "3":
                return new pizzaPoireaux();
            case "4":
                return new pizzaFraisesJambon();
            default:
                return null;
        }
    }
}