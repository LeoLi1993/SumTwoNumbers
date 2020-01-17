package com.sap.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException
    {
	    Solution solution = new Solution();
	    ListNode firstListNode = new ListNode();
        ListNode secondListNode = new ListNode();
        ListNode finalListNode = new ListNode();
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        try
        {
            // read data from console
            getDataFromConsole(firstListNode, bufferedReader);
            getDataFromConsole(secondListNode, bufferedReader);
            //add two numbers into finalListNode
            solution.addTwoNumbers(firstListNode, secondListNode,finalListNode);
            printFinalListNode(finalListNode);
        }
        catch(IOException ex)
        {
            System.out.println("Can not read data from console.");
            System.exit(1);
        }
        finally
        {
            inputStreamReader.close();
            bufferedReader.close();
        }
    }

    /**
     * @Description fetch data from console, also construct two different single linked list.
     * @param head
     * @param bufferedReader
     * @throws IOException
     */
    private static void getDataFromConsole(ListNode head, BufferedReader bufferedReader) throws IOException
    {
        System.out.println("Please input int data, use ',' to separate different numbers.");
        String data = bufferedReader.readLine();
        String[] firstLineData = data.split(",");
        for(String str:firstLineData)
        {
            try
            {
                int intData = Integer.parseInt(str);
                ListNode subListNode = new ListNode();
				subListNode.data = intData;
                head.next = subListNode;
                head = head.next;
            }
            catch(NumberFormatException ex)
            {
                System.out.println("Please input int data.");
                System.exit(1);
            }
        }
    }

	/**
	 * @Description print final listNode result
	 * @param headListNode
	 */
	private static void printFinalListNode(ListNode headListNode)
	{
		System.out.println("Final result:");
		StringBuilder stringBuilder = new StringBuilder();
		while(null != headListNode.next)
		{
			stringBuilder.append(headListNode.next.data);
			if(null != headListNode.next.next)
			{
				stringBuilder.append(",");
			}
			headListNode = headListNode.next;
		}
		System.out.println(stringBuilder.toString());
	}
}
