<%-- Source project: sip03, branch: 01 (Maven Project) --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Visualgo</title>
	<meta http-equiv="Content-Type" content="text/html">
	<meta name="description" content="Test project using SpringMVC, arbor.js, bootstrap.css">
	<meta name="author" content="Ilariia Belova">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.css"/>" media="screen">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>" media="screen">
  
</head>
<body>
    <div id="navbar" class="navbar navbar-fixed-top center">
      <div class="container">
        <h1 class="text-center">Visualgo</h1>
      </div>
    </div
    
    <div id="canvas" class="container container-canvas">
      <canvas id="mycanvas"></canvas>
    </div>

  
  <script src="http://code.jquery.com/jquery.js"></script>

  <!-- run from the original source files: -->
  <!-- <script src="../../src/etc.js"></script>
       <script src="../../src/kernel.js"></script>
       <script src="../../src/graphics/colors.js"></script>
       <script src="../../src/graphics/primitives.js"></script>
       <script src="../../src/graphics/graphics.js"></script>
       <script src="../../src/tween/easing.js"></script>
       <script src="../../src/tween/tween.js"></script>
       <script src="../../src/physics/atoms.js"></script>
       <script src="../../src/physics/physics.js"></script>
       <script src="../../src/physics/system.js"></script>
       <script src="../../src/dev.js"></script> -->

  <!-- run from the minified library file: -->
  <script src="<c:url value="/resources/js/arbor.js"/>" ></script>  

  <script src="<c:url value="/resources/js/main.js"/>" ></script>

</body>
</html>
