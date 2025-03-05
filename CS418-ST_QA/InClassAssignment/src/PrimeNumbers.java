import java.util.*;

public class PrimeNumbers implements Iterable<Integer> {

    private List<Integer> primes = new ArrayList<Integer>();

    /*
     * creates a list of n prime numbers
     *
     * @param n - the number of primes to compute silently treats negative
     * arguments as zero
     */
    public void computePrimes(int n) {
        int count = 1; // count of primes
        int number = 2; // number tested for primeness
        boolean isPrime; // is this number a prime

        while (count <= n) {
            isPrime = true;
            for (int divisor = 2; divisor <= number / 2; divisor++) {
                if (number % divisor == 0) {
                    isPrime = false;
                    break; // for loop
                }
            }
            if (isPrime ) { // THIS IS THE FAULT!!!
                //&& (number % 10 != 7)
                primes.add(number);
                count++;
            }
            number++;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return primes.iterator();
    }

    @Override
    public String toString() {
        return primes.toString();
    }
}