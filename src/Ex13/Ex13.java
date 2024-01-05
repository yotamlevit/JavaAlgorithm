// Author: Yotam Levit

package Ex13;

public class Ex13 {

     /**
     *A recursive function that calculates the shortest common super-sequence of two strings.
     * The shortest common super-sequence is the shortest string
     * that contains both input strings as subsequences.
     <br><br>
     *<br><br>
     * For example: <br><br>
     * If st1 = AGGTAB, st2 = GXTXAYB then the shortest common super-sequence will be AGGXTXAYB <br><br>
     * If st1 = CAT, st2 = DOT then the shortest common super-sequence will be CATDOD<br><br>
     *<br><br>
     *
     * @param st1: The first input string.
     * @param st2: The second input string.
     * @return String: Returns the shortest common super-sequence string of st1 and st2.
     **/
    public static String minimalSt(String st1, String st2) {

        //Brake condition 1
        if (st1.length() == 0)
            return st2;

        //Brake condition 2
        if (st2.length() == 0)
            return st1;

        if (st1.charAt(0) == st2.charAt(0)) {
            return st1.charAt(0) + minimalSt(st1.substring(1), st2.substring(1));
        } else {
            String option1 = st1.charAt(0) + minimalSt(st1.substring(1), st2);
            String option2 = st2.charAt(0) + minimalSt(st1, st2.substring(1));

            // Returns the sorter string between the 2 options
            return option1.length() > option2.length() ? option2 : option1;
        }
    }
}
