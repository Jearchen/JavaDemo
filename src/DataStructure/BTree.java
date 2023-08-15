package com.jearchen.ds.Base;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;






public class BTree {
    
    //Node节点定义
    private class Node{
        //左孩子
        private Node leftChild;
        //右孩子
        private Node rightChild;
        //节点值
        String value;
        //访问标识
        boolean visited =false;
        //是否根节点标识
        Boolean root =Boolean.FALSE;

        //haffman树的节点值
        int weight;

        //树，二叉树转化用得到
        Node[] childs;

        public void setValue(String value){
            this.value = value;
        }

        public void setRoot(Boolean flag){
            this.root=flag;
        }

        public String getValue(){
            return this.value;
        }
        
        public Boolean checkIfRoot(){
            return root;
        }

        public void setVisit(boolean flag){
            this.visited = flag;
        }

        public boolean getVisit(){
            return this.visited;
        }



    }
    //声明一个根节点
    private Node root = new Node();

    //链表实现二叉树
    //初始化二叉树
    /*
     *                          root(a)
     *                     |                |
     *                     b               c
     *                  |      |        |      |
     *                  d      e        f    null
     *              |   |   |    |     |  |
     *           null null null null null null
     */
    public void initTree(){
        root.setValue("a");
        root.setRoot(Boolean.TRUE);

        Node b = new Node();
        b.setValue("b");

        Node c = new Node();
        c.setValue("c");

        Node d = new Node();
        d.setValue("d");

        Node e = new Node();
        e.setValue("e");

        Node f = new Node();
        f.setValue("f");

        Node g = new Node();
        g.setValue("g");

        Node h = new Node();
        h.setValue("h");

        Node i = new Node();
        i.setValue("i");

        root.leftChild=b;
        root.rightChild=c;
        b.leftChild=d;
        b.rightChild=e;
        c.leftChild=f;
        c.rightChild=g;

        d.leftChild=null;
        d.rightChild=i;
        e.leftChild =null;
        e.rightChild =null;
        f.leftChild=null;
        f.rightChild=null;
        // root.leftChild =b;
        // root.rightChild =null;
        // b.leftChild = e;
        // b.rightChild = c;
        // e.leftChild=null;
        // e.rightChild=f;
        // c.leftChild=g;
        // c.rightChild=d;
        // d.leftChild=h;
        // d.rightChild=null;
        // h.leftChild=null;
        // h.rightChild=i;
        // i.leftChild=null;
        // i.rightChild=null;
    }

    //选择二叉树对应的功能
    public void recursive(String type){
        switch(type){
            case "pre" : preRecusive(this.root);break;
            case "post" : postRecusive(this.root); break;
            case "mid" : midRecusive(this.root); break;
            case "lawer" : lawerRecusive(this.root); break;
            case "poststackrec" : postStackRecursive(this.root); break;
            case "findNode" : {
                initTree();
                findNode(this.root,"c");
            } break;
            case "height" : {
                int height = getTreeHeight(this.root);
                System.out.println(height);
            };break;
            default: midRecusive(this.root);break;
        }
    }

    //二叉树的先序遍历
    private void preRecusive(Node root){
        if(root.value!=null)
            System.out.print(root.value+" ");
        if(root.leftChild!=null)
            preRecusive(root.leftChild);
        if(root.rightChild!=null)
            preRecusive(root.rightChild);
    }

    /*
     *
     * 使用栈非递归实现二叉树后序遍历,第一次实现进栈顺序是倒序的后序遍历，改成中右左，即为正序的后序遍历
     * 
     */
    private void postStackRecursive(Node root){
        Node temp = new Node();
        Stack<Node> container = new Stack<>();
        container.add(root);
        while(!container.isEmpty()){
            temp = container.peek();
            if(temp.rightChild!=null&&temp.rightChild.visited==false){
                container.push(temp.rightChild);
            }

            if(temp.leftChild!=null&&temp.leftChild.visited==false){
                container.push(temp.leftChild);
            }
            
            if(temp.leftChild==null&&temp.rightChild==null&&temp.visited==false){
                Node pop = container.pop();
                System.out.println(pop.value);
                pop.visited =true;
            }
            if((temp.leftChild!=null&&temp.leftChild.visited==true)||(temp.rightChild!=null&&temp.rightChild.visited==true)){
                Node pop = container.pop();
                System.out.println(pop.value);
                pop.visited =true;
            }
        }   
    }

    //二叉树的中序遍历
    public void midRecusive(Node root){
        if(root.leftChild!=null)
            midRecusive(root.leftChild);
        if(root.value!=null)
            System.out.print(root.value+" ");
        if(root.rightChild!=null)
            midRecusive(root.rightChild);
    }

    //二叉树的后序遍历
    public void postRecusive(Node root){
        if(root.leftChild!=null)
            postRecusive(root.leftChild);
        if(root.rightChild!=null)
            postRecusive(root.rightChild);
        if(root.value!=null)
            System.out.print(root.value+" ");
    }

