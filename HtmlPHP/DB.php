

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

$lat = (string)$_POST["lat"];
$long = (string)$_POST["long"];
$phone = (string)$_POST["phone"];
$email = (string)$_POST["email"];
if (isset($_POST["alos"])){
    $alos = (string)isset($_POST["alos"]);
}
else {
    $alos = '0';
}
if (isset($_POST["sunrise"])){
    $sunrise = (string)isset($_POST["sunrise"]);
}
else {
    $sunrise = '0';
}
if (isset($_POST["shma"])){
    $shma = (string)isset($_POST["shma"]);
}
else {
    $shma = '0';
}
if (isset($_POST["tfila"])){
    $tfila = (string)isset($_POST["tfila"]);
}
else {
    $tfila = '0';
}
if (isset($_POST["plag"])){
    $plag = (string)isset($_POST["plag"]);
}
else {
    $plag = '0';
}
if (isset($_POST["sunset"])){
    $sunset = (string)isset($_POST["sunset"]);
}
else {
    $sunset = '0';
}

        

$sql = "INSERT INTO reminders (lat, longt, phone, alos, sunrise, shma, tfila, plag, sunset, email) VALUES ('$lat', '$long', '$phone', '$alos', '$sunrise', '$shma', '$tfila', '$plag', '$sunset', '$email')";

if ($conn->query($sql) === TRUE) {
    echo "New record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

echo "<br><br><a href='index.php'>Click here to add another reminder</a>";

$conn->close();
 ?> 
