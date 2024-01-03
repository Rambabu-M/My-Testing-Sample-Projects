function fn() {
    karate.log('config init....');
    karate.configure('connectTimeout', 40000);
    karate.configure('readTimeout', 40000);
    var jutil = Java.type('SimpleRunner');

  

    var ctr=jutil.seq();

   // karate.configure('headers', mh);

    var config = {
        baseUrl: 'http://nginxmaster/PL/rpc/',
        plus_Url:'https://connectors.cbwpayments.com/PLMASTER/rpc/',
        bbaseUrl:'https://connectors.cbwpayments.com/PL/rpc/',
        gpsUrl:'https://connectors.cbwpayments.com/gps/rpc/',
        jutil: Java.type('SimpleRunner'),
        seq: function() {                        
            return ''+jutil.seq();
        },

        getTOTPCode: function(gauth) {
            return ''+jutil.getTOTPCode(gauth);
        },

        signs: function(req,user){   
            var signature = jutil.sign(JSON.stringify(req.params.payload), user.pk); 
            karate.log(signature)      
            req.api.signature = signature;
            return req;
        },
    
        defaults:{
            program:"100000000132001",
            product:"PL",
            glasset:"GL1661249528995"
        },

        adminuser:{
            user:"g.naveenkumar+1@netsys-inc.com",
            password:"Test@1234",
            keyId:"2003",
            pk: '-----BEGIN PRIVATE KEY-----\nMIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQgyGFy9Fdc2oEZpMfC\nF+S6N0nLnu4o0jS0N6qRp+RafTuhRANCAASrV9YL2WW/2Qzaq3DPxjP93xxuMMlB\nBWtgoc+Pbs2f+rUCe+alrX+o97CdE17zR7HmZekqna0ylmUtyKaZ8tRg\n-----END PRIVATE KEY-----',
        },

        netsys : {
            user: 'admin@netsys.org',
            password: 'Test@1234',
            keyId: '592',
            pk: '-----BEGIN PRIVATE KEY-----\nMIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQgyGFy9Fdc2oEZpMfC\nF+S6N0nLnu4o0jS0N6qRp+RafTuhRANCAASrV9YL2WW/2Qzaq3DPxjP93xxuMMlB\nBWtgoc+Pbs2f+rUCe+alrX+o97CdE17zR7HmZekqna0ylmUtyKaZ8tRg\n-----END PRIVATE KEY-----',
            pubk:'-----BEGIN PUBLIC KEY-----\nMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEq1fWC9llv9kM2qtwz8Yz/d8cbjDJ\nQQVrYKHPj27Nn/q1Anvmpa1/qPewnRNe80ex5mXpKp2tMpZlLcimmfLUYA==\n-----END PUBLIC KEY-----'
        
        },

        legalrep:{
            user: 'torreto@netxd.com',
            password: 'Test@1234',
            apikey:"1036d86f4d594e1baa83195283abadda",
            credientials:"Basic dG9ycmV0b0BuZXR4ZC5jb206MTAzNmQ4NmY0ZDU5NGUxYmFhODMxOTUyODNhYmFkZGE=",
            pk: '-----BEGIN PRIVATE KEY-----\nMIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQgk0iQ1HTtL05H/4Yu\nw9lntgQTljndp7uE2Umqbj7pHJmhRANCAARAecyXRrJb6+ZopM16DSCjlhJYR0Pw\nCcKdsnDRi5U87gTb4LKhMmAJGZuS41mVk0gR28Qz5IbcgIWtohjwZcg/\n-----END PRIVATE KEY-----'    
        },

        Business_Cust:{
            user: "g.naveenkumar+501@bankcbw.org",
            password:"Test@1234",
            id: '100000000000001',
            id1: '100000000631310',
            acc_no: '200583364057128',
            acc_no1: '200688567322908',
            sender : 'BH05QUJZ89749664699159',
            to: 'BH25TZOD55564797476216',
            keyId: '2004',
            legalrepid: '4006',
            SSN: '201480995',
            phone: '1245011201',
            email: 'g.naveenkumar+1001@netsys-inc.com',
            key: '1003',
            lemail:'g.naveenkumar+101@bankcbw.org',
            lphone:'75586908',
            lkey:'1635333703',
            lCR:'661434556',
            semail:'g.naveenkumar+2001@bankcbw.org',
            sphone:'56895132',
            scpr:'622345452',
            skey:'1635419237',
            sid:'11001'
        }
    }
    return config;
    
}

