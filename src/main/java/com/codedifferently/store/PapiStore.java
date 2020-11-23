// This is the package it defines the family relation of objects
package com.codedifferently.store;
// this imports ArrayList, HashMap & Map classes from java.util library/folder
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
// this is PapiStore class that contains the scope of this class
public class PapiStore {
    // declaring variables tabs, isStoreOpen & owesPapiMoney
    private boolean isStoreOpen;
    private ArrayList<String> tabs;
    Map<String, Double> owesPapiMoney;
    // this is a constructor that initializes the declared variables in the PapiStore class
    public PapiStore(){
        this.isStoreOpen = false;
        this.tabs = new ArrayList();
        this.owesPapiMoney = new HashMap<>();
    }
    // a constructor that takes a boolean and ArrayList parameters
    public PapiStore(Boolean isOpen, ArrayList<String> tabsIn){
        this.isStoreOpen = isOpen;
        this.tabs = tabsIn;
        this.owesPapiMoney = new HashMap<>();
    }

    public void closeStore(){

    }
    // this is a method called openStore that returns void and is used to check if the store is open
    public void openStore(){
        this.isStoreOpen = true;
    }
    // this is a method that returns the true/false state depending on if the store is open
    public boolean isStoreOpen() {
        return isStoreOpen;
    }

    // a boolean method that will return true if the name in the parameter has an open tab at the papi store
    public Boolean allowToUseTab(String name){
        Boolean response = false;
        if(hasAnActiveTab(name) && !hasAnOverDueBalance(name))
            response = true;
        return response;
    }
    // a private method that returns true/false depending on if the name in its parameter has an overdue balance at papi store
    private boolean hasAnOverDueBalance(String name){
        if(!owesPapiMoney.containsKey(name))
            return false;
        Double money = owesPapiMoney.get(name);
        Boolean owes = false;
        if(money > 0.0)
            owes = true;
        return owes;
    }
    // this is a private method that returns true/false if the customer has an active tab or not
    private boolean hasAnActiveTab(String name){
        for (String tab : tabs){
            if (tab.equals(name))
                return true;
        }
        return false;
    }
    // this method does not return anything but will create/start a tabe for the name passed in or added
    public void createActiveTab(String name){
        this.tabs.add(name);
    }

    // this is the psvm that sends out a greeting when we access papi store.
    public static void main(String[] args) {
        System.out.println("Welcome to Papi Store, Hola");
    }


}
