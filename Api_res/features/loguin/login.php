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
/*metodo get
require_once(dirname(__DIR__)."../../db/db_config.php");
if($_SERVER['REQUEST_METHOD']=="GET"){
    $identificacion= $_GET['identificacion'];
    $db =new DBConfig();
    $dbConnection = $db->connect();
    $query = "SELECT * FROM users";
    $users = $dbConnection->query($query)->fetchall(PDO::FETCH_ASSOC);
    $response = array("Peter"=>"35", "Ben"=>"37", "Joe"=>"43");
    echo(json_encode($users));
    print_r($users[0][0]);
}else{
    echo "inmelo papi de malas";
}

*/
require_once(dirname(__DIR__)."../../db/db_config.php");
if($_SERVER['REQUEST_METHOD']=="POST"){
    $data = json_decode(file_get_contents('php://input'), TRUE);    
    var_dump($data);
    $nombre= $data['nombre'];
    $db =new DBConfig();
    $dbConnection = $db->connect();
    $query = "SELECT * FROM users WHERE fullname='$nombre'";
    $users = $dbConnection->query($query)->fetchall(PDO::FETCH_ASSOC);
    header('Content-Type: application/json');
    echo(json_encode($users[0]));
}else{
    echo "inmelo papi de malas";
}