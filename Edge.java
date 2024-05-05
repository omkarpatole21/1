import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Edge
{
int source, dest;
public Edge(int source, int dest)
{
this.source = source;
this.dest = dest;
}
}
class Graph
{
List<List<Integer>> adjList = null;
Graph(List<Edge> edges, int n)
{
adjList = new ArrayList<>();
for (int i = 0; i < n; i++) {
adjList.add(new ArrayList<>());
}
for (Edge edge: edges)
{
int src = edge.source;
int dest = edge.dest;
adjList.get(src).add(dest);
adjList.get(dest).add(src);
}
}
}
class Main
{
public static void DFS(Graph graph, int v, boolean[] discovered)
{
discovered[v] = true;
System.out.print(v + " ");
for (int u: graph.adjList.get(v))
{
if (!discovered[u]) {
DFS(graph, u, discovered);
}
}
}
public static void main(String[] args)
{
List<Edge> edges = Arrays.asList(
new Edge(1, 2), new Edge(1, 7), new Edge(1, 8), new
Edge(2, 3),
new Edge(2, 6), new Edge(3, 4), new Edge(3, 5), new
Edge(8, 9),
new Edge(8, 12), new Edge(9, 10), new Edge(9, 11)
);
int n = 13;
Graph graph = new Graph(edges, n);
boolean[] discovered = new boolean[n];
for (int i = 0; i < n; i++)
{
if (!discovered[i]) {
DFS(graph, i, discovered);
}
}
}
}
