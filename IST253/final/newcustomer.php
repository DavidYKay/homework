<?php

include "include.php";

/*
 * Create a new customer based on parameters taken in from the web form
 */
function newCustomer($fname, $lname, $stadd, $stadd2, $city, $state, $zip, $phone) {
    $mysqli = new mysqli( $db_host, $db_user, $db_password, 'test');
    $mysqli->select_db('test');

    if (mysqli_connect_errno()) {
        printf("Can't connect to MySQL Server. Errorcode: %s\n", mysqli_connect_error());
        exit;
    }

    if ($stmt = $mysqli->prepare("INSERT INTO `CUSTOMER` 
        (CustomerLName, CustomerFName, CustomerAddress, CustomerCity, 
        CustomerState, CustomerZip, CustomerPhone)
        VALUES ('?', '?', '?', '?', '?', '?', '?')")
    ) {
        $address = $stadd . "\n" . $stadd2;
        $stmt->bind_param('sssssss', $fname, $lname, $address, $city, $state, $zip, $phone);
        $stmt->execute(); 
        echo "Statement SUCCESS";
        echo "<br/>";
    } else {
        echo "Statement FAIL: $stmt";
        echo "<br />";
    }
        $mysqli->close(); 
}

//Grab the values from the web form
$fname  = $_POST['element_1'];
$lname  = $_POST['element_2'];

$stadd  = $_POST['element_3_1'];
$stadd2 = $_POST['element_3_2'];
$city   = $_POST['element_3_3'];
$state  = $_POST['element_3_4'];
$zip    = $_POST['element_3_5'];

$phone  = $_POST['element_4_1'] .  $_POST['element_4_2'] .  $_POST['element_4_3'];

echo "Hello, " . $fname . "!";
echo "<br/>";

if ($fname && $lname) {
    //add the customer to the database
    newCustomer($fname, $lname, $stadd, $stadd2, $city, $state, $zip, $phone);
}

//Put the links on the bottom of the page
readfile("../footer.html");

?>
