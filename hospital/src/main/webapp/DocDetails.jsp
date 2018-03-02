<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.hospital.javabeen.HospitalDTO"%>
<%@page import="com.hospital.doc.DocService"%>
<%@page import="java.util.List" import="java.util.ArrayList"%>
<jsp:useBean id="dto" class="com.hospital.javabeen.HospitalDTO"></jsp:useBean>
<jsp:setProperty name="dto" property="docId" param="doc-id" />
<%	List<HospitalDTO> listDTO=new ArrayList<HospitalDTO>();
    DocService service=new DocService();
    System.out.println("in jsp : "+dto.getDocId());
    
    listDTO=service.docDataRetrive(dto);
    
    //dto=listDTO.get(1);
    
    	%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Doctor details</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="bootstrap/css/extra.css">
<link rel="stylesheet" href="bootstrap/css/PatDetails.css">
<link rel="stylesheet" type="text/css" href="login.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div id="" class="header">
				<p align="center">
					<span class="title">Hospital.com</span>
				</p>
			</div>
		</div>

		<div class="row">
			<div class="panel panel-default">
				<div class="panel-heading">
					<span class="pat-name"><strong><u>Welcome <%=dto.getDocName()%></u></strong></span>
				</div>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Pat-Name</th>
							<th>Symptoms</th>
							<th>Apo-Date</th>
						</tr>
					</thead>
					<tbody>
						<%for(HospitalDTO DTO:listDTO){ %>
						<tr>
							<td><%DTO.getPatName(); %></td>
							<td><%DTO.getSymptoms(); %></td>
							<td><%DTO.getApoDate(); %></td>
						</tr>
						<%} %>
						</tbody>
						</table>
			</div>
		</div>

		<div class="row">
			<div align="center" id="" class="footer">
				<hr>
				<p>
					<span class="end">Thankyou for visiting Hospital.com</span>
				</p>
				<p>
					<span class="end">&copy; Copy Right by Hospital.com</span>
				</p>
			</div>
		</div>
	</div>
</body>
</html>