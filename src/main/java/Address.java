public class Address {
    private String Street;
    private int houseNumber;

    public Address(String street, int houseNumber) {
        Street = street;
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return Street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }
}
