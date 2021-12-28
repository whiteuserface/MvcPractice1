package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import Entities.MemberEntity;
import Service.MemberService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		boolean oc = true;
		MemberService ms = new MemberService();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int swichNum;
		
		while(oc) {
			ms.menu();
			System.out.println("swichNum을 입력하세요.");
			swichNum = Integer.parseInt(br.readLine());
			
			switch(swichNum) {
				
			case 1:
				try {
					System.out.print("새로운 아아디 입력:");
					String userId = br.readLine();
					if(ms.checkId(userId)) {
						System.out.println("중복된 아이디가 존재합니다!");
						break;
					} else {
						System.out.print("새로운 비밀번호 입력:");
						String userPassword = br.readLine();
						System.out.print("새로운 닉네임 입력:");
						String userNickName = br.readLine();
						MemberEntity me = new MemberEntity(userId,userPassword,userNickName);
						ms.insert(me);						
						break;
					}
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				
			case 2:
				try {
					System.out.print("기존 아이디 입력:");
					String userId2 = br.readLine();
					System.out.print("기존 아이디의 패스워드 입력:");
					String userPassword2 = br.readLine();
					if(ms.checkId(userId2)) {
						if(userId2==null || userPassword2 == null) {
							break;
						}	
						if(ms.checkPs(userId2, userPassword2)) {
							System.out.println("수정할 아이디 입력:");
							String newId = br.readLine();
							System.out.println("수정할 비밀번호 입력:");
							String newPassword = br.readLine();
							System.out.println("수정할 닉네임 입력:");
							String newNickName = br.readLine();
							MemberEntity me2 = new MemberEntity(newId, newPassword, newNickName);
							ms.update(me2, userId2);
							break;						
					} else {
						System.out.println("중복된 아이디 입니다!");
					}
					} else {
						System.out.println("아이디와 비밀번호을 다시 확인해서 시도해주세요.");
						break;
					}
				} catch(NumberFormatException e) {
					e.printStackTrace();
				}
				
			case 3:
				try {
					ms.selectAll();
					break;
				} catch(Exception e) {
					e.printStackTrace();
				}
				
			case 4:
				
				System.out.println("삭제할 아이디 입력:");
				String userId4 = br.readLine();
				System.out.println("비밀번호 입력:");
				String userPassword4 = br.readLine();
				if(ms.checkPs(userId4, userPassword4)) {
					ms.delete(userId4);
				} else {
					System.out.println("비밀번호가 틀립니다.");
				}
				
					break;
			case 5:
				System.out.println("종료됩니다!");
				oc=false;
					break;
				}
		}
	}
}
