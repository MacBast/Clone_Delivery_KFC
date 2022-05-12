<?php

require_once(dirname(__DIR__)."../../db/db_config.php");
if( $_SERVER['REQUEST_METHOD'] == "POST"){
    
    $data = json_decode(file_get_contents('php://input'), true);    

    $emailApi= $data['email'];
    $passApi= $data['pass'];

    $db =new DBConfig();
    $dbConnection = $db->connect();
    $query = "INSERT INTO usuarios (email,contraseña) values ('$emailApi','$passApi')";
    $users = $dbConnection->query($query);
    header('Content-Type: application/json');
    echo (json_encode("registro exitoso"));
}else{
    echo (json_encode("Error"));
}
