<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t" %>

<html>
<script type="text/javascript" src="js/dojo/dojo.js" djConfig="parseOnLoad: true"> </script> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Scheduler (Denis Strukov)</title>

 
<link href="css/main.css" rel="stylesheet" type="text/css">
</head>
<body> 
<center>
<f:view>
 <h:form>
 
 <div id="wrapper"> 
 	<div id="header" ><img src="images/logo.png" width="300" height="150"><img src="images/Title.png" width="400" height="150"></div>
 
 
 	<div id="appView">
 	<div id="controlPanel"> 
 	  Welcome &gt; Upload Data &gt; <strong>Input Parameters</strong> &gt;Progress &gt; Results 	</div>
 	<div id="textPanel"> 
	<div align="left">
 	   <p>You can fill in your own values or leave the default ones.<br>
 	     <strong>Note</strong>: The amount of iterations is per node. 	   </p>
 	   </div>
 	</div>
	
	<div id="infoPanel">
	  
	    
	      <table border="0" width="100%" class="infoTable">
              <tr>
                <td>Iteration Count </td>
                <td ><h:inputText value="#{dataBean.iterationCount}">  </h:inputText> </td>
              </tr>
              <tr>
                <td>Student Window Penalty </td>
                <td><h:inputText value="#{dataBean.studentPenalty}">  </h:inputText> </td>
              </tr>
              <tr>
                <td>Teacher Window Penalty </td>
                <td><h:inputText value="#{dataBean.teacherPenalty}"></h:inputText> </td>
              </tr>
              <tr>
                <td>Teacher Day Off Penalty </td>
                <td><h:inputText value="#{dataBean.teacherOffPenalty}"> </h:inputText> </td>
              </tr>
              <tr>
                <td>Hour overflow Penalty </td>
                <td><h:inputText value="#{dataBean.hourOverflowPenalty}"> </h:inputText> </td>
              </tr>
              <tr>
                <td>Continue </td>
                <td><t:commandLink value="Next" action="#{wizardBean.next}"> </t:commandLink> </td>
              </tr>
            </table>
	     
	</div>
 	</div>
 </div>
</h:form>
</f:view>
</center>
</body>
</html>