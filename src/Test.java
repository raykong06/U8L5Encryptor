import java.util.Arrays;
public class Test {
    public static void main(String[] args) {
        Encryptor ec = new Encryptor(3,5);
        ec.fillBlock("Meet at noon");
        print2DArray(ec.getLetterBlock());
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
