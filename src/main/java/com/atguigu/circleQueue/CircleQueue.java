package com.atguigu.circleQueue;

/**
 * @author shkstart
 * @create 2021-11-15 17:35
 */
public class CircleQueue {

    private int[] circleQueue;
    private int maxSize;
    private int front;
    private int rear;
    public CircleQueue(int maxSize)
    {
        this.maxSize = maxSize;
        circleQueue = new int[maxSize];
    }

    public void addElement(int element)
    {
        //判断数组是否已经满了
        if(isFull())
        {
            System.out.println("数组已经满了，不要再添加了！！！");
            return;
        }
        circleQueue[rear] = element;
        rear = (rear+1)%maxSize;
    }
    //删除元素
    public int getElement()
    {
        if(isEmpty())
        {
            throw new RuntimeException("没有数据了，不要再读了");
        }
        int value = circleQueue[front];
        front=(front+1)%maxSize;
        return value;

    }
    //遍历数组
    public void listCircleQueue()
    {
        for(int i = front;i<front+getRealLength();i++)
        {
            System.out.printf("circleQueue[%d]=%d\n",i%maxSize,circleQueue[i%maxSize]);
        }
    }
    //look at element from forward
    public int getForwardElement()
    {
        return circleQueue[front];
    }
    public boolean isFull()
    {
        return (rear+1)%maxSize==front;
    }
    public boolean isEmpty()
    {
        return rear==front;
    }
    public int getRealLength()
    {
        return (rear-front+maxSize)%maxSize;
    }
}
