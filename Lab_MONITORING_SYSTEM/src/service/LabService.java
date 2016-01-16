package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import bean.Dependent;
import bean.Hcp;
import bean.HcpLogin;
import bean.LSP;
import bean.Login;
import bean.Patient;
import bean.PatientSecurity;
import bean.Search_bean;
import bean.View_Schedule;
import dao.LabDAO;

public class LabService {
	String password;
																LabDAO da=new LabDAO();  //belongs to dependent module																
	/////Generate Password for Patient registering himself
																	
	
	
		public String generatePassword(){
	
								Random g=new Random();
								int upper_case=g.nextInt((90-65)+1)+65;
								int lower_case=g.nextInt((122-97)+1)+97;
								int special_case=g.nextInt((47-33)+1)+33;
								int number_case=g.nextInt((57-48)+1)+48;
									int upper_case1=g.nextInt((90-65)+1)+65;
									int lower_case1=g.nextInt((122-97)+1)+97;
									int special_case1=g.nextInt((47-33)+1)+33;
									int number_case1=g.nextInt((57-48)+1)+48;
								char upper_case_char=(char)upper_case;
								char lower_case_char=(char)lower_case;
								char number_case_char=(char)number_case;
								char special_case_char=(char)special_case;
								char upper_case_char1=(char)upper_case1;
								char lower_case_char1=(char)lower_case1;
								char number_case_char1=(char)number_case1;
								char special_case_char1=(char)special_case1;
								char password_array[]=new char[8];
								password_array[0]=upper_case_char;
								password_array[1]=lower_case_char;
								password_array[2]=number_case_char;
								password_array[3]=special_case_char;
								password_array[4]=upper_case_char1;
								password_array[5]=lower_case_char1;
								password_array[6]=special_case_char1;
								password_array[7]=number_case_char1 ;
								password=new String(password_array);
								return password;
	}
	
	
	
	///add the patient to the database when patient registers himself
	public String addPatient(Patient bean){
		// TODO Auto-generated method stub
		LabDAO dao = new LabDAO();
		String pid=dao.addPatient(bean,password);
		return pid;
		
	}
	
	///HCP registraion when HCP registers himself
	public HcpLogin createHcp(Hcp hcp) throws SQLException
	{
		// TODO Auto-generated method stub
		System.out.println("In Service");
		LabDAO hcpdao=new LabDAO();
		HcpLogin hl=new HcpLogin();
		hl=hcpdao.createHcp(hcp,password);
		return hl;

	}
	
	//Login Patient 
	
