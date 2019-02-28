package functions_assignment;
import java.util.*;
import java.util.logging.Logger;

/*
   Space Complexity is O(1) and Time Complexity is O(M*N)
   Where M=Number of Rows
         N=NUmber of Columns
*/

public class MatrixZeroes {

    private static int numberOfRows;
    private static int numberOfColumns;
    private static int[][] inputMatrix;
    private static Logger logger = Logger.getLogger(MatrixZeroes.class.getName());


    //Function allows user to enter the number of rows and columns
    private static void enterNoOfRowsAndColumns(Scanner scanner) {
        //Throws Exception if input mismatches
        logger.info("Enter Number of Rows:");
        numberOfRows = scanner.nextInt();
        logger.info("Enter Number of Columns:");
        numberOfColumns = scanner.nextInt();
    }

    //Function used to check if the number of rows and columns are valid or not
    private static boolean isNoOfRowsAndColumnsValid() {
        //Throws exception if number rows or columns are <=0
        try {
            if (numberOfRows <= 0 || numberOfColumns <= 0) {
                throw new Exception("Number of Rows and Columns should be >0");
            }
        }
        catch (Exception e) {
            logger.info(e.getMessage());
            return false;
        }
        return true;
    }

    //Function allows user to enter input matrix
    private static void enterInputMatrix(Scanner scanner) {
        //throws Exception if input mismatches
        logger.info("Enter Input Matrix of size(numberOfRows*numberOfColumns):");
        inputMatrix = new int[numberOfRows][numberOfColumns];
        for (int rowIndex = 0; rowIndex < numberOfRows; rowIndex++) {
            for (int columnIndex = 0; columnIndex < numberOfColumns; columnIndex++) {
                inputMatrix[rowIndex][columnIndex] = scanner.nextInt();
            }
        }
    }

    //Function used to set Matrix to zeroes by using row array and column array
    private static void setMatrixtToZeroes() {
        //Flags used to check whether first row and column have zeroes
        boolean firstRowHasZero;
        boolean firstCoumnHasZero;
        firstRowHasZero = isFirstRowHasZero();
        firstCoumnHasZero = isFirstColumnHasZero();
        setSubMatrixToZeroes();
        setFirstRowToZeroes(firstRowHasZero);
        setFirstColumnToZeroes(firstCoumnHasZero);
    }

    //Function used to check whether the first row has zero or not
    private static boolean isFirstRowHasZero() {
        for (int columnIndex = 0; columnIndex < numberOfColumns; columnIndex++) {
            if (inputMatrix[0][columnIndex] == 0) {
                return true;
            }
        }
        return false;
    }

    //Function used to check whether the first column has zero or not
    private static boolean isFirstColumnHasZero() {
        for (int rowIndex = 0; rowIndex < numberOfRows; rowIndex++) {
            if (inputMatrix[rowIndex][0] == 0)
                return true;
        }
        return false;
    }

    //Function used to set submatrix to zeroes except first row and first column
    private static void setSubMatrixToZeroes() {
        createRowAndColumnArray();
        for (int rowIndex = 0; rowIndex < numberOfRows; rowIndex++) {
            for (int columnIndex = 0; columnIndex < numberOfColumns; columnIndex++) {
                if (inputMatrix[rowIndex][0] == 0 || inputMatrix[0][columnIndex] == 0) {
                    inputMatrix[rowIndex][columnIndex] = 0;
                }
            }
        }
    }

    //Function used to create row and column array to set the submatrix to zeroes
    private static void createRowAndColumnArray() {
        //Setting first row as column array which holds zeroes in the column indices to set that entire column to zeroes
        setFirstRowAsColumnArray();
        //Setting first column as row array which holds zeroes in the row indices to set that entire row to zeroes
        setFirstColumnAsRowArray();
    }

    //Function used to set first row as column array
    private static void setFirstRowAsColumnArray() {
        for (int rowIndex = 1; rowIndex < numberOfRows; rowIndex++) {
            for (int columnIndex = 0; columnIndex < numberOfColumns; columnIndex++) {
                if (inputMatrix[rowIndex][columnIndex] == 0) {
                    inputMatrix[rowIndex][0] = 0;
                }
            }
        }
    }

    //Function used to set first column as row array
    private static void setFirstColumnAsRowArray() {
        for (int rowIndex = 0; rowIndex < numberOfRows; rowIndex++) {
            for (int columnIndex = 1; columnIndex < numberOfColumns; columnIndex++) {
                if (inputMatrix[rowIndex][columnIndex] == 0) {
                    inputMatrix[0][columnIndex] = 0;
                }
            }
        }
    }

    //Function used to set first row to zeroes if first row has zero
    private static void setFirstRowToZeroes(boolean firstRowHasZero) {
        if (firstRowHasZero) {
            for (int columnIndex = 0; columnIndex < numberOfColumns; columnIndex++) {
                inputMatrix[0][columnIndex] = 0;
            }
        }
    }

    //Function used to set first column to zeroes if first column has zero
    private static void setFirstColumnToZeroes(boolean firstColumnHasZero) {
        if (firstColumnHasZero) {
            for (int rowIndex = 0; rowIndex < numberOfRows; rowIndex++) {
                inputMatrix[rowIndex][0] = 0;
            }
        }
    }

    //Function used to print modified input or the final output matrix
    private static void printModifiedInputMatrix() {
        logger.info("The modified input matrix after setting zeroes is:");
        StringBuilder outputString = new StringBuilder();
        outputString.append("\n");
        for (int rowIndex = 0; rowIndex < numberOfRows; rowIndex++) {
            for (int columnIndex = 0; columnIndex < numberOfColumns; columnIndex++) {
                outputString.append(inputMatrix[rowIndex][columnIndex]);
                outputString.append(" ");
            }
            outputString.append("\n");
        }
        //Converting StringBuilder object to String using String.valueOf
        logger.info(String.valueOf(outputString));
    }

    public static void main(String[] args) {
        try {
            logger.info("Enter Matrix to modify it in such a way that if an element in a matrix of size MxN is zero then that entire row and column are set to zero");
            //Scanner object used to Read the input
            Scanner scanner = new Scanner(System.in);
            enterNoOfRowsAndColumns(scanner);
            //Checking whether the user entered valid number of rows and columns or not and continues only if they are valid
            if (isNoOfRowsAndColumnsValid()) {
                enterInputMatrix(scanner);
                setMatrixtToZeroes();
                printModifiedInputMatrix();
            }
        }
        catch (InputMismatchException e) {
            logger.info("please enter valid inputs");
        }
    }
}


/*
   Input test cases:
   Matrix size:
   1
   2
   Matrix:
   1 0
   Matrix size:
   2
   2
   Matrix:
   1 1
   1 0
   Matrix size:
   3
   3
   Matrix:
   1 2 3
   1 0 1
   0 0 0
   Matrix size:
   2
   2
   Matrix:
   1 1
   2 3
   Matrix size:
   4
   4
   Matrix:
   1 0 1 1
   1 1 0 0
   1 1 1 1
   1 0 1 1
 */