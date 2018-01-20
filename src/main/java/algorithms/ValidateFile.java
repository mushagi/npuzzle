package algorithms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ValidateFile {

    private static boolean isComment(String line) {
        return line.charAt(0) == '#';
    }

    private static boolean isNumber(String line) {
        for (char c : line.toCharArray()) {
            if (!Character.isDigit(c))
                return (false);
        }
        return (true);
    }

    private static String removeComment(String line) {
        line = line.split("#")[0];
        return (line);
    }

    private boolean isFileValid(String filename) {
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(filename));
            String line;
            int size = 0, lines = 0;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (isComment(line))
                    continue;
                line = removeComment(line);
                if (isNumber(line)) {
                    if (size > 0)
                        return (false);
                    size = Integer.parseInt(line);
                    if (size < 2)
                        return (false);
                } else {
                    lines++;
                    if (size > 0 && lines <= size) {
                        String[] items = line.split("\\s+");
                        if (items.length != size)
                            return (false);
                        for (String str : items) {
                            if (!isNumber(str))
                                return (false);
                        }
                    } else
                        return (false);
                }
            }
            return lines == size;
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(0);
        }
        return (true);
    }
}