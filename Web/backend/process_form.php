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

