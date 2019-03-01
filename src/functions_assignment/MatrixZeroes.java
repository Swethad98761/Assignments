package functions_assignment;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

/*
   Auxiliary Space Complexity is O(1) and Time Complexity is O(M*N)
   Where M=Number of Rows
         N=NUmber of Columns
*/

public class MatrixZeroes {

    private static final Logger logger = Logger.getLogger(MatrixZeroes.class.getName());


    //Function used to check if the number of rows and columns are valid or not
    private static boolean isNoOfRowsAndColumnsValid(int numberOfRows, int numberOfColumns) {
        //Throws exception if number rows or columns are <=0
        try {
            if (numberOfRows <= 0 || numberOfColumns <= 0) {
                throw new Exception("Number of Rows and Columns should be >0");
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
            return false;
        }
        return true;
    }

    //Function allows user to enter input matrix
    private static void enterInputMatrix(Scanner scanner, int[][] inputMatrix) {
        //throws Exception if input mismatches
        logger.info("Enter Input Matrix of size(numberOfRows*numberOfColumns):");
        for (int rowIndex = 0; rowIndex < inputMatrix.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < inputMatrix[0].length; columnIndex++) {
                inputMatrix[rowIndex][columnIndex] = scanner.nextInt();
            }
        }
    }

    public static int[][] setMatrixtToZeroes(int[][] inputMatrix) {
        //Flags used to check whether first row and column have zeroes
        boolean firstRowHasZero;
        boolean firstCoumnHasZero;
        firstRowHasZero = isFirstRowHasZero(inputMatrix);
        firstCoumnHasZero = isFirstColumnHasZero(inputMatrix);
        setSubMatrixToZeroes(inputMatrix);
        setFirstRowToZeroes(firstRowHasZero, inputMatrix);
        setFirstColumnToZeroes(firstCoumnHasZero, inputMatrix);
        return inputMatrix;
    }

    //Function used to check whether the first row has zero or not
    private static boolean isFirstRowHasZero(int[][] inputMatrix) {
        for (int columnIndex = 0; columnIndex < inputMatrix[0].length; columnIndex++) {
            if (inputMatrix[0][columnIndex] == 0) {
                return true;
            }
        }
        return false;
    }

    //Function used to check whether the first column has zero or not
    private static boolean isFirstColumnHasZero(int[][] inputMatrix) {
        for (int rowIndex = 0; rowIndex < inputMatrix.length; rowIndex++) {
            if (inputMatrix[rowIndex][0] == 0)
                return true;
        }
        return false;
    }

    //Function used to set submatrix to zeroes except first row and first column
    private static void setSubMatrixToZeroes(int[][] inputMatrix) {
        createRowAndColumnArray(inputMatrix);
        for (int rowIndex = 1; rowIndex < inputMatrix.length; rowIndex++) {
            for (int columnIndex = 1; columnIndex < inputMatrix[0].length; columnIndex++) {
                if (inputMatrix[rowIndex][0] == 0 || inputMatrix[0][columnIndex] == 0) {
                    inputMatrix[rowIndex][columnIndex] = 0;
                }
            }
        }
    }

    //Function used to create row and column array to set the submatrix to zeroes
    private static void createRowAndColumnArray(int[][] inputMatrix) {
        //Setting first row as column array which holds zeroes in the column indices to set that entire column to zeroes
        setFirstRowAsColumnArray(inputMatrix);
        //Setting first column as row array which holds zeroes in the row indices to set that entire row to zeroes
        setFirstColumnAsRowArray(inputMatrix);
    }

    //Function used to set first row as column array
    private static void setFirstRowAsColumnArray(int[][] inputMatrix) {
        for (int rowIndex = 1; rowIndex < inputMatrix.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < inputMatrix[0].length; columnIndex++) {
                if (inputMatrix[rowIndex][columnIndex] == 0) {
                    inputMatrix[rowIndex][0] = 0;
                }
            }
        }
    }

    //Function used to set first column as row array
    private static void setFirstColumnAsRowArray(int[][] inputMatrix) {
        for (int rowIndex = 0; rowIndex < inputMatrix.length; rowIndex++) {
            for (int columnIndex = 1; columnIndex < inputMatrix[0].length; columnIndex++) {
                if (inputMatrix[rowIndex][columnIndex] == 0) {
                    inputMatrix[0][columnIndex] = 0;
                }
            }
        }
    }

    //Function used to set first row to zeroes if first row has zero
    private static void setFirstRowToZeroes(boolean firstRowHasZero, int[][] inputMatrix) {
        if (firstRowHasZero) {
            for (int columnIndex = 0; columnIndex < inputMatrix[0].length; columnIndex++) {
                inputMatrix[0][columnIndex] = 0;
            }
        }
    }

    //Function used to set first column to zeroes if first column has zero
    private static void setFirstColumnToZeroes(boolean firstColumnHasZero, int[][] inputMatrix) {
        if (firstColumnHasZero) {
            for (int rowIndex = 0; rowIndex < inputMatrix.length; rowIndex++) {
                inputMatrix[rowIndex][0] = 0;
            }
        }
    }

    //Function used to print modified input or the final output matrix
    private static void printModifiedInputMatrix(int[][] inputMatrix) {
        logger.info("The modified input matrix after setting zeroes is:");
        StringBuilder outputString = new StringBuilder();
        outputString.append("\n");
        for (int rowIndex = 0; rowIndex < inputMatrix.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < inputMatrix[0].length; columnIndex++) {
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
            int numberOfRows;
            int numberOfColumns;
            logger.info("Enter Number of Rows:");
            numberOfRows = scanner.nextInt();
            logger.info("Enter Number of Columns:");
            numberOfColumns = scanner.nextInt();
            int[][] inputMatrix;
            //Checking whether the user entered valid number of rows and columns or not and continues only if they are valid
            if (isNoOfRowsAndColumnsValid(numberOfRows, numberOfColumns)) {
                inputMatrix = new int[numberOfRows][numberOfColumns];
                enterInputMatrix(scanner, inputMatrix);
                setMatrixtToZeroes(inputMatrix);
                printModifiedInputMatrix(inputMatrix);
            }
        } catch (InputMismatchException e) {
            logger.info("please enter valid inputs");
        }
    }
}