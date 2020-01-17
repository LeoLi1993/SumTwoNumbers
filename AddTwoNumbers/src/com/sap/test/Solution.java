package com.sap.test;

/**
 * Project Name:AddTwoNumbers
 * File Name:Solution
 * Description:
 * Copyright: Copyright (c) 2017
 * Company:SAP
 *
 * @author SAP
 * @date
 * @see
 * @since
 */
public class Solution
{
	/**
	 * @Description calculate two different single linked list sum value, then store result into firstHead.
	 * @param firstHead
	 * @param secondHead
	 * @return
	 */
	public ListNode addTwoNumbers(ListNode firstHead, ListNode secondHead, ListNode headListNode)
	{
		//Use carry to judge if the value of sum two numbers is greater than 10
		//If value is greater than 10, then carry is 1, otherwise carry is 0;
		int carry = 0;
		//to store final result
		//sum numbers with common length of two single linked list
		while(null != firstHead.next && null != secondHead.next)
		{
			ListNode listNode = new ListNode();
			int data = firstHead.next.data + secondHead.next.data + carry;
			if(data >= 10)
			{
				int modData = data%10;
				listNode.data = modData;
				carry = 1;
			}
			else
			{
				listNode.data = data;
				carry = 0;
			}
			headListNode.next = listNode;
			headListNode = headListNode.next;

			firstHead = firstHead.next;
			secondHead = secondHead.next;
		}
		//if first linked list's length is greater than second linked list.
		while(null != firstHead.next)
		{
			ListNode listNode = new ListNode();
			int data = firstHead.next.data + carry;
			if(data == 10)
			{
				listNode.data = 0;
				carry = 1;
			}
			else
			{
				listNode.data = data;
				carry = 0;
			}
			headListNode.next = listNode;
			headListNode = headListNode.next;
			firstHead = firstHead.next;
		}
		//if second linked list's length is greater than first linked list.
		while(null != secondHead.next)
		{
			ListNode listNode = new ListNode();
			int data = secondHead.next.data  + carry;
			if(data == 10)
			{
				listNode.data = 0;
				carry = 1;
			}
			else
			{
				listNode.data = data;
				carry = 0;
			}
			headListNode.next = listNode;
			headListNode = headListNode.next;
			secondHead = secondHead.next;
		}
		//specific for (2,4,5) + (2,6,4)
		if(0 != carry)
		{
			ListNode listNode = new ListNode();
			listNode.data = carry;
			headListNode.next = listNode;
			headListNode = headListNode.next;
		}
		return headListNode;
	}
}
