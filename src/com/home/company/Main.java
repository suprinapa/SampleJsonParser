package com.home.company;

import java.util.*;
public class Main {
   public static void main(String[] args) {
       ArrayList<SalesMan> mySalesManlist  =  ReadJsonToList();
       PrintTheList(mySalesManlist);
       ArrayList<SalesMan> londonCity = SpecificCity(mySalesManlist);
       PrintTheList(londonCity);
       int x = TotalSalesmaninLondon(mySalesManlist);
       Print(x);
       ArrayList<String> y = LondonNames(mySalesManlist);
       Printstr(y);
   }
    //write function to return only names of all salesman who lives in london
   public static ArrayList<String> LondonNames (ArrayList<SalesMan> allSalesMan){
       ArrayList<String> London = new ArrayList<>();
       for (int i = 0; i < allSalesMan.size(); i++) {
           SalesMan city = allSalesMan.get(i);
           if(city.City =="London"){
                  London.add(city.Name);
                  }

              }
           return London;
   }
public static ArrayList<SalesMan>SpecificCity(ArrayList<SalesMan> allSalesMan){
     ArrayList<SalesMan> London = new ArrayList<>();
    for (int i = 0; i < allSalesMan.size(); i++) {
       SalesMan city = allSalesMan.get(i);
       if(city.City =="London"){
          London.add(city);
       }
    }
    return London;
}

public static int TotalSalesmaninLondon(ArrayList<SalesMan> allSalesMan){
        int total = 0;
        for (int a = 0; a < allSalesMan.size(); a++) {
            SalesMan thisSalesman = allSalesMan.get(a);
            if (thisSalesman.City == "London") {
                total++;
            }
        }
        return total;
}

    public static void PrintTheList(ArrayList<SalesMan> allSalesManArg){
        for (int i=0; i<allSalesManArg.size(); i++)
        {
            SalesMan currentSalesman = allSalesManArg.get(i);
            System.out.println(" The sales man " + currentSalesman.Name + " lives in " + currentSalesman.City + " and is " + currentSalesman.Age + " years old");
        }
    }

    public  static void Print(int allSalesManArg){
        System.out.println("Total people living in london =" +allSalesManArg);
    }
    public  static void Printstr (ArrayList<String> allSalesManArg){
        System.out.println("people living in london with name =" +allSalesManArg);
    }

    private static SalesMan CreateSalesman(String name, String city, int age) {
    SalesMan objSalesMan = new SalesMan();
        objSalesMan.Name = name;
        objSalesMan.City = city;
        objSalesMan.Age = age;

    return objSalesMan;
    }

    private static ArrayList<SalesMan> ReadJsonToList() {
       ArrayList<SalesMan> allSalesMan = new ArrayList<SalesMan>() ;
        allSalesMan.add(CreateSalesman("Jones","Boston",34));
        allSalesMan.add(CreateSalesman("Kivell","London",54));
        allSalesMan.add(CreateSalesman("Jardine","Boston",34));
        allSalesMan.add(CreateSalesman("Sorvino","NewYork",41));
        allSalesMan.add(CreateSalesman("Andrews","Boston",27));
        allSalesMan.add(CreateSalesman("Thompson","London",32));
        allSalesMan.add(CreateSalesman("Howard","NewYork",22));
        allSalesMan.add(CreateSalesman("Parent","Boston",31));
        allSalesMan.add(CreateSalesman("Smith","London",40));
        return allSalesMan;
    }
}
