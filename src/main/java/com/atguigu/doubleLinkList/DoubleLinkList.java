package com.atguigu.doubleLinkList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author shkstart
 * @create 2021-11-16 21:20
 */
public class DoubleLinkList {




}

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
class HeadNode {

    private int no;
    private String name;
    private String nickName;
    public HeadNode next;
    public HeadNode pre;


}