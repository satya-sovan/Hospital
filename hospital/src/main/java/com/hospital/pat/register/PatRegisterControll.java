package com.hospital.pat.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.javabeen.HospitalDTO;
import com.hospital.javabeen.HospitalVO;
import com.hospital.pat.PatService;

//@WebServlet("PatRegisterControll")
public class PatRegisterControll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HospitalVO vo=new HospitalVO();
		HospitalDTO dto=new HospitalDTO();
		PatService service=new PatService();
		
		//General Setting
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		
		//store request data to BO class
		vo.setPatName(request.getParameter("first-name").trim()+"@"+request.getParameter("last-name").trim());
		vo.setDocId(request.getParameter("doc-id").trim());
		
		vo.setPatPhNo(request.getParameter("patPhNo").trim());
		vo.setSymptoms(request.getParameter("symptoms").trim());
		
		//store bo data to dto
		
		dto.setPatName(vo.getPatName());
		dto.setPatPhNo(Long.parseLong(vo.getPatPhNo()));
		dto.setSymptoms(vo.getSymptoms());
		dto.setApoDate(vo.getApoDate());
		dto.setDocId(vo.getDocId());
		
		try {
			if(service.insert(dto)) {
				
				RequestDispatcher rd=request.getRequestDispatcher("PatDetaile.jsp");
				rd.include(request, response);
				pw.println("<script>alert('register successfull')</script>");
				
				
			}
			else {
				
				RequestDispatcher rd=request.getRequestDispatcher("PatDetaile.jsp");
				pw.println("<script>alert('register failed')</script>");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
		@SuppressWarnings("finally")
		protected java.sql.Date getDate(String date){
			SimpleDateFormat sfd=null;
			Date rd = null;
			try {
				sfd=new SimpleDateFormat("dd-MM-yyyy");
				
			} catch (Exception e) {
				try {
					sfd=new SimpleDateFormat("yyyy-MM-dd");
				} catch (Exception e1) {
					sfd=new SimpleDateFormat("dd-MMM-yy");
				}
			}finally {
				try {
					rd=sfd.parse(date);
					return new java.sql.Date(rd.getTime());
				} catch (final ParseException e) {
					e.printStackTrace();
				}
				return new java.sql.Date(rd.getTime());
			}
		} 
}
