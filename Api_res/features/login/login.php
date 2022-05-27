<?php

require_once(dirname(__DIR__)."../../db/db_config.php");
if( $_SERVER['REQUEST_METHOD'] == "POST"){
    
    $data = json_decode(file_get_contents('php://input'), true);    
    $emailApi= $data['email'];
    $passApi = $data['pass'];
    $db =new DBConfig();
    $dbConnection = $db->connect();
    $query = "SELECT * FROM usuarios WHERE email='$emailApi' AND contraseña='$passApi'";
    $users = $dbConnection->query($query)->fetchAll(PDO::FETCH_ASSOC);
    
    header('Content-Type: application/json');
    echo(json_encode($users[0]));

}else{
    echo "No hay conexion";
}



