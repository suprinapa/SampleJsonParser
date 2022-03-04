package com.home.company;
import java.util.*;
public class Main {
public static void main(String[] args){
       ArrayList<SalesMan> mySalesManlist  =  ReadJsonToList();
       String city = "London";
       ArrayList<SalesMan> CityYouWant = SpecificCity(mySalesManlist,city);
       System.out.println("People living in the given city");
       PrintTheList(CityYouWant);
       int x = TotalSalesmaninCity(mySalesManlist, city);
       Print(x,city);
       ArrayList<String> y = PersonLivingInCity(mySalesManlist, city);
       Printstr(y, city);
   }
/*   public static SalesMan GetYoungestSalesMan(ArrayList<SalesMan> allSalesMan){
       for (int s = 0; s < allSalesMan.size(); s++) {
           SalesMan salesMan = allSalesMan.get(s);
               int age = salesMan.Age;
               SalesMan max =allSalesMan.get(0);
          if (!(allSalesMan.get(s)  > max))   {
              max = allSalesMan.get(s);

           }
       }
       return max;
   }*/

    //write function to return only names of all salesman who lives in london
   public static ArrayList<String> PersonLivingInCity (ArrayList<SalesMan> allSalesMan, String city){
       ArrayList<String> salesManName = new ArrayList<>();
       for (int i = 0; i < allSalesMan.size(); i++) {
           SalesMan salesMan = allSalesMan.get(i);
           if(salesMan.City == city){
               salesManName.add(salesMan.Name);
                  }
              }
       return salesManName;
   }
public static ArrayList<SalesMan>SpecificCity(ArrayList<SalesMan> allSalesMan, String city){
 ArrayList<SalesMan> CityYouWant = new ArrayList<>();
    for (int i = 0; i < allSalesMan.size(); i++) {
       SalesMan cityName = allSalesMan.get(i);
       if(cityName.City == city){
          CityYouWant.add(cityName);
       }
    }
    return CityYouWant;
}

public static int TotalSalesmaninCity(ArrayList<SalesMan> allSalesMan, String city){
        int total = 0;
        for (int a = 0; a < allSalesMan.size(); a++) {
            SalesMan thisSalesman = allSalesMan.get(a);
            if (thisSalesman.City == city) {
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

    public  static void Print(int allSalesManArg, String city){
        System.out.println("Total people living in " +city+ " =" +allSalesManArg);
    }
    public  static void Printstr (ArrayList<String> allSalesManArg, String city){
        System.out.println("people living in city " +city+ " with name =" +allSalesManArg);
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
