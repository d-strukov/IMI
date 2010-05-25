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
 
<script type="text/javascript" >



</script>
<link href="css/main.css" rel="stylesheet" type="text/css">
</head>
<body> 
<center>
<f:view>
 <h:form enctype="multipart/form-data">
 
 <div id="wrapper"> 
 	<div id="header" ><img src="images/logo.png" width="300" height="150"><img src="images/Title.png" width="400" height="150"></div>
 
 
 	<div id="appView">
	
 	<div id="controlPanel"> 
 	  Welcome &gt; <strong>Upload Data</strong> &gt; Input Parameters &gt;Progress &gt; Results 	</div>
	  
	 <div id="textPanel"> 
	 <div align="left" > Please select data file and click the "Next" button
	    </div>
 	</div>
	
	<div id="infoPanel">
	  
	    
	      <table border="0" width="100%" class="infoTable">
             
              <tr>
                <td>Select File</td>
                <td> 
        <t:inputFileUpload id="upload"
            value="#{wizardBean.dataFile}" />
  
</td>
              </tr>
              <tr>
                <td> Continue </td>
                <td> <t:commandLink value="Next" action="#{wizardBean.next}" /> </td>
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