<?php
include "settings.php";

function prettyPrint($result) { 
    echo "<table border=2>";
    while( $row = $result->fetch_array(MYSQLI_BOTH)){

        if (!$headers) {
            //print the column headings
            //print the headers once:
            echo "<tr>";
            foreach ( array_keys($row) AS $header ) {
                //you have integer keys as well as string keys because of the way PHP 
                //handles arrays.
                if ( !is_int($header) ) {
                    echo "<th>$header</th>";
                }
            }
            echo "</tr>";
            $headers = true;
        }
        echo "<tr>";
        //Print data row
        foreach ( $row AS $key => $value ) {
            if ( !is_int($key) ) {
                echo "<td>$value</td>";
            }
        }
        echo "</tr>"; 
    }
    echo "</table>";
    $result->close();
}
?>
