package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Day1Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("input-day1.txt");
        Scanner in = new Scanner(inputFile);
        HashSet<Integer> set = new HashSet<>();
        while(in.hasNextLine()) {
            String valStr = in.nextLine();
            int val = Integer.parseInt(valStr);
            if(set.contains(2020-val)) {
                System.out.println((2020-val) * val);
            }
            set.add(val);
        }
        in.close();
    }
}
