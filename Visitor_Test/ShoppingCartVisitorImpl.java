public class ShoppingCartVisitorImpl implements ShoppingCartVisitor {

    @Override
    public float visit(Book book) {
        float cost = 0;
        //apply 5$ discount if book price is greater than 50
        if (book.getPrice() < 0){
            System.out.println("Cost of book with ISBN " + book.getIsbnNumber() + " can't be less that 0");
        return cost;
        }
        else {
            if (book.getPrice() > 50) {
                cost = book.getPrice() - 5;
            } else cost = book.getPrice();
            System.out.println("Book ISBN::" + book.getIsbnNumber() + " cost = " + cost);
            return cost;
        }
    }

    @Override
    public float visit(Fruit fruit) {
        float cost = 0;
        if (fruit.getPricePerKg() < 0 || fruit.getWeight() < 0) {
            try {
                System.out.println("Cost or weight of " + fruit.getName() + " can't be less that 0");
            } catch (Exception ex) {
                System.out.println("Exception: " + ex.getMessage());
            }
            return 0;
        } else {
            cost = fruit.getPricePerKg() * fruit.getWeight();
            System.out.println(fruit.getName() + " cost = " + cost);
            return cost;
        }
    }
}
