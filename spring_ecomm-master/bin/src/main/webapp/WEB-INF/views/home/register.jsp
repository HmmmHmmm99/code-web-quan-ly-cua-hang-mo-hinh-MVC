<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>  
<div class="">
	<ul class="breadcrumb">
		<li><a href="/home">Home</a> <span class="divider">/</span></li>
		<li class="active">Registration</li>
	</ul>
	<h3>Registration</h3>
	<div class="well">
		
		<s:form class="form-horizontal" action="${pageContext.request.contextPath }/register" modelAttribute="account" >
			<h4>Your personal information</h4>
			
			<div class="control-group">
				<label class="control-label" for="inputFname1">First name <sup>*</sup></label>
				<div class="controls">
					<input type="text" id="inputFname1" placeholder="First Name">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputLnam">Last name <sup>*</sup></label>
				<div class="controls">
					<input type="text" id="inputLnam" placeholder="Last Name">
				</div>
			</div>
			
			<!-- reg -->
			<%-- <s:form class="form-horizontal loginFrm" action="${pageContext.request.contextPath }/add-category" modelAttribute="category">
			  <div class="control-group">								
				<s:input path="name" placeholder="Name Category" required="required"/>
			  </div>
			  <div class="control-group">
				<s:input  id="" placeholder="Description"  path="description" required="required"/>
			  </div>
			  <div class="control-group">
				<label class="checkbox">
					<s:checkbox path="isActive"/>
					Active
				</label>
			  </div>
			  <button type="submit" class="btn btn-success" style="margin-right:10px">Save</button> 
			  
			</s:form> --%>
			
			<div class="control-group">
				<label class="control-label" for="input_email">Email <sup>*</sup></label>
				<div class="controls">
					<s:input path="username" type="text" id="input_email" placeholder="Email" required="required" />
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputPassword1">Password <sup>*</sup></label>
				<div class="controls">
					<s:input path="password" type="password" id="inputPassword1" placeholder="Password" required="required" />
				</div>
			</div>
			
			<div class="alert alert-block alert-error fade in">
				<button type="button" class="close" data-dismiss="alert">×</button>
				<strong>Lorem Ipsum is simply</strong> dummy text of the printing
				and typesetting industry. Lorem Ipsum has been the industry's
				standard dummy text ever since the 1500s
			</div>

			<p>
				<sup>*</sup>Required field
			</p>

			<div class="control-group">
				<div class="controls">
					<input class="btn btn-large btn-success" type="submit" value="Register">
				</div>
			</div>
		</s:form>
	</div>

</div>