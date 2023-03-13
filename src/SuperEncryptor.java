public class SuperEncryptor {
    int cipherShift;
    int rowShift;
    int colShift;
    int numRows;
    int numCols;
    public SuperEncryptor(int cipherShift, int rowShift, int colShift, int numRows, int numCols)
    {
        this.cipherShift = cipherShift;
        this.rowShift = rowShift;
        this.colShift = colShift;
        this.numRows = numRows;
        this.numCols = numCols;
    }

    // Super Encryptor
    public String superEncryptMessage(String message)
    {
        String cipheredMessage = caesarCipher(message, cipherShift);
        String[][] arr = strToArr(cipheredMessage);
        arr = rowShift(arr, rowShift);
        arr = columnShift(arr, colShift);
        String encrypt = readColumnMajor(arr);

        return encrypt;
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

    private String[][] strToArr(String str)
    {
        String[][] arr = new String[numRows][numCols];
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
                arr[i / numCols][i % numCols] = add;
                i++;
            }
        }
        return arr;
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

    private String[][] columnShift(String[][] arr, int shift)
    {
        String[][] newArr = new String[arr.length][arr[0].length];
        for (int c = 0; c < arr[0].length; c++)
        {
            for (int r = 0; r < arr.length; r++)
            {
                int newCol = (c + shift) % arr[0].length;
                newArr[r][newCol] = arr[r][c];
            }
        }
        return newArr;
    }

    private String readColumnMajor(String[][] arr)
    {
        String message = "";
        for (int c = 0; c < arr[0].length; c++)
        {
            for (int r = 0; r < arr.length; r++)
            {
                String str = arr[r][c];
                message += str;
            }
        }
        return message;
    }

    // Super Decryptor

    public String superDecryptMessage(String message)
    {
        String[][] arr = pasteColumnMajor(message);
        arr = columnShift(arr, numCols - (colShift % numCols));
        arr = rowShift(arr, numRows - (rowShift % numRows));
        String cipheredMessage = arrToStr(arr);
        String decrypt = undoCaesarCipher(cipheredMessage, cipherShift);
        decrypt = removeAs(decrypt);

        return decrypt;
    }

    public String[][] pasteColumnMajor(String message)
    {
        String[][] arr = new String[numRows][numCols];
        int i = 0;
        for (int c = 0; c < arr[0].length; c++)
        {
            for (int r = 0; r < arr.length; r++)
            {
                String str = message.substring(i, i + 1);
                arr[r][c] = str;
                i++;
            }
        }
        return arr;
    }

    private String arrToStr(String[][] arr)
    {
        String str = "";
        for (int r = 0; r < arr.length; r++)
        {
            for (int c = 0; c < arr[0].length; c++)
            {
                str += arr[r][c];
            }
        }
        return str;
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

    private String removeAs(String decryptedMessage)
    {
        int idx = decryptedMessage.length();
        boolean end = true;
        while (idx > 0 && end)
        {
            if (!(decryptedMessage.substring(idx - 1, idx).equals("A")))
            {
                end = false;
            }
            else
            {
                idx--;
            }
        }
        if (!end)
        {
            decryptedMessage = decryptedMessage.substring(0, idx);
        }
        return decryptedMessage;
    }
}
