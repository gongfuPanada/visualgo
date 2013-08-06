<%-- Source project: sip03, branch: 01 (Maven Project) --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Visualgo based using arbor.js project for visualization</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" type="text/css">
</head>
<body>
  <canvas id="viewport" width="800" height="600"></canvas>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>

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
  
<h1>Visualgo</h1>
<ul> 
	<li>
	Zero value: ${integer} 
	</li>
</ul>
</body>
</html>
