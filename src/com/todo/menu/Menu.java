package com.todo.menu;
public class Menu {

    public static void displaymenu()
    {
        System.out.println("��� �������� ��ɾ� �Ǵ� ���ڷ� ���� �����մϴ�.");
        System.out.println("1. �׸� �߰� ( add )");
        System.out.println("2. �׸� ���� ( del )");
        System.out.println("3. �׸� ����  ( edit )");
        System.out.println("4. ��ü ��� ( ls )");
        System.out.println("5. ����� ���� ( ls_name_asc or asc)");
        System.out.println("6. ���񿪼� ���� ( ls_name_desc or desc)");
        System.out.println("7. ��¥�� ���� ( ls_date or date)");
        System.out.println("8. ���� (exit)");
    }
    
    public static void prompt() {
		System.out.print("\nEnter Command (�޴�����: help | 0) > ");
	}
}
