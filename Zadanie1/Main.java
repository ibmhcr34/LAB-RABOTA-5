public class TSP {
    private int n;
    private int[][] dist;
    private boolean[] visited;
    private int minCost = Integer.MAX_VALUE;
    private int[] bestPath;

    public TSP(int[][] dist) {
        this.n = dist.length;
        this.dist = dist;
        this.visited = new boolean[n];
        this.bestPath = new int[n + 1];
    }

    public void solve() {
        int[] path = new int[n + 1];
        visited[0] = true;
        path[0] = 0;
        dfs(0, 1, 0, path);
    }

    private void dfs(int currentCity, int count, int cost, int[] path) {
        if (count == n) {
            cost += dist[currentCity][0];
            if (cost < minCost) {
                minCost = cost;
                System.arraycopy(path, 0, bestPath, 0, n);
                bestPath[n] = 0;
            }
            return;
        }

        for (int nextCity = 0; nextCity < n; nextCity++) {
            if (!visited[nextCity]) {
                visited[nextCity] = true;
                path[count] = nextCity;
                dfs(nextCity, count + 1, cost + dist[currentCity][nextCity], path);
                visited[nextCity] = false;
            }
        }
    }

    public void printResult() {
        System.out.println("minCost);
        for (int city : bestPath) {
            System.out.print(city + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] dist = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };

        TSP tsp = new TSP(dist);
        tsp.solve();
        tsp.printResult();
    }
}
