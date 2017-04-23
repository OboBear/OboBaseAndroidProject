function resize() {
	div_language.style.left = (document.body.clientWidth - 140) + "px";
	div_language.style.top = "18px"
	id_div_shop_link.style.left = id_div_topbar.offsetLeft + 1200 - 100 - 89 + "px"
}

function baseOnload() {
	resize()
}

window.onload = baseOnload

function mouse_enter_product(btn) {
	id_div_product_choose.hidden = false
}
function mouse_leave_product(btn) {
	id_div_product_choose.hidden = true
}

function product1Action() {
	window.location.href = "page2_1.html"
}



function product2Action() {
	window.location.href = "page2_2.html"
}