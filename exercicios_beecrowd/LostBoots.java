import java.util.Scanner;
import java.util.ArrayList;

public class LostBoots {
    public static void main(String[] args) {
        int bootsNum, pairsNum, bootSize;
        String bootFoot;
        ArrayList<Integer> rightFootList;
        ArrayList<Integer> leftFootList;
        Scanner reader = new Scanner(System.in);

        while(reader.hasNext()) {
            rightFootList = new ArrayList<>();
            leftFootList = new ArrayList<>();

            bootsNum = reader.nextInt();
            pairsNum = 0;

            for(int i = 0; i < bootsNum; i++) {
                bootSize = reader.nextInt();
                bootFoot = reader.next();

                if(bootFoot.equals("D") && leftFootList.contains(bootSize)) {
                    pairsNum++;
                    leftFootList.remove(Integer.valueOf(bootSize));
                } else if(bootFoot.equals("E") && rightFootList.contains(bootSize)) {
                    pairsNum++;
                    rightFootList.remove(Integer.valueOf(bootSize));
                } else {
                    if(bootFoot.equals("D")) rightFootList.add(bootSize);
                    else leftFootList.add(bootSize);
                }
            }

            System.out.println(pairsNum);
        }

        reader.close();
    }
}
