package com.atguigu.linkList;

import sun.awt.windows.ThemeReader;

import java.util.Stack;

/**
 * @author shkstart
 * @create 2021-11-15 17:37
 */
public class LinkList {

    private HeadNode headNode = new HeadNode(0,"","");


    public HeadNode getHeadNode()
    {
        return  headNode;
    }
    public void add(HeadNode headNode1)
    {
        HeadNode temp = headNode;
        while(true)
        {

            if(temp.next==null)
            {
                break;
            }
            temp = temp.next;

        }
        temp.next=headNode1;

    }


    /**
     *
     *
     * @param num
     * @return
     */

    public HeadNode getNodeByNumberFromBack(int num)
    {
        int nodeNum = getNodeNum();
        HeadNode temp = headNode.next;
        if(temp==null||num<0||num>nodeNum)
        {
            return null;
        }

        int index = nodeNum - num;
        while((index--)!=0)
        {

            temp = temp.next;
        }
        return temp;


    }
    public void addOrder(HeadNode headNode1)
    {
        HeadNode temp = headNode;
        boolean flag = false;
        while(true)
        {

            if(temp.next==null)
            {
                break;
            }
            if(temp.next.getNo() > headNode1.getNo())
            {
                break;
            }
            else if(temp.next.getNo() == headNode1.getNo())
            {
                flag=true;
                break;
            }



            temp = temp.next;

        }



        if(!flag)
        {
            headNode1.next = temp.next;
            temp.next = headNode1;

        }
        else{
            System.out.println("添加英雄编号已经存在！！！");

        }



    }

    /**
     * 计算链表中有效节点的个数
     *
     */
    public int getNodeNum()
    {
        if(headNode.next==null)
        {
            return 0;
        }
        HeadNode temp = headNode.next;

        int count = 0;
        while(temp!=null)
        {
            count++;
            temp=temp.next;

        }
        return count;
    }
    public void showLinkList()
    {
        if(headNode.next==null)
        {

            System.out.println("链表为空！！");
            return;

        }
        HeadNode temp = headNode;
        while(true)
        {
            if(temp==null)
            {
                System.out.println("空了");
                break;
            }
            System.out.println(temp);
            temp=temp.next;

        }

    }
    public void update(HeadNode headNode1)
    {
        HeadNode temp = this.headNode;
        boolean flag = false;
        while(true)
        {
            if(temp ==null)
            {
                break;
            }
            if(temp.getNo()==headNode1.getNo())
            {
                flag= true;
                break;
            }



            temp = temp.next;
        }

        if(flag)
        {
            temp.setName(headNode1.getName());
            temp.setNickName(headNode1.getNickName());
        }
        else
        {
            System.out.println("没找到！！！");
        }

    }
    public void deleteNode(int no)
    {
        HeadNode temp;
        temp = this.headNode;
        boolean flag1 = false;
        while(true)
        {
            if(temp.next==null)
            {
                break;
            }
            if(temp.next.getNo()==no)
            {
                flag1 = true;
                break;
            }

            temp = temp.next;
        }
        if(!flag1)
        {
            System.out.println("没找到！！");
        }
        else{

            temp.next= temp.next.next;
        }
    }

    public void reverseLinkList()
    {
        HeadNode reverseLinkListNode = new HeadNode(0,"","");
        HeadNode headNodeNext;
        HeadNode currentNext;
        HeadNode currentNode = headNode.next;
        if(currentNode==null)
        {
            return;
        }
        while(currentNode!=null)
        {
            headNodeNext = reverseLinkListNode.next;
            currentNext= currentNode.next;
            reverseLinkListNode.next = currentNode;
            currentNode.next = headNodeNext;

            currentNode=currentNext;

        }
        headNode.next =  reverseLinkListNode.next;

    }

    public void reverseListPrint()
    {

        HeadNode current = headNode.next;
        Stack<HeadNode> stack = new Stack<>();


        //将链表中所有数据存入栈中
        while(current!=null)
        {
            stack.push(current);
            current=current.next;

        }
        while(stack.size() > 0)
        {

            System.out.println(stack.pop());
        }


    }
}
class HeadNode {

    private int no;
    private String name;
    private String nickName;
    public HeadNode next;

    public HeadNode() {
    }
    public HeadNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }
    public HeadNode(int no, String name, String nickName, HeadNode next) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
        this.next = next;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public HeadNode getNext() {
        return next;
    }

    public void setNext(HeadNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "HeadNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}