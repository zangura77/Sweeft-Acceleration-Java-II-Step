public class MinSplitSolution {

    private int minSplit(int amount){
        int countFifty = amount / 50;
        amount %= 50;

        int countTwenty = amount / 20;
        amount %= 20;

        int countTen = amount / 10;
        amount %= 10;

        int countFive = amount / 5;
        amount %= 5;

        int countOne = amount / 1;
        amount %= 1;

        return countFifty + countTwenty + countTen + countFive + countOne;
    }

}
