/**
 * 
 */
function testt(e){
	console.log(document.getElementsByClassName("hjk")[0].getAttribute("name"))
	if(document.getElementsByClassName("hjk")[0].getAttribute("name") == "fk"){
		document.getElementsByClassName("hjk")[0].setAttribute("name", "ddd");
	}else{
		document.getElementsByClassName("hjk")[0].setAttribute("name", "fk");
	}
//	console.log(document.getElementsById("att"))
	if(document.getElementById("att") !== null){
//		document.getElementsByClassName("att")[0].remove();
		document.getElementById("att").style.display = 'none';
		
	}else{
//		console.log(document.getElementsByClassName("hjk")[0].getAttribute("name"));
		let div = document.createElement("div");
		div.setAttribute('id', "att");
		div.innerHTML = "fff";
		document.body.append(div);
	}
	
	
	console.log(document.getElementById("qqq").target.files[0]);
	
}


function getCoordinates(event,scale,X,Y){
	console.log("hguehgegbeiuerbe");
	document.getElementById("coordinateX").innerHTML = ((event.clientX-660)/(scale*20) - X);
	document.getElementById("coordinateY").innerHTML = ((320-event.clientY)/(scale*20) + Y);
}

function getResponse(){
	
	var params = {
    param1: '0',
    param2: '1',
    param3: "0"
};

var url = new URL('http://localhost:8080/MathAndDataSciensTools.web/TestGetUpClass');
url.search = new URLSearchParams(params).toString();
	let Data = "";
	fetch(url)
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.text();
    })
    .then(data => {
        document.getElementById("iii").innerHTML = ("" , data);
		Data = data;
		console.log('Response from servlet:', Data);
    })
    .catch(error => {
        console.error('Fetch error:', error);
    });
	

	
}

function changeDataType(){
	if(document.getElementById("dataType").value == "Path to Parameters"){
/** 		document.getElementsByName("Path to Parameters")[0].style.visibility = "visible";
		document.getElementsByName("Path to data")[0].style.visibility = "hidden";
		document.getElementsByName("Write data")[0].style.visibility = "hidden";
*/
		document.getElementById("inputDataParams").innerHTML= '<input type="file" id="fileName" onchange="setPath()"><br/><textarea id="PathArea" name="Path to Parameters">D:\\DevelopingPrograms\\eclipse\\workspace\\MathAndDataSciensTools.web\\src\\main\\java\\II_Functions\\ParemetersFolder\\MainParameters.txt</textarea>';
		document.getElementById("StudyParameters").innerHTML="";
	}else if(document.getElementById("dataType").value == "Path to data"){ 
/**
		document.getElementsByName("Path to Parameters")[0].style.visibility = "hidden";
		document.getElementsByName("Path to data")[0].style.visibility = "visible";
		document.getElementsByName("Write data")[0].style.visibility = "hidden";
*/
		document.getElementById("inputDataParams").innerHTML= '<input type="file" id="fileName" onchange="setPath()"><br/><textarea id="PathArea" name="Path to data">D:\\DevelopingPrograms\\eclipse\\workspace\\MathAndDataSciensTools.web\\src\\main\\java\\II_Functions\\DatasFolder\\MainData.txt</textarea>';
		document.getElementById("StudyParameters").innerHTML='<div>Studing parameters<br><textarea name="Studing Parameters">10000 0.1, 10000 0.01, 10000 0.001, 10000 0.0001, 10000 0.00001</textarea><br/>In pattern: numbers1 speedA1,  numbers2 speedA2, ...<br/>for example: 1000 0.01, 100000 0.00001</div> ';
	}else if(document.getElementById("dataType").value == "Write data"){
/** 
		document.getElementsByName("Path to Parameters")[0].style.visibility = "hidden";
		document.getElementsByName("Path to data")[0].style.visibility = "hidden";
		document.getElementsByName("Write data")[0].style.visibility = "visible"; 
*/
		document.getElementById("inputDataParams").innerHTML= '<textarea name="Write data"></textarea><br/>For Example 3, 4, 1 ; 4.4, 2, 3.2 ; 32, 33, 34 -- 2, 3 ; 3.3 , 5 ; 33, 5';
		document.getElementById("StudyParameters").innerHTML='<div>Studing parameters<br><textarea name="Studing Parameters">10000 0.1, 10000 0.01, 10000 0.001, 10000 0.0001, 10000 0.00001</textarea><br/>In pattern: numbers1 speedA1,  numbers2 speedA2, ...<br/>for example: 1000 0.01, 100000 0.00001</div> ';

	}
}

function onch(){
	console.log("db");
	document.getElementById("fff").style.backgroundColor = "red";
}


function setPath(){
	document.getElementById("PathArea").innerHTML = ("\\" + (document.getElementById("fileName").value).split("\\")[(document.getElementById("fileName").value).split("\\").length-1]);
}




/** function showParameterTextArea(){
	if(document.getElementById("paramtext").style.display == "block"){
		document.getElementById("paramtext").style.display = "none"
		document.getElementById("paraminp").style.display = "none"		
	}
	else{
		document.getElementById("paramtext").style.display = "block"	
		document.getElementById("paraminp").style.display = "block"		
	}
}
*/
