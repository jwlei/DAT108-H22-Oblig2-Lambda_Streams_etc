<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<title>Search result</title>
	</head>

	<body>
		<div class="center">
			<h1>Search for a King</h1>
			<h2>${king}</h2>
			<h3>${king.bYear}</h3>
			<h3>${king.reignStart}</h3>
			<h3>${king.reignEnd}</h3>
			<img src="${king.image}" alt="${king.name}"/>
			<a href="localhost:8080/index.html">Do another search</a>
		</div>
	</body>
</html>
