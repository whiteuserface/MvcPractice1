package Service;

import Entities.MemberEntity;
import Practice1.Dao.MemberDao;


public class MemberService {
		MemberDao md = new MemberDao();
		
				public void insert(MemberEntity me) {
					md.DaoControl(1, me);
				}
				
				public void update(MemberEntity me, String connectId) {
					md.DaoControl(2, me, connectId);
				}
				
				public void delete(String connectId) {
					
					md.DaoControl(3, connectId);
				}
				
				public void selectAll() {
					md.DaoControl(4);
				}
				
				public boolean checkPs(String userId, String userPassword) {
					return md.userPassWordCheck(userId, userPassword);
				}
				
				public boolean checkId(String userId) {
					return md.userIdCheck(userId);
				}
				
				public void menu() {
					System.out.println("1.회원가입");
					System.out.println("2.회원수정");
					System.out.println("3.목록보기");
					System.out.println("4.회원탈퇴");
					System.out.println("5.종료");
				}
}