    //二叉树的层序遍历,层序遍历参考了这篇文章https://www.cnblogs.com/bigsai/p/11393609.html
    public void lawerRecusive(Node root){
        Queue<Node> container = new ArrayDeque<>();
        container.add(root);
        while(!container.isEmpty()){
            Node firstData = container.poll();
                //检查一遍队列是否有子孩子，有则入队
                if(firstData.leftChild!=null){
                    Node leftChild = firstData.leftChild;
                    container.add(leftChild);
                }
                if(firstData.rightChild!=null){
                    Node rightChild = firstData.rightChild;
                    container.add(rightChild);
                }
                System.out.println(firstData.value);
        }
    }

    //层序遍历求二叉树的高度
    private int getTreeHeight(Node root){
        int height = 1 ;
        Node seperator = new Node();
        seperator.value = "&";
        Queue<Node> container= new ArrayDeque<>();
        container.add(root);
        container.add(seperator);
        while(!container.isEmpty()){
            Node firstData = container.poll();
            if(firstData.leftChild!=null){
                container.add(firstData.leftChild);
            }
            if(firstData.rightChild!=null){ 
                container.add(firstData.rightChild);
            }
            if(firstData.value.equals("&")&&!container.isEmpty()){
                container.add(seperator);
                height++;
            }
        }
        return height;
    }

    Node temp = new Node();
    //先序遍历查找二叉树的子节点,因为是字符串，不存在最大值，最小值之类的。
    public void findNode(Node root,String target){
        if(root.value.equals(target)){
            System.out.println(root.value);
            temp=root;
        }
        if(root.leftChild!=null){
            findNode(root.leftChild, target);
        }
        if(root.rightChild!=null){
            findNode(root.rightChild,target);
        }
    }



    //先序遍历删除节点，有三种情况，需要分情况删除,参考图片https://pdai.tech/md/algorithm/alg-basic-tree-search.html#%E5%88%A0%E9%99%A4
    public void deleteNode(Node root,String target){
        
    }

    //
    // 借用Node的rightChild模拟头插法实现单向链表
    // null ----- a ----- b ----- c ----- d ----- e ----- f
    //
    Node linkRoot= new Node();
    public void initLinkNode(){
        Node head = new Node();
        head.value="-1";

        Node a = new Node();
        a.value="a";

        Node b = new Node();
        b.value="b";

        Node c = new Node();
        c.value="c";

        Node d = new Node();
        d.value="d";

        Node e = new Node();
        e.value="e";

        Node f = new Node();
        f.value="f";


        head.rightChild = a;
        a.rightChild = b;
        b.rightChild = c;
        c.rightChild = d;
        e.rightChild = e;
        e.rightChild = f;
        f.rightChild = null;
        linkRoot = head;
    }
    
    //头插法插入单向链表
    public void insertHeadNode(Node insertNode){
        if(linkRoot==null){
            System.out.println("please init linkdata");
        }
        if(linkRoot.value !="-1"){
            System.out.println("invalid link head");
        }
        Node cursor = new Node();
        cursor = linkRoot.rightChild;
        linkRoot.rightChild = insertNode;
        insertNode.rightChild = cursor;
    }

    //尾插法插入单向链表
    public void insertlinknode(Node insertNode){
        Node cursor = new Node();
        cursor = linkRoot;
        while(cursor.rightChild!=null){
            cursor = cursor.rightChild;
        }
        insertNode.rightChild = null;
        cursor.rightChild =insertNode;
    }

    //遍历打印链表节点
    public void recurseLinkNode(){
        Node cursor = new Node();
        cursor = linkRoot;
        if(linkRoot==null){
            System.out.println("empty link,pelease init linkData");
        }
        while(cursor.rightChild!=null){
            System.out.println(cursor.value);
        }
    }

    //查找指定节点
    public void findLinkNode(String target){
        Node cursor = new Node();
        cursor = linkRoot;
        //排除头节点
        if(cursor.value==target){
            cursor=cursor.rightChild;
        }
        while(cursor.rightChild!=null){
            if(target==cursor.value){
                System.out.println("find it ,next Node is "+cursor.rightChild.value);
                return;
            }
        }
        System.out.println("can't find this node");
    }

    //链表求长度
    public int getLinkLength(){
        int length =0;
        Node cursor = new Node();
        cursor = linkRoot;
        cursor = cursor.rightChild;
        while(cursor.rightChild!=null){
            length++;
            cursor = cursor.rightChild;
        }
        return length;
    }

    

    //链表删除节点,需要保存目标的前置节点信息。这里可以借助leftChild存储前置节点，头节点存储值“-1”
    public void deleteLinkData(Node target){
        Node cursor = new Node();
        cursor = linkRoot;
        if(target.value=="-1"){
            cursor.leftChild = cursor;
            cursor= cursor.rightChild;
        }
        while(cursor.rightChild!=null){
            if(target.value==cursor.value){
                cursor.leftChild.rightChild = cursor.rightChild;
                return;
            }
            cursor.leftChild = cursor;
            cursor = cursor.rightChild;
        }
        if(cursor.value == target.value){
            cursor.leftChild.rightChild =null;
        }
    }

