<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Basic Form</title>
</head>
<body>
    <h2>Contact Form</h2>
    <form method="post">
        <label for="name">Name:</label><br>
        <input type="text" id="name" name="name" required><br><br>
        <label for="email">Email:</label><br>
        <input type="email" id="email" name="email" required><br><br>
        <input type="submit" value="Submit">
    </form>
    <?php
    // Check if the form is submitted
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        // Collect and sanitize form data
        $name = htmlspecialchars(strip_tags(trim($_POST['name'])));
        $email = htmlspecialchars(strip_tags(trim($_POST['email'])));

        // Simple validation (you can add more complex validation if needed)
        if (!empty($name) && !empty($email)) {
            // Display the collected data
            echo "<h2>Form Data Submitted Successfully</h2>";
            echo "<p><strong>Name:</strong> $name</p>";
            echo "<p><strong>Email:</strong> $email</p>";
        } else {
            echo "<p>Please fill in all fields.</p>";
        }
    } else {
        echo "<p>Invalid request.</p>";
    }
    ?>
</body>
</html>

