package com.todo.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.*;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

public class TodoUtil {
	
	public static void createItem(TodoList list) {
		String title, desc;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("[�׸� �߰�]\n"
				+ "������ �Է��ϼ��� > ");
		
		title = sc.nextLine();
		if (list.isDuplicate(title)) {
			System.out.print(title + "�� �̹� �����մϴ�!");
			return;
		}
		
		System.out.print("������ �Է��ϼ��� > ");
		desc = sc.nextLine().trim();
		
		TodoItem t = new TodoItem(title, desc, null);
		list.addItem(t);
		System.out.println("�� �׸��� ���������� �߰� �Ǿ����ϴ�!");
	}

	public static void deleteItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("[�׸� ����]\n"
				+ "������ �׸��� ������ �Է��ϼ��� > ");
		String title = sc.next();
		
		if (!l.isDuplicate(title)) {
			System.out.println("title doesn't exist");
			return;
		}
		
		for (TodoItem item : l.getList()) {
			if (title.equals(item.getTitle())) {
				l.deleteItem(item);
				System.out.println(title + "�� ���������� �����Ǿ����ϴ�!");
				break;
			}
		}
	}


	public static void updateItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("[�׸� ����]\n"
				+ "������ �׸��� ������ �Է��ϼ��� > ");
		String title = sc.next();
		
		if (!l.isDuplicate(title)) {
			System.out.println("�������� �ʴ� �����Դϴ�!");
			return;
		}
		sc.nextLine();

		System.out.print("�� ���� > ");
		String new_title = sc.nextLine();
		if (l.isDuplicate(new_title)) {
			System.out.print(new_title + "�� �̹� �����մϴ�!");
			return;
		}
		System.out.print("�� ���� > ");
		String new_description = sc.nextLine().trim();
		for (TodoItem item : l.getList()) {
			if (item.getTitle().equals(title)) {
				l.deleteItem(item);
				TodoItem t = new TodoItem(new_title, new_description, null);
				l.addItem(t);
				System.out.println("�׸��� ���������� �����Ǿ����ϴ�!");
			}
		}

	}

	public static void listAll(TodoList l) {
		System.out.println("[��ü ���]");
		for (TodoItem item : l.getList()) {
			System.out.println(item.toString());
		}
	}

	public static void saveList(TodoList l, String filename) {
		try {
			Writer w = new FileWriter(filename);
			for (TodoItem item : l.getList()) {
				w.write(item.toSaveString());
			}
			w.close();
			
			System.out .println("���� ���� ���� !!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void loadList(TodoList l, String filename) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String oneline;
			while((oneline = br.readLine()) !=null) {
				StringTokenizer st = new StringTokenizer(oneline, "##");
				String title = st.nextToken();
				String desc = st.nextToken();
				String date = st.nextToken();
				TodoItem t = new TodoItem(title, desc, date);
				l.addItem(t);
			}
			br.close();
			
			System.out.println("���� �ε� �Ϸ� !!! ");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
}
	}
}
