<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t" %>

<html>
<script type="text/javascript" src="js/dojo/dojo.js"
	djConfig="parseOnLoad: true">
	
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Scheduler (Denis Strukov)</title>

<script type="text/javascript">
	dojo.require("dojo.parser");
	dojo.require("dijit.form.TextBox");
	dojo.require("dijit.form.Button");

	// initialy refresh every 10 sec
	var refreshRate = 10000;

	function receiveData(data) {

		if (data.nodeCount != 'undefined') {
			dojo.byId("nodeCount").innerHTML = data.nodeCount;
		}

		if (data.mainGraph != 'undefined') {
			dojo.byId("mChart").src = data.mainGraph;
		}

		for ( var i = 1; i < 20; i++) {
			if (data["node"+i] != 'undefined')
				try{
				dojo.byId("nChart"+i).src = data["node"+i];
				}catch(err){
				}
		}

		if(data.nodesBusy != 'undefined' ){
			if(!data.nodesBusy && dojo.byId("btnStart").disabled) {
				dojo.byId("btnStart").style.visibility="hidden";

				dojo.byId("btnStart").text = "Finish";
				dojo.byId("lnkNextDiv").style.visibility = 'visible';
				
			}
		} 
	}

	function startRefreshing() {

		var args = {
			url : "Ajax.getData",
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

		setTimeout(startRefreshing, refreshRate);
	}

	function startProcess() {
		dojo.byId("btnStart").disabled = true;
		refreshRate = 3000;
		var args = {
			url : "Ajax.start",
			handleAs : "text",
			load : function(data) {
				var img = dojo.byId("chart");
				img.src = data;
			},

			error : function(error) {
				var img = dojo.byId("chart");
				img.innerHTML = "An unexpected error occurred: " + error;
			}

		};

		var deferred = dojo.xhrGet(args);
	}

	dojo.addOnLoad(startRefreshing);
</script>
<link href="css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
<center><f:view>
	<h:form>

		<div id="wrapper">
		<div id="header"><img src="images/logo.png" width="300"
			height="150"><img src="images/Title.png" width="400"
			height="150"></div>


		<div id="appView">
		<div id="controlPanel">Welcome &gt; Upload Data &gt; Input
		Parameters &gt;<strong>Progress</strong> &gt; Results</div>
		<div id="chartPanel">

		<div id="mainChart"><img name="mChart" width="548" height="125"
			id="mChart" /></div>
		<table>
			<tr>
				<td><img name="nChart1" width="180" height="88" id="nChart1" /></td>
				<td><img name="nChart2" width="180" height="88" id="nChart2" /></td>
				<td><img name="nChart3" width="180" height="88" id="nChart3" /></td>
			</tr>
			<tr>
				<td><img id="nChart4" width="180" height="88" /></td>
				<td><img id="nChart5" width="180" height="88" /></td>
				<td><img id="nChart6" width="180" height="88" /></td>
			</tr>
			<tr>
				<td><img id="nChart7" width="180" height="88" /></td>
				<td><img id="nChart8" width="180" height="88" /></td>
				<td><img id="nChart9" width="180" height="88" /></td>
			</tr>
			<tr>
				<td><img id="nChart10" width="180" height="88" /></td>
				<td><img id="nChart11" width="180" height="88" /></td>
				<td><img id="nChart12" width="180" height="88" /></td>
			</tr>
		</table>
		</div>

		<div id="infoPanel">


		<table border="0" width="100%" class="infoTable">
			<tr>
				<td><strong>Central Initialized:</strong></td>
				<td><em>true</em></td>
			</tr>
			<tr>
				<td><strong>Node Count:</strong></td>
				<td><em><span id="nodeCount"> </span></em></td>
			</tr>
			<tr>
				<td><strong>File uploaded: </strong></td>
				<td><em>true</em></td>
			</tr> 
			<tr>
				<td class="clearCell">&nbsp;</td>
				<td class="clearCell">
				<button id="btnStart" onClick="startProcess(); return false;">&nbsp;-=Start=-&nbsp;</button>
				<div id="lnkNextDiv"  style="visibility: hidden;" > <t:commandLink value="Finish" action="#{wizardBean.next}" > </t:commandLink></div>
				</td>
			</tr>
		</table>

		</div>
		</div>
		</div>
	</h:form>
</f:view></center>
</body>
</html>