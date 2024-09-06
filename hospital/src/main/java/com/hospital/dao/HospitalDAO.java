package com.hospital.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hospital.javabeen.HospitalBO;
import com.hospital.util.DBUtill;

/**
 *test
 */
public class HospitalDAO {
	
	//Private_Constructor
	private HospitalDAO() {
		super();
	}

	//Variable_Declarations
	private static volatile HospitalDAO hospitalDAO;
	PreparedStatement ps = null;

	
	//Instance_Method return HospitalDAO class Object
	public static HospitalDAO getInstance() {
		if (hospitalDAO == null) {
			synchronized (HospitalDAO.class) {
				if (hospitalDAO == null) {
					hospitalDAO = new HospitalDAO();
				}
			}
		}
		return hospitalDAO;
	}

	//DataBase_Connection method returns Connection Object
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(DBUtill.driver);
			con = DriverManager.getConnection(DBUtill.url, DBUtill.user_name, DBUtill.password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	//Insert_Method to insert pat details to data base
	public boolean insert(HospitalBO bo) throws SQLException {
		int insertFlag = 0;
		// insert into apo_table(pat_name,pat_ph_no,symptoms,doc_id,apo_date) values(,,,,);
		try {
			ps = HospitalDAO.getConnection().prepareStatement("insert into apo_table values(?,?,?,?,?,?)");
			ps.setString(1, bo.getPatName());
			ps.setLong(2, bo.getPatPhNo());
			ps.setString(3, bo.getSymptoms());
			ps.setDate(4, bo.getApoDate());
			ps.setString(5, bo.getPat_id());
			System.out.println(bo.getDocId());
			ps.setString(6, bo.getDocId());
			insertFlag = ps.executeUpdate();
			// System.out.println(bo.getPatName()+bo.getPatPhNo()+bo.getSymptoms()+bo.getDocId()+getApoDate());
			System.out.println(insertFlag);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null)
				ps.close();
			if (HospitalDAO.getConnection() != null)
				HospitalDAO.getConnection().close();
		}
		if (insertFlag >= 1)
			return true;
		return false;
	}

	//This method id used to get the next appointment date
	public java.sql.Date getApoDate(HospitalBO bo) {
		ResultSet rs = null;
		try {
			// SQL= (select apo_date,count(apo_date) from apo_table where apo_date between
			// sysdate and (select max(apo_date) from apo_table) group by apo_date order by
			// apo_date;)
			ps = HospitalDAO.getConnection().prepareStatement(
					"select apo_date,count(apo_date)  from apo_table where apo_date between sysdate-1 and (select max(apo_date) from apo_table) and  DOC_ID=? group by apo_date order by apo_date",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			ps.setString(1, bo.getDocId());
			rs = ps.executeQuery();

			while (rs.next()) {
				if (rs.getDate(1).toLocalDate().equals(java.time.LocalDate.now()) && rs.getInt(2) < 3) {
					if (java.time.LocalTime.now().isBefore(java.time.LocalTime.parse("10:00")))
						return rs.getDate(1);
				} else if (rs.getInt(2) < 3)
					return rs.getDate(1);
				else if (rs.isLast()) {
					if (rs.getDate(1).toLocalDate().plusDays(1).getDayOfWeek().toString().equalsIgnoreCase("SUNDAY"))
						return java.sql.Date.valueOf(rs.getDate(1).toLocalDate().plusDays(2));
					else
						return java.sql.Date.valueOf(rs.getDate(1).toLocalDate().plusDays(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (java.time.LocalTime.now().isBefore((java.time.LocalTime.parse("10:00")))
				&& !java.time.LocalDate.now().getDayOfWeek().toString().equalsIgnoreCase("SUNDAY")) {
			return java.sql.Date.valueOf(java.time.LocalDate.now());
		} else {
			return java.sql.Date.valueOf(java.time.LocalDate.now().plusDays(1));
		}

	}

	public boolean retrive(HospitalBO bo) throws SQLException {
		//sql="SELECT 	PAT.PAT_NAME,PAT.PAT_PH_NO,PAT.SYMPTOMS,PAT.DOC_ID,PAT.APO_DATE,PAT.PAT_ID,DOC.DOC_NAME	 FROM APO_TABLE PAT INNER JOIN DOC_TABLE DOC ON DOC.DOC_ID=PAT.DOC_ID WHERE PAT.PAT_PH_NO=? "
		ResultSet rs=null;
		ps=this.getConnection().prepareStatement("SELECT 	PAT.PAT_NAME,PAT.PAT_PH_NO,PAT.SYMPTOMS,PAT.APO_DATE,PAT.PAT_ID,DOC.DOC_NAME	 FROM APO_TABLE PAT INNER JOIN DOC_TABLE DOC ON DOC.DOC_ID=PAT.DOC_ID WHERE PAT.PAT_PH_NO=? ");
		
		if (ps!=null) {
			//ps.setString(1, bo.getPatName());
			ps.setLong(1, bo.getPatPhNo());
			rs = ps.executeQuery();
		}
		if(rs!=null) {
			while(rs.next()) {
				bo.setPatName(rs.getString(1));
				bo.setPatPhNo(rs.getLong(2));
				bo.setSymptoms(rs.getString(3));
				bo.setApoDate(rs.getDate(4));
				bo.setPat_id(rs.getString(5));
				bo.setDocName(rs.getString(6));
				
				
			}
			
			return true;
		}
		
		return false;
	}

	public List<HospitalBO> getDocDetails(HospitalBO bo) throws SQLException {
		//sql="	SELECT PAT.PAT_NAME,PAT.SYMPTOMS,PAT.APO_DATE,DOC.DOC_NAME FROM APO_TABLE PAT INNER JOIN DOC_TABLE DOC ON PAT.DOC_ID=DOC.DOC_ID WHERE PAT.DOC_ID=? ORDER BY PAT.APO_DATE  "
		ps=HospitalDAO.getConnection().prepareStatement("	SELECT PAT.PAT_NAME,PAT.SYMPTOMS,PAT.APO_DATE,DOC.DOC_NAME FROM APO_TABLE PAT INNER JOIN DOC_TABLE DOC ON PAT.DOC_ID=DOC.DOC_ID WHERE PAT.DOC_ID=? ORDER BY PAT.APO_DATE ");
		ps.setString(1, bo.getDocId());
		System.out.println("inside HospitalDAO:: "+bo.getDocId());
		//create arrayList object
		List<HospitalBO> listBO=new ArrayList<HospitalBO>();
		
		//excute query
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			HospitalBO lbo=new HospitalBO();
			lbo.setPatName(rs.getString(1));
			lbo.setSymptoms(rs.getString(2));
			lbo.setApoDate(rs.getDate(3));
			lbo.setDocName(rs.getString(4));
			listBO.add(lbo);
			System.out.println("inside HospitalDAO:: "+rs.getString(1));
		}
		return listBO;
	}

}
