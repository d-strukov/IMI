<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<html>
<script type="text/javascript" src="js/dojo/dojo.js" djConfig="parseOnLoad: true"> </script> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Scheduler (Denis Strukov)</title>

<script type="text/javascript" >

function getResults() {

	var args = {
		url : "Ajax.getResult",
		handleAs : "json",

		load : function(data) {
			receiveData(data);
		},

		error : function(error) {
			var img = dojo.byId("chart");
			img.innerHTML = "An unexpected error occurred: " + error;
		}
	};

	var deferred = dojo.xhrGet(args);

	
}
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
 	  Welcome &gt; Upload Data &gt; Input Parameters &gt; Progress &gt; <strong>Results</strong> 	</div>
 	<div id="textPanel"> 
	
 	   <div> Download the rusulting files   <a href="Ajax.getResult">here</a>.</div>
	   </div>
	
	</div>
 </div>
</h:form>
</f:view>
</center>
</body>
</html>