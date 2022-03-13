package com.home.company;
import java.util.*;
public class Main {
public static void main(String[] args){
       ArrayList<SalesMan> mySalesManlist  =  ReadJsonToList();
       String city = "London";
       int age = 0;
       ArrayList<SalesMan> CityYouWant = SpecificCity(mySalesManlist,city);
       PrintTheList(CityYouWant);
       ArrayList<SalesMan> AgeYouWant = Specific(mySalesManlist,age);
       PrintTheList(AgeYouWant);
       int x = TotalSalesManInCity(mySalesManlist, city);
       Print(x,city);
       ArrayList<String> y = PersonLivingInCity(mySalesManlist, city);
       PrintStr(y, city);
       double z = AvgAge(mySalesManlist,city);
       PrintAvg(z,city);
       ArrayList<SalesMan> sortByAge = OrderBy(mySalesManlist);
       PrintSort(sortByAge);
       int maxMinValue = MaxAndMin(mySalesManlist);
       PrintMaxMin(maxMinValue);
      String youngest = GetYoungestSalesman(mySalesManlist);
      PrintYoungestSalesMan(youngest);
      String oldest = GetOldestSalesman(mySalesManlist);
      PrintOldestSalesMan(oldest);
      ArrayList<String> bothCities = BothCity(mySalesManlist);
      PrintSalesManInLondonNewYork(bothCities);
   }

   //write a function to find name of salesman who lives in both london and Newyork
    public static ArrayList<String> BothCity (ArrayList<SalesMan>allSalesMan){
    ArrayList<String> bothCity = new ArrayList<>();
        for (int i = 0; i < allSalesMan.size(); i++) {
            SalesMan salesManName = allSalesMan.get(i);
            if(salesManName.City == "London" || salesManName.City == "NewYork" ){
                bothCity.add(salesManName.Name);
            }
        }
    return bothCity;
    }


   //write function to return object(salesman) of salesman who is oldest.
    public static String GetOldestSalesman(ArrayList<SalesMan>allSalesMan){
    OrderBy(allSalesMan);
    SalesMan oldest = null;
    String NameOfOldest = null;

        for (int i = 0; i < allSalesMan.size(); i++) {
            oldest = allSalesMan.get(allSalesMan.size()-1);
            NameOfOldest = oldest.Name;
        }
    return NameOfOldest;
    }

   //write function to return object(salesman) of salesman who is youngest.
    public static String GetYoungestSalesman(ArrayList<SalesMan>allSalesMan) {
        OrderBy(allSalesMan);
        SalesMan youngest = null;
        String NameOfYoungest = null;
        for (int s = 0; s < allSalesMan.size(); s++) {
            youngest = allSalesMan.get(0);
            NameOfYoungest = youngest.Name;
        }
        return NameOfYoungest;
    }

   // Write function to return difference of max age and min age of salesman who lives in london.
 public static int MaxAndMin(ArrayList<SalesMan> allSalesMan) {
     ArrayList<SalesMan> sort = OrderBy(allSalesMan);
     SalesMan min = null;
     SalesMan max = null;
     int value = 0;
     for (int s = 0; s < allSalesMan.size(); s++) {
         min = allSalesMan.get(0);
         max = allSalesMan.get(allSalesMan.size()-1);
         value =  max.Age - min.Age;
     }
     return value;
 }

    // write function to return list of salesman order by their age.
public static ArrayList<SalesMan> OrderBy(ArrayList<SalesMan>allSalesMan) {
       Collections.sort(allSalesMan, new Comparator<SalesMan>() {
           @Override
           public int compare(SalesMan s1, SalesMan s2) {
               return ((Integer)s1.Age.compareTo(s2.Age));
           }
       });
    return allSalesMan;
}
    //write function to return average age of salesman who lives in london
    public static double AvgAge(ArrayList<SalesMan> allSalesMan,String city) {
        double avg = 0;
        double total = 0;
        int totalOfCity = TotalSalesManInCity(allSalesMan, city);
        ArrayList<SalesMan> ages = SpecificCity(allSalesMan,city);
        for (int i = 0; i < ages.size(); i++) {
            SalesMan salesMan = ages.get(i);
             total = total+ salesMan.Age++;
        }
        avg = total/totalOfCity;
        return avg;
    }

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

public static ArrayList<SalesMan>Specific(ArrayList<SalesMan> allSalesMan, int age){
        ArrayList<SalesMan> SalesManInfoYouWant = new ArrayList<>();
        for (int i = 0; i < allSalesMan.size(); i++) {
            SalesMan salesManAge = allSalesMan.get(i);
            if (salesManAge.Age == age ){
                SalesManInfoYouWant.add(salesManAge);
            }
        }
        return SalesManInfoYouWant;
    }

public static int TotalSalesManInCity(ArrayList<SalesMan> allSalesMan, String city){
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
    public  static void PrintAvg(double allSalesManArg,String city) {
        System.out.println("Avg age of people living in " + city + "=" + allSalesManArg);
    }
    public  static void PrintStr (ArrayList<String> allSalesManArg, String city){
        for (int i = 0; i < allSalesManArg.size(); i++) {
            String salesMan = allSalesManArg.get(i);
            System.out.println("people living in city " +city+ " with name =" +salesMan);
        }
    }

    public static void PrintYoungestSalesMan(String allSalesManArg){
        System.out.println("Youngest SalesMan is: "+allSalesManArg);
     }
    public static void PrintOldestSalesMan(String allSalesManArg){
        System.out.println("Oldest SalesMan is: "+allSalesManArg);
    }

    public  static void PrintSalesManInLondonNewYork(ArrayList<String> allSalesManArg){
    System.out.println("People Living in Both London and NewYork"+allSalesManArg);
    }
    public  static void PrintSort(ArrayList<SalesMan> allSalesManArg){
       System.out.println("Orderby age:");
        for (int i = 0; i < allSalesManArg.size(); i++) {
            SalesMan salesMan = allSalesManArg.get(i);
            System.out.print(salesMan.Age + ",");
        }
    }

    public static void PrintMaxMin(int allSalesManArg){
        System.out.println("\n the difference between max and min " +allSalesManArg);
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
