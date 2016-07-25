<%-- 
    Document   : index
    Created on : 21 Jul, 2016, 6:58:02 AM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@page import= "com.game.chess"%>
<%@page import= "com.game.chessGUI"%>
<%@page import=  "java.awt.GraphicsEnvironment" %>
<%@page import= "javax.swing.JFrame"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Game</title>
</head>
<body>
    <% 
          
  GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
System.out.println("Headless mode: " + ge.isHeadless());
if(!ge.isHeadless()){ 
    System.setProperty("java.awt.headless", "true");
    chess c =new chess();
    }
          
 %>
 <div>  Chess Game Loading</div>
</body>
</html>