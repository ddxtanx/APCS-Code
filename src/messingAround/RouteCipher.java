package messingAround;
public class RouteCipher
{
    public RouteCipher(int rows, int cols){
        numRows = rows;
        numCols = cols;
        letterBlock = new String[numRows][numCols];
    }
    /** A two-dimensional array of single-character strings, instantiated in the constructor */
    public String[][] letterBlock;
    /** The number of rows of letterBlock, set by the constructor */
    private int numRows;
    /** The number of columns of letterBlock, set by the constructor */
    private int numCols;
    /** Places a string into letterBlock in row-major order.
     * @param str the string to be processed
     * Postcondition:
     * if str.length() < numRows * numCols, "A" is placed in each unfilled cell
     * if str.length() > numRows * numCols, trailing characters are ignored
     */
    public void fillBlock(String str)
    {
        int lengthOfBlock = numCols*numRows;
        while(str.length() != lengthOfBlock ){
            str += "A";
        }
        for(int x = 0; x<numRows; x++){
            for(int y = 0; y<numCols; y++){
                int start = x*numCols + y;
                letterBlock[x][y] = str.substring(start, start+1);
            }
        }
    }
    /** Extracts encrypted string from letterBlock in column-major order.
     * Precondition: letterBlock has been filled
     * @return the encrypted string from letterBlock
     */
    public String encryptBlock()
    {
        String returnedString = "";
        for(int y = 0; y<numCols; y++){
            for(int x = 0; x<numRows; x++){
                returnedString += letterBlock[x][y];
            }
        }
        return returnedString;
    }
    /** Encrypts a message.
     * @param message the string to be encrypted
     * @return the encrypted message;
     * if message is the empty string, returns the empty string
     */
    public String encryptMessage(String message)
    {
        int sizePartition = numCols*numRows;
        int numOfIterations = (int)Math.ceil((double)message.length()/sizePartition);
        String encrypt = "";
        for(int x = 0; x<numOfIterations; x++){
            int start = x*sizePartition;
            int end = Math.min(message.length(), (x+1)*sizePartition);
            String partition = message.substring(start, end);
            fillBlock(partition);
            encrypt += encryptBlock();
        }
        return encrypt;
    }
    // There may be instance variables, constructors, and methods that are not shown.
}