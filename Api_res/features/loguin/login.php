<?php
/*endpoint url ubicado php
if($_SERVER['REQUEST_METHOD']=="GET"){
    //echo "Melo papa";
    print_r($_GET['name']);
    echo(dirname(__DIR__));//trae la ruta absoluta delproyecto
}else{
    echo "inmelo papi de malas";
}*/

//variable escargada de manejar las peticiones GET

require_once(dirname(__DIR__)."../../db/db_config.php");
if($_SERVER['REQUEST_METHOD']=="GET"){
    $identificacion= $_GET['identificacion'];
    $db =new DBConfig();
    $dbConnection = $db->connect();
    $query = "SELECT * FROM users";
    $users = $dbConnection->query($query)->fetchall(PDO::FETCH_ASSOC);
    $response = array("Peter"=>"35", "Ben"=>"37", "Joe"=>"43");
    echo(json_encode($users));
    //print_r($users[0][0]);
}else{
    echo "inmelo papi de malas";
}