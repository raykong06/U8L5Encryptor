import java.util.Arrays;
public class Test {
    public static void main(String[] args) {
        SuperEncryptor ec = new SuperEncryptor(0,1,1,3,5);
        String[][] arr = {{"a","d","g","j","m"},
                {"b","e","h","k","n"},
                {"c","f","i","l","o"}};

        String str = ec.superEncryptMessage("Chicken wing chicken wing");
        System.out.println(str);
        System.out.println(ec.superDecryptMessage(str));
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
