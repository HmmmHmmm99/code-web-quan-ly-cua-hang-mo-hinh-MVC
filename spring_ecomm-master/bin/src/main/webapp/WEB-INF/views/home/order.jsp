<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import="java.util.*" %>
<div class="">
	<ul class="breadcrumb">
		<li>
			<a href="/home">Home</a> <span class="divider">/</span>
		</li>
		<li ><a href="/cart">Cart</a> <span class="divider">/</span></li>
		<li class="active">Order</li>
	</ul>
	<h3>
		ORDER SUMMARY
	</h3>
	<hr class="soft">
	
	<div class="span8">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Product</th>
					<th>Description</th>
					<th>Quantity</th>
					<th>Price</th>
					<!-- <th>Discount</th>-->
					
					<th>Total</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="row" items="${cartProduct}">
					<tr>
						<td><img src="${pageContext.request.contextPath }/uploads/images/${row.item.path}" width="70px" alt="img"></td>
						<td><c:out value="${row.item.title}" /><br>Color : black, Material : metal</td>
						<td>
							<div class="">
								<input class="" style="max-width: 34px" placeholder="qty" value=<c:out value="${row.quantity}" /> 
									id="appendedInputButtons" size="16" type="number" required="required" min="1" step="any" value="1" disabled>
								
							</div>
						</td>
					<td>$<c:out value="${row.item.price}" /></td>
					<!-- <td>$25.00</td>-->
					<!-- <td>$15.00</td>  -->
					<td>$ <fmt:formatNumber type="number" maxFractionDigits="3" value="${row.quantity * row.item.price}" /></td>
				</tr>	
			</c:forEach>
				<tr>
					<td colspan="6" style="text-align: right">
						<strong>Qty</strong></td>
					<td class="label label-inverse" style="display: block"><strong>
							<fmt:formatNumber type="number" maxFractionDigits="3" value="${qty}" /> </strong></td>
				</tr>
				<tr>
					<td colspan="6" style="text-align: right">
						<strong>TOTAL</strong></td>
					<td class="label label-important" style="display: block"><strong>
							$<fmt:formatNumber type="number" maxFractionDigits="3" value="${total}" /> </strong></td>
				</tr>
				
			</tbody>
		</table>
		<table class="table table-bordered">
			<tbody>
				<tr>
					<th>ORDER SUMMARY</th>
				</tr>
				<tr>
					<td>
						<form class="form-horizontal" id="order-form">

							<div class="control-group">
								<label class="control-label"><strong> Full Name: </strong> </label>
								<div class="controls">
									<input name="name" type="text" class="input-medium" placeholder="Name" id="name-order">
									
								</div>
							</div>
							<div class="control-group">
								<label class="control-label"><strong> Phone: </strong> </label>
								<div class="controls">
									<input name="phone" type="tel" class="input-medium" placeholder="Phone" id="phone-order">
									
								</div>
							</div>
							<div class="control-group">
								<label class="control-label"><strong> Address: </strong> </label>
								<div class="controls">
									<input name="address" type="text" class="input-medium" placeholder="Address" id="address-order">
									
								</div>
							</div>
							<div class="control-group">
								<label class="control-label"><strong> Email: </strong> </label>
								<div class="controls">
								
									<% 
										String user = (String)session.getAttribute("username");
									%>
									<input name="email" type="email" class="input-medium" placeholder="Email" value=<%=session.getAttribute("username") %> id="email-order">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label"><strong> Date Order: </strong> </label>
								<div class="controls">
									<%java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd"); %>
									<input disabled name="date" diable type="text" class="input-medium" placeholder="Date"  value="<%= df.format(new java.util.Date()) %>" id="date-order">
									
								</div>
							</div>
							<div class="control-group">
								<label class="control-label"><strong> Quantity: </strong> </label>
								<div class="controls">
									<input disabled name="quantity" class="input-medium" type="text" placeholder="qty" value="<c:out value="${qty}"  />" id="quantity-order" >
								</div>
							</div>
							<div class="control-group">
								<label class="control-label"><strong> Total: </strong> </label>
								<div class="controls">
									<input disabled name="total" class="input-medium" type="text" placeholder="qty" value="<c:out value="${total}" />" id="total-order" >					
								</div>
							</div>
							<div class="control-group">
								<label class="control-label"><strong> Note: </strong> </label>
								<div class="controls">
									<input name="note" type="text" class="input-medium" placeholder="Note" id="note-order" id="note-order">
								</div>
							</div>
						</form>
					</td>
					<td>
						<form class="form-horizontal">
							<div class="control-group">
								<label class="control-label"><strong> VOURCHER: </strong> </label>
								<div class="controls">
									<input type="text" class="input-medium" placeholder="CODE">
									<%-- <span  class="btn btn-secondary"> Create order </span> --%>
									<button type="submit" class="btn btn-primary" style="margin-top:10px">ADD</button>
								</div>
							</div>
							
						</form>
					</td>
				</tr>
	
			</tbody>
		</table>
		
		<table class="table table-bordered">
			<tbody>
				<tr>
					<th>PAYMENT</th>
				</tr>
				<tr>
					<td>
						<form class="form-horizontal" method="post" action="/pay">
							<div class="control-group">

							</div>
							<div class="control-group">
								<label class="control-label" >Click to pay with Paypal </label>
								<label class="control-label"><strong> Total: </strong> </label>
								<div class="controls">
									<input name="price" type="text" placeholder="qty" value="${total}" id="total-order" >	
									<input name="price" type="hidden"  placeholder="qty" value="${paypal}" id="paypal" >					
								</div>
								
								<c:if test = "${paypal == 0}">
						        	<div class="controls">
										<button type="submit" class="btn btn-lg btn-primary">PAYPAL</button>
									</div>
						      	</c:if>
						      	
								<!-- <div class="controls">
									<button type="submit" class="btn btn-lg btn-primary">PAYPAL</button>
								</div> -->
								
								<c:if test = "${paypal == 1}">
						        	<div class="alert alert-success" style="margin-top:10px;">
								        <button type="button" class="close" data-dismiss="alert">×</button>
								        <strong>Well done!</strong> Your Paypal payment is successful.
								    </div>
						      	</c:if>
								
							</div> 
						</form>
					</td>
				</tr>
			</tbody>
		</table>
		<div class="row">
			<a href="/cart" class="btn btn-large"><i
				class="icon-arrow-left"></i> Back to cart </a> 
			<span  id="testform" href="/order-success" id="create-order"
				class="btn btn-large pull-right">Make Order <i class="icon-arrow-right"></i></span>
		</div>
	</div>

</div>