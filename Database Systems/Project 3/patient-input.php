<!-
// patient-input.php
//
// this html form is used to collect information from a patient;
//      a separate php script is used to perform a lookup and insertion
//      into a MySQL database (insert-patient.php)
//
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

<html>
<body>

<form action="insert-patient.php" method="post">
patient name: <input type="text" name="name"><br>
zipcode: <input type="text" name="zipcode"><br>
street: <input type="text" name="street"><br>
house number: <input type="text" name="number"><br>
<input type="submit" value="create new patient">
</form>

</body>
</html>