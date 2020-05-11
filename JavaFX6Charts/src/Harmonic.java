
/**
 * Harmonic number is the sum of the reciprocals of the first n natural numbers
 * @author Hutchison
 *
 */
public class Harmonic {
	public static double harmonic(int n) {

		// compute 1/1 + 1/2 + 1/3 + ... + 1/n
		double sum = 0.0;
		for (int i = 1; i <= n; i++) {
			sum += 1.0 / i;
		}
		// return the nth harmonic number
		return (sum);
	}
}
