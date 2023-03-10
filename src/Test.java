import java.util.Arrays;
public class Test {
    public static void main(String[] args) {
        Encryptor ec = new Encryptor(2,2);
        String str = ec.encryptMessage("Well, you only need the light when it's burning low\n" +
                "Only miss the sun when it starts to snow\n" +
                "Only know you love her when you let her go");
        System.out.println(str);
        System.out.println(ec.decryptMessage("Woeul lo,n lyy hnee eldi gthti tw'hse nb uronwi\n" +
                "nOgn lly hmei sssu nt w hsetna ritts wt\n" +
                "oO nslnyo kun olwo vyeo hne ry owuh elegto AhAeArA A\n"));

        String[][] arr = {
                {"a","b","c"},
                {"d","e","f"},
                {"g","h","i"},
                {"j","k","l"}};
        print2DArray(ec.rowShift(arr, 5));
    }

    public static void print2DArray(String[][] arr)
    {
        for (String[] row : arr)
        {
            for (String val : row)
            {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