	public String loginPatient(String pid,String password)
	{
		String msg=null;
		LabDAO dao=new LabDAO();
		try {
			msg=dao.patientLogin(pid,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}
	
	//HCP Logins here
	
	public String validateLogin(Login login) {
		// TODO Auto-generated method stub
		 LabDAO hcpdao=new LabDAO();
		 String success=hcpdao.validateLogin(login);
		//.out.println(success.getSuccess());
		return success;
	}
	
	//Patient forgets Password
	
	public String checkPatient(PatientSecurity psec, String pid) {
		// TODO Auto-generated method stub
		
		LabDAO da=new LabDAO();
		String msg=da.checkPatient(psec,pid);
		return msg;
		
	}
	//when User answers right security question and answer
	
	public String changepassword(String pid,PatientSecurity psec) {
		LabDAO da=new LabDAO();
		String msg=da.changePassword(pid,psec);
		return msg;
	}
	//When HCp forgets the password
	
	public String checkHCP(PatientSecurity psec, String pid) {
		// TODO Auto-generated method stub
		
		LabDAO da=new LabDAO();
		String msg=da.checkHCP(psec,pid);
		return msg;
		
	}
	
	//When HCP gives right security Question and answers
	
	public String hcpchangepassword(String pid,PatientSecurity psec) {
		LabDAO da=new LabDAO();
		String msg=da.hcpchangePassword(pid,psec);
		return msg;
	}
	
	//View the Patient details or profile by Patient or himself
	
	public Patient viewPatients(String pid) {
		// TODO Auto-generated method stub
		LabDAO dao=new LabDAO();
		Patient p=new  Patient();
		try {
			p=dao.viewPatients(pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
	}
	
	//Update Patient details to the database after showing him the updatePatient form
	
	public String updatePatient(Patient p,String pid)
	{
		String msg=null;
		LabDAO da=new LabDAO();
		try {
			 msg=da.updatePatientDetails(p,pid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}
	
	//add dependent details or register Dependent
	
	
	   
	 public String addDependent(String p_id,Dependent d) throws SQLException{
		 return da.addDependent(p_id,d);
	 }
	 //Update the Dependent details
	 
	 
	 public int updateDependent(Dependent d,String id ) throws SQLException{
		 return da.updateDependent(d,id);
	 }
	 
	 //View the dependent details here
	 
	 public ArrayList<Dependent> viewDependent(String p_id) {
		 return da.viewDependent(p_id) ;
	 }
	 
	 //check Old password while changing password for patient
	 
		public String checkoldpassword(String pid, String oldpwd) {
			
			LabDAO dao=new LabDAO();
			String msg=dao.checkoldpassword(pid,oldpwd);
			
			// TODO Auto-generated method stub
			return msg;
		}
		
		//Set the security Question and answer for the Patient
		
		public String setSecurity(PatientSecurity psec, String pid) {
			// TODO Auto-generated method stub
			//Call the DAO method here 
			String msg=null;
			LabDAO dao=new LabDAO();
			msg=dao.setSecurity(psec,pid);
			return msg;
			
		}
		
		//Delete the patient Profile by patient himself
		
		public String deletePatient(String pid)
		{
			LabDAO dao=new LabDAO();
			String msg=null;
			try {
				msg = dao.deletePatient(pid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return msg;
			
		}
		
		//View the HCP service Profile by HCP himself
		
		 public ArrayList<Hcp> viewHcp(String hcpid)throws SQLException
		 {
			 LabDAO hcpdao=new LabDAO();
			ArrayList<Hcp> hcpList = hcpdao.viewHcp(hcpid);
			System.out.println("flow in back");
			return hcpList;
		}
		 
		 //Display the details to Update the HCP profile by HCP
		 
		 public Hcp updatehcpProfile(String loginId) {
				// TODO Auto-generated method stub
				LabDAO hcpdao=new LabDAO();
				Hcp hcp=new Hcp();
				hcp=hcpdao.updatehcpProfile(loginId);
				return hcp;
			}
		 
		 //Update the HCP profile by HCP
		 public String updateNew(Hcp hcp,String loginid) {
				// TODO Auto-generated method stub
				LabDAO hcpdao=new LabDAO();
				String success=hcpdao.updateNew(hcp,loginid);
				return success;
			}
		 
		 //Add patient by HCP
		 

			public String registerPatientviahcp(Patient patient,String loginid) {
				// TODO Auto-generated method stub
				LabDAO pdao=new LabDAO();
				String success=null;
				try {
					success = pdao.registerPatientviahcp(patient,loginid);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return success;
			}
			
			//view the Patient Profile by HCP for updating
			
			public ArrayList<Patient> updatePatientProfile(String loginid) {
				// TODO Auto-generated method stub
				ArrayList<Patient>patientList=new ArrayList<Patient>();
				LabDAO patientdao=new LabDAO();
				patientList=patientdao.updatePatientProfile(loginid);
				return patientList;
			
			}//Display the form for Updating the patient Details via HCP
			
			
			public Patient updateNewProfilePatient(String patientid)
			{
				// TODO Auto-generated method stub
				Patient patient=new Patient();
				LabDAO patientdao=new LabDAO();
				patient=patientdao.updateNewProfilePatient(patientid);
				return patient;
			}
			
			
			
			//finally update the Patient profile by HCP after displaying the details of the Patient
			
			
			
			public String finalUpdate(Patient patient,String patientid) {
				// TODO Auto-generated method stub
				LabDAO patientdao=new LabDAO();
				
				String success=patientdao.finalUpdate( patient,patientid);
				return success;
			}
			
			
			
			//Displaying the patients to HCP while deleting the Patient
			
			
			public ArrayList<Patient> deletePatientviaHCP(String loginid) {
				// TODO Auto-generated method stub
				ArrayList<Patient> patientList=new ArrayList<Patient>();
				LabDAO patientdao=new LabDAO();
				patientList=patientdao.deletePatientviaHCP(loginid);
				return patientList;
			}
			
			
			//Deleting the Patient by HCP by entering either the Patient ID or phone number
			
			
			public String deleteNewPatient(String patientid) {
				// TODO Auto-generated method stub
				LabDAO patientdao=new LabDAO();
				String success=patientdao.deleteNewPatient(patientid);
				return success;
			}
			
			//change password Via HCP for HCP
			
			public String changepasswordviahcp(String pid,PatientSecurity psec) {
				LabDAO da=new LabDAO();
				String msg=da.changePasswordviahcp(pid,psec);
				return msg;
			}
			
			
			//check old password of HCP so that we can verify its the right user that is changing password
			
			public String checkoldpasswordviahcp(String pid, String oldpwd) {
				
				LabDAO dao=new LabDAO();
				String msg=dao.checkoldpasswordviahcp(pid,oldpwd);
				
				// TODO Auto-generated method stub
				return msg;
			}
			
			//setting the Security Question and Security Answer for the HCP
			
			public String setSecurityviahcp(PatientSecurity psec, String pid) {
				// TODO Auto-generated method stub
				//Call the DAO method here 
				String msg=null;
				LabDAO dao=new LabDAO();
				msg=dao.setSecurityviahcp(psec,pid);
				return msg;
				
			}
			
			//Used for searching the LSP from the Dummy database
			
			public ArrayList<Search_bean> searchPatient(String search)
			{
				ArrayList<Search_bean> arsearch=new ArrayList<Search_bean>();
			
				LabDAO dao=new LabDAO();
				arsearch=dao.searchPatient(search);
				
				return arsearch;
			}
			
			//Used for View Schedule in the LSP results only for Patient and LSP
			
			
			
			public ArrayList<View_Schedule> view_schedule(String test_name,String lab_service_provider,String city)
			{
				//View_Schedule v1=null;

				LabDAO dao=new LabDAO();
				ArrayList<View_Schedule> vs=new ArrayList<View_Schedule>();
				vs=dao.view_schedule(test_name,lab_service_provider,city);
				return vs;
				
			}
			
			//Used for Viewing the result of the LSP based on cost sorting is done ..available only for HCP
			
			public ArrayList<Search_bean> sortedResults()
			{
				ArrayList<Search_bean> ar=new ArrayList<Search_bean>();
				LabDAO da=new LabDAO();
				ar=da.sortedResults();
				
				return ar;
			}
			
			
			//LSP registration is done here
			
			
			public String LspService(LSP lsp)
			{
				
				LabDAO da=new LabDAO();

				String msg=da.LspService(lsp);
				return msg;
			}
			
			


}
