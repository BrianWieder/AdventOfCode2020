package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Day1Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("input-day1.txt");
        Scanner in = new Scanner(inputFile);
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> nums = new HashSet<>();
        while(in.hasNextLine()) {
            String valStr = in.nextLine();
            int val = Integer.parseInt(valStr);
            list.add(val);
            nums.add(val);
        }
        for(int i = 0; i < list.size() - 1; i++) {
            for(int x = i + 1; x < list.size(); x++) {
                int val = 2020 - list.get(i) - list.get(x);
                if(nums.contains(val)) {
                    System.out.println(val * list.get(i) * list.get(x)
                    );
                    return;
                }
            }
        }
        in.close();
    }
}
