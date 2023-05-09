public class Book implements ItemElement {

    private float price;
    private String isbnNumber;

    public Book(int cost, String isbn) {
        this.price = cost;
        this.isbnNumber = isbn;
    }

    public float getPrice() {
        return price;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    @Override
    public float accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }

}
