public class House {
    private String address;
    private int price;
    private int area;
    private int numBedrooms;

    public House(String address, int price, int area, int numBedrooms) {
        this.address = address;
        this.price = price;
        this.area = area;
        this.numBedrooms = numBedrooms;
    }

    public String getAddress() {
        return address;
    }

    public int getPrice() {
        return price;
    }

    public int getArea() {
        return area;
    }

    public int getNumBedrooms() {
        return numBedrooms;
    }

    public boolean satisfies (Criteria c) {
        if (this.area >= c.getMinArea() && this.area <= c.getMaxArea()
                && this.price >= c.getMinPrice() && this.price <= c.getMaxPrice()
                && this.numBedrooms >= c.getMinNumOfBedrooms() && this.numBedrooms <= c.getMaxNumOfBedrooms())
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return "House{" +
                "address='" + address + '\'' +
                ", price=" + price +
                ", area=" + area +
                ", numBedrooms=" + numBedrooms +
                '}';
    }
}