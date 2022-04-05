<?php

require_once(dirname(__DIR__)."../../db/db_config.php");
if( $_SERVER['REQUEST_METHOD'] == "POST"){
    $data = json_decode(file_get_contents('php://input'), true);    
    $emailApi= $data['email'];
    $db =new DBConfig();
    $dbConnection = $db->connect();
    $query = "SELECT * FROM users WHERE email='$emailApi'";
    $users = $dbConnection->query($query)->fetchall(PDO::FETCH_ASSOC);
    header('Content-Type: application/json');
    echo (json_encode($users[0]));
}else{
    echo "No hay conexion";
}



