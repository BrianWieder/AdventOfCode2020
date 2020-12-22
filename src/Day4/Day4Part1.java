package Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day4Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("input-day4.txt");
        Scanner scan = new Scanner(input);

        Pattern hair = Pattern.compile("#[0-9a-f]{6}");
        Pattern eye = Pattern.compile("(amb|blu|brn|gry|grn|hzl|oth)");
        Pattern passport = Pattern.compile("[0-9]{9}");

        String ecl  = null;
        String pid = null;
        int eyr = -1;
        String hcl = null;
        int byr = -1;
        int iyr = -1;
        String cid = null;
        String hgt = null;
        int numValid = 0;

        while(scan.hasNextLine()) {
            String line = scan.nextLine().trim();
            if(line.length() == 0) {
                boolean valid = true;
                if(byr < 1920 || byr > 2002) {
                    valid = false;
                }
                if(iyr < 2010 || iyr > 2020) {
                    valid = false;
                }
                if(eyr < 2020 || eyr > 2030) {
                    valid = false;
                }
                if(hcl == null || ecl == null || pid == null || hgt == null) {
                    valid = false;
                }

                if(valid) {
                    String type = hgt.substring(hgt.length()-2);
                    int height = Integer.parseInt(hgt.substring(0, hgt.length() - 2));
                    switch(type) {
                        case "in":
                            if(height < 59 || height > 76) {
                                valid = false;
                            }
                            break;
                        case "cm":
                            if(height < 150 || height > 193) {
                                valid = false;
                            }
                            break;
                        default:
                            valid = false;
                    }
                    Matcher m = hair.matcher(hcl);
                    if(valid && !m.matches()) {
                        valid = false;
                    }
                    m = eye.matcher(ecl);
                    if(valid && !m.matches()) {
                        valid = false;
                    }
                    m = passport.matcher(pid);
                    if(valid && !m.matches()) {
                        valid = false;
                    }

                    if(valid) {
                        numValid++;
                    }
                }
                 ecl  = null;
                 pid = null;
                 eyr = -1;
                 hcl = null;
                 byr = -1;
                 iyr = -1;
                 cid = null;
                 hgt = null;
            }
            String[] parts = line.split(" ");
            for (String part:
                 parts) {
                String[] field = part.split(":");
                switch (field[0].trim()) {
                    case "ecl":
                        ecl = field[1];
                        break;
                    case "pid":
                        pid = field[1];
                        break;
                    case "eyr":
                        eyr = Integer.parseInt(field[1]);
                        break;
                    case "hcl":
                        hcl = field[1];
                        break;
                    case "byr":
                        byr = Integer.parseInt(field[1]);
                        break;
                    case "iyr":
                        iyr = Integer.parseInt(field[1]);
                        break;
                    case "cid":
                        cid = field[1];
                        break;
                    case "hgt":
                        hgt = field[1];
                        break;
                    default:
                }
            }
        }
        boolean valid = true;
        if(byr < 1920 || byr > 2002) {
            valid = false;
        }
        if(iyr < 2010 || iyr > 2020) {
            valid = false;
        }
        if(eyr < 2020 || eyr > 2030) {
            valid = false;
        }
        if(hcl == null || ecl == null || pid == null || hgt == null) {
            valid = false;
        }

        if(valid) {
            String type = hgt.substring(hgt.length()-2);
            int height = Integer.parseInt(hgt.substring(0, hgt.length() - 2));
            switch(type) {
                case "in":
                    if(height < 59 || height > 76) {
                        valid = false;
                    }
                    break;
                case "cm":
                    if(height < 150 || height > 193) {
                        valid = false;
                    }
                    break;
                default:
                    valid = false;
            }
            Matcher m = hair.matcher(hcl);
            if(valid && !m.matches()) {
                valid = false;
            }
            m = eye.matcher(ecl);
            if(valid && !m.matches()) {
                valid = false;
            }
            m = passport.matcher(pid);
            if(valid && !m.matches()) {
                valid = false;
            }

            if(valid) {
                numValid++;
            }
        }
        System.out.println(numValid);

        scan.close();
    }
}
