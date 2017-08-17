<?php
 require_once "functions.php";

 $category_id = 0 + post("category_id");
 $category_name = post("category_name");
 $cmd = post("cmd");
 $result = array("status"=>false,
                 "message"=>"",
                 "data"=>null);
 


 if($cmd == "add") {
  $result["status"] = execute("insert into category (category_name) values (?)", 
                               array( $category_name ) );
  $status["message"] = $result["status"] ? "Added" : "Can't add";
 }
 if($cmd == "update") {
  $result["status"] = execute("update category set category_name=? where category_id=?", 
                               array( $category_name, $category_id ) );
  $status["message"] = $result["status"] ? "Updated" : "Can't Update";
 }
 if($cmd == "delete") {
  $result["status"] = execute("delete from  category where category_id=?", 
                               array( $category_id ) );
  $status["message"] = $result["status"] ? "Deleted" : "Can't Delete";
 }
 
 if($cmd == "rows") {
    $result["data"] = rows("select * from category");
    $result["status"] = is_array($result["data"]);
 }

if($cmd == "row") {
    $result["data"] = rows("select * from category where category_id=?",array($category_id));
    $result["status"] = is_array($result["data"]);
 }
header("content-type: application/json");
echo json_encode($result);