<?php

 //Database functions

 function getCn() {
   return new PDO("mysql:host=localhost;dbname=product_db","root","");
 }

 //To execute the insert/delete/update query
 function execute( $sql, $array = null) {
    $cn = getCn();
    $st = $cn->prepare($sql);
    $st->execute($array);
    $err = $st->errorInfo();
    return !(0 + $err[0]);  //true if success
 }
 //fetchall
 function rows( $sql, $array = null) {
    $cn = getCn();
    $st = $cn->prepare($sql);
    $st->execute($array);
    return $st->fetchall(PDO::FETCH_ASSOC);
 }

 //fetch
 function row( $sql, $array = null) {
    $cn = getCn();
    $st = $cn->prepare($sql);
    $st->execute($array);
    return $st->fetch(PDO::FETCH_ASSOC);
 }


 //Request methods
 function post($key) {
    if(isset($_POST[$key])) return $_POST[$key];
    return ""; 
 }
function get($key) {
    if(isset($_GET[$key])) return $_GET[$key];
    return ""; 
 }
