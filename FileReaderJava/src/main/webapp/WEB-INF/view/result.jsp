<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">
  <head>
  	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Upload file</title>
  </head>
  
  <script>
		function myFunction() {
		  var myTable = document.getElementById("myTable");
		  var data = ${data};
		  var row = table.insertRow(0);
		  var cell1 = row.insertCell(0);
		  var cell2 = row.insertCell(1);
		  cell1.innerHTML = "NEW CELL1";
		  cell2.innerHTML = "NEW CELL2";
		}
	</script>
  <body>
		<table id="myTable">
		</table>
     
   </body>
</html> 