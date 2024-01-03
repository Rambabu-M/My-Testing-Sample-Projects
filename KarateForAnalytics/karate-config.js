function fn(){

	karate.configure('connectTimeout', 5000);
	karate.configure('readTimeout', 5000);
	var jutil = Java.type('Utils.signatureCreation');

	var config = {
	
	   // jutil : Java.type('signatureCreation'),
		name : "Rambabu",
		baseUrl : "",
		admin_username : "",
		admin_password : "",
		admin_private : "",
		admin_credential : "",
		admin_apikey : "",
		admin_keyid : "",
		
		signs: function(req,userPrivate){   
            var signature = jutil.sign(JSON.stringify(req), userPrivate);       
            //req.api.signature = signature 
            return signature
        },
            
            seq: function() {                        
            return ''+jutil.seq();
        }
	};
	//return config;
	
	var environment = karate.env
	karate.log('The environment used for this transaction is : ', environment);
	
	if(environment == "admin"){
		config.baseUrl = "https://connectors.cbwpayments.com/PLMASTER";
		config.admin_credential = "Basic cmVzdGFzc3VyZWRAbmV0eGQuY29tOlRlc3RAMTIzNA==";
		config.admin_keyid = "1420011";
		config.admin_private = "-----BEGIN PRIVATE KEY-----\nMIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQgnpsE1/CUF+hPYF1f\nii66QipvIU+23cx+NL8AETqwnlGhRANCAAS4tBHD4T2zF7pcANmMIgbaubCc5HwV\nB8/pHI9MbDT7QxXTu/3v7EmcKd9rz4/sqqMl4RNwP7WOqg49NelUT7A2\n-----END PRIVATE KEY-----";
		
		/*cofig.admin_apikey : "5701a9613876424e97b3c147e96b82e4";*/
	}
	else if(environment == "legalrep"){
		config.baseUrl = "https://reqres.in/api/users?page=4"
	}
	else{
		config.baseUrl = "https://reqres.in/api/users?page=5"
	};
	
	return config;
	
}