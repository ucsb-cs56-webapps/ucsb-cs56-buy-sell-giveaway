<!DOCTYPE html>
<html>
 <head>
   <title>New Post</title>
   <#include "head.ftl" />
 </head>
 <body>
   <#include "navbar.ftl" />
   <h1>Make A New Post</h1>
   <form action="/new_post" method "get">
     <p>Title: <input type="text" name="title"></p>
     <p>Description: <input type="text" name="desc"></p>
     <p>Contact Info: <input type="text" name="contact"></p>
     <p>
       <input type="submit" value="Submit">
       <input type="reset" value="Reset">
     </p>
   </form>
 </body>
</html>

