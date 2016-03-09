<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <script>
        function getLocation() {
            if (navigator.geolocation) {
                navigator.geolocation.getCurrentPosition(showPosition);
            } else {
                body.innerHTML = "Geolocation is not supported by this browser.";
            }
        }
        function showPosition(position) {
            document.getElementById("lat").value = position.coords.latitude;
            document.getElementById("long").value = position.coords.longitude; 
         }
         window.onload = getLocation;
</script>
        
    </head>
 <body>
     <h4>Please enter your phone number as a 10 digit number without any spaces or symbols (e.g. -().)</h4>
 <form action="DB.php" method="post">
 <input type="hidden" id="lat" name="lat" value=""/>
 <input type="hidden" id="long" name="long" value=""/>
 Phone Number: <input type="text" name="phone"><br>
<input type="checkbox" name="alos" value="Alos">Alos<br>
<input type="checkbox" name="sunrise" value="Sunrise">Sunrise<br>
<input type="checkbox" name="shma" value="Shma">Shma<br>
<input type="checkbox" name="tfila" value="Tfila">Tfila<br>
<input type="checkbox" name="plag" value="Plag">Plag<br>
<input type="checkbox" name="sunset" value="Sunset">Sunset<br>
Email: <input type="text" name="email"><br>
 <input type="submit">
 </form>
     <br><br><br><br>
     <a href="Unsub.php"> click here to cancel your reminders</a>

 </body>
 </html> 