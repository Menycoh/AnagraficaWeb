<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="UTF-8">
<title>Contact Form</title>
<link rel="stylesheet" href="./style.css">
</head>
<body>
	<div class="wrapper">
		<header>
			<h1>Contact Us</h1>
			<p>Fill out the form below to get in touch with us.</p>
		</header>
		<main>
			<h1>Form get</h1>
			<form action="<%=request.getContextPath() + "/FormServlet"%>"
				method="get">
				<div class="form-group">
					<label for="name">Name:</label> <input type="text" id="name"
						name="name" required aria-label="Name">
				</div>

				<div class="form-group">
					<label for="email">Email:</label> <input type="email" id="email"
						name="email" required aria-label="Email">
				</div>

				<div class="form-group">
					<label for="message">Message:</label>
					<textarea id="message" name="message" rows="5" required
						aria-label="Message"></textarea>
				</div>

				<div class="form-group">
					<input type="checkbox" id="terms" name="terms" required> <label
						for="terms">I agree to the <a href="/terms">terms and
							conditions</a>.
					</label>
				</div>

				<button type="submit">Send</button>
			</form>

			<h1>Form post</h1>
			<form action="<%=request.getContextPath() + "/FormServlet"%>"
				method="post">

				<div class="form-group">
					<label for="name">Name:</label> <input type="text" id="name"
						name="name" required aria-label="Name">
				</div>

				<div class="form-group">
					<label for="email">Email:</label> <input type="email" id="email"
						name="email" required aria-label="Email">
				</div>

				<div class="form-group">
					<label for="message">Message:</label>
					<textarea id="message" name="message" rows="5" required
						aria-label="Message"></textarea>
				</div>

				<div class="form-group">
					<input type="checkbox" id="terms" name="terms" required> <label
						for="terms">I agree to the <a href="/terms">terms and
							conditions</a>.
					</label>
				</div>

				<button type="submit">Send</button>
			</form>
		</main>

		<footer>
			<p>&copy; 2024 My Application. All rights reserved.</p>
		</footer>
	</div>
</body>
</html>