<!DOCTYPE html>
<html>
	<head>
		<title>UCSB Buy/Sell</title>
		<#include "head.ftl" />
	</head>
	<body>
		<#include "navbar.ftl" />
		<h1>Welcome to UCSB Buy/Sell</h1>
		<p>This webapp would be dedicated to providing a platform on which UCSB students could make post about items they wish to sell and search for items other students are selling. The actual exchanging of items/payment would be handled by the individuals, the webapp just introduces the individuals. </p>
		<table>
			<tr>
				<th>Title</th>
				<th>Description</th>
				<th>Contact Info</th>
			</tr>
<#--
			<#list posts in post>
				<tr>
					<td>${post.title}</td>
					<td>${post.description}</td>
					<td>${post.contact}</td>
				</tr>
			</#list>
			-->
		</table>
	</body>
</html>
