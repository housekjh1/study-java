package Chap11_그래프;

import java.util.Scanner;

class QueueNodeM {
	int data;
	QueueNodeM link;

	QueueNodeM(int data, QueueNodeM link) {
		this.data = data;
		this.link = link;
	}
}

class QueueM {
	private QueueNodeM front, rear;

	void QueueEmpty() {
		front = rear = null;
	}

	public QueueM() {
		QueueEmpty();
	}

	boolean IsEmpty() {
		if (front == null)
			return true;
		else
			return false;
	}

	void Insert(int y) {
		// 구현할 부분
		QueueNodeM p = rear, q = null;
		QueueNodeM tmp = new QueueNodeM(y, null);
		if (rear == null) {
			rear = tmp;
			front = rear;
			return;
		}
		while (p != null) {
			q = p;
			p = p.link;
		}
		q.link = tmp;
	}

	int Delete() {
		// 구현할 부분
		if (front == null) {
			System.out.println("큐가 비었습니다.");
			return -1;
		}
		int tmp = front.data;
		front = front.link;
		if (front == null) {// 딜리트 후 큐가 비었을 경우 rear를 null처리하지 않으면 인서트 시 rear가 초기화되지않아 구현실패
			rear = null;
		}
		return tmp;
	}

	void showQueue() {
		if (front == null) {
			System.out.println("큐가 비었습니다.");
			return;
		}
		QueueNodeM p = front;
		while (p != null) {
			System.out.print(p.data + " ");
			p = p.link;
		}
		System.out.println();
	}
}

class StackNodeM {
	ListNodeM data;
	StackNodeM link;

	StackNodeM(ListNodeM data, StackNodeM link) {
		this.data = data;
		this.link = link;
	}
}

class StackM {
	private StackNodeM top;

	void StackEmpty() {
		top = null;
	}

	public StackM() {
		StackEmpty();
	}

	boolean IsEmpty() {
		if (top == null)
			return true;
		else
			return false;
	}

	void Insert(ListNodeM y) {
		// 구현할 부분
		StackNodeM p = top, q = null;
		StackNodeM tmp = new StackNodeM(y, null);
		if (top == null) {
			top = tmp;
			return;
		}
		while (p != null) {
			q = p;
			p = p.link;
		}
		q.link = tmp;
	}

	ListNodeM Delete()
	// delete the top node in stack and return its data
	{
		// 구현할 부분
		if (top == null) {
			System.out.println("스택이 비었습니다.");
			return null;
		}
		StackNodeM p = top, q = null;
		while (p.link != null) {
			q = p;
			p = p.link;
		}
		if (p == top) {
			ListNodeM tmp = top.data;
			top = null;
			return tmp;
		}
		ListNodeM tmp = p.data;
		q.link = null;
		p = null;
		return tmp;
	}

	void showStack() {
		if (top == null) {
			System.out.println("스택이 비었습니다.");
			return;
		}
		StackNodeM p = top;
		while (p != null) {
			System.out.print(p.data.to + " ");
			p = p.link;
		}
		System.out.println();
	}
}

class ListNodeM {
	int to;
	int weight;
	ListNodeM link;

	public ListNodeM(int to, int weight) {
		this.to = to;
		this.weight = weight;
		link = null;
	}
}

class ListM {
	ListNodeM first;

	public ListM() {
		first = null;
	}

	void Insert(int to, int weight) {// 같은 값을 체크하지 않아 중복 입력됨
		// 구현할 부분
		ListNodeM tmp = new ListNodeM(to, weight);
		if (first == null) {
			first = tmp;
			return;
		}
		if (first.data > k) {
			tmp.link = first;
			first = tmp;
			return;
		}
		ListNodeM p = first, q = null;
		while (p != null) {
			if (p.data < k) {
				q = p;
				p = p.link;
			} else if (p.data >= k) {
				q.link = tmp;
				tmp.link = p;
				return;
			}
		}
		q.link = tmp;
	}

