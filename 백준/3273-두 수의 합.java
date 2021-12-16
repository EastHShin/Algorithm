import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int n;

	private static int result(int[] sequence, int target) {
		int i = 0;
		int j = n - 1;
		int count = 0;
		int sum;
		Arrays.sort(sequence);
		while (i < j) {
			sum = sequence[i] + sequence[j];
			if (sum == target) {
				count += 1;
				j -= 1;
				continue;
			}
			if (sum > target) {
				j -= 1;
				continue;
			}
			if (sum < target) {
				i += 1;
				continue;
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int target;
		int[] sequence = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			sequence[i] = Integer.parseInt(st.nextToken());
		}

		target = Integer.parseInt(br.readLine());
		int result = result(sequence, target);
		System.out.println(result);

	}

}

