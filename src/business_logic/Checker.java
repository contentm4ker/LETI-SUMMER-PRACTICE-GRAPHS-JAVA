package business_logic;

public class Checker {
    private final int[][] indMatrix;
    private DFSState[] visited;

    public Checker(Graph graph) {
        this.indMatrix = graph.getIndMatrix();
        visited = new DFSSTATE[indMatrix.length];

        for (int i = 0; i < visited.length; i++) {
            visited[i] = DFSSTATE.WHITE;
        }
    }

    private boolean dfs(int u) {
        visited[u] = DFSState.GREY;

        for (int v = 0; v < indMatrix[u].length; v++) {
            if (indMatrix[u][v] != 0) {
                if (visited[v] == DFSSTATE.WHITE) {
                    boolean isCycleByNextVertex = dfs(v);

                    if (isCycleByNextVertex){
                        return true;
                    }
                }
                else if (visited[v] == DFSSTATE.GREY){
                    return true;
                }
            }
        }

        visited[u] == DFSState.BLACK;
        return false;
    }

    public boolean isCycle() {
        for (int u = 0; u < indMatrix.length; u++) {
            if (visited[u] == DFSSTATE.WHITE) {
                if (dfs(u)) {
                    return true;
                }
            }
        }

        return false;
    }

    private enum DFSState {
        WHITE,
        GREY,
        BLACK
    }
}