<?php

$servername = "127.0.0.1";
$username = "admin";
$password = "sa";
$dbname = "zmanim";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
 // Check connection
 if ($conn->connect_error) {
     die("Connection failed: " . $conn->connect_error);
} 

$phone = $_POST["phone"];

$sql = "DELETE FROM reminders WHERE phone = $phone";

if ($conn->query($sql) === TRUE) {
    echo "Your reminders have been canceled";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

echo "<br><br><a href='index.php'>Click here to add another reminder</a>";

$conn->close();
 ?> 