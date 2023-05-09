public class Fruit implements ItemElement {

    private int pricePerKg;
    private float weight;
    private String name;

    public Fruit(int priceKg, float wt, String nm) {
        this.pricePerKg = priceKg;
        this.weight = wt;
        this.name = nm;
    }

    public int getPricePerKg() {
        return pricePerKg;
    }


    public float getWeight() {
        return weight;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public float accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }

}
