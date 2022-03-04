package com.home.company;

import java.util.*;
public class Main {
   public static void main(String[] args) {
       ArrayList<SalesMan> mySalesManlist  =  ReadJsonToList();
       PrintTheList(mySalesManlist);
       ArrayList<SalesMan> londonCity = SpecificCity(mySalesManlist);
       PrintTheList(londonCity);
       TotalSalesmaninLondon(mySalesManlist);
       ArrayList<String> name = LondonNames(mySalesManlist);
       PrintTheList(name);

   }
    //write function to return only names of all salesman who lives in london
   public static ArrayList<String> LondonNames (ArrayList<SalesMan> allSalesMan){
       ArrayList<String> London = new ArrayList<>();
       for (int i = 0; i < allSalesMan.size(); i++) {
           SalesMan city = allSalesMan.get(i);
           if(city.city =="London"){
               for (int j = 0; j < allSalesMan.size(); j++) {
                   SalesMan name = allSalesMan.get(j);
                          London.add(name.name);
                   }

           }

       }
       return London;
   }

public static ArrayList<SalesMan>SpecificCity(ArrayList<SalesMan> allSalesMan){
     ArrayList<SalesMan> London = new ArrayList<>();
    for (int i = 0; i < allSalesMan.size(); i++) {
       SalesMan city = allSalesMan.get(i);
       if(city.city =="London"){
          London.add(city);
       }
    }
    return London;
}

public static void TotalSalesmaninLondon(ArrayList<SalesMan> allSalesMan){
        int total = 0;
        for (int a = 0; a < allSalesMan.size(); a++) {
            SalesMan thisSalesman = allSalesMan.get(a);
            if (thisSalesman.city == "London") {
                total++;
            }
        }
        System.out.println(" The sales man in London " + total);
}

    public static void PrintTheList(ArrayList<SalesMan> allSalesManArg){
        for (int i=0; i<allSalesManArg.size(); i++)
        {
            SalesMan currentSalesman = allSalesManArg.get(i);
            System.out.println(" The sales man " + currentSalesman.name + " lives in " + currentSalesman.city + " and is " + currentSalesman.age + " years old");
        }
    }

    private static ArrayList<SalesMan> ReadJsonToList() {
       ArrayList<SalesMan> allSalesMan = new ArrayList<SalesMan>() ;

        SalesMan objSalesManOne = new SalesMan();
        objSalesManOne.name = "Jones";
        objSalesManOne.city = "Boston";
        objSalesManOne.age = 34;
        allSalesMan.add(objSalesManOne);

        SalesMan objSalesManTwo = new SalesMan();
        objSalesManTwo.name = "Kivell";
        objSalesManTwo.city = "NewYork";
        objSalesManTwo.age = 23;
        allSalesMan.add(objSalesManTwo);

        SalesMan objSalesManThree = new SalesMan();
        objSalesManThree.name = "Jardine";
        objSalesManThree.city = "London";
        objSalesManThree.age = 54;
        allSalesMan.add(objSalesManThree);

        SalesMan objSalesManFour = new SalesMan();
        objSalesManFour.name = "Sorvino";
        objSalesManFour.city = "NewYork";
        objSalesManFour.age = 41;
        allSalesMan.add(objSalesManFour);

        SalesMan objSalesManFive = new SalesMan();
        objSalesManFive.name = "Andrews";
        objSalesManFive.city = "Boston";
        objSalesManFive.age = 27;
        allSalesMan.add(objSalesManFive);

        SalesMan objSalesManSix = new SalesMan();
        objSalesManSix.name = "Thompson";
        objSalesManSix.city = "London";
        objSalesManSix.age = 32;
        allSalesMan.add(objSalesManSix);

        SalesMan objSalesManSeven = new SalesMan();
        objSalesManSeven.name = "Howard";
        objSalesManSeven.city = "NewYork";
        objSalesManSeven.age = 22;
        allSalesMan.add(objSalesManSeven);

        SalesMan objSalesManEight = new SalesMan();
        objSalesManEight.name = "Parent";
        objSalesManEight.city = "Boston";
        objSalesManEight.age = 31;
        allSalesMan.add(objSalesManEight);

        SalesMan objSalesManNine = new SalesMan();
        objSalesManNine.name = "Smith";
        objSalesManNine.city = "London";
        objSalesManNine.age = 40;
        allSalesMan.add(objSalesManNine);

        return allSalesMan;
    }
}
