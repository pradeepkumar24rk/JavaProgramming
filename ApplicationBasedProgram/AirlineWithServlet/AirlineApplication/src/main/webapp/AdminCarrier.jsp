<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import= "models.CarrierModel" %>
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
		
		.operation_buttons{
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
	</style>
	
	<script>
		const setAction = (actionType) => {
			document.getElementById("actionInput").value = actionType;
			
		}
		
	</script>
	
	
</head>

<body>

	<form action="adminCarrierController" method="post" class="container">
      <h3 id="trip_title">Carrier Details</h3>
		<div id="table_div">
	      <table id="table">
	        <tr>
	          <th>ID</th>
	          <th>Name</th>
	          <th>discount 30 Days Advance Booking</th>
	          <th>discount 60 Days Advance Booking</th>
	          <th>discount 90 Days Advance Booking</th>
	          <th>bulk Booking Discount</th>
	          <th>refund 2 Day Before TravelDate</th>
	          <th>refund 10 Day Before TravelDate</th>
	          <th>refund 20 Day Before TravelDate</th>
	          <th>silver User Discount</th>
	          <th>gold User Discount</th>
	          <th>platinum User Discount</th>
	          <th>Edit</th>
	          <th>Delete</th>
	        </tr>
	        <% ArrayList<CarrierModel> carrierList = (ArrayList<CarrierModel>) request.getAttribute("carriers");
	        	if(carrierList!=null) {
	        		for(CarrierModel carr:carrierList) {
	        %>
	        <tr>
	        	<td><%=carr.getCarrierId() %></td>
	        	<td><%=carr.getCarrierName() %></td>
	        	<td><%=carr.getDiscountPercentageThirtyDaysAdvanceBooking() %></td>
	        	<td><%=carr.getDiscountPercentageSixtyDaysAdvanceBooking() %></td>
	        	<td><%=carr.getDiscountPercentageNinetyDaysAdvanceBooking() %></td>
	        	<td><%=carr.getBulkBookingDiscount() %></td>
	        	<td><%=carr.getRefundPercentageForTicketCancelling2DayBeforeTravelDate() %></td>
	        	<td><%=carr.getRefundPercentageForTicketCancelling10DayBeforeTravelDate() %></td>
	        	<td><%=carr.getRefundPercentageForTicketCancelling20DayBeforeTravelDate() %></td>
	        	<td><%=carr.getSilverUserDiscount() %></td>
	        	<td><%=carr.getGoldUserDiscount() %></td>
	        	<td><%=carr.getPlatinumUserDiscount() %></td>
	        	<td><input type="radio" name="edit_operation" value="<%=carr.getCarrierId()%>"></td>
	        	<td><input type="checkbox" name="delete_operation" value="<%=carr.getCarrierId()%>" ></td>
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
		
	<div class="operation_buttons">
		<button class="btn" type="button" style="width: 84px; ">Add</button>
		<button class="btn" onclick='setAction("edit")' type="submit" value="edit" style="width: 84px;">Edit</button>
		<button class="btn" onclick='setAction("delete")' type="submit" value="delete" style="width: 84px;">Delete</button>
	</div>
	</form>
	
</body>
</html>