    //不借助leftChild存储前置节点，使用双指针，道理一样
    public void doubleLinkData(Node target){
        Node cursor1 = new Node();
        Node cursor2 = new Node();
        cursor1 = linkRoot;
        cursor2 = linkRoot.rightChild;
        //无节点直接返回
        if(cursor2==null){
            System.out.println("empty link Node!");
            return;
        }
        //单个节点若相同直接删除，若不同报错。
        if(cursor2.rightChild ==null){
            if(cursor2.value==target.value){
                cursor1.rightChild=null;
                return;
            }
            System.out.println("not exsit Node");
        }
        while(cursor2.rightChild!=null){
            if(cursor2.value==target.value){
                cursor1.rightChild = cursor2.rightChild;
            }
            
            cursor1 =cursor1.rightChild;
            cursor2 =cursor2.rightChild;
        }
        if(cursor2.value == target.value){
            cursor1.rightChild =null;
        }
    }

    //单链表去重,链表左边去过重，右边待比较节点。
    public void distinctLinkNode(){
        Node cursor = new Node();
        Node cursor1 = new Node();
        cursor1.leftChild = linkRoot;
        cursor = linkRoot.rightChild;
        Vector<Node> container = new Vector<>();
        while(cursor.rightChild!=null){
            if(container.contains(cursor)){
                cursor1.rightChild = cursor.rightChild;
            }
            cursor1 = cursor1.rightChild;
            cursor =cursor.rightChild;
        }
        if(container.contains(cursor)){
            cursor1.rightChild = null;
        }
    }


    
    public void initMultipleTree(){
        Node a = new Node();
        a.value = "a";

        Node b = new Node();
        b.value = "b";

        Node c = new Node();
        c.value = "c";

        Node d = new Node();
        d.value = "d";

        Node e = new Node();
        e.value = "e";


        Node f = new Node();
        f.value = "f";

        Node g = new Node();
        g.value = "g";

        Node h = new Node();
        h.value = "h";

        Node i = new Node();
        i.value = "i";

        Node j = new Node();
        j.value = "j";

        a.childs=new Node[]{b,c,d};

        b.childs= new Node[]{e,f};

        c.childs = new Node[]{g};

        d.childs = new Node[]{h,i,j};

        root =a;
    }

    //树转成二叉树，
    //首先，转换前后节点意义发生改变。左右子结点自动改变成孩子节点和兄弟节点。
    //然后，树本身的子结点比较多，这里使用数组代替。        
    //              a
    //         |    |    |
    //         b    c    d
    //     |   |    |   |  |  |
    //     e   f    g   h  i  j
    public void  transformTreeToBtree(){
        Node cursor = new Node();
        Queue<Node> container = new ArrayDeque<>();
        container.add(root);
        while(!container.isEmpty()){
            Node first = container.poll();
            cursor =first;
            if(first.childs==null){
                return;
            }
            //单个子结点的要单独处理
            if(first.childs.length==1){
                cursor.leftChild = first.childs[0];
                continue;
            }
            cursor.leftChild= first.childs[0];
            Node cursor2 = new Node();
            cursor2 = cursor.childs[0];
            for(int i =0;i<cursor.childs.length;i++){
                if(cursor.childs[i].childs!=null){
                    container.add(cursor.childs[i]);
                }
                cursor2.rightChild =cursor.childs[i];
                cursor2 = cursor2.rightChild;
            }
        }
        //打印一下节点
        preRecusive(root);
    }

    //二叉树转成树将所有右子节点当成兄弟，然后将其挂到最左端的父节点中，直到同层的没有右节点为止。
    //这个过程并不是唯一的。二叉树本来就是树的一种。将度为2改成任意度并无标准，按上面改，最后会只剩下左子树。
    //并且根节点的度会变得很大。
    public void transforBtreeToMultiple(){

    } 

    //todo:森林转换成二叉树

    //todo:二叉树转换成森林

    //树的遍历只有先序和后序遍历两种


    //todo:森林的遍历


    //todo:红黑树,TreeMap中有对应实现。

    
    //todo: 最小堆构造huffman树，首先每个节点都是带有权值的。所有节点都是叶子节点，满足WPL最小
    public void Huffman(int[] weightArr){

    }

    //二叉排序树,这种树就是左边小，右边大。非要分个大小真是有点不爽。只能用int型数据。
    //如果对Object类型数据，可以比较hash值试试。这个树的特点就是方便查找节点。
    //这里使用huffman的整形节点存储元素值
    public void constructTree(int target){
        Node cursor = new Node();
        cursor = root;
        while(target<cursor.weight){
            if(cursor.leftChild==null){
                Node  newNode = new Node();
                newNode.weight = target;
                cursor.leftChild = newNode;
            }
            cursor =cursor.leftChild;
        }
        if(target==cursor.weight){
            System.out.println("重复的元素，不需要添加。");
        }
        while(target>cursor.weight){
            if(cursor.rightChild==null){
                Node newNode = new Node();
                newNode.weight = target;
                cursor.rightChild = newNode;
            }
            cursor = cursor.rightChild;
        }
    }

    //平衡二叉树AVL
    //删除

    //todo:并查集实现  

    //todo:hashcode函数生成

    //图

    

}
