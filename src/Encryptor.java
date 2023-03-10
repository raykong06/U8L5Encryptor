public class Encryptor
{
    /** A two-dimensional array of single-character strings, instantiated in the constructor */
    private String[][] letterBlock;

    /** The number of rows of letterBlock, set by the constructor */
    private int numRows;

    /** The number of columns of letterBlock, set by the constructor */
    private int numCols;

    /** Constructor*/
    public Encryptor(int r, int c)
    {
        letterBlock = new String[r][c];
        numRows = r;
        numCols = c;
    }

    public String[][] getLetterBlock()
    {
        return letterBlock;
    }

    /** Places a string into letterBlock in row-major order.
     *
     *   @param str  the string to be processed
     *
     *   Postcondition:
     *     if str.length() < numRows * numCols, "A" in each unfilled cell
     *     if str.length() > numRows * numCols, trailing characters are ignored
     */
    public void fillBlock(String str)
    {
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

    /** Extracts encrypted string from letterBlock in column-major order.
     *
     *   Precondition: letterBlock has been filled
     *
     *   @return the encrypted string from letterBlock
     */
    public String encryptBlock()
    {
        String encryptedString = "";
        for (int c = 0; c < numCols; c++)
        {
            for (int r = 0; r < numRows; r++)
            {
                encryptedString += letterBlock[r][c];
            }
        }
        return encryptedString;
    }

    /** Encrypts a message.
     *
     *  @param message the string to be encrypted
     *
     *  @return the encrypted message; if message is the empty string, returns the empty string
     */
    public String encryptMessage(String message)
    {
        String encryptedMessage = "";
        int length = message.length() / (numRows * numCols);
        if (message.length() - length > 0)
        {
            length++;
        }
        int interval = numRows * numCols;
        int i = 0;
        while (i < length)
        {
            if (!message.equals(""))
            {
                if (i == length - 1)
                {
                    fillBlock(message);
                }
                else
                {
                    fillBlock(message.substring(0, interval));
                    message = message.substring(interval);
                }
                encryptedMessage += encryptBlock();
            }
            i++;
        }
        return encryptedMessage;
    }

    /**  Decrypts an encrypted message. All filler 'A's that may have been
     *   added during encryption will be removed, so this assumes that the
     *   original message (BEFORE it was encrypted) did NOT end in a capital A!
     *
     *   NOTE! When you are decrypting an encrypted message,
     *         be sure that you have initialized your Encryptor object
     *         with the same row/column used to encrypted the message! (i.e.
     *         the “encryption key” that is necessary for successful decryption)
     *         This is outlined in the precondition below.
     *
     *   Precondition: the Encryptor object being used for decryption has been
     *                 initialized with the same number of rows and columns
     *                 as was used for the Encryptor object used for encryption.
     *
     *   @param encryptedMessage  the encrypted message to decrypt
     *
     *   @return  the decrypted, original message (which had been encrypted)
     *
     *   TIP: You are encouraged to create other helper methods as you see fit
     *        (e.g. a method to decrypt each section of the decrypted message,
     *         similar to how encryptBlock was used)
     */
    public String decryptMessage(String encryptedMessage)
    {
        String decryptedMessage = "";
        int length = encryptedMessage.length() / (numCols * numRows);
        int i = 0;
        while (i < length)
        {
            if (!encryptedMessage.equals(""))
            {
                String[][] block = fillDecryptBlock(encryptedMessage.substring(0, numCols * numRows));
                encryptedMessage = encryptedMessage.substring(numCols * numRows);
                for (String[] r : block)
                {
                    for (String c : r)
                    {
                        decryptedMessage += c;
                    }
                }
            }
            i++;
        }
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

    private String[][] fillDecryptBlock(String str)
    {
        String[][] block = new String[numRows][numCols];
        int i = 0;
        for (int c = 0; c < numCols; c++)
        {
            for (int r = 0; r < numRows; r++)
            {
                block[r][c] = str.substring(i, i + 1);
                i++;
            }
        }
        return block;
    }

    // Super Encryptor
    public String superEncryptMessage(String message, int cipherShift, int rowShift, int colShift)
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