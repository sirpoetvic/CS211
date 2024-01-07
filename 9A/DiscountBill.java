/*
 * {Victor}
 * Winter 2023, C211, William Iverson
 * 1/7/24
 * Chapter 9a Assignment
 * Data structure class for a Discount Bill
 */
public class DiscountBill extends GroceryBill {
    //Privated data fields
    private int discountCount;
    private double discountAmount;
    private boolean isPreferred;

    //Default Constructor
    public DiscountBill() {
        this(new Employee(), false);
    }

    //Main Constructor
    public DiscountBill(Employee clerk, boolean preferred) {
        super(clerk);
        discountCount = 0;
        discountAmount = 0;
        isPreferred = preferred;
    }

    //Overrides the add method from GroceryBill, keeps track of number of discounted
    //items and the discount amount
    @Override
    public void add(Item i) {
        super.add(i);
        if(isPreferred && i.getDiscount() > 0) {
            discountCount++;
            discountAmount += i.getDiscount();
        }
        
    }


    //Overrides the total method from GroceryBill to get a discounted total
    @Override
    public double getTotal() {
        return super.getTotal() - discountAmount;
    }

    //Getter methods
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