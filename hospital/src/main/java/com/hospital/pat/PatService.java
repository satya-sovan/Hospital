package com.hospital.pat;

import java.sql.SQLException;
import java.util.Random;

import com.hospital.dao.HospitalDAO;
import com.hospital.javabeen.HospitalBO;
import com.hospital.javabeen.HospitalDTO;

public class PatService {
	HospitalBO bo=new HospitalBO();
	HospitalDAO dao= HospitalDAO.getInstance();
	
	public boolean insert(HospitalDTO dto) throws SQLException {
				
		bo.setPatName(dto.getPatName());
		bo.setPatPhNo(dto.getPatPhNo());
		bo.setSymptoms(dto.getSymptoms());
		bo.setDocId(dto.getDocId());
		bo.setPat_id(this.getPatId());
		bo.setApoDate(dao.getApoDate(bo));
		
		return dao.insert(bo);
		
	}

	public boolean retrive(HospitalDTO dto) throws SQLException {
		bo.setPatName(dto.getPatName());
		bo.setPatPhNo(dto.getPatPhNo());
		if(dao.retrive(bo)) {
			dto.setPatName(bo.getPatName().replace('@', ' '));
			dto.setPatPhNo(bo.getPatPhNo());
			dto.setSymptoms(bo.getSymptoms());
		 	dto.setApoDate(bo.getApoDate().toString());
			dto.setPat_id(bo.getPat_id());
			dto.setDocName(bo.getDocName());
			return true;
		}else
			return false;
		
	}
	
	public String getPatId() {
		String pat_id="";
		char[] c= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9','A'};
		for(int i=0;i<6;i++) {
			pat_id=pat_id+c[new Random().nextInt(36)];
		}
		return pat_id;
	}
}
