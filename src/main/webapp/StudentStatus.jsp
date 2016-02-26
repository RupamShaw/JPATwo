
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Status</title>
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
function setaction(sel) { 
	var textbox=document.getElementById("txtStudentID");
	var input_val = document.getElementById("txtStudentID").value;
	addreceivable.action = "/webapi/students/status/"+input_val+"";
	addreceivable.submit();
	}
</SCRIPT>
</head>
<body>
<H1>Letting Only Numbers Pass to a  Student ID</H1>
<HR>
<FORM name ="addreceivable" onSubmit="setaction()"  method="get">
Enter any positive number for Student ID: <INPUT TYPE="text" NAME="txtStudentID" id="txtStudentID"
    onKeyPress="return checkIt(event)">
</FORM>

</body>
</html>