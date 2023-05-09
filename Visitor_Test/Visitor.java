public class Visitor {

    public static void main(String[] args) {
        ItemElement[] items = new ItemElement[]{new Fruit(-10, 1, "Banana"), new Fruit(-3, 10, "Apple")};
        ItemElement[] itemss = new ItemElement[]{new Book(-120, "1234"),new Book(200, "5678"),
                new Fruit(15, -10, "Pomelo"), new Fruit(-55, 1, "Dragon Fruit")};

//
        float total = calculatePrice(itemss);
        System.out.println("Total Cost = " + total);


    }

    public static float calculatePrice(ItemElement[] items) {
        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
        float sum = 0;
        for (ItemElement item : items) {
            sum = sum + item.accept(visitor);
        }
        return sum;
    }


}
