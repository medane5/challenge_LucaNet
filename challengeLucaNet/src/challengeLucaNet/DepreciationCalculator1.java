package challengeLucaNet;

import java.util.Calendar;

public class DepreciationCalculator1 {
	/*represents the useful life of the asset*/
    private int assetDepreciationRange;
    /*stores the date when the asset was acquired*/
    private Calendar acquisitionDate;
    /*represents the initial cost of the asset*/
    private double acquisitionCosts;
    
    
    /*The constructor DepreciationCalculator is used to initialize the instance variables with the provided values*/
    public DepreciationCalculator1(int assetDepreciationRange, Calendar acquisitionDate, double acquisitionCosts) {
        this.assetDepreciationRange = assetDepreciationRange;
        this.acquisitionDate = acquisitionDate;
        this.acquisitionCosts = acquisitionCosts;
    }
    
    /*The calculatedLinearDepreciation method calculates and prints the straight-line depreciation of the asset*/
    public void calculatedLinearDepreciation() {
        double depreciationAmount = acquisitionCosts / assetDepreciationRange;
        double remainingBookValue = acquisitionCosts;
        
        for (int year = acquisitionDate.get(Calendar.YEAR); year < acquisitionDate.get(Calendar.YEAR) + assetDepreciationRange; year++) {
        	remainingBookValue -= depreciationAmount;
            System.out.printf("%d: | Depreciation amount: %.2f | Remaining book value: %.2f\n",
                    year, depreciationAmount, remainingBookValue);
            
          
        }
    }
    
    
    /*The calculateDegressiveDepreciation method calculates and prints the declining balance depreciation of the asset*/
    public void calculateDegressiveDepreciation() {
        double maxDepreciationRate = acquisitionDate.get(Calendar.YEAR) < 2006 ? 20.0 : 30.0;
        double depreciationRate = maxDepreciationRate / 100.0 / assetDepreciationRange;
        double remainingBookValue = acquisitionCosts;
        
        for (int year = acquisitionDate.get(Calendar.YEAR); year < acquisitionDate.get(Calendar.YEAR) + assetDepreciationRange; year++) {
            double depreciationAmount = remainingBookValue * depreciationRate;
            
            if (depreciationAmount > remainingBookValue) {
                depreciationAmount = remainingBookValue;
            }
            
            System.out.printf("%d: | Depreciation amount: %.2f | Remaining book value: %.2f\n",
                    year, depreciationAmount, remainingBookValue);
            
            remainingBookValue -= depreciationAmount;
        }
    }
    
    public static void main(String[] args) {
        int usefulLife = 5;
        Calendar acquisitionDate = Calendar.getInstance();
        acquisitionDate.set(Calendar.YEAR, 2015);
        acquisitionDate.set(Calendar.MONTH, 0);
        acquisitionDate.set(Calendar.DAY_OF_MONTH, 1);
        double acquisitionCosts = 1000.0;
        
        DepreciationCalculator1 calculator = new DepreciationCalculator1(usefulLife, acquisitionDate, acquisitionCosts);
        calculator.calculatedLinearDepreciation();
        
        System.out.println();
        
        calculator.calculateDegressiveDepreciation();
    }
}

