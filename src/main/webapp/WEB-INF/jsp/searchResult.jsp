<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<title>Search result</title>
		<link rel="stylesheet" href="styles.css">
	</head>

	<body>
		<div class="center">
			<!-- Displays the King which is found from the int(year) supplied to the search form -->
			<h1>Search for a King</h1>
			<h3>In the year of ${year}, King ${king.name} ruled over Norway.</h3>
			<h3>He was born ${king.bYear}, and ruled from ${king.reignStart} to ${king.reignEnd}.</h3>
			<img src="${king.img}" alt="${king.name}" width="250" height="250"/>
			<a href="index.html">Do another search</a>
		</div>
	</body>
</html>
