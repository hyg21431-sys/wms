function inoutForm(event) {
	event.preventDefault();
	
	const product_code = document.getElementById("product_code");
	const tCount = document.getElementById("t_count");
	const tDate = document.getElementById("t_date");
	const company_code = document.getElementById("company_code");
	
	if(product_code.value.trim() === "") {
		alert("제품코드를 입력해주세요.");
	    product_code.focus();
	    return;
	}
	
	if(tCount.value.trim() === "") {
		alert("수량을 입력해주세요.");
	    tCount.focus();
	    return;
	}
	
	if(tDate.value.trim() === "") {
		alert("거래일자를 입력해주세요.");
	    tDate.focus();
	    return;
	}
	
	if(company_code.value.trim() === "") {
		alert("거래처를 선택해주세요.");
	    company_code.focus();
	    return;
	}
	
	alert("입출고등록이 정상적으로 등록되었습니다");
	  document.getElementById("inoutForm").submit();
}