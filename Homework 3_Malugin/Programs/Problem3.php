<?php
//Compile and run: php Problem3.php
// This programs uses wildcards to determine which students have a last name that starts with 'D' and ends with a 'd' or 'e'

$servername = "localhost";
$username = "root";
$password = "coursework";

$conn = new mysqli($servername, $username, $password);
if ($conn->connect_error) {
	die("Connection failed: " . $conn->connect_error);
}
	
$sql = "select firstname, lastname from TTU.students where lastname like 'd%e' or lastname like 'd%d'";
$result = mysqli_query($conn,$sql);

if (mysqli_num_rows($result) > 0) {
   
   printf("%s","First Name");
   printf("%11s\n","Last Name");
   
   while ($row = mysqli_fetch_assoc($result)) {
   printf("%-13s",$row["firstname"]);
   printf("%-13s\n",$row["lastname"]);
    
}
}


  
mysqli_close($conn);

?>


