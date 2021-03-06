package com.home.company;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        ArrayList<SalesMan> mySalesManList = ReadJsonToList();
        String city = "London";
        int age = 0;
        boolean isOldest = false;
        if(isOldest) {
            SalesMan oldest = GetOldestSalesman(mySalesManList);
            PrintYoungestOrOldest(oldest, isOldest);
        }
        else {
            SalesMan youngest = GetYoungestSalesman(mySalesManList);
            PrintYoungestOrOldest(youngest, isOldest);
        }
        ArrayList<SalesMan> CityYouWant = SpecificCity(mySalesManList, city);
        PrintTheList(CityYouWant);
        ArrayList<SalesMan> AgeYouWant = Specific(mySalesManList, age);
        PrintTheList(AgeYouWant);
        int x = TotalSalesManInCity(mySalesManList, city);
        Print(x, city);
        ArrayList<String> y = PersonLivingInCity(mySalesManList, city);
        PrintStr(y, city);
        double z = AvgAge(mySalesManList, city);
        PrintAvg(z, city);
        ArrayList<SalesMan> sortByAge = OrderBy(mySalesManList);
        PrintSort(sortByAge);
        int maxMinValue = MaxAndMin(mySalesManList);
        PrintMaxMin(maxMinValue);
        ArrayList<String> bothCities = BothCity(mySalesManList);
        PrintSalesManInLondonNewYork(bothCities);
        SalesMan secondOldest = SecondOldest(mySalesManList, city);
        PrintSecondOldest(secondOldest, city);
        HashMap<String, Double> eachCityAverage = eachAvgCity(mySalesManList);
        PrintEachCityAvg(eachCityAverage);
    }

    public static HashMap<String, Double> eachAvgCity(ArrayList<SalesMan>allSalesman) {
        HashMap<String, Double> map = new HashMap<>();
        ArrayList<String> DistinctCity = new ArrayList<>();
        for (int i = 0; i < allSalesman.size(); i++) {
            SalesMan salesMan = allSalesman.get(i);
            String uniqueCity = salesMan.City;
            if (!DistinctCity.contains(uniqueCity)) {
                DistinctCity.add(uniqueCity);
                for (int j = 0; j < DistinctCity.size(); j++) {
                    map.put(uniqueCity, AvgAge(allSalesman,uniqueCity));
                }
            }
        }
        return map;
    }

    //write a function to object(salesman) of salesman who is  second oldest in London
    public static SalesMan SecondOldest(ArrayList<SalesMan> allSalesMan, String city) {
        OrderBy(allSalesMan);
        for (int i = 0; i < allSalesMan.size(); i++) {
            SalesMan SalesManCity = allSalesMan.get(i);
            if (SalesManCity.City == city) {
            }
        }
        return allSalesMan.get(allSalesMan.size() - 2);
    }

   //write a function to find name of salesman who lives in both london and Newyork
    public static ArrayList<String> BothCity (ArrayList<SalesMan>allSalesMan) {
        ArrayList<String> LondonCity = new ArrayList<>();
        ArrayList<String> NewYorkCity = new ArrayList<>();
        for (int i = 0; i < allSalesMan.size(); i++) {
            SalesMan salesManName = allSalesMan.get(i);

            if (salesManName.City == "London") {
                LondonCity.add(salesManName.Name);
            }

            if (salesManName.City == "NewYork") {
                NewYorkCity.add(salesManName.Name);
            }
            LondonCity.retainAll(NewYorkCity);

        }
        return LondonCity;
    }

   //write function to return object(salesman) of salesman who is oldest.
    public static SalesMan GetOldestSalesman(ArrayList<SalesMan>allSalesMan){
    OrderBy(allSalesMan);
    return  allSalesMan.get(allSalesMan.size()-1);
    }

   //write function to return object(salesman) of salesman who is youngest.
    public static SalesMan GetYoungestSalesman(ArrayList<SalesMan>allSalesMan) {
        OrderBy(allSalesMan);
        return allSalesMan.get(0);
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
       Collections.sort(allSalesMan, new AgeComparator());
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
            Integer age = salesMan.Age++;
             total = total+age;
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

    public static void PrintYoungestOrOldest(SalesMan allSalesManArg, boolean isOldest){
        if(isOldest){
            System.out.println("Oldest SalesMan is: " +allSalesManArg.Name+" and his age is " + allSalesManArg.Age);
        }
        else System.out.println("Youngest SalesMan is: " +allSalesManArg.Name+" and his age is " + allSalesManArg.Age);
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
    public  static void PrintSecondOldest(SalesMan allSalesManArg, String city){
    System.out.println("Second Oldest in " + city + " is " +allSalesManArg.Name);
    }

    public static void PrintEachCityAvg (HashMap<String, Double> allSalesManArg){
        for (Map.Entry pairEntry : allSalesManArg.entrySet()){
            System.out.println(pairEntry.getKey() + " : " +pairEntry.getValue());
        }
    }


    private static SalesMan CreateSalesman(String name, String city, int age) {
    SalesMan objSalesMan = new SalesMan();
        objSalesMan.Name = name;
        objSalesMan.City = city;
        objSalesMan.Age = age;
    return objSalesMan;
    }

    private static ArrayList<SalesMan> ReadJsonToList() {
       ArrayList<SalesMan> allSalesMan = new ArrayList<>() ;
        allSalesMan.add(CreateSalesman("Jones","Boston",34));
        allSalesMan.add(CreateSalesman("Kivell","London",54));
        allSalesMan.add(CreateSalesman("Jardine","Boston",34));
        allSalesMan.add(CreateSalesman("Sorvino","NewYork",41));
        allSalesMan.add(CreateSalesman("Andrews","Boston",27));
        allSalesMan.add(CreateSalesman("Thompson","London",32));
        allSalesMan.add(CreateSalesman("Howard","NewYork",22));
        allSalesMan.add(CreateSalesman("Parent","Boston",31));
        allSalesMan.add(CreateSalesman("Smith","London",40));
        allSalesMan.add(CreateSalesman("Kivell","NewYork",54));
        allSalesMan.add(CreateSalesman("Thompson","NewYork",32));
        return allSalesMan;
    }
}
