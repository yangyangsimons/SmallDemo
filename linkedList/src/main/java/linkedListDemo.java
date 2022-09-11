public class linkedListDemo {
    public static void main(String[] args) {
//        create 4 HeroNodes for test;
        HeroNode hero1 = new HeroNode(1, "songjiang", "jishiyu");
        HeroNode hero2 = new HeroNode(2, "wuyong", "zhiduoxing");
        HeroNode hero3 = new HeroNode(3, "linchong", "baozitou");
        HeroNode hero4 = new HeroNode(4, "likui", "heixuanfeng");
        singleLinkedList list1 = new singleLinkedList();
//        list1.add(hero1);
//        list1.add(hero2);
//        list1.add(hero3);
//        list1.add(hero4);
//        list1.show();
//        list1.delete(2);
//        list1.show();

//        test the add by order function;
        list1.addByOrder(hero4);
        list1.addByOrder(hero2);
        list1.addByOrder(hero1);
        list1.addByOrder(hero3);
        list1.show();

    }
}

class singleLinkedList {
    public singleLinkedList() {
    }

    private HeroNode headNode = new HeroNode(0, "", "");

    public void add(HeroNode hn) {
//      Because headNode is fixed, so a temp node is needed to store the last node;
        HeroNode temp = headNode;
        while (true) {
            if (temp.next == null) {
                break;
            } else {
                temp = temp.next;
            }
        }
        temp.next = hn;
    }

    public void addByOrder(HeroNode hn) {
//        use a temp node to literate the whole loop;
        HeroNode temp = headNode;
        while (true) {
            if (temp.next == null) {
//          if temp get the last node in the list, then add the inserted node in the end;
                temp.next = hn;
                break;
            } else if (temp.next.num > hn.num) {
//              if the next node's number is bigger than the insert node, then add the insert node before this node;
                hn.next = temp.next;
                temp.next = hn;
                break;
            }else{
                temp = temp.next;
            }

        }
    }

    public void delete(int num) {
//      because this is a one way linked list, so find the node before the selected one;
        HeroNode temp = headNode;
        while (true) {
//            find the node before the to be deleted node;
            if (temp.next.num == num) {
//                 if the node to be deleted is the last node.
                if (temp.next.next == null) {
                    System.out.printf("the deleted node number is %d \n", temp.next.num);
                    temp.next = null;
                } else {
//                  if the node to be deleted is not the last node;
                    System.out.printf("the deleted node number is %d \n", temp.next.num);
                    temp.next = temp.next.next;
                }
                break;
            }
            if (temp.next == null) {
//          get the end of this list
                System.out.printf("Can't find this node %d in the list", num);
                break;
            }
            temp = temp.next;
        }
    }

    public void show() {
        if (headNode.next == null) {
            System.out.println("this list is empty.");
        } else {
            HeroNode temp = headNode;
            while (true) {
                if (temp.next == null) {
//                    temp is get the last node of this list,break loop;
                    break;
                } else {
                    temp = temp.next;
                    System.out.println(temp);
                }
            }
        }
    }
}
class HeroNode {
    int num;
    String name;
    String nickName;
    HeroNode next;

    public HeroNode(int num, String name, String nickName) {
        this.num = num;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "linkedList{" +
                "name='" + name + '\'' +
                ", number=" + num +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}