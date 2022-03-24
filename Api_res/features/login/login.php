<?php

require_once(dirname(__DIR__)."../../db/db_config.php");
if( $_SERVER['REQUEST_METHOD'] == "POST"){
    //var_dump($data);
    $data = json_decode(file_get_contents('php://input'), true);    
    $identification= $data['identification'];
    $db =new DBConfig();
    $dbConnection = $db->connect();
    $query = "SELECT * FROM users WHERE identification='$identification'";
    $users = $dbConnection->query($query)->fetchall(PDO::FETCH_ASSOC);
    header('Content-Type: application/json');
    echo (json_encode($users));
}else{
    echo "No hay conexion";
}



