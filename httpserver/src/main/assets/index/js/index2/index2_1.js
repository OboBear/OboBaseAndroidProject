/**
 * 左侧
 */
function resizeLeft() {
	div_left_0.style.height = div_left_0.offsetWidth * 463 / 695 + "px"
	text_left_0.style.marginTop = div_left_0.offsetHeight / 2 + "px"
	text_left_0.style.marginLeft = div_left_0.offsetWidth / 2 - text_left_0.offsetWidth / 2 + "px"

	div_left_1.style.width = (div_left.offsetWidth / 2.0 - 0.5) + "px";
	div_left_1.style.height = div_left_1.style.width;

	div_left_1_0.style.marginTop = div_left_1.offsetHeight / 2 - div_left_1_0.offsetHeight / 2 + "px"

	div_left_2.style.width = div_left_1.style.width;
	div_left_2.style.height = div_left_1.style.width;

	div_left_3.style.width = div_left_1.style.width;
	div_left_3.style.height = (div_left.offsetWidth / 2 * 587 / 346) + "px"

	div_left_4.style.width = div_left_1.offsetWidth - 2 + "px";
	div_left_4.style.height = div_left_3.style.height;
	div_left_4_0.style.marginTop = div_left_4.offsetHeight / 2 - div_left_4_0.offsetHeight / 2 + "px"
}

/**
 * 右侧 
 */
function resizeRight() {

	div_right_1.style.width = (div_right.offsetWidth * 347  / (479 + 347)) + "px";
	div_right_1.style.height = div_right.offsetWidth * 569  / (479 + 347) + "px";
	img_right_1.style.width = (div_right.offsetWidth * 479  / (479 + 347) - 1) + "px";
	img_right_1.style.height = div_right_1.style.height;
	div_right_1_0.style.marginTop = img_right_1.offsetHeight / 2 - div_right_1_0.offsetHeight / 2 + "px"
	
	id_content_detail.style.height = (div_left_4.offsetTop + div_left_4.offsetHeight) + "px"
	
	img_right_5.style.width = div_right.offsetWidth + "px"
	img_right_5.style.height = div_left.offsetHeight - div_right_1.offsetHeight + "px"
	
	id_video_hud.style.width = div_right.offsetWidth + "px"
	id_video_hud.style.top = div_right_2.offsetTop + (div_right_2.offsetHeight - id_video_hud.offsetHeight)/2 + "px";
	
	id_btn_pause.style.top = div_right_2.offsetTop + (div_right_2.offsetHeight - id_btn_pause.offsetHeight)/2 + "px";
	id_btn_pause.style.left = div_right_2.offsetLeft + (div_right_2.offsetWidth - id_btn_pause.offsetWidth )/2 + "px";
	div_right_2.style.width = div_right.offsetWidth + "px"
	div_right_2.style.height = div_left.offsetHeight - div_right_1.offsetHeight + "px"
}


/**
 * 调整尺寸 
 */
function onresize() {
	resizeLeft()
	resizeRight()
}

/**
 * 首次加载 
 */
function onLoad() {
	baseOnload();
	onresize();
}

window.onload = onLoad;

function mouse_enter(btn) {
	btn.style.color = "#FF0000"
}

function mouse_leave(btn) {
	btn.style.color = "white"
}

function mouse_click(btn) {}

function startVideo(btn) {
	
	id_video_hud.hidden = false;
	id_video_hud.style.width = div_right.offsetWidth + "px"
	id_video_hud.style.top = div_right_2.offsetTop + (div_right_2.offsetHeight - id_video_hud.offsetHeight)/2 + "px";
	btn.hidden = true;
	img_right_5.hidden = true;
}
