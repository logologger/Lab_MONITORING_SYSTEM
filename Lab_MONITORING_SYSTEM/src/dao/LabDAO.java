package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import util.DBUtil;
import bean.Dependent;
import bean.Hcp;
import bean.HcpLogin;
import bean.LSP;
import bean.Login;
import bean.Patient;
import bean.PatientSecurity;
import bean.Search_bean;
import bean.View_Schedule;

public class LabDAO {
	String msg=null;
	Connection con=null;
	PreparedStatement ps = null;
	ResultSet rs= null;
	PreparedStatement ps2,seqPS,ps3,ps4,psfinal;
	///Add the patient to the database when patient registers himself
	public String addPatient(Patient bean, String password){
		//return the Patient_ID
		
		con=DBUtil.getConnection();
		
		try {
			ps=con.prepareStatement("select max(serial_no) from e_patient");
			ResultSet rs=ps.executeQuery();
			int max_serno=0;
			if(rs.next())
			{
				max_serno = rs.getInt(1);
			}
			max_serno++;
			String new_pid = "p" + String.valueOf(max_serno);
			System.out.println("PID = "+new_pid);
			
			//new_pid is the new patient ID which now can be stored in the database
			
			ps=con.prepareStatement("insert into e_patient values(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, new_pid);
			ps.setString(2, bean.getFirstName());
			ps.setString(3, bean.getLastName());
			ps.setString(4, bean.getGender());
			ps.setString(5, bean.getAge());
			ps.setString(6, bean.getAddress());
			ps.setString(7, bean.getContactNo());
			ps.setString(8, bean.getHealthInsuranceNo());
			ps.setString(9, bean.getBill());
			ps.setInt(10, max_serno);
			
			ps.executeUpdate();
			
			ps=con.prepareStatement("insert into e_patient_login values(?,?,?,?,?)");
			ps.setString(1, new_pid);
			ps.setString(2, password);
			ps.setInt(3, 0);
			ps.setString(4, "");
			ps.setString(5, "");
			
			ps.executeUpdate();
			return new_pid;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return null;
	}
	
	
	//HCP registeration
	
	
	

	public HcpLogin createHcp(Hcp hcp, String password) throws SQLException {
		try {
			

			con = DBUtil.getConnection();
			System.out.println("dao cvlass");

			ps = con.prepareStatement("insert into e_hcp values(?,?,?,?,?,?,?,?,?)");

			ps.setString(1, hcp.getHcpName());
			/*---------------*/
			PreparedStatement ps1 = con
					.prepareStatement("select max(serial_no) from e_hcp");

			ResultSet rs = ps1.executeQuery();
			//String max_hcpid = "hcp1";
			int max_serno=0;
			if (rs.next()) {
				max_serno = rs.getInt(1);
			}
		
			max_serno = max_serno +1;
			// concatenate it with p character and here we get our new pid
			// String hcpid_real_string=null;
			String new_hcpid = "hcp" + String.valueOf(max_serno);
			System.out.println(new_hcpid);
			System.out.println("Maimum serial number is "+max_serno+"contact is "+hcp.getContact());
			// new_pid is the new patient ID which now can be stored in the
			// database
			
			//System.out.println(new_hcpid);
			ps.setString(2, new_hcpid);
			ps.setString(3, hcp.getHcpLicenseNumber());
			ps.setString(4, hcp.getAddress());
			ps.setString(5, hcp.getContact());
			ps.setString(6, hcp.getEmergencyContact());
			ps.setString(7, hcp.getEmailId());
			ps.setString(8, password);
			ps.setInt(9,max_serno);
			System.out.println(password);
			ps.executeUpdate();
			ps3=con.prepareStatement("insert into e_hcp_login (hcp_id,password) values(?,?)");
			ps3.setString(1, new_hcpid);
			ps3.setString(2, password);
			ps3.executeUpdate();
			HcpLogin hl=new HcpLogin();
			hl.setHcpid(new_hcpid);
			hl.setPassword(password);
			
			ps2=con.prepareStatement("select * from e_hcp where hcp_id=?");
			ps2.setString(1, new_hcpid);
			ResultSet rs1=ps2.executeQuery();
			if(rs1.next())
			{
			String append="userid="+rs1.getString(2)+"password="+rs1.getString(8);
			return hl;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("excepton in dao class");
		} finally {
			if (con != null) {
				con.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}

		}
		return null;
	}
	
	//Patient Login DAO 
	
	public String patientLogin(String ppid, String pwd) throws SQLException
	{
		con=DBUtil.getConnection();
		String pid=null;
		String password = null;
		String result = null;
		int noOfVisits = 0;
		System.out.println("I came and conquered"+ppid+"  "+pwd);
		String patid=null;
		try{
			ps=con.prepareStatement("select epl.p_id,epl.password,ep.contact_number from e_patient_login epl inner join e_patient ep on epl.p_id=ep.p_id where (epl.P_ID = ? or ep.contact_number =? ) and epl.password= ?");
			ps.setString(1, ppid);
			ps.setString(2, ppid);
			ps.setString(3, pwd);
			rs=ps.executeQuery();
			if(rs.next()){
				
				 patid=rs.getString(1);
				return patid;
			}
		
		}
		catch(Exception e )
		{
			e.printStackTrace();
		}
		
		return patid;
	}
	//HCP logins here
	
	public String validateLogin(Login login) {
		String success=null;
		String hcpid=null;
		try {
			String validLogin="select epl.hcp_id,epl.password,ep.contact from e_hcp_login epl inner join e_hcp ep on epl.hcp_id=ep.hcp_id where (epl.hcp_id = ? or ep.contact =? ) and epl.password= ?";
			
			
			con = DBUtil.getConnection();
			System.out.println("dao cvlass");
			seqPS = con.prepareStatement(validLogin);
			seqPS.setString(1, login.getLoginID());
			seqPS.setString(2, login.getLoginID());
			seqPS.setString(3,login.getPassword());
			rs=seqPS.executeQuery();
			System.out.println("After rs");
			/*
			while(rs.next()){
				System.out.println(rs.getString(1));
			}*/
			
			if(rs.next())
			{
				System.out.println("Entered");
				hcpid=rs.getString(1);
				//means it is a right user 
				return hcpid;
				
			
				//System.out.println(success);
			}
			
					}
		catch (Exception e)
		{
			e.printStackTrace();
		} 
					
						
						return hcpid;
				}
	///When Patient forgets Password
	
	public String checkPatient(PatientSecurity psec, String pid) {
		// TODO Auto-generated method stub
		//here i will check the right user or not i.e patient in this case
		con=DBUtil.getConnection();
		
		try {
			String sq=psec.getSecurityQuestion();
			String sa=psec.getSecurityAnswer();
			PreparedStatement ps=con.prepareStatement("select * from e_patient_login where p_id=? and security_question=? and security_answer=?");
			ps.setString(1,pid);
			ps.setString(2,sq);
			ps.setString(3,sa);
			ResultSet rse=ps.executeQuery();
			while(rse.next())
			{
				return "ok";
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "notok";
		}
		return "notok";
		
	}
	//when User answers Right security answer and question he will be prompted to change passwor
	
	public String changePassword(String pid, PatientSecurity psec) {
		// TODO Auto-generated method stub
//changing the password here
		con=DBUtil.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("update e_patient_login set password=? where p_id=?");
		ps.setString(1,psec.getNewPwd());
		ps.setString(2,pid);
		ps.executeUpdate();
		return "ok";
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "notok";
		}
		
		
	}
	//When HCP forgets his/her password
	
	public String checkHCP(PatientSecurity psec, String pid) {
		// TODO Auto-generated method stub
		//here i will check the right user or not i.e patient in this case
		con=DBUtil.getConnection();
		
		try {
			String sq=psec.getSecurityQuestion();
			String sa=psec.getSecurityAnswer();
			PreparedStatement ps=con.prepareStatement("select * from e_hcp_login where hcp_id=? and security_question=? and security_answer=?");
			ps.setString(1,pid);
			ps.setString(2,sq);
			ps.setString(3,sa);
			ResultSet rse=ps.executeQuery();
			while(rse.next())
			{
				return "ok";
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "notok";
		}
		return "notok";
		
	}

//When HCP gives right security question and answer
	
	public String hcpchangePassword(String hcp_id, PatientSecurity psec)
	{
	
		con=DBUtil.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("update e_hcp_login set password=? where hcp_id=?");
		ps.setString(1,psec.getNewPwd());
		ps.setString(2,hcp_id);
		ps.executeUpdate();
		return "ok";
		
		} catch (Exception e) {
			e.printStackTrace();
			return "notok";
		}
		
		
	}
	
	//View the Patient details or profile by Patient or himself
	
	public Patient viewPatients(String pId) throws SQLException
	{
		Patient p= new Patient();
		con=DBUtil.getConnection();
		
		try{
			ps=con.prepareStatement("select ep.p_id, ep.first_name, ep.last_name, ep.gender, ep.age, ep.address, ep.contact_number, ep.health_insurance_number, ep.bill,epvh.medical_complaint,epvh.refer_doctor from e_patient ep left outer join e_patient_register_via_hcp epvh on ep.p_id=epvh.p_id where ep.p_id = ?");
			ps.setString(1, pId);
			rs=ps.executeQuery();
			while(rs.next())
			{
				
				p.setPatientID(rs.getString(1));
				p.setFirstName(rs.getString(2));
				p.setLastName(rs.getString(3));
				p.setGender(rs.getString(4));
				p.setAge(rs.getString(5));
				p.setAddress(rs.getString(6));
				p.setContactNo(rs.getString(7));
				p.setHealthInsuranceNo(rs.getString(8));
				p.setBill(rs.getString(9));
				p.setMedicalComplaint(rs.getString(10));
				p.setReferDoctor(rs.getString(11));
				
			
			}
		}
		finally{
			con.close();
		}
		return p;
		
		}
	
		//Update the patient details after displaying him the update Patient form 
	
		public String updatePatientDetails(Patient p, String pid) 
		{
					try
					{
					con=DBUtil.getConnection();
					ps=con.prepareStatement("update e_patient set first_name=? , last_name=? , gender=?, age=?, address=?, contact_number=?, health_insurance_number=? where p_id=? ");
					ps.setString(1, p.getFirstName());
					ps.setString(2, p.getLastName());
					ps.setString(3, p.getGender());
					ps.setString(4, p.getAge());
					ps.setString(5, p.getAddress());
					ps.setString(6, p.getContactNo());
					ps.setString(7, p.getHealthInsuranceNo());
					
					
					ps.setString(8, pid);
				
					System.out.println("updating the patient details by patient"+p.getHealthInsuranceNo());
					
						ps.executeUpdate();
					
					
						return "ok";
					}
					
					catch(Exception e)
					{
						e.printStackTrace();
					
						return "fail";
					}
		
		}
		
		//Add dependent details or register dependent
		
		public String addDependent(String p_id,Dependent d) throws SQLException
		{		
			con=DBUtil.getConnection();
			 String d_id=null;

			try {
				
				PreparedStatement ps1 = con.prepareStatement("select max(serial_no) from e_dependents");
				ResultSet rs = ps1.executeQuery();
				int max_serno=0;
				if (rs.next()) {
				max_serno = rs.getInt(1);
				}
				max_serno = max_serno +1;
				String new_did = "d" + String.valueOf(max_serno);
				d_id=new_did;

				ps = con.prepareStatement("insert into e_dependents values(?,?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1,d_id);
				ps.setString(2, p_id);
				ps.setString(3, d.getFirst_name());
				ps.setString(4, d.getLast_name());
				ps.setString(6, d.getRelationship());
				ps.setInt(7, d.getAge());
				ps.setString(8, d.getAddress());
				ps.setString(5, d.getGender());
				ps.setInt(9, d.getHealth_number());
				ps.setString(10, d.getPhone_number());
				ps.setInt(11,max_serno);
				
				ps.executeUpdate();
				
				
			 }catch(Exception e){
				 e.printStackTrace();
				 }finally
					{
					        if(con!=null)
							con.close();
							if(ps!=null)
							ps.close();
							}
				return d_id;
			 }
		
		
		//UPdate the Dependent details
		
		
		
		public int updateDependent(Dependent d,String p_id) throws SQLException {
			// TODO Auto-generated method stub
					Connection con=DBUtil.getConnection();
					int count =0;
					
					try
					{
						
						String d_id=d.getDep_id().trim();
						System.out.println("Dependents "+d.getAddress()+"   "+d.getDep_id()+" "+d.getLast_name());
							ps = con.prepareStatement("update e_dependents set first_name=?,last_name=?,relationship=?,age=?,address=?,gender=?,health_insurance_number=?,contact_number=? where p_id=? and d_id=? ");
		
					 ps.setString(1,d.getFirst_name());
					ps.setString(2,d.getLast_name());
					ps.setString(3, d.getRelationship());
					ps.setString(4,String.valueOf(d.getAge()));
					ps.setString(5, d.getAddress());
					ps.setString(6,d.getGender());
					ps.setString(7,String.valueOf(d.getHealth_number()));
					ps.setString(8,d.getPhone_number());
					ps.setString(9,p_id);
					ps.setString(10,d_id);
				
		
					ps.executeUpdate();
					 System.out.println("mere dil mein yuhi rehna "+d.getDep_id()+"count "+count+"pid"+p_id);
		
					}catch(Exception se){
						se.printStackTrace();
					}
				
					return count;
		}
		//View the dependent details here
		
		public ArrayList<Dependent> viewDependent(String p_id) 
		{
			con=DBUtil.getConnection();
						ArrayList<Dependent> alist = new ArrayList<Dependent>();
						
						try
						{
							System.out.println("DAO "+p_id);
						PreparedStatement ps = con.prepareStatement("select * from e_dependents where p_id=?");
						ps.setString(1,p_id);
						
						ResultSet rs = ps.executeQuery();
						while(rs.next())
						{
							 Dependent d=new Dependent();
							 d.setDep_id(rs.getString(1));
							d.setFirst_name(rs.getString(3));
							d.setLast_name(rs.getString(4));
							d.setRelationship(rs.getString(6));
							d.setAge(rs.getInt(7));
							d.setAddress(rs.getString(8));
							d.setGender(rs.getString(5));
							d.setHealth_number(rs.getInt(9));
							d.setPhone_number(rs.getString(10));
							alist .add(d);
						}
						
						}catch(SQLException se){
							System.out.println("No data to show");
						}
						finally
						{
							try {
								if(con!=null)
								con.close();
								if(ps!=null)
								ps.close();
								
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
						return alist;
		}

		//check old password while changing patient password
		
		public String checkoldpassword(String pid, String oldpwd) {
			// TODO Auto-generated method stub
			con=DBUtil.getConnection();
			PreparedStatement ps;
			try {
				ps = con.prepareStatement("select password from e_patient_login where p_id=?");
				ps.setString(1,pid);
				
				ResultSet rs=ps.executeQuery();
				String old_password=null;
				while(rs.next())
				{
					 old_password=rs.getString(1);
				}
				if(old_password.equals(oldpwd))
				{
					//means he or she can now change password or is a authentic user
					return "ok";
					//
				}
				else
				{
					return "notok";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
		}
		
		//Set  the Security Question and answer for the Patient
		
		public String setSecurity(PatientSecurity psec, String pid) {
			// TODO Auto-generated method stub
			//insert the security question and answer here into the database
			con=DBUtil.getConnection();
			
			try {
				PreparedStatement ps=con.prepareStatement("update e_patient_login set security_question=?,security_answer=? where p_id=?");
				ps.setString(1,psec.getSecurityQuestion());
				ps.setString(2,psec.getSecurityAnswer());
				ps.setString(3,pid);
				ps.executeUpdate();
				return "ok";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "notok";
			}
			
		
		}
		
		//delete the Patient Profile by patient Himself
		
		public String deletePatient(String pid)
		{
						con=DBUtil.getConnection();
						try
						{
							System.out.println("i came in delete with pid="+pid);
									ps=con.prepareStatement("select bill from e_patient where p_id=?");
									ps.setString(1,pid);
									ResultSet rs=ps.executeQuery();
									int bill=0;
									while(rs.next())
									{
										 bill=rs.getInt(1);
									}
									
									int check=0;
									
									if(bill==0)
									{
										System.out.println("i cam in bill=0");
										ps=con.prepareStatement("select p_id from e_dependents where p_id=?");
										ps.setString(1,pid);
										ResultSet rsr=ps.executeQuery();
										while(rsr.next())
										{
										ps=con.prepareStatement("delete from e_dependents where p_id=?");
										//problem is when he or she has no dependents
										//then u can't delete anything from there
										ps.setString(1, pid);
										check = ps.executeUpdate();
										}
										//if(check!=0)
										
										{
											System.out.println("I deleted e_dependents");
											ps=con.prepareStatement("delete from e_patient_login where p_id=?");
											ps.setString(1, pid);
											check = ps.executeUpdate();
											if(check!=0)
											{
												ps=con.prepareStatement("delete from e_patient where p_id=?");
												ps.setString(1, pid);
												check = ps.executeUpdate();
												if(check!=0)
														{
															System.out.println("success! deleted from login table");
														}
											}
											
											
										}
									}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return "ok";
		}
		
		//View the HCP Profile by HCP himself
		
		
		public ArrayList<Hcp> viewHcp(String hcpid)
		{
			
							String viewHcpSql = "select * from e_hcp where hcp_id=?";
							ArrayList<Hcp> hcpList = new ArrayList<>();
							try {
								
								con=DBUtil.getConnection();
								System.out.println("dao cvlass");
								seqPS = con.prepareStatement(viewHcpSql);
								seqPS.setString(1,hcpid);
								rs = seqPS.executeQuery();
								while (rs.next()) 
								{
									Hcp hcp = new Hcp();
									hcp.setHcpName(rs.getString(1));
									hcp.setId(rs.getString(2));
									hcp.setHcpLicenseNumber(rs.getString(3));
									hcp.setAddress(rs.getString(4));
									hcp.setContact(rs.getString(5));
									hcp.setEmergencyContact(rs.getString(6));
									hcp.setEmailId(rs.getString(7));
									hcpList.add(hcp);
				
								}
								System.out.println("Length of list: " + hcpList.size());
							} catch (Exception e) {
								e.printStackTrace();
							} finally {
								try {
									rs.close();
									seqPS.close();
									con.close();
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
							return hcpList;
		}
		
		//display the details to Update the HCP Profile by HCP
		
		public Hcp updatehcpProfile(String loginId) 
		{
			
							try {
								Hcp hcp = new Hcp();
								String updateProfileSQL = "select * from e_hcp where hcp_id=?";
								
								con = DBUtil.getConnection();
								System.out.println("dao cvlass");
								ps=con.prepareStatement(updateProfileSQL);
								ps.setString(1, loginId);
								ResultSet rs9=ps.executeQuery();
								
								while(rs9.next()) 
								{
									System.out.println("Entered rs true");
									hcp.setHcpName(rs9.getString(1));
									hcp.setId(rs9.getString(2));
									hcp.setHcpLicenseNumber(rs9.getString(3));
									hcp.setAddress(rs9.getString(4));
									hcp.setContact(rs9.getString(5));
									hcp.setEmergencyContact(rs9.getString(6));
									hcp.setEmailId(rs9.getString(7));
									System.out.println("After creation");
									return hcp;
								}
							}catch (Exception e) {
								e.printStackTrace();
							} finally {
								try {
									ps.close();
									con.close();
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
							return null;
		}
		
		//Update the HCP profile by HCP
		
		
		public String updateNew(Hcp hcp,String loginid) {
			// TODO Auto-generated method stub
			String success=null;
			try {
				
				con = DBUtil.getConnection();
				System.out.println("dao cvlass");

				ps = con.prepareStatement("update e_hcp set hcp_name=?, license_number=?, address=?, contact=?, emergency_contact=?, email_id=? where hcp_id=?" );
				ps.setString(7, loginid);
				ps.setString(1, hcp.getHcpName());
				ps.setString(2, hcp.getHcpLicenseNumber());
				ps.setString(3, hcp.getAddress());
				ps.setString(4, hcp.getContact());
				ps.setString(5, hcp.getEmergencyContact());
				ps.setString(6, hcp.getEmailId());
				int x=ps.executeUpdate();
				if(x>0)
				{
					 success = "ok";
				}
				else
				{
					success="notok";
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			} finally
			{
				try
				{
					ps.close();
					con.close();
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		return success;
	}
//Add Patient By HCP
		
		public String registerPatientviahcp(Patient patient,String loginid) throws SQLException
		{
		
				try {
					
					con = DBUtil.getConnection();
					System.out.println("dao cvlass");

					ps = con.prepareStatement("insert into e_patient values(?,?,?,?,?,?,?,?,?,?)");

					ps.setString(2, patient.getFirstName());
					/*---------------*/
					PreparedStatement ps1 = con
							.prepareStatement("select max(serial_no) from e_patient");

					ResultSet rs = ps1.executeQuery();
					//String max_hcpid = "hcp1";
					int max_serno=0;
					if (rs.next()) {
						max_serno = rs.getInt(1);
					}
				//	String hcpid_number = max_hcpid.substring(3, max_hcpid.length());
					// Do the required parsing and increase the number by 1
				//	int hcpid_real = Integer.parseInt(hcpid_number);
					max_serno = max_serno +1;
					// concatenate it with p character and here we get our new pid
					// String hcpid_real_string=null;
					String new_pid = "p" + String.valueOf(max_serno);
					System.out.println(new_pid);
					// new_pid is the new patient ID which now can be stored in the
					// database
					
					//System.out.println(new_hcpid);
					ps.setString(1, new_pid);
					ps.setString(3, patient.getLastName());
					ps.setString(4, patient.getGender());
					ps.setString(5, patient.getAge());
					ps.setString(6, patient.getAddress());
					ps.setString(7, patient.getContactNo());
					ps.setString(8, patient.getHealthInsuranceNo());
					ps.setString(9, patient.getBill());
					ps.setInt(10,max_serno);
					/* =====++++++++====== */
					Random g = new Random();
					int upper_case = g.nextInt((90 - 65) + 1) + 65;
					int lower_case = g.nextInt((122 - 97) + 1) + 97;
					int special_case = g.nextInt((47 - 33) + 1) + 33;
					int number_case = g.nextInt((57 - 48) + 1) + 48;
					int upper_case1 = g.nextInt((90 - 65) + 1) + 65;
					int lower_case1 = g.nextInt((122 - 97) + 1) + 97;
					int special_case1 = g.nextInt((47 - 33) + 1) + 33;
					int number_case1 = g.nextInt((57 - 48) + 1) + 48;
					char upper_case_char = (char) upper_case;
					char lower_case_char = (char) lower_case;
					char number_case_char = (char) number_case;
					char special_case_char = (char) special_case;
					char upper_case_char1 = (char) upper_case1;
					char lower_case_char1 = (char) lower_case1;
					char number_case_char1 = (char) number_case1;
					char special_case_char1 = (char) special_case1;
					char password_array[] = new char[8];
					password_array[0] = upper_case_char;
					password_array[1] = lower_case_char;
					password_array[2] = number_case_char;
					password_array[3] = special_case_char;
					password_array[4] = upper_case_char1;
					password_array[5] = lower_case_char1;
					password_array[6] = special_case_char1;
					password_array[7] = number_case_char1;
					String password = new String(password_array);
					System.out.println(password);
					ps3=con.prepareStatement("insert into e_patient_register_via_hcp values(?,?,?,?)");
					ps3.setString(1, loginid);
					ps3.setString(2, new_pid);
					ps3.setString(3, patient.getMedicalComplaint());
					System.out.println(patient.getMedicalComplaint());
					ps3.setString(4,patient.getReferDoctor());
					ps.executeUpdate();
					ps3.executeUpdate();
					ps2=con.prepareStatement("insert into e_patient_login (p_id,password) values(?,?)");
					ps2.setString(1, new_pid);
					ps2.setString(2, password);
					ps2.executeUpdate();
					ps4=con.prepareStatement("select * from e_patient_login where p_id=?");
					ps4.setString(1,new_pid);
					ResultSet rs1=ps4.executeQuery();
					if(rs1.next())
					{
					String append=rs1.getString(1)+rs1.getString(2);
					return append;
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("excepton in dao class");
				} finally {
					if (con != null) {
						con.close();
					}
					if (rs != null) {
						rs.close();
					}
					if (ps != null) {
						ps.close();
					}

				}
				return null;
			}
		
		//View the Patient by HCP for updating
		
		public ArrayList<Patient> updatePatientProfile(String loginid) {
			// TODO Auto-generated method stub
			//String viewHcpSql = "select * from e_patient e join e_patient_register_via_hcp h on e.pid=h.pid ";
			ArrayList<Patient>patientList=new ArrayList<Patient>();
			try {
				String updateProfileSQL = "select * from e_patient e join e_patient_register_via_hcp h on e.p_id=h.p_id where h.hcp_id=? ";
				con = DBUtil.getConnection();
				System.out.println("dao cvlass");
				ps=con.prepareStatement(updateProfileSQL);
				ps.setString(1, loginid);
				ResultSet rs9=ps.executeQuery();
				
				while(rs9.next()) 
				{
					Patient patient=new Patient();
					System.out.println("Entered rs true");
					patient.setPatientID(rs9.getString(1));
					patient.setFirstName(rs9.getString(2));
					patient.setLastName(rs9.getString(3));
					patient.setGender(rs9.getString(4));
					patient.setAge(rs9.getString(5));
					patient.setAddress(rs9.getString(6));
					patient.setContactNo(rs9.getString(7));
					patient.setHealthInsuranceNo(rs9.getString(8));
					patient.setBill(rs9.getString(9));
					patient.setMedicalComplaint(rs9.getString(13));
					patient.setReferDoctor(rs9.getString(14));
					System.out.println("After creation");
					patientList.add(patient);
				}
				return patientList;
			}catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					ps.close();
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return null;
			
		}

		
		//Display the form for Updating the patient Details via HCP
		
		
		public Patient updateNewProfilePatient(String patientid) {
			// TODO Auto-generated method stub
			try {
				Patient patient=new Patient();
				con = DBUtil.getConnection();
				System.out.println("dao cvlass");
				ps = con.prepareStatement("select * from e_patient e1 join e_patient_register_via_hcp h1 on e1.p_id=h1.p_id where e1.p_id=?");
				ps.setString(1, patientid);
				ResultSet rs9=ps.executeQuery();
				while(rs9.next())
				{
				patient.setPatientID(rs9.getString(1));
				patient.setFirstName(rs9.getString(2));
				patient.setLastName(rs9.getString(3));
				patient.setGender(rs9.getString(4));
				patient.setAge(rs9.getString(5));
				patient.setAddress(rs9.getString(6));
				patient.setContactNo(rs9.getString(7));
				patient.setHealthInsuranceNo(rs9.getString(8));
				patient.setBill(rs9.getString(9));
				patient.setMedicalComplaint(rs9.getString(13));
				patient.setReferDoctor(rs9.getString(14));
			//	System.out.println(patient.getMedicalComplaint());
				}
				return patient;
			}catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					ps.close();
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
				return null;
		}
		
		
		
		//finally update the Patient profile by HCP after displaying the details of the Patient
		
		
		
		public String finalUpdate(Patient patient,String patientid) 
		{
			// TODO Auto-generated method stub
			String success=null;
			try {
				con = DBUtil.getConnection();
				System.out.println("dao cvlass update");

				ps = con.prepareStatement("UPDATE e_patient SET first_name=?,last_name=?,gender=?,age=?,address=?,contact_number=?,health_insurance_number=?,bill=? where p_id=?" );
				psfinal=con.prepareStatement("update e_patient_register_via_hcp set medical_complaint=?,refer_doctor=? where p_id=?");
				//ps.setString(1, patient.getPatientID());
				ps.setString(1, patient.getFirstName());
				ps.setString(2, patient.getLastName());
				ps.setString(3, patient.getGender());
				ps.setString(4, patient.getAge());
				ps.setString(5, patient.getAddress());
				ps.setString(6, patient.getContactNo());
				ps.setString(7, patient.getHealthInsuranceNo());
				ps.setString(8, patient.getBill());
				psfinal.setString(1, patient.getMedicalComplaint());
				psfinal.setString(2, patient.getReferDoctor());
				ps.setString(9, patientid);
				psfinal.setString(3,patientid);
				int x=ps.executeUpdate();
				int y=psfinal.executeUpdate();
				if(x>0 || y>0)
				{
					 success = "ok";
				}
				else
				{
					success="Failure";
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			} finally
			{
				try
				{
					ps.close();
					con.close();
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		return success;		
		}

		//Displaying the patients to HCP while deleting the Patient
		
		
		public ArrayList<Patient> deletePatientviaHCP(String loginid) 
		{
			// TODO Auto-generated method stub
			ArrayList<Patient>patientList=new ArrayList<Patient>();
			try {
				String deleteProfileSQL = "select * from e_patient e join e_patient_register_via_hcp h on e.p_id=h.p_id where h.hcp_id=? ";
				con = DBUtil.getConnection();
				System.out.println("dao cvlass");
				ps=con.prepareStatement(deleteProfileSQL);
				ps.setString(1, loginid);
				ResultSet rs9=ps.executeQuery();
				
				while(rs9.next()) 
				{
					Patient patient=new Patient();
					System.out.println("Entered rs true");
					patient.setPatientID(rs9.getString(1));
					patient.setFirstName(rs9.getString(2));
					patient.setLastName(rs9.getString(3));
					patient.setGender(rs9.getString(4));
					patient.setAge(rs9.getString(5));
					patient.setAddress(rs9.getString(6));
					patient.setContactNo(rs9.getString(7));
					patient.setHealthInsuranceNo(rs9.getString(8));
					patient.setBill(rs9.getString(9));

					patient.setMedicalComplaint(rs9.getString(13));
					patient.setReferDoctor(rs9.getString(14));
					System.out.println("After creation");
					patientList.add(patient);
				}
				return patientList;
			}catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					ps.close();
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return null;
		}
		
		//Deleting the Patient by HCP by entering either the Patient ID or phone number
		
		
		
		public String deleteNewPatient(String patientid) 
		{
			// TODO Auto-generated method stub
			String success="no records found";
			try {
				System.out.println("In delete new patient dao class");
				String deleteNewE_PatientSQL = "delete from e_patient  where p_id=?";
				String deleteNewE_patient_login_SQL="delete from e_patient_login where p_id=?";
				String deleteNewE_patient_register_via_hcp_SQL="delete from e_patient_register_via_hcp where p_id=?";
				String deleteNewE_dependents_SQL="delete from e_dependents where p_id=?";	
				con = DBUtil.getConnection();
				System.out.println("dao cvlass");
				ps=con.prepareStatement(deleteNewE_PatientSQL);
				ps4=con.prepareStatement(deleteNewE_dependents_SQL);
				ps3=con.prepareStatement(deleteNewE_patient_register_via_hcp_SQL);
				ps2=con.prepareStatement( deleteNewE_patient_login_SQL);
				ps2.setString(1, patientid);
				ps3.setString(1, patientid);
				ps4.setString(1, patientid);
				ps.setString(1, patientid);
				int i=ps4.executeUpdate();
				int j=ps3.executeUpdate();
				int k=ps2.executeUpdate();
				int l=ps.executeUpdate();
				if(i>0||j>0||k>0||l>0)
				{
					success="Deleted Successfully";
				}
				else
				{
					success="No records found";
				}
			}catch (Exception e) {
				
				e.printStackTrace();
			} finally {
				try {
					ps.close();
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return success;
		}
		
		//change Password of HCP via HCP
		
		public String changePasswordviahcp(String hcp_id, PatientSecurity psec)
		
		{
			// TODO Auto-generated method stub
	//changing the password here
			con=DBUtil.getConnection();
			try {
				PreparedStatement ps=con.prepareStatement("update e_hcp_login set password=? where hcp_id=?");
			ps.setString(1,psec.getNewPwd());
			ps.setString(2,hcp_id);
			ps.executeUpdate();
			return "ok";
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "notok";
			}
			
			
		}
		
		//check old password of HCP so that we can verify that he or she is the right user for changing the password
		
		public String checkoldpasswordviahcp(String pid, String oldpwd) {
			// TODO Auto-generated method stub
			con=DBUtil.getConnection();
			PreparedStatement ps;
			try {
				ps = con.prepareStatement("select password from e_hcp_login where hcp_id=?");
				ps.setString(1,pid);
				
				ResultSet rs=ps.executeQuery();
				String old_password=null;
				while(rs.next())
				{
					 old_password=rs.getString(1);
				}
				if(old_password.equals(oldpwd))
				{
					//means he or she can now change password or is a authentic user
					return "ok";
					//
				}
				else
				{
					return "notok";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
		}
		
		//Setting the Security Question and Security Answer for the HCP
		
		
		public String setSecurityviahcp(PatientSecurity psec, String pid) {
			// TODO Auto-generated method stub
			//insert the security question and answer here into the database
			con=DBUtil.getConnection();
			
			try {
				PreparedStatement ps=con.prepareStatement("update e_hcp_login set security_question=?,security_answer=? where hcp_id=?");
				ps.setString(1,psec.getSecurityQuestion());
				ps.setString(2,psec.getSecurityAnswer());
				ps.setString(3,pid);
				ps.executeUpdate();
				return "ok";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "notok";
			}
			
		
		}
		
		
		//Used for Searching the LabService Providers in the Dummy database that we have
		
		
		
		public ArrayList<Search_bean> searchPatient(String search)
		{
			ArrayList<Search_bean> arsearch=new ArrayList<Search_bean>();
			Connection con=null;
			con=DBUtil.getConnection();
			
			//simple search functionality 
			//like it will match only city='Hyderabad'  will give result but when they compare city='hyderabad'
			//now i will use like pattern 
			//here i will perform searching and other things
			search="%"+search+"%";
			try {
				PreparedStatement ps=con.prepareStatement("select r.name,r.address,r.state,r.city,s.test_name,s.test_code,s.test_description,s.cost_of_the_test,s.lab_or_home from e_lab_service_providers r inner join e_lab_service s on s.lab_id=r.lab_id where r.city like ? or r.name like ? or s.test_name like ? or s.test_description like ?");
				ps.setString(1,search);
				ps.setString(2,search);
				ps.setString(3,search);
				ps.setString(4,search);
				ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Search_bean s=new Search_bean();
				s.setLab_service_provider_name(rs.getString(1));
				s.setAddress(rs.getString(2));
				s.setState(rs.getString(3));
				s.setCity(rs.getString(4));
				s.setTest_name(rs.getString(5));
				s.setTest_code(rs.getString(6));
				s.setTest_description(rs.getString(7));
				s.setCost_of_the_test(rs.getInt(8));
				s.setLaborhome(rs.getString(9));
				arsearch.add(s);
				
				
			}
				//new_pid is the new patient ID which now can be stored in the database
				

				
				
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return arsearch;
		
		}
		
		
		//Used for Viewing the Schedule for the Particular Lab ...this feature is only available to Patient and HCP
		
		public ArrayList<View_Schedule> view_schedule(String test_name,String lab_service_provider,String city)
		{
			ArrayList<View_Schedule> vs=new ArrayList<View_Schedule>();
			View_Schedule v1=null;
			Connection con=null;
			con=DBUtil.getConnection();
			try
			{
				PreparedStatement ps=con.prepareStatement("select * from  e_lab_schedule where test_name=? and lab_service_provider_name=? and city=?");
				ps.setString(1,test_name);
				ps.setString(2,lab_service_provider);
				ps.setString(3,city);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					View_Schedule v=new View_Schedule();
					v.setTest_code(rs.getString(1));
					v.setTest_name(rs.getString(2));
					v.setSchedule_date(rs.getString(3));
					v.setSchedule_duration(rs.getString(4));
					v.setCity(rs.getString(5));
					v.setLab_service_provider_name(rs.getString(6));
					vs.add(v);
					
				}
				
				}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return vs;
		}
		
		//Used for Viewing the Sorted LSP Providers based on cost,city and particular Lab Service Providers
		
		public ArrayList<Search_bean> sortedResults()
		{
			ArrayList<Search_bean> ar=new ArrayList<Search_bean>();
			Connection con=null;
			con=DBUtil.getConnection();
			try
			{
				//try
			//	{
				//	PreparedStatement ps1=con.prepareStatement("select name from e_lab_service_providers");
				//	ResultSet rs1=ps1.executeQuery();
				//	while(rs1.next())
				//	{
				
				PreparedStatement ps=con.prepareStatement("select r.name,r.address,r.state,r.city,s.test_name,s.test_code,s.test_description,s.cost_of_the_test,s.lab_or_home from e_lab_service_providers r  inner join e_lab_service s on s.lab_id=r.lab_id where s.test_name  like '%test%' and r.name in (select name from e_lab_service_providers) order by s.cost_of_the_test");
				
				//System.out.println("Wow!");
				ResultSet rs=ps.executeQuery();
				while(rs.next())
					
				{	
					//System.out.println("Singh");
					Search_bean s=new Search_bean();
					s.setLab_service_provider_name(rs.getString(1));
					s.setAddress(rs.getString(2));
					s.setState(rs.getString(3));
					s.setCity(rs.getString(4));
					s.setTest_name(rs.getString(5));
					s.setTest_code(rs.getString(6));
					s.setTest_description(rs.getString(7));
					s.setCost_of_the_test(rs.getInt(8));
					s.setLaborhome(rs.getString(9));
					ar.add(s);
					
				}
				
			//	}
					
				//}
					//catch(Exception e)
				//	{
				////		e.printStackTrace();
				//	}
				}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return ar;
		}
		
		
		//LSP registration is done here
		
		public String LspService(LSP lsp)
		{
			String msg=null;
			
			
			con=DBUtil.getConnection();
			try
			{
				
				PreparedStatement ps=con.prepareStatement("insert into e_lsp values(?,?,?,?,?)");
				ps.setString(1,lsp.getLsp_name());
				ps.setString(2,"lsp1");
				ps.setString(3,lsp.getLsp_email());
				ps.setString(4,lsp.getLsp_contact());
				ps.setString(5,lsp.getLsp_address());
				
				ps.executeUpdate();
				return "ok";
				
				

							
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
						return "notok";
		}


		

}