	void Delete(int k) {
		// 구현할 부분
		ListNodeM p = first, q = null;
		if (first == null) {
			System.out.println("리스트가 비었습니다.");
			return;
		}
		if (first.data == k) {
			first = first.link;
			return;
		}
		while (p != null) {
			if (p.data < k) {
				q = p;
				p = p.link;
			} else if (p.data == k) {
				q.link = p.link;
				return;
			}
		}
		System.out.println("삭제할 데이터가 없습니다.");
		return;
	}
}

class ListIteratorM {

	private ListM list;
	private ListNodeM current;

	public ListM getList() {
		return list;
	}

	public ListNodeM getCurrent() {
		return current;
	}

	public ListIteratorM(ListM l) {
		list = l;
		current = list.first;
	}

	int First() {
		if (current != null)
			return current.data;
		else
			return 0;
	}

	int Next() {
		int data = current.data;
		current = current.link;
		return data;
	}

	boolean NotNull() {
		if (current != null)
			return true;
		else
			return false;
	}

	boolean NextNotNull() {
		if (current.link != null)
			return true;
		else
			return false;
	}

}

class GraphM {
	ListM[] HeadNodes;
	int n;
	boolean[] visited;

	public GraphM(int vertices) {
		n = vertices;
		HeadNodes = new ListM[n];
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			HeadNodes[i] = new ListM();
			visited[i] = false;
		}

	}

	void displayAdjacencyLists() {
		for (int i = 0; i < n; i++) {
			// 구현할 부분
			ListNodeM p = HeadNodes[i].first;
			System.out.printf("%d", i);
			while (p != null) {
				System.out.print(" -> " + p.data);
				p = p.link;
			}
			System.out.println();
		}
	}

	void InsertVertex(int start, int end, int weight) {
		if (start < 0 || start >= n || end < 0 || end >= n) {
			System.out.println("the start node number is out of bound.");
			return;
		}
		// 구현할 부분
		ListM p = HeadNodes[start];
		ListNodeM tmp = new ListNodeM(end, weight);
		if (p.first == null) {
			p.first = tmp;
			return;
		}
		if (p.first.data > end) {
			tmp.link = p.first;
			p.first = tmp;
			return;
		}
		ListNodeM p1 = p.first, q1 = null;
		while (p1 != null) {
			if (p1.data < end) {
				q1 = p1;
				p1 = p1.link;
			} else if (p1.data > end) {
				tmp.link = p1;
				q1.link = tmp;
				return;
			} else {
				System.out.println("중복 처리");
				return;
			}
		}
		q1.link = tmp;
	}

