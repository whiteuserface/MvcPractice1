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
			System.out.println("swichNum�� �Է��ϼ���.");
			swichNum = Integer.parseInt(br.readLine());
			
			switch(swichNum) {
				
			case 1:
				try {
					System.out.print("���ο� �ƾƵ� �Է�:");
					String userId = br.readLine();
					if(ms.checkId(userId)) {
						System.out.println("�ߺ��� ���̵� �����մϴ�!");
						break;
					} else {
						System.out.print("���ο� ��й�ȣ �Է�:");
						String userPassword = br.readLine();
						System.out.print("���ο� �г��� �Է�:");
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
					System.out.print("���� ���̵� �Է�:");
					String userId2 = br.readLine();
					System.out.print("���� ���̵��� �н����� �Է�:");
					String userPassword2 = br.readLine();
					if(ms.checkId(userId2)) {
						if(userId2==null || userPassword2 == null) {
							break;
						}	
						if(ms.checkPs(userId2, userPassword2)) {
							System.out.println("������ ���̵� �Է�:");
							String newId = br.readLine();
							System.out.println("������ ��й�ȣ �Է�:");
							String newPassword = br.readLine();
							System.out.println("������ �г��� �Է�:");
							String newNickName = br.readLine();
							MemberEntity me2 = new MemberEntity(newId, newPassword, newNickName);
							ms.update(me2, userId2);
							break;						
					} else {
						System.out.println("�ߺ��� ���̵� �Դϴ�!");
					}
					} else {
						System.out.println("���̵�� ��й�ȣ�� �ٽ� Ȯ���ؼ� �õ����ּ���.");
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
				
				System.out.println("������ ���̵� �Է�:");
				String userId4 = br.readLine();
				System.out.println("��й�ȣ �Է�:");
				String userPassword4 = br.readLine();
				if(ms.checkPs(userId4, userPassword4)) {
					ms.delete(userId4);
				} else {
					System.out.println("��й�ȣ�� Ʋ���ϴ�.");
				}
				
					break;
			case 5:
				System.out.println("����˴ϴ�!");
				oc=false;
					break;
				}
		}
	}
}
