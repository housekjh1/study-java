//package Chap11_그래프;
//
///*
// Graph Representation
// Adjacency Lists + BFS + DFS
//*/
//
//import java.util.Scanner;
//
//class ListNode {
//	int data;
//	ListNode link;
//
//	public ListNode(int data) {
//		this.data = data;
//		link = null;
//	}
//}
//
//class List {
//	ListNode first;
//
//	public List() {
//		first = null;
//	}
//
//	void Insert(int k) {// 같은 값을 체크하지 않아 중복 입력됨
//		// 구현할 부분
//		ListNode tmp = new ListNode(k);
//		if (first == null) {
//			first = tmp;
//			return;
//		}
//		if (first.data > k) {
//			tmp.link = first;
//			first = tmp;
//			return;
//		}
//		ListNode p = first, q = null;
//		while (p != null) {
//			if (p.data < k) {
//				q = p;
//				p = p.link;
//			} else if (p.data >= k) {
//				q.link = tmp;
//				tmp.link = p;
//				return;
//			}
//		}
//		q.link = tmp;
//	}
//
//	void Delete(int k) {
//		// 구현할 부분
//		ListNode p = first, q = null;
//		if (first == null) {
//			System.out.println("리스트가 비었습니다.");
//			return;
//		}
//		if (first.data == k) {
//			first = first.link;
//			return;
//		}
//		while (p != null) {
//			if (p.data < k) {
//				q = p;
//				p = p.link;
//			} else if (p.data == k) {
//				q.link = p.link;
//				return;
//			}
//		}
//		System.out.println("삭제할 데이터가 없습니다.");
//		return;
//	}
//}
//
//class ListIterator {
//
//	private List list;
//	private ListNode current;
//
//	public List getList() {
//		return list;
//	}
//
//	public ListNode getCurrent() {
//		return current;
//	}
//
//	public ListIterator(List l) {
//		list = l;
//		current = list.first;
//	}
//
//	int First() {
//		if (current != null)
//			return current.data;
//		else
//			return 0;
//	}
//
//	int Next() {
//		int data = current.data;
//		current = current.link;
//		return data;
//	}
//
//	boolean NotNull() {
//		if (current != null)
//			return true;
//		else
//			return false;
//	}
//
//	boolean NextNotNull() {
//		if (current.link != null)
//			return true;
//		else
//			return false;
//	}
//
//}
//
//class QueueNode {
//	int data;
//	QueueNode link;
//
//	QueueNode(int data, QueueNode link) {
//		this.data = data;
//		this.link = link;
//	}
//}
//
//class Queue {
//	private QueueNode front, rear;
//
//	void QueueEmpty() {
//		front = rear = null;
//	}
//
//	public Queue() {
//		QueueEmpty();
//	}
//
//	boolean IsEmpty() {
//		if (front == null)
//			return true;
//		else
//			return false;
//	}
//
//	void Insert(int y) {
//		// 구현할 부분
//		QueueNode p = rear, q = null;
//		QueueNode tmp = new QueueNode(y, null);
//		if (rear == null) {
//			rear = tmp;
//			front = rear;
//			return;
//		}
//		while (p != null) {
//			q = p;
//			p = p.link;
//		}
//		q.link = tmp;
//	}
//
//	int Delete() {
//		// 구현할 부분
//		if (front == null) {
//			System.out.println("큐가 비었습니다.");
//			return -1;
//		}
//		int tmp = front.data;
//		front = front.link;
//		if (front == null) {// 딜리트 후 큐가 비었을 경우 rear를 null처리하지 않으면 인서트 시 rear가 초기화되지않아 구현실패
//			rear = null;
//		}
//		return tmp;
//	}
//	
//	void showQueue() {
//		if (front == null) {
//			System.out.println("큐가 비었습니다.");
//			return;
//		}
//		QueueNode p = front;
//		while (p != null) {
//			System.out.print(p.data + " ");
//			p = p.link;
//		}
//		System.out.println();
//	}
//}
//
//class StackNode {
//	ListNode data;
//	StackNode link;
//
//	StackNode(ListNode data, StackNode link) {
//		this.data = data;
//		this.link = link;
//	}
//}
//
//class Stack {
//	private StackNode top;
//
//	void StackEmpty() {
//		top = null;
//	}
//
//	public Stack() {
//		StackEmpty();
//	}
//
//	boolean IsEmpty() {
//		if (top == null)
//			return true;
//		else
//			return false;
//	}
//
//	void Insert(ListNode y) {
//		// 구현할 부분
//		StackNode p = top, q = null;
//		StackNode tmp = new StackNode(y, null);
//		if (top == null) {
//			top = tmp;
//			return;
//		}
//		while (p != null) {
//			q = p;
//			p = p.link;
//		}
//		q.link = tmp;
//	}
//
//	ListNode Delete()
//	// delete the top node in stack and return its data
//	{
//		// 구현할 부분
//		if (top == null) {
//			System.out.println("스택이 비었습니다.");
//			return null;
//		}
//		StackNode p = top, q = null;
//		while (p.link != null) {
//			q = p;
//			p = p.link;
//		}
//		if (p == top) {
//			ListNode tmp = top.data;
//			top = null;
//			return tmp;
//		}
//		ListNode tmp = p.data;
//		q.link = null;
//		p = null;
//		return tmp;
//	}
//
//	void showStack() {
//		if (top == null) {
//			System.out.println("스택이 비었습니다.");
//			return;
//		}
//		StackNode p = top;
//		while (p != null) {
//			System.out.print(p.data.data + " ");
//			p = p.link;
//		}
//		System.out.println();
//	}
//}
//
//class Graph {
//	List[] HeadNodes;
//	int n;
//	boolean[] visited;
//
//	public Graph(int vertices) {
//		n = vertices;
//		HeadNodes = new List[n];
//		visited = new boolean[n];
//		for (int i = 0; i < n; i++) {
//			HeadNodes[i] = new List();
//			visited[i] = false;
//		}
//
//	}
//
//	void displayAdjacencyLists() {
//		for (int i = 0; i < n; i++) {
//			// 구현할 부분
//			ListNode p = HeadNodes[i].first;
//			System.out.printf("%d", i);
//			while (p != null) {
//				System.out.print(" -> " + p.data);
//				p = p.link;
//			}
//			System.out.println();
//		}
//	}
//
//	void InsertVertex(int start, int end) {
//		if (start < 0 || start >= n || end < 0 || end >= n) {
//			System.out.println("the start node number is out of bound.");
//			return;
//		}
//		List p = HeadNodes[start];
//		ListNode tmp = new ListNode(end);
//		if (p.first == null) {
//			p.first = tmp;
//			return;
//		}
//		if (p.first.data > end) {
//			tmp.link = p.first;
//			p.first = tmp;
//			return;
//		}
//		ListNode p1 = p.first, q1 = null;
//		while (p1 != null) {
//			if (p1.data < end) {
//				q1 = p1;
//				p1 = p1.link;
//			} else if (p1.data > end) {
//				tmp.link = p1;
//				q1.link = tmp;
//				return;
//			} else {
//				System.out.println("중복 처리");
//				return;
//			}
//		}
//		q1.link = tmp;
//		// 구현할 부분
//	}
//
//	void BFS(int v) {
////		boolean[] visited = new boolean[n]; // visited is declared as a Boolean
//		for (int i = 0; i < n; i++)
//			visited[i] = false; // initially, no vertices have been visited
//		// 구현할 부분
//		// BFS에 사용할 큐를 생성합니다.
//		Queue queue = new Queue();
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
//			ListIterator li = new ListIterator(HeadNodes[a]);
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
//		ListIterator li = new ListIterator(HeadNodes[v]);
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
//		Stack stack = new Stack();
//		int[] result = new int[n];
//		int i = 0;
//		stack.StackEmpty();
//		stack.Insert(new ListNode(v)); // 초기 노드를 스택에 넣어 시작합니다.
//		System.out.println("Stack:");
//		while (!stack.IsEmpty()) {
//			stack.showStack();
//			ListNode tmp = stack.Delete(); // 스택에서 노드를 꺼내고 방문 처리합니다.
//			v = tmp.data; // 현재 방문한 노드를 업데이트합니다.
//
//			if (!visited[v]) {
//				visited[v] = true;
////				System.out.print(v + " ");
//				result[i++] = v;
//
//				// 현재 노드와 인접한 노드를 스택에 넣습니다.
//				ListIterator li = new ListIterator(HeadNodes[v]);
//				while (li.NotNull()) {
//					int w = li.Next();
//					if (!visited[w]) {
//						stack.Insert(new ListNode(w));
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
//}
//
//public class Chap11_test_그래프DFS_BFS {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int select = 10, n, startEdge = -1, endEdge = -1;
//		int startBFSNode = 100;// the start node to BFS
//
//		System.out.println("vertex 숫자 입력: ");
//
//		n = sc.nextInt();
//
//		Graph g = new Graph(n);
//
//		while (select != '0') {
//			System.out.println("\n명령 선택 1: edge 추가, 2: Adjacency Lists 출력, 3: BFS, 4: DFS, 5: 종료 => ");
//			select = sc.nextInt();
//			switch (select) {
//			case 1:
//				System.out.println("edge 추가: from vertext: ");
//				startEdge = sc.nextInt();
//				System.out.println("to vertex: ");
//				endEdge = sc.nextInt();
//				if (startEdge < 0 || startEdge >= n || endEdge < 0 || endEdge >= n) {
//					System.out.println("the input node is out of bound.");
//					break;
//				}
//				// get smallest start node.
//				if (startEdge < startBFSNode)
//					startBFSNode = startEdge;
//				if (endEdge < startBFSNode)
//					startBFSNode = endEdge;
//				g.InsertVertex(startEdge, endEdge);
//				g.InsertVertex(endEdge, startEdge);
//				break;
//			case 2:
//				// display
//				g.displayAdjacencyLists();
//				break;
//
//			case 3:
//				System.out.println("Start BFS from node: " + startBFSNode);
//				g.BFS(startBFSNode);
//				break;
//			case 4:
//				System.out.println("Start DFS from node: " + startBFSNode);
//				g.DFS(startBFSNode);
//				break;
//			case 5:
//				System.exit(0);
//				break;
//			default:
//				System.out.println("WRONG INPUT  " + "\n" + "Re-Enter");
//				break;
//			}
//		}
//
//		return;
//	}
//}
