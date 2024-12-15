import java.util.Scanner;
public class Main {
    public static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = {
                3, 4, 5, 7, 8, 5, 1
        };
        System.out.println(arrToList(arr));

        IntNode list1 = arrToList(arr);

        //printerRec(list1);
        System.out.println("backwards:");
        printerRec2(list1);

        System.out.println("-----------minus1Builder--------------");
        //System.out.println(minus1Builder()) ;

        System.out.println("------------printerZugi-----------------");
        printerZugi(list1);

        // בדיקת נוכחות מספר ברשימה (ex5)
        IntNode head = null; // רשימה ריקה לבדיקה
        System.out.print("Is 4 in the list? ");
        System.out.println(numInList(head, 4));

        System.out.print("Is 4 in the list (recursively)? ");
        System.out.println(numInListRec(head, 4));

        // הסרת המספר הראשון שמופיע ברשימה (ex6)
        System.out.print("List after removing first occurrence of 3: ");
        IntNode updatedList = removeFirst(list1, 3);
        printer(updatedList);

        // הסרת צומת במקום מסוים ברשימה (ex7)
        System.out.print("List after removing node at position 4: ");
        IntNode listAfterRemove = removeInNode(updatedList, 4);
        printer(listAfterRemove);

        // בדיקת האם כל המספרים ברשימה אחת קיימים בשנייה (ex8)
        System.out.print("All elements of L1 in L2? ");
        Node<Integer> node5 = new Node<>(5);
        Node<Integer> node4 = new Node<>(4, node5);
        Node<Integer> node3 = new Node<>(3, node4);
        Node<Integer> node2 = new Node<>(2, node3);
        Node<Integer> node1 = new Node<>(1, node2);  // L1


        Node<Integer> nodeA = new Node<>(1);
        Node<Integer> nodeB = new Node<>(2, nodeA);
        Node<Integer> nodeC = new Node<>(3, nodeB);
        Node<Integer> nodeD = new Node<>(4, nodeC);
        Node<Integer> nodeE = new Node<>(5, nodeD);  // L2

        System.out.print(TwoListsRec(node1,nodeE));
        System.out.println("\nCommon values:");
        printCommonValues(userList, L2);
       
        IntNode commonList = intersectLists(userList, L2);
        System.out.println("\nIntersection of L1 and L2:");
        printList(commonList);
        
        userList = removeAllInL2(userList, L2);
        System.out.println("\nAfter removing elements from L1 that are in L2:");
        printList(userList);
    }
        }

    public static IntNode arrToList(int[] arr) { //ex1
        IntNode head = new IntNode(arr[0]);
        IntNode prev = head;
        IntNode p;
        for (int i = 1; i < arr.length; i++) {
            p = new IntNode(arr[i]);
            prev.setNext(p);
            prev = p;
        }
        return head;
    }

    public static void printer(IntNode head) { //ex2

        while (head != null) {
            System.out.println(head.getValue());
            head = head.getNext();
        }
    }

    public static void printerRec(IntNode head) {
        if (head == null) {
            return;
        }

        System.out.println(head.getValue());
        head = head.getNext();

        printerRec(head);

    }

    public static void printerRec2(IntNode head) {
        if (head.getNext() == null) {
            System.out.println(head.getValue());
            return;
        }
        printerRec2(head.getNext());
        System.out.println(head.getValue());

    }

    public static IntNode minus1Builder() { //ex3
        System.out.println("enter numbers, -1 will finish");
        int value = reader.nextInt();
        IntNode head = new IntNode(value);
        IntNode p;
        IntNode prev = head;
        while ((value = reader.nextInt()) != -1) {
            p = new IntNode(value);
            prev.setNext(p);
            prev = p;

        }
        return head;
    }

    public static void printerZugi(IntNode head) {//ex4
        IntNode p = head;
        while (p != null) {
            if (p.getValue() % 2 == 0) {
                System.out.println(p.getValue());
            }
            p = p.getNext();
        }
    }



    public static boolean numInList(IntNode head, int num) { //ex5
        IntNode current = head;
        while(current != null) {
            if(current.getValue() == num) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }


    public static boolean numInListRec(IntNode head, int num) {
        if(head == null) {
            return false;
        }
        if(head.getValue() == num) {
            return true;
        }
        return numInListRec(head.getNext() , num);
    }

    public static IntNode removeFirst( IntNode head , int num){ //ex6
        if (head == null) {
            return null;
        }

        if (head.getValue() == num) {
            return head.getNext();  // מחזירים את הצומת הבאה אחרי הראש
        }

        IntNode current = head;
        while(current != null) {
            if(current.getNext().getValue() == num) {
                current.setNext(current.getNext().getNext()); // דילוג על הצומת עם המספר המבוקש
                return head;
            }
            current = current.getNext();
        }

        return head;
    }

    public static IntNode removeInNode(IntNode head , int x){ //ex7
        if (head == null) {
            return null;
        }

        if(x == 0) {
            return head.getNext();
        }

        IntNode current = head;

        for(int i = 0; i< x-1 ; i++) {
            if(current == null || current.getNext() == null) {
                return head;
            }
            current = current.getNext();
        }

        if (current.getNext() != null) {
            current.setNext(current.getNext().getNext());
        }

        return head;
    }

    public static boolean TwoListsRec(IntNode L1, IntNode L2) { //ex8

        if(L1 == null) {
            return true;
        }

        if(!numInList(L2, L1.getValue())) {
            return false;
        }

        return TwoListsRec(L1.getNext(), L2);

    }
    public class exe9 {
        public static boolean isIn(Node<Integer> head, int value) {
            while (head != null) {
                if (head.getValue() == value) {
                    return true;
                }
                head = head.getNext();
            }
            return false;
        }

        public static Node<Integer> exe10(Node<Integer> L1, Node<Integer> L2) {
            Node<Integer> dummy = new Node<>(-1);
            Node<Integer> current = dummy;

            while (L1 != null) {
                if (isIn(L2, L1.getValue())) {
                    current.setNext(new Node<>(L1.getValue()));
                    current = current.getNext();
                }
                L1 = L1.getNext();
            }

            return dummy.getNext();
        }

        public static Node<Integer> exe11(Node<Integer> L1, Node<Integer> L2) {
            Node<Integer> dummy = new Node<>(-1);
            dummy.setNext(L1);
            Node<Integer> num = dummy;

            while (num.getNext() != null) {
                if (isIn(L2, num.getNext().getValue())) {
                	num.setNext(num.getNext().getNext());
                } else {
                	num = num.getNext();
                }
            }

            return dummy.getNext();
        }
    }

}