package 자료구조9장트리;

/*
 * 23.6.7 3회차 실습 코드
 */
import java.util.Random;
import java.util.Scanner;

//정수를 저정하는 이진트리 만들기 실습

class TreeNode {
	TreeNode LeftChild;
	int data;
	TreeNode RightChild;

	public TreeNode() {
		LeftChild = RightChild = null;
	}

	public TreeNode(int x) {
//		LeftChild = RightChild = null;
		data = x;
	}
}

class Tree {
	TreeNode root;

	Tree() {
		root = null;
	}

	TreeNode inorderSucc(TreeNode current) {
		TreeNode temp = current.RightChild;
		if (current.RightChild != null)
			while (temp.LeftChild != null)
				temp = temp.LeftChild;
		return temp;
	}
	
	TreeNode inorderPredecessor(TreeNode current) {
		TreeNode temp = current.LeftChild;
		if (current.LeftChild != null)
			while (temp.RightChild != null)
				temp = temp.RightChild;
		return temp;
	}

	boolean isLeafNode(TreeNode current) {
		if (current.LeftChild == null && current.RightChild == null)
			return true;
		else
			return false;
	}
	
	boolean HasOnlyLeftChild(TreeNode current) {
		if (current.LeftChild != null && current.RightChild == null)
			return true;
		else
			return false;
	}
	
	boolean HasOnlyRightChild(TreeNode current) {
		if (current.RightChild != null && current.LeftChild == null)
			return true;
		else
			return false;
	}
	
	boolean HasFullChild(TreeNode current) {
		if (current.LeftChild != null && current.RightChild != null)
			return true;
		else
			return false;
	}

	void inorder() {
		inorder(root);
	}

	void preorder() {
		preorder(root);
	}

	void postorder() {
		postorder(root);
	}

	void inorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			inorder(CurrentNode.LeftChild);
			System.out.print(" " + CurrentNode.data);
			inorder(CurrentNode.RightChild);
		}
	}

	void preorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			System.out.print(CurrentNode.data + " ");
			preorder(CurrentNode.LeftChild);
			preorder(CurrentNode.RightChild);
		}
	}

	void postorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			postorder(CurrentNode.LeftChild);
			postorder(CurrentNode.RightChild);
			System.out.print(CurrentNode.data + " ");
		}
	}

	boolean insert(int x) {// binary search tree를 만드는 입력 => A + B * C을 tree로 만드는 방법: 입력 해결하는 알고리즘 작성 방법을
							// 설계하여 구현
		if (root == null) {
			root = new TreeNode(x);
			System.out.println("루트:" + x);
			return true;
		}

		TreeNode p = root, q = null;

		while (p != null) {
			if (x > p.data) {
				q = p;
				p = p.RightChild;

			} else if (x < p.data) {
				q = p;
				p = p.LeftChild;
			} else {
				System.out.println("중복:" + x);
				return false;
			}
		}

		TreeNode tmp = new TreeNode(x);
		if (x > q.data) {
			q.RightChild = tmp;
		} else {
			q.LeftChild = tmp;
		}
		return true;
	}

	boolean delete(int num) {
		
		TreeNode p = root, q = null;

	    // 먼저 삭제할 노드를 찾습니다.
	    while (p != null) {
	        if (p.data > num) {
	            q = p;
	            p = p.LeftChild;
	        } else if (p.data < num) {
	            q = p;
	            p = p.RightChild;
	        } else {
	            break;
	        }
	    }

	    if (p == null) {
	        System.out.println("삭제 실패: 데이터가 존재하지 않습니다.");
	        return false;
	    }

	    // 삭제할 노드가 leaf node 인 경우
	    if (isLeafNode(p)) {
	        if (q == null) {
	            // 삭제할 노드가 root 인 경우
	            root = null;
	        } else if (q.LeftChild == p) {
	            q.LeftChild = null;
	        } else {
	            q.RightChild = null;
	        }
	        p = null;
	    } else if (HasOnlyRightChild(p)) {
	        // 삭제할 노드가 오직 오른쪽 자식만 가지고 있는 경우
	        if (q == null) {
	            // 삭제할 노드가 root 인 경우
	            root = p.RightChild;
	        } else if (q.LeftChild == p) {
	            q.LeftChild = p.RightChild;
	        } else {
	            q.RightChild = p.RightChild;
	        }
	        p = null;
	    } else if (HasOnlyLeftChild(p)) {
	        // 삭제할 노드가 오직 왼쪽 자식만 가지고 있는 경우
	        if (q == null) {
	            // 삭제할 노드가 root 인 경우
	            root = p.LeftChild;
	        } else if (q.LeftChild == p) {
	            q.LeftChild = p.LeftChild;
	        } else {
	            q.RightChild = p.LeftChild;
	        }
	        p = null;
	    } else if (HasFullChild(p)) {
	        // 삭제할 노드가 양쪽 자식을 모두 가지고 있는 경우
	        // 오른쪽 서브트리의 가장 작은 값을 찾아서 현재 노드에 복사한 뒤,
	        // 오른쪽 서브트리에서 해당 값을 삭제합니다.
	        TreeNode successor = inorderSucc(p);
	        int tempData = successor.data;
	        delete(successor.data); // 오른쪽 서브트리에서 중위 후속자 삭제
	        p.data = tempData; // 후속자의 데이터를 현재 노드로 복사
	    }

	    return true;

	}

	boolean search(int num) {
		
		TreeNode current = root;
	    while (current != null) {
	        if (num == current.data) {
	            // 현재 노드의 데이터가 찾는 데이터와 일치하면 true 반환
	            return true;
	        } else if (num < current.data) {
	            // 찾는 데이터가 현재 노드의 데이터보다 작으면 왼쪽 서브트리에서 검색
	            current = current.LeftChild;
	        } else {
	            // 찾는 데이터가 현재 노드의 데이터보다 크면 오른쪽 서브트리에서 검색
	            current = current.RightChild;
	        }
	    }
	    // 노드를 찾지 못한 경우 false 반환
	    return false;

	}
}

