import java.util.Scanner;

public class IPA_1 {
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    TravelAgencies[] arr = new TravelAgencies[4];

    for(int i = 0; i < arr.length; i++){
        int a = sc.nextInt(); sc.nextLine();
        String b = sc.nextLine();
        String c = sc.nextLine();
        int d = sc.nextInt(); sc.nextLine();
        boolean e = sc.nextBoolean();
        arr[i] = new TravelAgencies(a, b, c, d, e);
    }
        int regNo = sc.nextInt(); sc.nextLine();
        String packageType = sc.nextLine();

        int max = findAgencyWithHighestPackagePrice(arr);
        TravelAgencies result = agencyDetailsforGivenIdAndType(arr, regNo, packageType);
        System.out.println(max);
        System.out.println(result.getAgencyName()+":"+result.getPrice());
        
    }

    public static int findAgencyWithHighestPackagePrice(TravelAgencies[] arr){
        int max =  arr[0].getPrice();
        for (int i = 1; i < arr.length; i++){
            if (max < arr[i].getPrice()){
                max =  arr[i].getPrice();
            }
        }

        if (max < 0){
            return 0;
        }
        else{
            return max;
        }
    }

    public static TravelAgencies agencyDetailsforGivenIdAndType(TravelAgencies[] arr, int regNo, String packageType){
        for (int i = 0; i < arr.length; i++){
            if (arr[i].flightFacility == true){
                if (arr[i].getRegNo() == regNo && arr[i].packageType.equals(packageType)){
                    return arr[i];
                }
            }
        }

        return null;
    }
}

class TravelAgencies{
    int regNo;
    String agencyName;
    String packageType;
    int price;
    boolean flightFacility;

    public String getAgencyName() {
        return agencyName;
    }

    public int getRegNo() {
        return regNo;
    }

    public String getPackageType() {
        return packageType;
    }

    public int getPrice() {
        return price;
    }

    public boolean getFlightFacility() {
        return flightFacility;
    }

    public TravelAgencies(int regNo, String agencyName, String packageType, int price, boolean flightFacility) {
        this.regNo = regNo;
        this.agencyName = agencyName;
        this.packageType = packageType;
        this.price = price;
        this.flightFacility = flightFacility;
    }


}
