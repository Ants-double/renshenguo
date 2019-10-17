package com.antsdouble.steel;

import com.antsdouble.steel.greedy.Haystack;
import com.antsdouble.steel.greedy.IsValid;
import com.antsdouble.steel.greedy.Palindrome;
import com.antsdouble.steel.greedy.SumNumber;
import org.junit.Test;

/**
 * @author lyy
 * @Deprecated
 * @date 2019/10/17
 */
public class ALTest {

    @Test
    public void  test(){
        try {
            switch (5) {
                case 1:
                    testFunction();//检测数组中是否有满足条件的数据
                    break;

                case 2:
                    palindromeFunction();//回文数
                    break;
                case 3:
                    IsValid validObject = new IsValid();
                    System.out.println(validObject.isValidString("()[]{}"));
                    break;
                case 4://匹配括号
                    break;
                case 5://实现str
                    Haystack haytest = new Haystack();
                    // System.out.println(haytest.strStr("hello","ll"));
                    System.out.println(haytest.strStrTwo("hello", "ll"));


                    break;
                default:
                    break;
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            System.out.println("test finally");
        }

    }

    private static void testFunction() throws NullPointerException {
        SumNumber mySumNumber = new SumNumber();
        int[] res = mySumNumber.TwoSumMap(new int[]{3, 2, 4}, 6);
        System.out.println(mySumNumber.TwoSumMap(new int[]{3, 2, 4}, 6));
        ;
        // throw  new NullPointerException("test");
        return;
    }

    private static void palindromeFunction() throws IllegalArgumentException {

        Palindrome pd = new Palindrome();
        System.out.println(pd.isPalindrome(8888));

    }
}
