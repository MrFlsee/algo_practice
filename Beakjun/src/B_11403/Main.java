package B_11403;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] adj = new int[121][121];
	static int[][] dist = new int[121][121];
	static final int INF = (int)1e9;
			
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 1; j <= n; j++) {
				int temp = Integer.parseInt(st.nextToken());
				adj[i][j] = temp;
				if(temp == 0) {
					dist[i][j] = INF;
				} else {					
					dist[i][j] = adj[i][j];
				}
			}
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if(dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				int temp = dist[i][j];
				
				if(temp == INF) 
					dist[i][j] = 0;
				else
					dist[i][j] = 1;
				
				bw.write(String.valueOf(dist[i][j]) + " ");
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();

	}
}
