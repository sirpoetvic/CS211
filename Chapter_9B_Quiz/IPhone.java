package Chapter_9B_Quiz;

/*
 * {Victor}
 * Winter 2023, C211, William Iverson
 * 1/9/24
 * Chapter 9b Quiz
 * Data structure class for a IPhone
 */
public class IPhone implements Asset {
    public static final double ANNUAL_DEPRECIATION = 0.2; //fraction decline each year
    private double originalCost; // in US dollars, fixed for each object
    private int currentAge; // in years


    public IPhone(double originalCost, int currentAge) {
        this.originalCost = originalCost;
        this.currentAge = currentAge;
    }
    
    public IPhone() {
        this(0,0);
    }


    // how much the asset is worth
    @Override
    public double getMarketValue() {
        return originalCost * Math.pow((1-ANNUAL_DEPRECIATION),currentAge);
    }
    
    // how much money has been made on this asset
    @Override
    public double getProfit() {
        return getMarketValue() - originalCost;
    }

    public String toString() {
        return "IPhone (" + currentAge + " years old)";
    }
}
