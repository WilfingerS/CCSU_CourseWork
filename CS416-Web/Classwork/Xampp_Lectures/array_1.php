<?php
    $stuff = array("name" => "Chuck", "course" => "WA4E"); /* Dictionary */
    echo $stuff["name"];
    $stuff1 = array("Chuck","SI664");
    foreach($stuff1 as $k => $v){ /*key,val */
        echo "<pre>Key=",$k, "Val=",$v;
    }
    echo "<br/><br/>";
    var_dump($stuff1);