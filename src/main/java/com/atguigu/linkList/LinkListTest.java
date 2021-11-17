package com.atguigu.linkList;

import com.atguigu.linkList.HeadNode;
import com.atguigu.linkList.LinkList;
import org.junit.Test;

/**
 * @author shkstart
 * @create 2021-11-16 12:41
 */
public class LinkListTest {
    @Test
    public void test01()
    {
        LinkList linkList = new LinkList();
        HeadNode hero1 = new HeadNode(1, "宋江", "及时雨");
        HeadNode hero2 = new HeadNode(2, "卢俊义", "玉麒麟");
        HeadNode hero3 = new HeadNode(3, "吴用", "智多星");
        HeadNode hero4 = new HeadNode(4, "林冲", "豹子头");
        linkList.add(hero1);
        linkList.add(hero2);
        linkList.add(hero3);
        linkList.add(hero4);

        linkList.showLinkList();
        linkList.reverseLinkList();
        int nodeNum = linkList.getNodeNum();
        System.out.println(nodeNum);
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$");
        linkList.showLinkList();
        HeadNode nodeByNumberFromBack = linkList.getNodeByNumberFromBack(10);
        System.out.println(nodeByNumberFromBack);

        linkList.reverseListPrint();

    }
}
