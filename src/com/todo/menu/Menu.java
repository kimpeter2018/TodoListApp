package com.todo.menu;
public class Menu {

    public static void displaymenu()
    {
        System.out.println("모든 선택지는 명령어 또는 숫자로 실행 가능합니다.");
        System.out.println("1. 항목 추가 ( add )");
        System.out.println("2. 항목 삭제 ( del )");
        System.out.println("3. 항목 수정  ( edit )");
        System.out.println("4. 전체 목록 ( ls )");
        System.out.println("5. 제목순 정렬 ( ls_name_asc or asc)");
        System.out.println("6. 제목역순 정렬 ( ls_name_desc or desc)");
        System.out.println("7. 날짜순 정렬 ( ls_date or date)");
        System.out.println("8. 종료 (exit)");
    }
    
    public static void prompt() {
		System.out.print("\nEnter Command (메뉴보기: help | 0) > ");
	}
}
