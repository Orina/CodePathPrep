package week1.math;

/**
 * Given a number N, verify if N is prime or not.
 *
 * Return 1 if N is prime, else return 0.
 *
 * Example :
 *
 * Input : 7
 * Output : True
 *
 * Created by Elmira Andreeva on 7/13/17.
 */
public class VerifyPrime {

    /**
     * The simplest primality test is trial division: Given an input number n, check whether any prime integer m from 2 to √n evenly divides n (the division leaves no remainder).
     * If n is divisible by any m then n is composite, otherwise it is prime.
     *
     * The algorithm can be improved further by observing that all primes are of the form 6k ± 1, with the exception of 2 and 3.
     * This is because all integers can be expressed as (6k + i) for some integer k and for i = −1, 0, 1, 2, 3, or 4;
     * 2 divides (6k + 0), (6k + 2), (6k + 4); and 3 divides (6k + 3).
     * So, a more efficient method is to test if n is divisible by 2 or 3, then to check through all the numbers of form 6k ± 1 <= √n
     * This is 3 times as fast as testing all m.
     */
    public int isPrime(int a) {
        if (a <= 1) return 0;
        else if (a == 2 || a == 3) return 1;

        if (a % 2 == 0 || a % 3 == 0) return 0;

        int i = 5;
        while (i * i <= a) {
            if (a % i == 0 || a % (i + 2) == 0) return 0;
            i += 6;
        }
        return 1;
    }
}
