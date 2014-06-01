<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Spring Rest Example</title>
<%@include file="imports.jsp"%>
</head>
<body>
	<div class="container">

		<div class="page-header">
			<h1>Restful Spring MVC Hibernate Test App</h1>
			<p class="lead">This app also uses jquery, mysql and bootstrap.</p>
		</div>

		<h3>User List</h3>
		<pre id="list-click-div" class="col-md-12"></pre>
		<br>
		<button id="list-click" class="btn btn-sm btn-default">GET
			JSON</button>
		<button id="list-url" class="btn btn-sm btn-default">JSON URL</button>

		<h3>
			User ID = <input class="input" id="userid" type="text" name="userid">
		</h3>
		<pre id="id-click-div" class="col-md-12"></pre>
		<br>
		<button id="id-click" class="btn btn-sm btn-default">GET JSON</button>
		<button id="id-url" class="btn btn-sm btn-default">JSON URL</button>

		<h3>
			Username = <input class="input" id="username" type="text"
				name="username">
		</h3>
		<pre id="name-click-div" class="col-md-12"></pre>
		<br>
		<button id="name-click" class="btn btn-sm btn-default">GET
			JSON</button>
		<button id="name-url" class="btn btn-sm btn-default">JSON URL</button>

		<h3>Add User</h3>
		<form class="form">
			Username: <input class="input" id="addusername" type="text"
				name="addusername"> Password: <input class="input"
				id="addpassword" type="text" name="addpassword">
		</form>
		<pre id="add-user-click-div" class="col-md-12"></pre>
		<br>
		<button id="add-user-click" class="btn btn-sm btn-default">POST
			JSON</button>
	
	</div>

</body>
</html>
