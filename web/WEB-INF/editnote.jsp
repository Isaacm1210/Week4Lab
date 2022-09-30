<%-- 
    Document   : editnote
    Created on : 28-Sep-2022, 11:25:34 AM
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
        
        <h2>Edit Note</h2>
        
        <form action="note" method="post">
            <b>Title: </b> <input type="text" name="title" value="${note.title}">
            <br>
            <b>Contents: </b> <input type="text" name="content" value="${note.content}">
            <br>
            
        <input type="Submit" name="Save" value="Save">
        </form>
        
        
    </body>
</html>
