public class SuperEncryptor {
    int cipherShift;
    int rowShift;
    int colShift;
    public SuperEncryptor(int cipherShift, int rowShift, int colShift)
    {
        this.cipherShift = cipherShift;
        this.rowShift = rowShift;
        this.colShift = colShift;
    }

    // Super Encryptor
    public String superEncryptMessage(String message)
    {
        String cipheredMessage = caesarCipher(message, cipherShift);
        String[][] arr =
        return null;
    }

    private String caesarCipher(String message, int shift)
    {
        String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerLetters = "abcdefghijklmnopqrstuvwxyz";

        String newMessage = "";

        shift = shift % 26;

        for (int i = 0; i < message.length(); i++)
        {
            String character = message.substring(i, i + 1);
            if (capitalLetters.indexOf(character) != -1)
            {
                int charShiftIndex = (capitalLetters.indexOf(character) + shift) % 26;
                character = capitalLetters.substring(charShiftIndex, charShiftIndex + 1);
            }
            else if (lowerLetters.indexOf(character) != -1)
            {
                int charShiftIndex = (lowerLetters.indexOf(character) + shift) % 26;
                character = lowerLetters.substring(charShiftIndex, charShiftIndex + 1);
            }
            newMessage += character;
        }
        return newMessage;
    }

    private String[][] rowShift(String[][] arr, int shift)
    {
        String[][] newArr = new String[arr.length][arr[0].length];
        for (int r = 0; r < arr.length; r++)
        {
            String[] row = arr[r];
            int newRow = (r + shift) % arr.length;
            newArr[newRow] = row;
        }
        return newArr;
    }

    private String[][] strToArr(String str)
    {
        int numRows =
        int i = 0;
        for (int r = 0; r < numRows; r++)
        {
            for (int c = 0; c < numCols; c++)
            {
                String add;
                if (i < str.length())
                {
                    add = str.substring(i, i + 1);
                }
                else
                {
                    add = "A";
                }
                letterBlock[i / numCols][i % numCols] = add;
                i++;
            }
        }
    }

    private String undoCaesarCipher(String message, int shift)
    {
        String capitalLetters = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
        String lowerLetters = "zyxwvutsrqponmlkjihgfedcba";

        String newMessage = "";

        shift = shift % 26;

        for (int i = 0; i < message.length(); i++)
        {
            String character = message.substring(i, i + 1);
            if (capitalLetters.indexOf(character) != -1)
            {
                int charShiftIndex = (capitalLetters.indexOf(character) + shift) % 26;
                character = capitalLetters.substring(charShiftIndex, charShiftIndex + 1);
            }
            else if (lowerLetters.indexOf(character) != -1)
            {
                int charShiftIndex = (lowerLetters.indexOf(character) + shift) % 26;
                character = lowerLetters.substring(charShiftIndex, charShiftIndex + 1);
            }
            newMessage += character;
        }
        return newMessage;
    }
}
