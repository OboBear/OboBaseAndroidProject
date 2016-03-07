function obclick(a)
{
	var showImage= document.getElementById("show_image");
	showImage.src = a.src;
	showImage.width = document.body.width;
	showImage.height = showImage.width * 3/4;
	
	var log = document.getElementById("log");
	
	log.width = document.body.width;
	
	var body_div = document.getElementById("body_div");
	
	body_div.innerHTML += body_div.innerHTML+"<p>nihao</p>";
}

