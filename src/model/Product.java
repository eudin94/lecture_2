package model;

public class Product {

    public Product() {
    }

    public Product(String name, Double totalValue) {
        this.name = name;
        this.totalValue = totalValue;
    }

    private String name;
    private Double totalValue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }
}
