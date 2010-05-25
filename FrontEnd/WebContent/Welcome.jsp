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
 <h:form>
 
 <div id="wrapper"> 
 	<div id="header" ><img src="images/logo.png" width="300" height="150"><img src="images/Title.png" width="400" height="150"></div>
 
 
 	<div id="appView">
	
 	<div id="controlPanel"> 
 	  <strong>Welcome</strong> &gt; Upload Data &gt; Input Parameters &gt;Progress</strong> &gt; Results 	</div>
	  
	  
	 <div id="textPanel"> 
	  <div align="left" >Welcome to the school schedule creation and optimization program.<br/>
	    This schedule creation and optimization wizard will guide you through <br/>
	    the rest of the process.<br/>
	    Click the "Next" button whenever you are ready to continue. </div>
 	</div>
	<div id="infoPanel">
	  
	
	
	      <table border="0" width="100%" class="infoTable">
              
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