
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Number</title>
<SCRIPT LANGUAGE="JavaScript">
function checkIt(evt) {
	
    evt = (evt) ? evt : window.event
    var charCode = (evt.which) ? evt.which : evt.keyCode
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        status = "This field accepts numbers only."
        return false
    }
    status = ""
    return true
}
function setactions(sel) { 
	alert("h1");
	var textbox=document.getElementById("txtNumber1");
	var input_val1 = document.getElementById("txtNumber1").value;
	var input_val2 = document.getElementById("txtNumber2").value;
	addreceivable.action = "http://http://localhost:8888/webapi/addition/number/"+input_val1+"/"+inputval2+"";
	addreceivable.submit();
	}
function setactions() { 
	alert("h");
	var textbox=document.getElementById("txtNumber1");
	var input_val1 = document.getElementById("txtNumber1").value;
	var input_val2 = document.getElementById("txtNumber2").value;
	addreceivable.action = "http://localhost:8888/webapi/addition/number/"+input_val1+"/"+inputval2+"";
	addreceivable.submit();
	}
function fetactions() { 

	var textbox=document.getElementById("txtNumber1");
	var inpu1 = document.getElementById("txtNumber1").value;
	var inpu2 = document.getElementById("txtNumber2").value;
	var act="/webapi/addition/number/"+inpu1+"/"+inpu2;

	addreceivable.action = act;
	addreceivable.submit();
	}

</SCRIPT>
</head>
<body>
<H1>Letting Only Numbers Pass to a  Student ID</H1>
<HR>
<FORM name ="addreceivable" onSubmit="fetactions()"  method="get" >
Enter First Number: <INPUT TYPE="text" NAME="txtNumber1" id="txtNumber1"
    onKeyPress="return checkIt(event)">
    Enter Second Number: <INPUT TYPE="text" NAME="txtNumber2" id="txtNumber2"
    onKeyPress="return checkIt(event)">
    <Button onclick="fetactions()"   ></Button>
    
</FORM>

</body>
</html>