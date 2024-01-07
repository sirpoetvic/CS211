public class DiscountBill extends GroceryBill {
    private int discountCount;
    private double discountAmount;
    private boolean isPreferred;

    public DiscountBill() {
        this(new Employee(), false);
    }

    public DiscountBill(Employee clerk, boolean preferred) {
        super(clerk);
        discountCount = 0;
        discountAmount = 0;
        isPreferred = preferred;
    }

    @Override
    public void add(Item i) {
        super.add(i);
        if(isPreferred && i.getDiscount() >= 0) {
            discountCount++;
            discountAmount += i.getDiscount();
        }
    }


    @Override
    public double getTotal() {
        return super.getTotal() - discountAmount;
    }

    public int getDiscountCount() {
        return discountCount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public double getDiscountPercent() {
        return discountAmount * 100 / super.getTotal();
    }

}