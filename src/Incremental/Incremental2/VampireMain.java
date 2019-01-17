package Incremental.Incremental2;

public class VampireMain
{
    static int vampireCount = 0;
    public static void main(String[] args)
    {

        VampireMain vampire = new VampireMain();

        for(int testNumber=10; vampireCount!=100; testNumber++){

            String numInStr = String.valueOf(testNumber);
            int leftIndex = 0;
            int rightIndex = numInStr.length()-1;
            int numberLength = numInStr.length();
            if(vampire.checkIfVampire(numInStr, leftIndex, rightIndex, numberLength, testNumber)) {
                System.out.println(testNumber);
                System.out.println(vampireCount);
            }
            if(String.valueOf(testNumber).length()%2 == 1){
                testNumber = vampire.findNextEvenLengthNumber(String.valueOf(testNumber));
            }
        }
    }

    private boolean checkIfVampire(String str, int left, int right,int numberLength, int testNumber)
    {
        if (left == right){
            String firstNum = str.substring(0,numberLength/2);
            String secondNum = str.substring(numberLength/2,numberLength);

            if(!(firstNum.charAt(numberLength/2-1)=='0' && secondNum.charAt(numberLength/2-1)=='0')){
                int firstNumber = Integer.parseInt(firstNum);
                int secondNumber = Integer.parseInt(secondNum);
                int product = firstNumber*secondNumber;

                if(testNumber == product){
                    vampireCount++;

                    return true;
                }

            }
            return false;

        }
        else {
            for (int index = left; index <= right; index++) {
                str = swap(str, left, index);

                if(checkIfVampire(str, left+1, right, numberLength, testNumber))
                    return true;

                str = swap(str, left, index);
            }
            return false;
        }
    }

    int findNextEvenLengthNumber(String number) {
        String nextEvenLengthInteger = "";
        int nextEvenNumberLength = number.length() + 1;
        String st = String.format("%1$-" + (nextEvenNumberLength-1) + "s", "").replace(' ', '0');

        return Integer.parseInt(1+""+st);

    }

    public String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

}
