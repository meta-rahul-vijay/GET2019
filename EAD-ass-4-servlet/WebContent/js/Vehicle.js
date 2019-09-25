		

	function convertINR(usd) {
		return Math.round(71.78 * usd).toFixed(2);
	}

	function convertYEN(usd) {
		return Math.round(106.17 * usd).toFixed(2);
	}


	function switchCurrency(){
		var type = document.getElementById("v_type").value;
		var d_price;
		var m_price;
		var y_price;
		switch(type){
		case "C" :
			d_price = (5/71.5).toFixed(2);
			m_price = (100/71.5).toFixed(2);
			y_price = (500/71.5).toFixed(2);
			break;
		case "M" :
			d_price = (10/71.5).toFixed(2);
			m_price = (200/71.5).toFixed(2);
			y_price = (1000/71.5).toFixed(2);
			break;
		case "F" :
			d_price = (20/71.5).toFixed(2);
			m_price = (500/71.5).toFixed(2);
			y_price = (3500/71.5).toFixed(2);
			break;
		default :
			break;
		}

		if(document.getElementById("daily_curr").value == "INR"){
			document.getElementById("daily_price").value = convertINR(d_price);
			document.getElementById("monthly_price").value = convertINR(m_price);
			document.getElementById("yearly_price").value = convertINR(y_price);
		}
		else if (document.getElementById("daily_curr").value == "YEN"){
			document.getElementById("daily_price").value = convertYEN(d_price);
			document.getElementById("monthly_price").value = convertYEN(m_price);
			document.getElementById("yearly_price").value = convertYEN(y_price);
		}else{
			document.getElementById("daily_price").value = d_price;
			document.getElementById("monthly_price").value = m_price;
			document.getElementById("yearly_price").value = y_price;
		}
	}