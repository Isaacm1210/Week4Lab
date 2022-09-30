<%-- 
    Document   : viewnote
    Created on : 28-Sep-2022, 11:25:15 AM
    Author     : mhame
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        
        <h2>View Note</h2>
        
        <div>Title: ${note.title}</div>
        <div>Contents: ${note.content}</div>
        
        <a href="note?edit">Edit</a>
    </body>
</html>
