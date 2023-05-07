<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Random Word Generator</title>
</head>
<body>
	<% 
		int count = (int) session.getAttribute("count");
		String randomWord = (String) session.getAttribute("randomWord");
		String date = (String) session.getAttribute("date");
	%>

	<main>
		<div>
			<h3>You have generated a word <%= count %> times</h3>
			<h2><%= randomWord %></h2>
			<button onclick="window.location.reload()">Generate</button>
			<h3>The last time you generated a word was:</h3>
			<h3><%= date %></h3>
		</div>
	</main>
</body>
</html>