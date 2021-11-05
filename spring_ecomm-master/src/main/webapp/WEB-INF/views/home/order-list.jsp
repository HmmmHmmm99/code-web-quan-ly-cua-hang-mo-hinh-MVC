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
		<li class="active">Order History</li>
	</ul>
	<h3>
		ORDER HISTORY
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
			<tbody id="order-history">
				
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
		
		<div class="row">
			<a href="/home" class="btn btn-large"><i
				class="icon-arrow-left"></i> Back to home 
			</a> 
		</div>
	</div>

</div>