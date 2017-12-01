<!-
// insert-patient.php
// 
// this php script uses patient information to obtain a person ID
//      via a MySQL database lookup; a new patient record is created
//      for that person.  This script is called by patient-input.php
//      and it uses information gathered by that form.

// adapted from w3schools.com PHP tutorials by Karen Davis 11/27/17
// 
// assumptions: 1. a PHP server and MySQL are installed and running
//              2. a testuser with password testpwd has been created
//              3. a database called testDB has been created with the
//                 following relations: Person, Address, HasAddress,
//                 Patient, Shift, and Visits
//              4. At least one Person and one Shift are in testDB
//
// notes: this is a working solution that could be improved in terms 
//        of robustness, security, and aesthetics
->

<?php
$servername = "localhost";
$username = "testuser";
$password = "testpwd";
$dbname = "testDB";

try {
    // creates a PHP data object (PDO) called $conn
    $conn = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
    // set the PDO error mode to exception
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

/* uncomment this section to check the results from your form
	echo $_POST["name"];
	echo $_POST["number"];
	echo $_POST["street"];
	echo $_POST["zipcode"];
*/
    // assign the form fields to variables
    $name = $_POST["name"];
	$number = $_POST["number"];
	$street = $_POST["street"];
	$zipcode = $_POST["zipcode"];
	

    // lookup the patient's details to obtain the person ID
	$sql= "SELECT p.persID 
	       FROM Person p, Address a, HasAddress h
		   WHERE p.persID = h.persID and
		         a.aID = h.aID and
				 p.name = :name and
				 a.number = :number and
				 a.street = :street and
				 a.zipcode = :zipcode"; 
	$stmt = $conn->prepare($sql);
	$stmt->bindParam(':name', $name, PDO::PARAM_STR); // name is a string
	$stmt->bindParam(':number', $number, PDO::PARAM_INT); // number is an integer
	$stmt->bindParam(':street', $street, PDO::PARAM_STR); // street is a string
	$stmt->bindParam(':zipcode', $zipcode, PDO::PARAM_STR); // zipcode is a string
	$stmt->execute();

// set the resulting array to associative
    $result = $stmt->setFetchMode(PDO::FETCH_ASSOC);
	
// pick out the person ID value as a variable
	$row=$stmt->fetch();
	$persID=$row['persID'];
	
// create a new visit record; you may also have to prompt the
//     user for a patient ID (I don't have to do this since my patientID
//     is an autoincrement field,  I just need to look up the last value 
//     created to insert it into Visits either using select max(id) from patient
//     or select_last_insert_id().)	

    $sql = "INSERT INTO Patient (persID) VALUES(:persID)";
	$stmt = $conn->prepare($sql);
    $stmt->bindParam(':persID', $persID, PDO::PARAM_INT); // persID is an integer
	$stmt->execute();
    echo "new patient record created successfully";

    }
catch(PDOException $e)
    {
    echo $sql . "<br>" . $e->getMessage();
    }

$conn = null;


?>