public class BinaryTree_int {
	enum Menu {
		Add("삽입"), Delete("삭제"), Search("검색"), InorderPrint("순차출력"), Exit("종료");

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) { // 생성자(constructor)
			message = string;
		}

		String getMessage() { // 표시할 문자열을 반환
			return message;
		}
	}

	// --- 메뉴 선택 ---//
	static Menu SelectMenu() {
		Scanner stdIn = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values())
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
			System.out.print(" : ");
			key = stdIn.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());

		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner stdIn = new Scanner(System.in);
		Tree t = new Tree();
		Menu menu; // 메뉴
		int count = 0;
		int num;
		boolean result;
		do {
			switch (menu = SelectMenu()) {
			case Add: // 노드 삽입
				System.out.println("The number of items = ");
				count = stdIn.nextInt();
				int[] input = new int[10];
				for (int ix = 0; ix < count; ix++) {
					input[ix] = rand.nextInt(9) + 1;
				}
				for (int i = 0; i < count; i++) {
					if (!t.insert(input[i]))
						System.out.println("Insert Duplicated data");
				}
				break;

			case Delete: // 노드 삭제
				System.out.println("삭제할 데이터:: ");
				num = stdIn.nextInt();
				if (t.delete(num))
					System.out.println("삭제 데이터 = " + num + " 성공");
				else
					System.out.println("삭제 실패");
				;
				break;

			case Search: // 노드 검색
				System.out.println("검색할 데이터:: ");

				num = stdIn.nextInt();
				result = t.search(num);
				if (result)
					System.out.println(" 데이터 = " + num + "존재합니다.");
				else
					System.out.println("해당 데이터가 없습니다.");
				break;

			case InorderPrint: // 전체 노드를 키값의 오름차순으로 표시
				t.inorder();
				System.out.println();
				break;
			}
		} while (menu != Menu.Exit);
	}
}
