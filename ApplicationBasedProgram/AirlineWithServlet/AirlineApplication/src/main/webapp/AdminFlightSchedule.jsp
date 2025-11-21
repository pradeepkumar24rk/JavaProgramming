<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import= "models.FlightScheduleModel" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<style type="text/css">
		body {
		  margin: 0;
		  padding: 0;
		}
		
		.container {
		
				display:flex;
		  justify-content: center;
		  align-items: center;
		  flex-direction:column;
		}
		
		#table_div {
			padding:20px;
			margin-bottom:20px;
		}
		
		#table_div > table {
		  font-family: arial, sans-serif;
		  border-collapse: collapse;
		}
		
		td {
		  border: 1px solid teal;
		  padding: 20px;
		}
		
		th {
		  border: 1px solid white;
		  padding: 20px;
		   text-transform: capitalize;
		}
		
		tr:nth-child(1) {
		  background-color: teal;
		  color: white;
		}
		
		.operation_buttons {
			display:flex;
		  justify-content: center;
		  align-items: center;
		  gap:10px;
		}
		.btn {
		  padding: 8px;
		    border: none;
		    cursor: pointer;
		    background-color: dodgerblue;
		    color: white;
		    border-radius:5px;
		}
		
		.btn:hover {
		    background-color: #0047ab;
		}
		
		.cancel_btn {
			all:unset;
			 padding: 8px;
		    border: none;
		    cursor: pointer;
		    background-color: red;
		    color: white;
		    border-radius:5px;
		    
		}
		.cancel_btn:hover {
		    background-color: #ab0000;
		}
		.container_input {
			display:flex;
		 	justify-content: center;
		  	align-items: center;
		  	gap:10px;
		}
		
		
		
	</style>
	
	<script>
		const setAction = (actionType) => {
			document.getElementById("actionInput").value = actionType;		
		}
		
	</script>
	
	
</head>

<body>

	
	

	<div class="container">
      <h3 id="trip_title">Flight Schedule Details</h3>
      <form class="container_input" method="post" action="adminFlightScheduleController">
			<input type="text" placeholder="Enter flightID" name="flightId"/>
			<input type="date" name="dataOfTravel" />
			<button class="btn" type="submit" style="width: 84px; ">Add</button>
	</form>
		<div id="table_div">
	      <table id="table">
	        <tr>
	          <th>ID</th>
	          <th>Flight ID</th>
	          <th>Date Of Travel</th>
	          <th>Bussiness Count</th>
	          <th>Economy Count</th>
	          <th>Executive Count</th>
	          <th>Cancellation</th>
	          
	        </tr>
	        <% ArrayList<FlightScheduleModel> flightScheduleList = (ArrayList<FlightScheduleModel>) request.getAttribute("flightSchedule");
	        	if(flightScheduleList!=null) {
	        		for(FlightScheduleModel fsarr:flightScheduleList) {
	        %>
	        <tr>
	        	<td><%=fsarr.flightScheduleId() %></td>
	        	<td><%=fsarr.getFlightId() %></td>
	        	<td><%=fsarr.getDateOfTravel() %></td>
	        	<td><%=fsarr.getBussinessClassBookingCount() %></td>
	        	<td><%=fsarr.getExecutiveClassBookedCount() %></td>
	        	<td><%=fsarr.getEconomyClassBookedCount() %></td>
	        	
	        	<td><a class='cancel_btn' href="adminFlightScheduleController?scheduleId=<%=fsarr.flightScheduleId()%>" name="cancel_operation" >Cancel</a></td>
	        </tr>
	        <%
	        		}
	        	} else {
	        	
	        %>
	        <tr >
	        <td colspan="1000">
	        	No data available
	        </td>
	        </tr>
	        <%} %>
	      </table>
	      <input type="hidden" name='action' id='actionInput' />
	    </div>
	    
	    <% String message = (String) request.getAttribute("message");
	    	String type = (String) request.getAttribute("type");
	    %>
		<% if (message != null && type.equals("success")) { %>
		    <div style="color: green; font-weight: bold;margin-bottom: 10px;"><%= message %></div>
		<% } else if(message != null && type.equals("fail")) { %>
			<div style="color: red; font-weight: bold;margin-bottom: 10px;"><%= message %></div>
		<%} %>
		
	</div>
	
</body>
</html>