import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int N;
	private static int M;

	private static void solution(Integer[] arrA, Integer[] arrB) {
		StringBuilder sb = new StringBuilder();
		int lenOfArrA = arrA.length;
		int lenOfArrB = arrB.length;
		int idxA = 0;
		int idxB = 0;
		while (idxA < lenOfArrA || idxB < lenOfArrB) {
			if (idxA >= lenOfArrA) {
				sb.append(arrB[idxB] + " ");
				idxB += 1;
				continue;
			} else if (idxB >= lenOfArrB) {
				sb.append(arrA[idxA] + " ");
				idxA += 1;
				continue;
			}

			if (arrA[idxA] < arrB[idxB]) {
				sb.append(arrA[idxA] + " ");
				idxA += 1;
			}else{
				sb.append(arrB[idxB] + " ");
				idxB += 1;
			}
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Integer[] arrA = new Integer[N];
		Integer[] arrB = new Integer[M];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arrA[i] = Integer.parseInt(st2.nextToken());
		}
		StringTokenizer st3 = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arrB[i] = Integer.parseInt(st3.nextToken());
		}
		solution(arrA, arrB);

	}

}