//	void BFS(int v) {
////		boolean[] visited = new boolean[n]; // visited is declared as a Boolean
//		for (int i = 0; i < n; i++)
//			visited[i] = false; // initially, no vertices have been visited
//		// 구현할 부분
//		// BFS에 사용할 큐를 생성합니다.
//		QueueM queue = new QueueM();
//		int[] result = new int[n];
//		int i = 0;
//		// 시작 노드를 큐에 추가하고 방문 표시를 합니다.
//		queue.Insert(v);
//		visited[v] = true;
//
//		System.out.println("Queue:");
//
//		while (!queue.IsEmpty()) {
//			queue.showQueue();
//			// 큐에서 노드를 꺼내어 방문합니다.
//			int a = queue.Delete();
////			System.out.print(a + " ");
//			result[i++] = a;
//			// 현재 노드의 인접한 노드를 큐에 추가합니다.
//			ListIteratorM li = new ListIteratorM(HeadNodes[a]);
//			while (li.NotNull()) {
//				int w = li.Next();
//				if (!visited[w]) {
//					queue.Insert(w);
//					visited[w] = true;
//				}
//			}
//		}
//		System.out.println("BFS 순서:");
//		for (int j = 0; j < n; j++) {
//			System.out.print(result[j] + " ");
//		}
//		System.out.println();
//	}
//
//	// Driver
//	void DFS(int v) {
//		for (int i = 0; i < n; i++)
//			visited[i] = false; // initially, no vertices have been visited
//
//		// _DFS(v); // start search at vertex 0
//		_NonRecursiveDFS(v);
//	}
//
//	// Workhorse
//	void _DFS(int v)
//	// visit all previously unvisited vertices that are reachable from vertex v
//	{
//		visited[v] = true;
//		System.out.println(v + ", ");
//		ListIteratorM li = new ListIteratorM(HeadNodes[v]);
//		if (!li.NotNull())
//			return;
//		int w = li.First();
//		while (true) {
//			if (!visited[w])
//				_DFS(w);
//			if (li.NotNull())
//				w = li.Next();
//			else
//				return;
//		}
//	}
//
//	// Workhorse 2
//	void _NonRecursiveDFS(int v)
//	// visit all previously unvisited vertices that are reachable from vertex v
//	{
//		// 구현할 부분
//		StackM stack = new StackM();
//		int[] result = new int[n];
//		int i = 0;
//		stack.StackEmpty();
//		stack.Insert(new ListNodeM(v)); // 초기 노드를 스택에 넣어 시작합니다.
//		System.out.println("Stack:");
//		while (!stack.IsEmpty()) {
//			stack.showStack();
//			ListNodeM tmp = stack.Delete(); // 스택에서 노드를 꺼내고 방문 처리합니다.
//			v = tmp.data; // 현재 방문한 노드를 업데이트합니다.
//
//			if (!visited[v]) {
//				visited[v] = true;
////				System.out.print(v + " ");
//				result[i++] = v;
//
//				// 현재 노드와 인접한 노드를 스택에 넣습니다.
//				ListIteratorM li = new ListIteratorM(HeadNodes[v]);
//				while (li.NotNull()) {
//					int w = li.Next();
//					if (!visited[w]) {
//						stack.Insert(new ListNodeM(w));
//					}
//				}
//			}
//		}
//		System.out.println("DFS 순서:");
//		for (int j = 0; j < n; j++) {
//			System.out.print(result[j] + " ");
//		}
//		System.out.println();
//	}
}

//minimal spanning tree:: Kruskal’s source code
//min heap, set 사용하여 MST 구현
interface MaxHeap {
	public void Insert(Edge x);

	public Edge DeleteMin();
}

class Edge implements Comparable<Edge> {
	int src;
	int dest;
	int weight;

	@Override
	public int compareTo(Edge o) {
		return this.weight > o.weight ? 1 : this.weight < o.weight ? -1 : 0;
	}

}

class Heap implements MaxHeap {
	final int heapSize = 100;
	private Edge[] heap;
	private int n; // current size of MaxHeap
	private int MaxSize; // Maximum allowable size of MaxHeap

	public Heap(int sz) {
		MaxSize = sz;
		n = 0;
		heap = new Edge[MaxSize + 1]; // heap[0]은 사용하지 않음
	}

	public void display() {
		int i;
		for (i = 1; i <= n; i++)
			System.out.print("  (" + i + ", " + heap[i] + ") ");
		System.out.println();
	}

	@Override
	public void Insert(Edge x) {
		int i;
		if (n >= MaxSize + 1) {
			HeapFull();
			return;
		}
		n++;// 힙 증가
		for (i = n;;) {
			if (i == 1)
				break;// 커서가 루트일 경우 나가기
			if (heap[i / 2].compareTo(x) <= 0)
				break;// 마지막 노드의 부모보다 입력값이 크거나 같은 경우 나가기
			heap[i] = heap[i / 2];// 부모를 자식으로 이동
			i = i / 2;// 부모노드 위치로 점프
		}
		heap[i] = x;
	}

