<!DOCTYPE html>
<html>
	<head>
		<title>UCSB Buy/Sell</title>
		<#include "head.ftl" />
	</head>
	<body>
		<#include "navbar.ftl" />
		<h1>Admin Post Approval Page</h1>
		<div class="grid-container">
			<#list postings as posting>
				<div class="grid-item">
					<h2>${posting.title}</h2>
					<h4>${posting.description}</h4>
					<h3>${posting.contact}</h3>
					<div>
					<p>
					  <input type="button" value="Approve" onclick="alert('Woah')">
					  <input type="button" value="Remove" onclick="alert('Nope')">
					</p>
		  </div>
			</#list>
		</table>
	</body>
</html>
