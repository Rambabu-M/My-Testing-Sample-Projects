function fn() {
    karate.log('config init....');
    karate.configure('connectTimeout', 40000);
    karate.configure('readTimeout', 40000);
    //var jutil = Java.type('SimpleRunner')
    var jutil = Java.type('plainJava.SimpleRunner')

   /* var mh = function (request) {
        karate.log(user);
        var sg = jutil.sign(request.bodyAsString, user.pk);
        var hdrs = {
            Authorization: 'Basic ' + jutil.btoa(user.user + ':' + user.password),
            Signature: 'keyId=' + user.keyId + ',algorithm=ecdsa-sha256,signature=' + sg
        }
        return hdrs;
    }*/

    var ctr=jutil.seq();

   // karate.configure('headers', mh);

    var config = {
        baseUrl:'https://connectors.cbwpayments.com/PLMASTER/',
        jutil: Java.type('plainJava.SimpleRunner'),
        
        seq: function() {                        
            return ''+jutil.seq();
        },

        signs: function(req,user){  
        karate.log('Calling signs function...'); 
            var signature = jutil.sign(JSON.stringify(req.params.payload), user.pk);       
            req.api.signature = signature 
            return req
           // return signature
           // return ''+jutil.sign(JSON.stringify(req.params.payload), user.pk);
        },

        referenceNumber: function (s){
            var d=new Date();
            return (s+ +d.getFullYear()+''+(d.getMonth()+1)+''+d.getDate()+''+d.getMinutes()+''+d.getMilliseconds());
            },

        admin:{
            user: 'restassured@netxd.com',
            password: 'Test@1234',
            gauth: '3F2ZMJGLB2GZHRE24YQBUC4646TNW3DN',
            keyId: '1420011',
            credential: 'Basic cmVzdGFzc3VyZWRAbmV0eGQuY29tOlRlc3RAMTIzNA==',
            pk: '-----BEGIN PRIVATE KEY-----\nMIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQgnpsE1/CUF+hPYF1f\nii66QipvIU+23cx+NL8AETqwnlGhRANCAAS4tBHD4T2zF7pcANmMIgbaubCc5HwV\nB8/pHI9MbDT7QxXTu/3v7EmcKd9rz4/sqqMl4RNwP7WOqg49NelUT7A2\n-----END PRIVATE KEY-----',
            publicKey:'-----BEGIN PUBLIC KEY-----\nMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEuLQRw+E9sxe6XADZjCIG2rmwnOR8\nFQfP6RyPTGw0+0MV07v97+xJnCnfa8+P7KqjJeETcD+1jqoOPTXpVE+wNg==\n-----END PUBLIC KEY-----'
        },

        legalRep:{
            user: 'karatelegal@netxd.com',
            password: 'Test@1234',
           // gauth:"5JHDM4XCUFQEW6OWPXCUSDCADFFTXTA6",
            apikey:"826cdb18627f4246997f6cd0627ad5f6",
            credentials:"Basic a2FyYXRlbGVnYWxAbmV0eGQuY29tOjgyNmNkYjE4NjI3ZjQyNDY5OTdmNmNkMDYyN2FkNWY2",
            pk: '-----BEGIN PRIVATE KEY-----\nMIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQgi6SWKjlT7cD5Rnyl\nuvrXlkkmFCnmyQUNEC7n753nmg2hRANCAAQfhbaqqaxNa4QIqmvsLzzHDOYCrqhj\npJbKM8IYXwc1+hSIlnPnHDkHBxIRU2trCqjYI4jLWyamyltYCanYTw3A\n-----END PRIVATE KEY-----'
        },
    }
    return config;
    
}