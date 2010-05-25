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

dojo.require("dojo.parser");
dojo.require("dijit.form.TextBox");
dojo.require("dijit.form.Button");





function startRefreshing() {

	var args = {
			url: "Ajax",
			mimetype: "text/json-comment-filtered",

			load: function(data) {
		      	var img =   dojo.byId("chart");
		      	img.src = data.message;
		    },
		    
		    error: function(error) {
		    	var img =   dojo.byId("chart");
		        img.innerHTML = "An unexpected error occurred: " + error;
		    }



		};

	var deferred = dojo.xhrGet(args);
		
	setTimeout(startRefreshing, 10000);

}
function startApp() {



	var args = {
			url: "http://localhost:8080/FrontEnd/MainServlet?action=0",
			handleAs: "text",
			load: function(data) {
		      	var img =   dojo.byId("chart");
		      	img.src = data;
		    },
		    
		    error: function(error) {
		    	var img =   dojo.byId("chart");
		        img.innerHTML = "An unexpected error occurred: " + error;
		    }



		};

	var deferred = dojo.xhrGet(args);
		
	
}

function onClick(){
	startApp();
	startRefreshing();
}

var button = dojo.byId("ok");
dojo.connect(button,"onclick", 'onClick');


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
 	  Welcome &gt; Upload Data &gt; Input Parameters &gt;<strong>Progress</strong> &gt; Results 	</div>
 	<div id="chartPanel"> 
	
 	   <div id="mainChart"><img id="mChart" /> </div>
	   <table>
	   	<tr><td><img id="nChart1" /></td><td><img id="nChart2" /></td><td><img id="nChart3" /></td></tr>
		<tr><td><img id="nChart4" /></td><td><img id="nChart5" /></td><td><img id="nChart6" /></td></tr>
		<tr><td><img id="nChart7" /></td><td><img id="nChart8" /></td><td><img id="nChart9" /></td></tr>
		<tr><td><img id="nChart10" /></td><td><img id="nChart11" /></td><td><img id="nChart12" /></td></tr>
	   </table>
 	</div>
	
	<div id="infoPanel">
	  
	    
	      <table border="0" width="100%" class="infoTable">
              <tr>
                <td width="100px">Opt Params1 </td>
                <td >reftg</td>
              </tr>
              <tr>
                <td>Opt Params 2 </td>
                <td>sdf</td>
              </tr>
              <tr>
                <td>Opt Params 4 </td>
                <td>sdf</td>
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