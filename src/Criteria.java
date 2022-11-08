public class Criteria {
    private int minPrice;
    private int maxPrice;
    private int minArea;
    private int maxArea;
    private int minNumOfBedrooms;
    private int maxNumOfBedrooms;

    public Criteria(int minPrice, int maxPrice, int minArea, int maxArea, int minNumOfBedrooms, int maxNumOfBedrooms) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.minArea = minArea;
        this.maxArea = maxArea;
        this.minNumOfBedrooms = minNumOfBedrooms;
        this.maxNumOfBedrooms = maxNumOfBedrooms;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public int getMinArea() {
        return minArea;
    }

    public int getMaxArea() {
        return maxArea;
    }

    public int getMinNumOfBedrooms() {
        return minNumOfBedrooms;
    }

    public int getMaxNumOfBedrooms() {
        return maxNumOfBedrooms;
    }

}