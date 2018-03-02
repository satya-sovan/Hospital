package com.hospital.doc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hospital.dao.HospitalDAO;
import com.hospital.javabeen.HospitalBO;
import com.hospital.javabeen.HospitalDTO;

public class DocService {
	@SuppressWarnings("deprecation")
	public List<HospitalDTO> docDataRetrive(HospitalDTO dto) {
		HospitalDAO dao=HospitalDAO.getInstance();
		HospitalBO bo=new HospitalBO();
		bo.setDocId(dto.getDocId());
		List<HospitalBO> listBO=new ArrayList<HospitalBO>();
		List<HospitalDTO> listDTO=new ArrayList<HospitalDTO>();
		
		try {
			System.out.println("in side DocService : "+dto.getDocId());
			listBO=dao.getDocDetails(bo);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(HospitalBO BO:listBO ) {
			HospitalDTO DTO=new HospitalDTO();
			DTO.setPatName(BO.getPatName());
			DTO.setSymptoms(BO.getSymptoms());
			DTO.setApoDate(BO.getApoDate().toLocaleString());
			DTO.setDocName(BO.getDocName());
			listDTO.add(DTO);
		}
		return listDTO;
	}
}
