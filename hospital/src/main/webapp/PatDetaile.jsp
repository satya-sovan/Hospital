<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.hospital.pat.PatService" %>
<%@page import="com.hospital.javabeen.HospitalDTO" %>
<%
	PatService service=new PatService();
	
%>

<jsp:useBean scope="application" id="dto" class="com.hospital.javabeen.HospitalDTO"></jsp:useBean>

<jsp:setProperty name="dto" property="patPhNo" />
<%
	service.retrive(dto);
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pat Details</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="bootstrap/css/extra.css">
<link rel="stylesheet" href="bootstrap/css/PatDetails.css">
<link rel="stylesheet" type="text/css" href="login.css">
</head>
<body>
	<div id="" class="container">
		<div id="" class="row">
			<div id="" class="header">
				<p align="center"><span class="title">Hospital.com</span></p>
			</div>
		</div>
		<div id="" class="row">
			<div class="panel panel-default" id="bdy-panel">
				<div class="panel-heading"><span class="pat-name"><strong><u>Welcome <%=dto.getPatName()%></u></strong></span></div>
				<div class="panel-body">
					<div id="" class="bdy">
						<table>
						<tr>
							<td><span class="table-data">Pat. ID :-</span></td>
							<td class="table-data pat-id"><%=dto.getPat_id() %></td>
						</tr>
						<tr>
							<td><span class="table-data">Ph. No. :- </span></td>
							<td class="table-data"><%=dto.getPatPhNo() %></td>
						</tr>
						<tr>
							<td><span class="table-data">Symptoms :- </span></td>
							<td class="table-data"><%=dto.getSymptoms() %></td>
						</tr>
						<tr>
							<td><span class="table-data">Doctor :- </span></td>
							<td class="table-data"><%=dto.getDocName() %></td>
						</tr>
						<tr>
							<td><span class="table-data">Apo. Date :- </span></td>
							<td class="table-data"><%=dto.getApoDate() %></td>
						</tr>
						
						</table>
						
					</div>
				</div>
				<div class="panel-footer" aling="center"><span class="footer" align="center"><input type="button" value="Print" class="btn btn-success" onclick="window.print()"></span></div>
			</div>
		</div>
		<div id="" class="row">
			<div align="center"id="" class="footer">
				<hr>
				<p><span class="end">Thankyou for visiting Hospital.com</span></p>
				<p><span class="end">&copy; Copy Right by Hospital.com</span></p>
			</div>
		</div>
	</div>
</body>
</html>

<script>
	function printData()   //Copied from internet (https://stackoverflow.com/q/21375398/7803643)
	{
	   var divToPrint=document.getElementById("bdy-panel");
	   newWin= window.open("");
	   newWin.document.write(divToPrint.outerHTML);
	   newWin.print();
	   newWin.close();
	}
</script>