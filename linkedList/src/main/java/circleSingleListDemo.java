public class circleSingleListDemo {
//Josephus problem:
//People are standing in a circle waiting to be executed. Counting begins at a specified point in the circle and
// proceeds around the circle in a specified direction. After a specified number of people are skipped,
// the next person is executed. The procedure is repeated with the remaining people, starting with the next person,
// going in the same direction and skipping the same number of people, until only one person remains, and is freed.
//The problem—given the number of people, starting point, direction, and number to be skipped—is to choose the
// position in the initial circle to avoid execution.
    public static void main(String[] args) {
        circleSingleList list2 = new circleSingleList();
        list2.addWhole(5);
        list2.show();
        list2.standOut(1,2);
    }

}

class circleSingleList {
    public circleSingleList(){}
//    create the first node but no default data in it;
    singleList first = null;
    public void addWhole(int number){
//        create a temp node as an iterator;
        singleList temp = null;
        for(int i = 0; i < number; i ++){
            singleList node = new singleList(i);
            if(i == 0){
                first = node;
                first.setNext(first);
                temp = first;
            }else{
                temp.setNext(node);
                node.setNext(first);
                temp = node;
            }
        }
    }

//    create a show function to show the whole list;
    public void show(){
        singleList temp = first;
        while(true){
            System.out.println(temp);
            if(temp.getNext() == first){
                break;
            }else{
                temp = temp.getNext();
            }
        }
    }

//  startNo represent the start node;
//  count represent the move pace (number); current node count as 1 and the next node as 2 ...
    public void standOut(int startNo, int count){
//        use the cur node to contain the current node and the temp node as a counter(temp node is the node before the current node)
        singleList cur = first;

//        move the temp node to the last node(before the current node)
        singleList temp = first;
        while(true){
            if(temp.getNext() == first){
                break;
            }else{
                temp = temp.getNext();
            }
        }
        System.out.printf("the temp node is %d \n", temp.getNum());

//       move the cur and temp to the start place;
        for (int i = 0; i < startNo - 1; i++) {
            cur = cur.getNext();
            temp = temp.getNext();
        }
        System.out.printf("the start node is %d \n", cur.getNum());

        while(true){
            if(cur == temp){
                break;
            }else{
//        move the cur and temp count - 1 times;
                for (int i = 0; i < count - 1; i++) {
                    cur = cur.getNext();
                    temp = temp.getNext();
                    System.out.printf("the stand out node is %d \n", cur.getNum());
//      delete the stand-out node by set the temp.next to the current.next;
                    temp.setNext(cur.getNext());
                    cur = cur.getNext();
                }
            }
        }
        System.out.printf("the last stand out node is %d \n", temp.getNum());

    }

}

class singleList {
    private int num; //default 0;
    private singleList next; //default null;

    public singleList(int num) {
        this.num = num;
    }
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public singleList getNext() {
        return next;
    }

    public void setNext(singleList next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "singleList{" +
                "num=" + num +
                '}';
    }
}