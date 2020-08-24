//imports for BufferedReader
import java.util.Scanner;

//import for Scanner and other utility classes

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static void main(String args[] ) throws Exception {
//        / Sample code to perform I/O:
//         * Use either of these methods for input

//        //BufferedReader
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String name = br.readLine();                // Reading input from STDIN
//        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
//        String name = s.nextLine();                 // Reading input from STDIN
//        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

 //Write your code here
//        //search engine
//        String ans = "";
//        String tInput = s.nextLine();
//        //code from https://stackoverflow.com/questions/14974033/extract-digits-from-string-stringutils-java
//        String tNumberOnly= tInput.replaceAll("[^0-9]", "");
//        int T = Integer.parseInt(tNumberOnly);
//        int caseNum = 0;
//        while (T > 0) {
//            caseNum++;
//            ans += "Case " +caseNum + ":" +"\n";
//            T--;
//            String NQ = s.nextLine();
//            String numberOnly= NQ.replaceAll("[^0-9]", "");
//            int N = Integer.parseInt(numberOnly.substring(0,1));
//            int Q = Integer.parseInt(numberOnly.substring(1,2));
//            String[] dataBase = new String[N];
//            while (N > 0) {
//                N--;
//                String dataEntry = s.nextLine();
//                dataBase[N] = dataEntry;
//            }
//            while (Q > 0) {
//                int count = 0;
//                String query = s.nextLine();
//                for (int i = 0; i < dataBase.length; i++) {
//                    String dataEntry = dataBase[i];
//                    if (dataEntry.contains(query)) {
//                        int id = dataEntry.indexOf(query);
//                        try {
//                            if (dataEntry.substring(id + query.length(), id + query.length() + 1).equals(" ")) {
//                                count++;
//                            }
//                        } catch (Exception e) {
//                            count++;
//                        }
//                    }
//                }
//                ans += count + "\n";
//                Q--;
//            }
//        }
//        System.out.println(ans);

        // Lucky Winner
        String input = s.nextLine();
        //code from https://stackoverflow.com/questions/14974033/extract-digits-from-string-stringutils-java
        int count = 0;
        int n = input.indexOf(" ");
        int N = Integer.parseInt(input.substring(n-1, n));
        int K = Integer.parseInt(input.substring(n+1));
        int[][] board = new int[N][3];
        boolean[][] trueFalseBoard = new boolean[N][3];
        for (int i = 0; i < trueFalseBoard.length; i++) {
            for (int j = 0; j < trueFalseBoard[0].length; j++) {
                trueFalseBoard[i][j] = true;
            }
        }
//        boolean firstRow = true;
        for (int i = 0; i < N; i++) {
            String inputRow = s.nextLine();
            String[] inputRowNums = inputRow.split(" ");
            for (int j = 0; j < inputRowNums.length; j++) {
                board[i][j] = Integer.parseInt(inputRowNums[j]);
            }
        }

        while (K > 0) {
            int maxNum = Integer.MIN_VALUE;
            int prevX1 = 0;
            int prevY1 = 0;
            int prevX2 = 0;
            int prevY2 = 0;
            for (int x = 0; x < board.length -1; x++) {
                for (int y = 0; y < board[0].length - 1; y++) {
                    if (trueFalseBoard[x][y] == false || trueFalseBoard[x + 1][y] == false || trueFalseBoard[x][y + 1] == false) {
                        continue;
                    }
                    int currentVal = board[x][y];
                    if (currentVal + board[x + 1][y] > maxNum) { //if vertically is larger
                        maxNum = currentVal + board[x + 1][y];
                        trueFalseBoard[prevX1][prevY1] = true;
                        trueFalseBoard[prevX2][prevY2] = true;
                        trueFalseBoard[x][y] = false;
                        trueFalseBoard[x + 1][y] = false;
                    } else if (currentVal + board[x][y + 1] > maxNum) { //if horizontally is larger
                        maxNum = currentVal + board[x][y + 1];
                        trueFalseBoard[prevX1][prevY1] = true;
                        trueFalseBoard[prevX2][prevY2] = true;
                        trueFalseBoard[x][y] = false;
                        trueFalseBoard[x][y + 1] = false;
                    }
                }
            }
            count += maxNum;
            K--;
            System.out.println(maxNum);
        }
        System.out.println(count);
    }
}