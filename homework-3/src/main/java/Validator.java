import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Validator {
    private File file;
    public Validator(File file) {
        this.file = file;
    }
    public boolean isSorted() {
        try (Scanner scanner = new Scanner(new FileInputStream(file))) {
            long prev = Long.MIN_VALUE;
            while (scanner.hasNextLong()) {
                long current = scanner.nextLong();
                if (current < prev) {
                    return false;
                } else {
                    prev = current;
                }
            }
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public int checkCountOfNums() {
        int count = 0;
        try (Scanner scanner = new Scanner(new FileInputStream(file))) {
            while (scanner.hasNextLong()) {
                long current = scanner.nextLong();
                count++;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return count;
    }
}