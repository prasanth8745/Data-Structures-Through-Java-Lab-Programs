Write a Java program to implement Doubly Linked List. 
    
Aim:To Write a Java program to implement Doubly Linked List. 
    
Description:

Doubly linked list  is a type of linked list in which each node apart from storing its data has two links.
The first link points to the previous node in the list and the second link points to the next node in the list. 
The cost of this is an extra link, which adds to the space requirements and also doubles the cost of insertions
and deletions because there are more pointers to fix. On the other hand it simplifies deletion, because you no
longer have to refer to a key by using pointers to the previous cell.

Program:

import java.util.Scanner;
class MyNode
{
    MyNode prev;
    int data;
    MyNode next;
}
class MyLinkedList
{
    Scanner s=new Scanner(System.in);
    MyNode head,last;
    MyLinkedList()
    {
        head=null;
        last=null;
    }
    void create(int n)
    {
        MyNode temp;
        for(int i=0;i<n;i++)
        {
            temp=new MyNode();
            System.out.println("enter data");
            temp.data=s.nextInt();
            temp.next=null;
            if(head==null)
            {
                head=last=temp;
                head.prev=null;
            }
            else
            {
                last.next=temp;
                temp.prev=last;
                last=temp;
            }
        }
    }
    void insertB()
    {
        MyNode temp=new MyNode();
        System.out.println("enter data");
        temp.data=s.nextInt();
        temp.prev=null;
        temp.next=head;
        head.prev=temp;
        head=temp;
    }
    void insertE()
    {
        MyNode temp=new MyNode();
        MyNode temp1;
        System.out.println("enter data");
        temp.data=s.nextInt();
        temp.next=null;
        for(temp1=head;temp1.next!=null;temp1=temp1.next);
        temp.prev=temp1;
        temp1.next=temp;
        last=temp;
    }
    void insertP(int p)
    {
        MyNode temp=new MyNode();
        MyNode temp1;
        int i;
        System.out.println("enter data");
        temp.data=s.nextInt();
        for(i=0,temp1=head;i<p-1;temp1=temp1.next,i++);
        temp.next=temp1.next;
        temp.prev=temp1;
        temp1.next.prev=temp;
        temp1.next=temp;
    }
    void deleteB()
    {
        MyNode temp;
        temp=head;
        head=temp.next;
        head.prev=null;
        temp=null;
    }
    void deleteE()
    {
        MyNode temp,temp1;
        for(temp=head;temp.next!=null;temp=temp.next);
        temp1=temp.prev;
        temp1.next=null;
        temp=null;
        last=temp1;
    }
    void deleteP(int p)
    {
        MyNode temp,temp1;
        int i;
        for(temp=head,i=0;i<p-1;i++,temp=temp.next);
        temp1=temp.next;
        temp.next=temp1.next;
        temp1.next.prev=temp;
        temp1=null;
    }
    void displayF()
    {
        MyNode temp;
        for(temp=head;temp!=null;temp=temp.next)
            System.out.print(temp.data+"->");
        System.out.println("null");
    }
    void displayB()
    {
        MyNode temp;
        for(temp=last;temp!=null;temp=temp.prev)
            System.out.print(temp.data+"->");
        System.out.println("null");
    }

}
class DoubleLinkedListDemo
{
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        MyLinkedList l=new MyLinkedList();
        System.out.println("enter the size of the list");
        int ch;
        l.create(s.nextInt());
        while(true)
        {
            System.out.println("enter your choice");
            ch=s.nextInt();
            switch(ch)
            {
                case 1: l.insertB();
                    break;
                case 2: l.insertE();
                    break;
                case 3:System.out.println("enter the position");
                    l.insertP(s.nextInt());
                    break;
                case 4:l.deleteB();
                    break;
                case 5:l.deleteE();
                    break;
                case 6: System.out.println("enter the position");
                    l.deleteP(s.nextInt());
                    break;
                case 7:l.displayF();
                    break;
                case 8:l.displayB();
                    break;
                default:return;
            }
        }
    }
}

Input and Output:

enter the size of the list
5
enter data
1
enter data
2
enter data
3
enter data
4
enter data
5
enter your choice
4
enter your choice
7
2->3->4->5->null
enter your choice
8
5->4->3->2->null
enter your choice

