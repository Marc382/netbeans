<?php
class Test {
public function getTag($tag){
  switch ($tag) {
    case "description":
    case "link":
    case "title":
      break;
    case "image":
      return $image;
    case "cloud":
      return $cloud;
    case "channel":
      return "<channel>\n";
  }
}

public function anotherone(){
  //blablabla
}
}
