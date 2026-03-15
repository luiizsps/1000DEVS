import java.util.Scanner;
import java.util.ArrayList;

public class PowerLines {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int expectedLastRegion = 13;
        int regionsNumber = 1;

        while(regionsNumber != 0) {
            ArrayList<Integer> regionsList;

            regionsNumber = reader.nextInt();

            if(regionsNumber == 0) {
                break;
            }
            
            int m = 1;
            while(true) {
                regionsList = createRegionsList(regionsNumber);
                int index = 0;

                while(regionsList.size() > 1) {
                    if(regionsList.get(index) == expectedLastRegion) {
                        break;
                    }
                    regionsList.remove(index);
                    index = (index + m - 1) % regionsList.size();
                }

                if(regionsList.get(0) == expectedLastRegion && regionsList.size() == 1) {
                    break;
                }

                m++;
            }

            System.out.println(m);
        }

        reader.close();
        
    }

    private static ArrayList<Integer> createRegionsList(int regionsNumber) {
        ArrayList<Integer> regionsList = new ArrayList<>();

        for(int i=1; i<=regionsNumber; i++) {
            regionsList.add(i);
        }

        return regionsList;
    }
}
