package Store;

public class Store {
    private String name, location;
    private int floor;
    private int capacity; //Luong nguoi chua duoc trong cung 1 luc
    private int rent;

    private Store(StoreBuilder builder) {
        this.name = builder.name;
        this.location = builder.location;
        this.floor = builder.floor;
        this.capacity = builder.capacity;
        this.rent = builder.rent;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getFloor() {
        return floor;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getRent(){
        return rent;
    }

    public  int getArea(){
        return floor*capacity;
    }

    public double calculateRent(double ratePerUnitArea){
        return this.getArea()*ratePerUnitArea;
    }

    @Override
    public String toString() {
        return "Store {" +
                " name = '" + name + '\'' +
                ", location = '" + location + '\'' +
                ", floor = " + floor +
                ", capacity = " + capacity +
                ", rent = " + rent +
                '}';
    }

    public static class StoreBuilder {
        private String name;
        private String location;
        private int floor;
        private int capacity;
        private int rent;

        public StoreBuilder(String name, String location) {
            this.name = name;
            this.location = location;
        }

        public StoreBuilder setFloor(int floor) {
            this.floor = floor;
            return this;
        }

        public StoreBuilder setCapacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public StoreBuilder setRent(int rent){
            this.rent = rent;
            return this;
        }

        public Store build() {
            Store newStore = new Store(this);
            StoreDatabase storeDatabase = StoreDatabase.getInstance();
            storeDatabase.addStore(newStore);
            return newStore;
        }
    }
}


