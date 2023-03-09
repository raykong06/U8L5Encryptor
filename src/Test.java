import java.util.Arrays;
public class Test {
    public static void main(String[] args) {
        Encryptor ec = new Encryptor(3,5);
        String str = ec.encryptMessage("I got a 78 on my Unit 6 APUSH Test. Gosh darn it Booker T. Washington!");
        System.out.println(ec.encryptMessage(str));
        System.out.println(ec.decryptMessage());
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
