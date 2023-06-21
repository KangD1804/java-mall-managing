package Store;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class StoreDatabase {
    private static StoreDatabase instance = null;
    private static Set<Store> storeList;

    private StoreDatabase() {
        storeList = new HashSet<>();
    }

    public static StoreDatabase getInstance() {
        if (instance == null) {
            instance = new StoreDatabase();
        }
        return instance;
    }

    public boolean checkStoreExistence(Store store){
        for(Store storeExisted : storeList){
            if(store.getName().equalsIgnoreCase(storeExisted.getName())){
                return true;
            }
        }
        return false;
    }

    public void addStore(Store store) {
        try {
            if(storeList.size() > 0){
                if(checkStoreExistence(store)) {
                    throw new Exception();
                } else {storeList.add(store);}
            }else{
                storeList.add(store);
            }
        }catch (Exception e){
            System.out.println(store.getName()+ " is added/existed");
        }
    }

    public void removeStore(Store store){
        if(storeList.contains(store)){
            storeList.remove(store);
        } else {
            System.out.println("Store.Store not exist.");
        }
    }

    public Set<Store> getStoresOnFloor(int floor) {
        Set<Store> storesOnFloor = new HashSet<>();
        for(Store store : storeList){
            if(store.getFloor() == floor){
                storesOnFloor.add(store);
            }
        }
        return storesOnFloor;
    }

    public int getTotalArea() {
    int totalArea = 0;
    for (Store store : storeList) {
        totalArea += store.getArea();
    }
    return totalArea;
    }

    public double calculateTotalRent(double ratePerUnitArea) {
        double totalRent = getTotalArea() * ratePerUnitArea;
        return totalRent;
    }

    public void exportStoreList() {
        String filePath = "./store_data.txt";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath);
            for (Store store : storeList) {
                fileWriter.write(store.getName() + " at floor " + store.getFloor() + " at " + store.getLocation() +"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void exportRentList() {
        String filePath = "./store_rent_data.txt";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath);
            for (Store store : storeList) {
                fileWriter.write(store.getName() + " at floor " + store.getFloor() + " is paying " + store.calculateRent(150.0) +"\n");
            }
            fileWriter.write("Total income from store: " +this.calculateTotalRent(150.0));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}