	@Override
	public Edge DeleteMin() {
		int p, c;
		if (n <= 0) {
			HeapEmpty();
			return null;
		}
		Edge x = heap[1];// 루트 가져오기
		Edge y = heap[n];// 마지막 노드 가져오기
		n--;// 힙 감소

		for (p = 1, c = 2; c <= n;) {
			if (c < n && heap[c].compareTo(heap[c + 1]) > 0)
				c++;// 자식 노드를 더 작은 자식으로 포인터링
			if (y.compareTo(heap[c]) <= 0)// 마지막 노드를 루트에 두고 내려가면서 자식과 비교
				break;// 마지막 노드가 자식 노드보다 작을 경우 나가기
			heap[p] = heap[c];// 부모 노드에 작은 자식노드 대입
			p = c;// 작은 자식 인덱스로 부모 인덱스 포인터링
			c = c * 2;// 바뀐 부모 인덱스의 자식인덱스로 내려감
		}

		heap[p] = y;// 마지막 반환 포인터에 마지막 노드 붙이기
		return x;// 루트값 반환
	}

	private void HeapEmpty() {
		System.out.println("Heap Empty");
	}

	private void HeapFull() {
		System.out.println("Heap Full");
	}
}

public class Chap11_test_minimalspanningtree {

//The main function to construct MST using Kruskal's algorithm
	static int addEdgeSet(Edge[] edgeSet, int e, int from, int to, int w) {

	}

	static int makeEdgeSet(GraphM grp, Edge[] edgeSet, int e) {
		// graph의 adjacency list를 읽어 edge set를 만든다
		int v = 0;
		ListNodeM p = grp.HeadNodes[v].first;
		int from = v;
		int to = p.to;
		int w = p.weight;
		addEdgeSet(edgeSet, e, from, to, w);
		
	}

	static void KruskalMST(GraphM graph, int n) {
		Edge[] edgeSet = new Edge[30];
		Edge result[] = new Edge[30]; // MST
		for (int p = 0; p < 30; p++) {
			edgeSet[p] = new Edge();
			result[p] = new Edge();
		}

		int t = 0; // MST result[]
		int edgeNum = 0; // edgeSet
		edgeNum = makeEdgeSet(graph, edgeSet, edgeNum);

		Heap hp = new Heap(100);
		for (int j = 0; j < edgeNum; j++) {
			hp.Insert(edgeSet[j]);
		}

		Sets m = new Sets(20);

		while (t < n - 1)// t contains less than n-1 edges
		{
			// choose an edge (v,w) from E of lowest cost

			// Else discard the next_edge
		}
		if (t < n - 1) {
			System.out.println("no spanning tree");
			return;
		}
		// MST 출력

		for (int k = 0; k < t; k++)
			System.out.println(result[k] + " ");
		return;
	}

//Driver program to test above functions
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int select = 0, n, weight;
		int startBFSNode = 100;// the start node to BFS
		int startEdge, endEdge;
		System.out.println("Input the total node number: ");
		n = sc.nextInt();

		/* Let us create following weighted graph */
		GraphM graph = new GraphM(n);
		while (select != '0') {
			System.out.println("\n명령선택:: 1.edges/Weight 입력, 2. Adjacency Lists 출력, 3. spanningTree, 4: Quit => ");
			select = sc.nextInt();
			switch (select) {

			case 1:
				System.out.println("edge 추가: from vertext: ");
				startEdge = sc.nextInt();
				System.out.println("to vertex: ");
				endEdge = sc.nextInt();
				System.out.println("가중치: ");
				weight = sc.nextInt();
				if (startEdge < 0 || startEdge >= n || endEdge < 0 || endEdge >= n) {
					System.out.println("the input node is out of bound.");
					break;
				}
				// get smallest start node.
				if (startEdge < startBFSNode)
					startBFSNode = startEdge;
				if (endEdge < startBFSNode)
					startBFSNode = endEdge;
				graph.InsertVertex(startEdge, endEdge, weight);
				break;
			case 2:
				// display
				graph.displayAdjacencyLists();
				break;
			case 3:
				System.out.println("\n Minimal SpanningTree 작업 시작");
				KruskalMST(graph, n);

				break;
			case 4:
				System.exit(0);
				break;
			default:
				System.out.println("WRONG INPUT  ");
				System.out.println("Re-Enter");
				break;
			}
		}
		return;
	}
}
