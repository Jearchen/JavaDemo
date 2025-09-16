package com.jeartech;

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

    public void recusiveWeight(){
        preRecusiveWithWeight(root);
    }
    //值比较的先序遍历
    private void preRecusiveWithWeight(Node root){
        if(root.weight!=0)
            System.out.print(root.weight+" ");
        if(root.leftChild!=null)
            preRecusiveWithWeight(root.leftChild);
        if(root.rightChild!=null)
            preRecusiveWithWeight(root.rightChild);
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
            if(firstData.value!=null&& firstData.value.equals("&")&&!container.isEmpty()){
                container.add(seperator);
                height++;
            }
        }
        return height;
    }

    private int getTreeHeightWithWeight(Node root){
        int height = 1 ;
        Node seperator = new Node();
        seperator.weight = -1;
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
            if(firstData.weight!=0&& firstData.weight==-1&&!container.isEmpty()){
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
    public void constructSortedTree(int target){
        Node treeCursor = new Node();
        treeCursor = root;
        while(treeCursor.leftChild!=null||treeCursor.rightChild!=null){
            if(target<treeCursor.weight){
                if(treeCursor.leftChild==null){
                    Node  newNode = new Node();
                    newNode.weight = target;
                    treeCursor.leftChild = newNode;
                    return;
                }
                treeCursor =treeCursor.leftChild;
            }
            if(target==treeCursor.weight){
                System.out.println("重复的元素，不需要添加。");
            }
            if(target>treeCursor.weight){
                if(treeCursor.rightChild==null){
                    Node newNode = new Node();
                    newNode.weight = target;
                    treeCursor.rightChild = newNode;
                    return;
                }
                treeCursor = treeCursor.rightChild;
            }
        } 
        if(treeCursor.weight>target){
            Node newNode = new Node();
            newNode.weight = target;
            treeCursor.leftChild = newNode;
        }
        if(treeCursor.weight<target){
            Node newNode = new Node();
            newNode.weight = target;
            treeCursor.rightChild = newNode;
        }
    }

    //代码复用前一个函数,非递归查找,有两个出口,递归的话只有一个出口.
    public void findNodeInSortedTree(int target ){
        Node treeCursor = new Node();
        treeCursor = root;
        while(treeCursor.leftChild!=null||treeCursor.rightChild!=null){
            if(target<treeCursor.weight){
                treeCursor =treeCursor.leftChild;
            }
            if(target==treeCursor.weight){
                System.out.println("1已找到元素");
                return;
            }
            if(target>treeCursor.weight){
                treeCursor = treeCursor.rightChild;
            }
        }
        if(treeCursor.weight==target){
            System.out.println("2已找到元素");
            return;
        }
        //比较到叶子节点也还没有,就是没有该节点了.
        System.out.println("不存在的元素,请检查输入");
    }

    //先查找,后删除,代码复用前一个函数,非根节点删完提左子树的最大值或者右子树的最小值作为根节点都可
    //关于这个删除的说明，我觉得pdai的说明不够简洁，可以查阅b站青空の霞光数据结构关于这一节的解释。我是按照这个思路实现的。
    public void deleteSortedNode(int target){
        //栈用来存先序节点，栈顶即为递归的父节点
        Stack<Node> data= new Stack<>();
        realDeleteNode1(data,root,target); 
    }

    private void realDeleteNode1(Stack<Node> stack,Node cursor,int target){
        Stack<Node> container = new Stack<>();
        while(cursor.leftChild!=null || cursor.rightChild!=null||cursor.weight==target){
            if(target<cursor.weight){
                container.push(cursor);
                cursor =cursor.leftChild;
            }
            if(target==cursor.weight){
                System.out.println("找到元素");
                //执行删除
                realDeleteNode(container,cursor,target);
                return;
            }
            if(target>cursor.weight){
                container.push(cursor);
                cursor = cursor.rightChild;
            }
        }
    }

    private void realDeleteNode(Stack<Node> stack,Node cursor,int target){
        Node temp = new Node(); 
        if(cursor.leftChild==null&&cursor.rightChild==null){
            Node father = stack.pop();
            if(father.leftChild!=null&&father.leftChild==cursor){
                    father.leftChild=null;
            }
            if(father.rightChild!=null&&father.rightChild==cursor){
                    father.rightChild=null;
            }
            return;
        }
            //非叶子节点.有左子树提升左边最大值,有右子树提升右边最小值
        if(cursor.leftChild!=null){
            //用temp去遍历子树,curosr用来保存根节点
            temp = cursor.leftChild;
            //遍历到的时候,使用cursorparent保存父节点
            while(temp.rightChild!=null){
                stack.push(temp);
                temp= temp.rightChild;
            }
            //有该节点有左子树,提升左子树为父节点右子树,
            if(temp.leftChild!=null){
                if(temp==cursor.leftChild){
                    cursor.leftChild= temp.leftChild;
                }else{
                    Node cursorparent = stack.pop();
                    cursorparent.rightChild=temp.leftChild;
                }
            }else{
                if(temp==cursor.leftChild){
                    //没有子结点.将父节点的子结点值为空即可
                    cursor.leftChild =null;
                }else{
                    Node cursorparent = stack.pop();
                    cursorparent.rightChild=null;
                }
            }
            //更新被删除顶点.
            cursor.weight =temp.weight;
            return ;
        }   
        if(cursor.rightChild!=null){
            //用temp去遍历子树,curosr用来保存根节点
            temp = cursor.rightChild;
            //遍历到的时候,使用cursorparent保存父节点
            while(temp.leftChild!=null){
                stack.push(temp);
                temp= temp.leftChild;
            }
            //子节点有右子树,提升右子树为父节点左子树,
            if(temp.rightChild!=null){
                if(temp==cursor.leftChild){
                    cursor.rightChild=temp.rightChild;
                }else{
                    Node cursorparent = stack.pop();
                    cursorparent.leftChild = temp.rightChild;
                }
            }else{
                if(temp==cursor.leftChild){
                    //没有子结点.将父节点的子结点值为空即可
                    cursor.rightChild =null;
                }else{
                    Node cursorparent = stack.pop();
                    //没有子结点.将父节点的子结点值为空即可
                    cursorparent.leftChild =null;
                }
            }
            //更新被删除节点
            cursor.weight = temp.weight;
            //返回最小值节点.
            return ;
        }
        return ;
    }

    //构造平衡二叉树AVL，直接复用二叉排序树代码。
    //关于树的高度。可以使用层序遍历获取。
    public void constructAVLtree(int target){
        Stack<Node> container = new Stack<>();
        Node cursor = new Node();
        cursor = root;
        //单根节点直接返回
        if(root.weight==0){
            root.weight=target;
            return;
        }
        //插入非叶子节点。
        while(cursor.leftChild!=null||cursor.rightChild!=null){
            if(target<cursor.weight){
                if(cursor.leftChild==null){
                    Node  newNode = new Node();
                    newNode.weight = target;
                    cursor.leftChild = newNode;
                    checkBanlance(container,root);
                    return;
                }
                cursor =cursor.leftChild;
            }
            if(target==cursor.weight){
                System.out.println("重复的元素，不需要添加。");
                return;
            }
            if(target>cursor.weight){
                if(cursor.rightChild==null){
                    Node newNode = new Node();
                    newNode.weight = target;
                    cursor.rightChild = newNode;
                    checkBanlance(container,root);
                    return;
                }
                cursor = cursor.rightChild;
            }
        } 
        if(cursor.weight>target){
            Node newNode = new Node();
            newNode.weight = target;
            cursor.leftChild = newNode;
        }
        if(cursor.weight<target){
            Node newNode = new Node();
            newNode.weight = target;
            cursor.rightChild = newNode;
        }
        checkBanlance(container,root);
    }
    

    private void checkBanlance(Stack<Node>stack, Node cursor){
        //失衡，则调整
        //找到失衡的最小树的根节点。进行调整
        int leftHeight = cursor.leftChild==null?0:getTreeHeightWithWeight(cursor.leftChild);
        int rightHeight = cursor.rightChild==null?0:getTreeHeightWithWeight(cursor.rightChild);
        if(Math.abs(leftHeight-rightHeight)>1){
            Node fatherNode =new Node();
            if(cursor!=root){
                fatherNode = stack.pop();
            }
            ajustTreeNode(fatherNode,cursor);
        }
        if(cursor.leftChild!=null){
            stack.push(cursor);
            cursor=cursor.leftChild;
            checkBanlance(stack,cursor);
        }
        if(cursor.rightChild!=null){
            stack.push(cursor);
            cursor=cursor.rightChild;
            checkBanlance(stack,cursor);
        }
    }

    //旋转节点
    private void ajustTreeNode(Node fatherNode,Node minroot){
        int leftHeight = getTreeHeightWithWeight(minroot.leftChild);
        int rightChild = getTreeHeightWithWeight(minroot.rightChild);
        if(rightChild==1&&leftHeight==3){
            Node cursor = minroot.leftChild;
            if((cursor.leftChild!=null)&&
                ((cursor.leftChild.leftChild!=null)||
                    (cursor.leftChild.rightChild!=null))){
                //LL型
                if(fatherNode.weight==0){
                    fatherNode.leftChild =cursor;
                }
                else if(fatherNode.leftChild!=null&& fatherNode.leftChild.weight==minroot.weight){
                    fatherNode.leftChild= cursor;
                }
                else if(fatherNode.rightChild!=null&&fatherNode.rightChild.weight==minroot.weight){
                    fatherNode.rightChild =cursor;
                }
                else{
                    System.out.println("unknown type");
                }
                if(cursor.rightChild!=null){
                    minroot.leftChild=cursor.rightChild;
                }else{
                    minroot.leftChild=null;
                }
                cursor.rightChild = minroot;
                if(fatherNode.weight==0){
                    //根节点的fatherNode需要调回
                    root = fatherNode.leftChild;
                }
                return;
            }
            if((cursor.rightChild!=null)&&
                ((cursor.rightChild.leftChild!=null)||
                    (cursor.rightChild.rightChild!=null))){
                //LR型
                //调整成LL型。
                minroot.leftChild= cursor.rightChild;
                Node leftPad= minroot.leftChild.leftChild;
                cursor.rightChild =leftPad==null?null:leftPad;
                minroot.leftChild.leftChild=cursor;
                
                //更新一下cursor;把LL抄过来
                cursor = minroot.leftChild;

                if(fatherNode.weight==0){
                    fatherNode.leftChild= cursor;
                }
                else if(fatherNode.leftChild!=null&& fatherNode.leftChild.weight==minroot.weight){
                    fatherNode.leftChild= cursor;
                }
                else if(fatherNode.rightChild!=null&&fatherNode.rightChild.weight==minroot.weight){
                    fatherNode.rightChild =cursor;
                }
                else{
                    System.out.println("unknown type");
                }
                if(cursor.rightChild!=null){
                    minroot.leftChild=cursor.rightChild;
                }else{
                    minroot.leftChild =null;
                }
                cursor.rightChild = minroot;
                if(fatherNode.weight==0){
                    //根节点的fatherNode需要调回
                    root = fatherNode.leftChild;
                }
                return;
            }
        }
        if(leftHeight==1&&rightChild==3){
            Node cursor = minroot.rightChild;
            if((cursor.rightChild!=null)&&
                ((cursor.rightChild.leftChild!=null)||
                (cursor.rightChild.rightChild!=null))){
                if(fatherNode.weight==0){
                    fatherNode.rightChild =cursor;
                }
                else if(fatherNode.leftChild!=null&& fatherNode.leftChild.weight==minroot.weight){
                    fatherNode.leftChild= cursor;
                }
                else if(fatherNode.rightChild!=null&&fatherNode.rightChild.weight==minroot.weight){
                    fatherNode.rightChild =cursor;
                }
                else{
                    System.out.println("unknown type");
                }
                if(cursor.leftChild!=null){
                    minroot.rightChild=cursor.leftChild;
                }else{
                    minroot.rightChild =null;
                }
                cursor.leftChild = minroot;
                if(fatherNode.weight==0){
                    //根节点的fatherNode需要调回
                    root = fatherNode.rightChild;
                }
                return;
            }
            if((cursor.leftChild!=null)&&
                ((cursor.leftChild.leftChild!=null)||
                (cursor.leftChild.rightChild!=null))){
                //RL型
                //先调整成RR型
                minroot.rightChild= cursor.leftChild;
                Node rightPad= minroot.rightChild.rightChild;
                cursor.leftChild =rightPad==null?null:rightPad;
                minroot.rightChild.rightChild=cursor;

                //更新cursor
                cursor = minroot.rightChild;
                
                if(fatherNode.weight==0){
                    fatherNode.rightChild =cursor;
                }
                else if(fatherNode.leftChild!=null&& fatherNode.leftChild.weight==minroot.weight){
                    fatherNode.leftChild= cursor;
                }
                else if(fatherNode.rightChild!=null&&fatherNode.rightChild.weight==minroot.weight){
                    fatherNode.rightChild =cursor;
                }
                else{
                    System.out.println("unknown type");
                }
                if(cursor.leftChild!=null){
                    minroot.rightChild=cursor.leftChild;
                }else{
                    minroot.rightChild =null;
                }
                cursor.leftChild = minroot;
                if(fatherNode.weight==0){
                    //根节点的fatherNode需要调回
                    root = fatherNode.rightChild;
                }
                return;
            }
        }
    }
    //删除之后需要平衡.
    public void deleteAVLNode(int target){
        //先删除
        deleteSortedNode(target);
        //检查+调整
        Stack<Node> container = new Stack<>();
        checkBanlance(container,root);
    }

    //todo:并查集实现  

    //todo:hashcode函数生成

    //图

    

}
