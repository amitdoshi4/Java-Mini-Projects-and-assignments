public class TextJustification1 {
    public static void main(String[] args) {
        String S = "I think Introduction to algorithm is hard but very worth reading you will learn a lot";
        int M=22;
        // str = "given a list of words and a window size of w";      
        extra2(S, M);
    }
    public static void extra2(String S, int M) {
        if (S == null || S == "") {
            return;
        }
        String[] strs = S.split(" ");
        /*
         * l[i][j] indicate the cost of word sequence, from wordi to wordj
         */
        int[][] l = new int[strs.length][strs.length];
        for (int i = 0; i < l.length; i++) {
            l[i][i] = (int) Math.pow(M - strs[i].length(), 3);
        }
        for (int wordStart = 0; wordStart < strs.length - 1; wordStart++) {
            int len = strs[wordStart].length();
            for (int i = 0; i < wordStart; i++) {
                l[wordStart][i] = Integer.MAX_VALUE / 100;
            }
            for (int wordEnd = wordStart + 1; wordEnd < strs.length; wordEnd++) {
                len += strs[wordEnd].length() + 1;
                if (len > M) {
                    for (int i = wordEnd; i < strs.length; i++) {
                        l[wordStart][i] = Integer.MAX_VALUE / 100;
                    }
                    break;
                } else {
                    
                }
            }
        }
        /*
         * cost[i] stores the least cost of the justification from word0 to
         * wordi
         */
        //int[] cost = new int[strs.length];
        /*
         * segment[i] stores index of left-most word which combines with wordi
         * in the same line. e.g. segment[6] = 3, it means word3, word4, word5,
         * word6 are in the same line.
         */
        int[] cost = new int[strs.length];
        int[] segment = new int[strs.length];
        cost[0] = l[0][0];
        segment[0] = 0;
        for (int i = 1; i < strs.length; i++) {
            cost[i] = l[0][i];
            segment[i] = 0;
            for (int j = 0; j < i; j++) {
                int currCost = cost[j] + l[j + 1][i];
                if (currCost < cost[i]) {
                    cost[i] = currCost;
                    segment[i] = j + 1;
                }
            }
        }
        
        /*
         * reverse the print sequence, in order to print
         */
        for (int i = strs.length - 1; i > 0;) {
            int wordStart = segment[i];
            segment[wordStart] = i;
            i = wordStart - 1;
        }
        
        for (int i = 0; i < strs.length;) {
            int wordEnd = segment[i];
            for (int j = i; j <= wordEnd; j++) {
                System.out.print(strs[j] + " ");
            }
            System.out.println();
            i = wordEnd + 1;
        }
        
    }
}