package com.todo;

import java.util.Scanner;

import com.todo.dao.TodoList;
import com.todo.menu.Menu;
import com.todo.service.TodoUtil;

public class TodoMain {
	
	public static void start() {
		
		Scanner sc = new Scanner(System.in);
		TodoList l = new TodoList();
		boolean isList = false;
		boolean quit = false;
//		TodoUtil.loadList(l, "todolist.txt");
		Menu.displaymenu();
		do {
			Menu.prompt();
			isList = false;
			String choice = sc.next();
			switch (choice) {

			case "add", "1":
				TodoUtil.createItem(l);
				break;
			
			case "del":
				TodoUtil.deleteItem(l);
				break;
				
			case "edit":
				TodoUtil.updateItem(l);
				break;
				
			case "ls":
				TodoUtil.listAll(l);
				break;

			case "ls_name_asc",
				 "asc":
				l.sortByName();
				System.out.println("����Ʈ�� ��������� ���ĵǾ����ϴ�.");
				isList = true;
				break;

			case "ls_name_desc",
				 "desc":
				l.sortByName();
				l.reverseList();
				System.out.println("����Ʈ�� ���񿪼����� ���ĵǾ����ϴ�.");
				isList = true;
				break;
				
			case "ls_date",
				 "date":
				l.sortByDate();
				System.out.println("����Ʈ�� ��¥������ ���ĵǾ����ϴ�.");
				isList = true;
				break;
				
			case "help":
				Menu.displaymenu();
				break;

			case "exit":
				quit = true;
				break;

			default:
				System.out.println("�������� �°� ������ �ֽʽÿ�");
				break;
			}
			
			if(isList) TodoUtil.listAll(l);
		} while (!quit);
		TodoUtil.saveList(l, "todolist.txt");
	}
}
