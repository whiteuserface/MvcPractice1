package Practice1.Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entities.MemberEntity;

import java.io.FileReader;

//import java.util.Properties;
//import Entities.MemberEntity;
//import java.util.HashMap;

public class MemberDao {
	
	String user = "c##tester";
	String password = "1234";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	
	
	private String getUser() {
		return user;
	}




	private void setUser(String user) {
		this.user = user;
	}




	private String getPassword() {
		return password;
	}




	private void setPassword(String password) {
		this.password = password;
	}




	private String getUrl() {
		return url;
	}




	private void setUrl(String url) {
		this.url = url;
	}




	private void findDriver() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	

	public void DaoControl(int num, MemberEntity me) {
		MemberDao md = new MemberDao();
		
		//db연동을 위한 기본 con rs ps 생성		
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try {
			md.findDriver();
			con = DriverManager.getConnection(md.url, md.user, md.password);	
			switch(num) {
				case 1: 
					String sql = "insert into \"MEMBER\" (\"NUM\", \"MEMBERID\" ,\"MEMBERPW\", \"NICKNAME\", \"REGDATE\") values (\"MEMBER_SEQ\".nextval,?, ?, ?, sysdate)";
					ps = con.prepareStatement(sql);
					ps.setString(1,me.getUserId());
					ps.setString(2,me.getUserPassword());
					ps.setString(3,me.getUserNickName());
					ps.executeUpdate();
					break;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					con.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void DaoControl(int num, MemberEntity me, String connectId) {
		MemberDao md = new MemberDao();
		//db연동을 위한 기본 con ps 생성		
		Connection con = null;
		PreparedStatement ps = null;
		
		
		
		try {
			md.findDriver();
			con = DriverManager.getConnection(md.url, md.user, md.password);	
			switch(num) {
				case 2:
					
					
						String sql2 = "update \"MEMBER\" set \"NUM\"=\"MEMBER_SEQ\".nextval, \"MEMBERID\"=? ,\"MEMBERPW\"=?,\"NICKNAME\"=?, \"REGDATE\"=sysdate WHERE \"MEMBERID\"=?";
						ps = con.prepareStatement(sql2);
						ps.setString(1,me.getUserId());
						ps.setString(2,me.getUserPassword());
						ps.setString(3,me.getUserNickName());
						ps.setString(4,connectId);
						ps.executeUpdate();
						
						break;		
					
						}
			
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							if(con != null) {
								try {
									con.close();
								} catch(SQLException e) {
									e.printStackTrace();
								}
							}
							if(ps != null) {
								try {
									ps.close();
								} catch(SQLException e) {
									e.printStackTrace();
								}
							}
						}
		
		}
	
	public void DaoControl(int num, String connectId) {
		MemberDao md = new MemberDao();
		
		//db연동을 위한 기본 con rs ps 생성		
		Connection con = null;
		PreparedStatement ps = null;
		
		
		
		try {
			md.findDriver();
			con = DriverManager.getConnection(md.url, md.user, md.password);	
			switch(num) {
				case 3:
					MemberDao md3 = new MemberDao();
					
					String sql3 = "delete from \"MEMBER\" where \"MEMBERID\"=?";
					ps = con.prepareStatement(sql3);
					ps.setString(1,connectId);
					ps.executeUpdate();
					break;	 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void DaoControl(int num) {
		MemberDao md = new MemberDao();
		
		//db연동을 위한 기본 con rs ps 생성		
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try {
			md.findDriver();
			con = DriverManager.getConnection(md.url, md.user, md.password);
		switch(num) {
			case 4:
			String sql4 = "select * from member";
			ps = con.prepareStatement(sql4);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getDate(5));
				System.out.println();
			}
			break;
			
		}
		
		}
		 catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private FileReader FileReader(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean userPassWordCheck(String userid, String password) {
		//프로퍼티스 정보 가져오기(디비정보)
//				Properties dbInformation = new Properties();
//				FileReader dbInformationReader = FileReader("./src/Practice1/Dao/OracleDbInformation.properties");
//				
//				HashMap<String,String> map = new HashMap<>();
//				map.put("url", dbInformation.getProperty("url"));
//				map.put("user", dbInformation.getProperty("user"));
//				map.put("password", dbInformation.getProperty("password"));
				//db연동을 위한 기본 con rs ps 생성		
				MemberDao md = new MemberDao();
				Connection con = null;
				ResultSet rs = null;
				PreparedStatement ps = null;
				
				
				
		
		try {
			md.findDriver();
			con = DriverManager.getConnection(md.url, md.user, md.password);	
			String sql5 = "select \"MEMBERPW\" from \"MEMBER\" where \"MEMBERID\"=?";
			ps = con.prepareStatement(sql5);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			if(rs.next()) {
					String tmpPs  = rs.getString(1);
					if(tmpPs.equals(password)) {
						return true;
					} 
			}
			} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
	public boolean userIdCheck(String userid) {
		//프로퍼티스 정보 가져오기(디비정보)
		MemberDao md = new MemberDao();
				
				//db연동을 위한 기본 con rs ps 생성		
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
				
				
				
		
		try {
			md.findDriver();
			con = DriverManager.getConnection(md.getUrl(), md.getUser(), md.getPassword());
			String sql5 = "select memberid from member where memberid=?";
			ps = con.prepareStatement(sql5);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			if(rs.next()) {
					String tmpId = rs.getString(1);
					if(tmpId.equals(userid)) {
						return true;
					} 
			}
			} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					con.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
//	private static String[] dbInfo() {
//		String[] info = new String[3];
//		info[0] =  "jdbc:oracle:thin@localhost:1521:xe";
//		info[1] = "c##tester";
//		info[2] = "1234";
//		return  info;
//	}



}
