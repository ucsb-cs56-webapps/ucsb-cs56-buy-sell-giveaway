<!DOCTYPE html>
<html>
  <head>
    <title>UCSB Buy/Sell</title>
    <#include "head.ftl" />
  </head>
  <body>
    <#include "navbar.ftl" />
    <h1>Admin Post Approval Page</h1>
    <div>
      <form action = "/admin">
	<p>Index (0 based) of Post for Approval(Comma seperated):<input type="text" name="index"></p>
	<p>
	  <input type="submit" value="Approve">
	</p>
      </form>
    </div>
    
    <div class="grid-container">
      <#list postings as posting>
	<div class="grid-item">
	  <h2>${posting.title}</h2>
	  <h4>${posting.description}</h4>
	  <h3>${posting.contact}</h3>
	</div>
      </#list>
  </body>
</html>
