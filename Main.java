public class Main {

    // Main method (psvm)
    public static void main(String[] args) {
        System.out.println("[LOG] Application started.");

        int number = 34;
        System.out.println("[LOG] Target number set to: " + number);

        boolean flag = false;

        System.out.println("[LOG] Starting loop to find prime addends...");

        // Loop to find prime numbers
        for (int i = 2; i <= number / 2; ++i) {
            
            System.out.println("[LOG] Checking if " + i + " is prime...");

            // condition for i to be a prime number
            if (checkPrime(i)) {
                System.out.println("[LOG] " + i + " is a prime number.");
                
                int complement = number - i;
                System.out.println("[LOG] Checking complement (" + number + " - " + i + " = " + complement + ") for primality...");

                // condition for n-i to be a prime number
                if (checkPrime(complement)) {
                    System.out.println("[LOG] Match found: " + i + " and " + complement + " are both prime.");

                    // n = primeNumber1 + primeNumber2
                    System.out.printf("%d = %d + %d\n", number, i, complement);
                    flag = true;
                } else {
                    System.out.println("[LOG] " + complement + " is NOT prime. Moving to next iteration.");
                }

            } else {
                System.out.println("[LOG] " + i + " is NOT prime. Skipping.");
            }
        }

        if (!flag) {
            System.out.println(number + " cannot be expressed as the sum of two prime numbers.");
            System.out.println("[LOG] No prime pairs found for " + number);
        }

        System.out.println("[LOG] Application finished.");
    }

    // Function to check prime number with logging
    static boolean checkPrime(int num) {
        // Note: Logging inside a high-frequency low-level method can verify detailed logic
        // but creates a lot of noise.
        
        boolean isPrime = true;

        for (int i = 2; i <= num / 2; ++i) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }
}