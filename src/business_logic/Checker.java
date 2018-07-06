package business_logic;

public class Checker {
    private final int[][] indMatrix;
    private final boolean[] visited;

    public Checker(Graph graph) {
        this.indMatrix = graph.getIndMatrix();
        visited = new boolean[indMatrix.length];
    }

    private boolean dfs(int u) {
        visited[u] = true;

        for (int v = 0; v < indMatrix[u].length; v++) {
            if (indMatrix[u][v] != 0) {
                if (visited[v] == false) {
                    boolean isCycleByNextVertex = dfs(v);

                    if (isCycleByNextVertex){
                        return true;
                    }

                }
                else {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isCycle() {
        for (int u = 0; u < indMatrix.length; u++) {
            if (visited[u] == false) {
                if (dfs(u)) {
                    return true;
                }
            }
        }

        return false;
    }
}