import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

	private static int N;
	private static int K;
	private static LinkedList<Integer> linkedList = new LinkedList<>();
	private static List<Integer> solutionList = new ArrayList<>();

	private static void solution() {
		StringBuilder sb = new StringBuilder();
		int size = linkedList.size();
		int index = -1;
		while (size > 0) {
			index = (index + K) % size;
			Integer removedNumber = linkedList.remove(index);
			solutionList.add(removedNumber);
			index -= 1;
			size -= 1;
		}
		String solutionString = solutionList.stream()
			.map(String::valueOf)
			.collect(Collectors.joining(", "));
		System.out.println("<" + solutionString + ">");

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			linkedList.add(i+1);
		}
		solution();

	}

}

