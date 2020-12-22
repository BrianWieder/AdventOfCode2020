package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("input-day3.txt");
        Scanner in = new Scanner(inputFile);
        ArrayList<String> lines = new ArrayList<>();
        while(in.hasNextLine()) {
            lines.add(in.nextLine());
        }
        long firstRocks = 0;
        for(int i = 1; i < lines.size(); i++) {
            if(lines.get(i).charAt(i % lines.get(i).length()) == '#') {
                firstRocks++;
            }
        }
        long secondRocks = 0;
        for(int i = 0; i < lines.size(); i++) {
            if(lines.get(i).charAt((i*3)%lines.get(i).length()) == '#') {
                secondRocks++;
            }
        }
        long thirdRocks = 0;
        for(int i = 0; i < lines.size(); i++) {
            if(lines.get(i).charAt((i*5)%lines.get(i).length()) == '#') {
                thirdRocks++;
            }
        }
        long fourthRocks = 0;
        for(int i = 0; i < lines.size(); i++) {
            if(lines.get(i).charAt((i*7)%lines.get(i).length()) == '#') {
                fourthRocks++;
            }
        }
        long fifthRocks = 0;
        for(int i = 0; i < lines.size() / 2; i++) {
            if(lines.get(i*2).charAt((i)%lines.get(i*2).length()) == '#') {
                fifthRocks++;
            }
        }
        System.out.println(secondRocks);
        System.out.println(firstRocks * secondRocks * thirdRocks * fourthRocks * fifthRocks);

        in.close();
    }
}
