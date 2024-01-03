function fn() {
    karate.log('config init....');
    karate.configure('connectTimeout', 70000);
    karate.configure('readTimeout', 70000);
    var jutil = Java.type('SimpleRunner')

    var mh = function (request) {
        karate.log(user);
        var sg = jutil.sign(request.bodyAsString, user.pk);
        var hdrs = {
            Authorization: 'Basic ' + jutil.btoa(user.user + ':' + user.password),
            Signature: 'keyId=' + user.keyId + ',algorithm=ecdsa-sha256,signature=' + sg
        }

        return hdrs;
    }

    karate.configure('headers', mh);

    var config = {
        // baseUrl: 'http://nginx/PL/rpc/',
        baseUrl: 'http://localhost:5010/PL/rpc/',
        wpsUrl: 'http://localhost:8000/wps/rpc/',
        cbaseUrl: 'https://connectors.cbwpayments.com/ledgermaster/rpc',
        bbaseUrl:'https://connectors.cbwpayments.com/PL/rpc/',
        gpsUrl:'https://connectors.cbwpayments.com/gps/rpc/',
        jutil: Java.type('SimpleRunner'),
        seq: function() {                        
            return ''+jutil.seq();
        },
        Date1: function() {  
            var d = new Date();
            return ''+d.getFullYear()+'-'+(d.getMonth()+1)+'-'+d.getDate()+'-'+d.getMinutes()+'-'+d.getMilliseconds();
        },
        ref: function() {
            var a = new Date()
            return ''+a.getTime();
        },
        ref1: function() {
            var a = new Date()
            return ''+a.getTime();
        },
        random: function() {
           return ''+Math.random();
        },
        random1: function() {
        return ''+ Math.floor(Math.random() * 1087589);
        },
        random2: function() {
            return ''+Math.floor(Math.random() * (9000000000 - 11))+100
        },
        cpr:function() {
            return ''+Math.floor(Math.random() * 1000000000);
        },

        getTOTPCode: function(gauth) {
            return ''+jutil.getTOTPCode(gauth);
        },
        
        Tokenstr: function(req,xml){
            let str=''
            var lines = xml.split("\n");
            for (var line = 0; line < lines.length; line++) {
            str += lines[line];
            }
            req.tokenFile=str
            return req
        },

        netsys : {
            user: 'admin@netsys.org',
            password: 'Test@1234',
            keyId: '9020',
            gauth:'MY73RTURHKUABTRH2KN4TV7FDU63OZ5L',
            pk: '-----BEGIN PRIVATE KEY-----\nMIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQgLvZvir7G0HDrunhb\ncT0OEJWeEjoVBtUJ8m89kDbFoA6hRANCAASEOa4WbRYxN8e7rCmFeWVKiXlLtNjb\nhWuBSzDONprOHujIys8/UZrktEMsam8flh4GCTWs67nsFcQ9J1mg89sO\n-----END PRIVATE KEY-----',
            pubk:'-----BEGIN PUBLIC KEY-----\nMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEhDmuFm0WMTfHu6wphXllSol5S7TY\n24VrgUswzjaazh7oyMrPP1Ga5LRDLGpvH5YeBgk1rOu57BXEPSdZoPPbDg==\n-----END PUBLIC KEY-----'
        
        },
        adminuser : {
            user: 'r.anbalagan@netxd.com',
            password: 'Test@1234',
            keyId: '9025',
            gauth:'OFOER2GH65NLAO5CXOAZLZC6BBHIEEEZ',
            pk: '-----BEGIN PRIVATE KEY-----\nMIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQgLvZvir7G0HDrunhb\ncT0OEJWeEjoVBtUJ8m89kDbFoA6hRANCAASEOa4WbRYxN8e7rCmFeWVKiXlLtNjb\nhWuBSzDONprOHujIys8/UZrktEMsam8flh4GCTWs67nsFcQ9J1mg89sO\n-----END PRIVATE KEY-----',
            pubk:'-----BEGIN PUBLIC KEY-----\nMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEhDmuFm0WMTfHu6wphXllSol5S7TY\n24VrgUswzjaazh7oyMrPP1Ga5LRDLGpvH5YeBgk1rOu57BXEPSdZoPPbDg==\n-----END PUBLIC KEY-----'
        
        },
        admin: {
            user: 'PL',
            password: '1513ef5cba4f4a9d93ec875afb184062',
            keyId: '9011',
            pk: '-----BEGIN PRIVATE KEY-----\nMIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQgLvZvir7G0HDrunhb\ncT0OEJWeEjoVBtUJ8m89kDbFoA6hRANCAASEOa4WbRYxN8e7rCmFeWVKiXlLtNjb\nhWuBSzDONprOHujIys8/UZrktEMsam8flh4GCTWs67nsFcQ9J1mg89sO\n-----END PRIVATE KEY-----',
            pubk:'-----BEGIN PUBLIC KEY-----\nMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEhDmuFm0WMTfHu6wphXllSol5S7TY\n24VrgUswzjaazh7oyMrPP1Ga5LRDLGpvH5YeBgk1rOu57BXEPSdZoPPbDg==\n-----END PUBLIC KEY-----'
        },
        PLCustomer: {
            accno:"200361432069974",
            cid:"100000000000001",
            cardid:"10002"
        },
        Individual_cust:{
            user: "g.naveenkumar+50@bankcbw.org",
            password:"Test@1234",
            id: '100000000000001',
            acc_no: '200418937683138',
            acc_no_2:'200182759707993',
            acc_no_3:'200910977978801',
            acc_no_4:'200182759707993',
            keyId: '9018',
            CPR: '147452270',
            phone: '82211469',
            email: 'g.naveenkumar+50@bankcbw.org',
            CardId:'10002',
            pubkey:'-----BEGIN PUBLIC KEY-----\nMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEhDmuFm0WMTfHu6wphXllSol5S7TY\n24VrgUswzjaazh7oyMrPP1Ga5LRDLGpvH5YeBgk1rOu57BXEPSdZoPPbDg==\n-----END PUBLIC KEY-----',
            pk: '-----BEGIN PRIVATE KEY-----\nMIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQgLvZvir7G0HDrunhb\ncT0OEJWeEjoVBtUJ8m89kDbFoA6hRANCAASEOa4WbRYxN8e7rCmFeWVKiXlLtNjb\nhWuBSzDONprOHujIys8/UZrktEMsam8flh4GCTWs67nsFcQ9J1mg89sO\n-----END PRIVATE KEY-----',
        },
        customer_user:{
            user: "g.naveenkumar+51@bankcbw.org",
            password:"Test@1234",
            acc_no_4:'200182759707993',
            id: '100000000000002',
            keyId: '10003',
            email: 'g.naveenkumar+51@bankcbw.org',
            CPR: '147452271',
            phone: '82211461',
            pubkey:'-----BEGIN PUBLIC KEY-----\nMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEhDmuFm0WMTfHu6wphXllSol5S7TY\n24VrgUswzjaazh7oyMrPP1Ga5LRDLGpvH5YeBgk1rOu57BXEPSdZoPPbDg==\n-----END PUBLIC KEY-----',
            pk: '-----BEGIN PRIVATE KEY-----\nMIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQgLvZvir7G0HDrunhb\ncT0OEJWeEjoVBtUJ8m89kDbFoA6hRANCAASEOa4WbRYxN8e7rCmFeWVKiXlLtNjb\nhWuBSzDONprOHujIys8/UZrktEMsam8flh4GCTWs67nsFcQ9J1mg89sO\n-----END PRIVATE KEY-----',
        },



        Business_Cust:{
            user: "g.naveenkumar+501@bankcbw.org",
            password:"Test@1234",
            id: '100000000000011',
            id1: '100000000000012',
            acc_no: '200820056313954',
            acc_no1: '200584257594672',
            namescreen_accno: '200659750839951',
            sender: 'BH25TZOD55564797476216',
            sendername: 'Ahemed Nadia',
            institutionId: '234',
            institutionName:'JP',
            to: 'BH25TZOD55564797476216',
            keyId: '2004',
            legalrepid: '3048',
            CR: '42235-1',
            phone: '77723698',
            email: 'g.naveenkumar+501@bankcbw.org',
            key: '1635333711',
            lemail:'g.naveenkumar+101@bankcbw.org',
            lphone:'75586908',
            lkey:'1635333703',
            lCR:'661434556',
            semail:'g.naveenkumar+2001@bankcbw.org',
            sphone:'56895132',
            scpr:'622345452',
            skey:'1635419237',
            sid:'11001'
        },

    ConfigForLedger: {
           BFCProgram: "PL",
        },
    accountCategory:{
    gpr:"1003",
    salary:"1002",
    wps:"1001",
    gpw:"472",
    Wps_Activity_Ac:"200087338071337",
    Gpw_Activity_Ac:"200255327459121",
    Salary_Activity_Ac:"200730413224916",
    FeeProfile:"4001",
    LimitProfile:"5001",
    MonthlyFeeTemp:"40001"
        },
    GlAccounts:{
    asset:"100329039346474",
    liability:"200862309203590",
    SettlementAcc:"200488934192024",
    feeAccount:"400098987414570",
    VendorAccount:"100655678505724",
    fee_per_gltocustomer:2,
    tax_per_gltocustomer:10,
      
          },
  
    Acno:"200418937683138",
    LimitProfileID:{
        limitProfilenew:"39001",
        limitProfilePerTransaction:"39002",
        limitProfilePerYear:"39005",
        limitProfilePerMonth:"39004",
        limitProfilePerDay:"39003",
        MoneyOutPerDay:"39006",
        MoneyOutPerMonth:"39007",
        DynamicLimit:"201001",
        MoneyInlimit:"42004",
        MoneyInLimitPerMonth:"42005",
        BenefitDepositPerTransaction:"42001",
        BenefitDepositperDay:"42002",
        BenefitDepositperMonth:"42003",
        PerTransactionGPW:"42008",
        PerDayGPW:"42006",
        PerMonthGPW:"42007",


    }
    }
    return config;
    
}
