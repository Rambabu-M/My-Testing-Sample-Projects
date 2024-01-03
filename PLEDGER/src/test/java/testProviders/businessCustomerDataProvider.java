package testProviders;

import org.testng.annotations.DataProvider;

public class businessCustomerDataProvider {

	@DataProvider(name = "invalidMethodNames")
    public Object[][] invalidMethodNames() {
        return new Object[][] {
            {"", "Empty method"},       // Test case 1: Empty username
            {" ", "White Spaces as method"},
            {"   CustomerService.AddCustomer", "Leading space in the method"},  // Test case 2: Username with leading space
            {"CustomerService.AddCustomer  ", "Trailing space in the method"},  // Test case 3: Username with trailing space
            {"@!#fkvjfkfjv", "Alphanumeric in the method"},  // Test case 4: Alphanumeric username
           // {"CustomerService.AddCustomer", "Valid method"}  // Test case 5: Valid method name
        };
	}
	
	@DataProvider(name = "invalidCountryCode")
    public Object[][] invalidCountryCode() {
        return new Object[][] {
            {"", "Empty country code"},       // Test case 1: Empty username
            {"  ", "White Spaces in the Country Code"},  // Test case 2: white spaces in the Country Code
            {"   US", "Leading space in the country code"},  // Test case 3: Username with leading space
            {"US  ", "Trailing space in the country code"},  // Test case 4: Username with trailing space
            {"@!#fkvjfkfjv", "Alphanumeric in the country code"}  // Test case 5: Alphanumeric username
        };
	}
	
	@DataProvider(name = "invalidDateEstablished")
    public Object[][] invalidDateEstablished() {
        return new Object[][] {
            {"", "Empty DateEstablished"},       // Test case 1: Empty username
            {"  ", "White Spaces in the DateEstablished"},  // Test case 2: white spaces in the Country Code
            {"   19901107", "Leading space in the DateEstablished"},  // Test case 3: Username with leading space
            {"19901107  ", "Trailing space in the DateEstablished"},  // Test case 4: Username with trailing space
            {"@!#fkvjfkfjv", "Alphanumeric in the DateEstablished"},  // Test case 5: Alphanumeric username
            {"19902907", "Date in the yyyy-dd-mm format"}
        };
	}
	
	@DataProvider(name = "invalidType")
    public Object[][] invalidType() {
        return new Object[][] {
            {"", "Empty Type"},       // Test case 1: Empty username
            {"  ", "White Spaces in the Type"},  // Test case 2: white spaces in the Country Code
            {"   BUSINESS", "Leading space in the Type"},  // Test case 3: Username with leading space
            {"BUSINESS  ", "Trailing space in the Type"},  // Test case 4: Username with trailing space
            {"@!#fkvjfkfjv", "Alphanumeric in the Type"}  // Test case 5: Alphanumeric username
        };
	}
	
	@DataProvider(name = "invalidBusinessNameLegal")
    public Object[][] invalidBusinessNameLegal() {
        return new Object[][] {
            {"", "Empty BusinessNameLegal"},       // Test case 1: Empty username
            {"  ", "White Spaces in the BusinessNameLegal"},  // Test case 2: white spaces in the Country Code
            {"   XYZ Customer", "Leading space in the BusinessNameLegal"},  // Test case 3: Username with leading space
            {"XYZ Customer  ", "Trailing space in the BusinessNameLegal"},  // Test case 4: Username with trailing space
            {"@!#fkvjfkfjv", "Alphanumeric in the BusinessNameLegal"}  // Test case 5: Alphanumeric username
        };
	}
	
	@DataProvider(name = "invalidMonthlyprojectionAmount")
    public Object[][] invalidMonthlyprojectionAmount() {
        return new Object[][] {
            {2.12, "Float data type as Projection amount"},       // Test case 1: Empty username
            {"2.00", "String as Projection amount"}
        };
	}
	
	@DataProvider(name = "invalidMonthlyprojectionCurrency")
    public Object[][] invalidMonthlyprojectionCurrency() {
        return new Object[][] {
            {"", "Empty as Projection currency"},       // Test case 1: Empty username
            {" ", "WhiteSpace as Projection currency"},
            {"  USD", "Leading Space as Projection currency"},
            {"USD  ", "Trailing Space as Projection currency"},
            {"usd", "Lower case letters as Projection currency"}
        };
	}
	
	@DataProvider(name = "invalidIdentificationType")
    public Object[][] invalidIdentificationType() {
        return new Object[][] {
            {"", "Empty IdentificationType"},       // Test case 1: Empty username
            {" ", "WhiteSpace as IdentificationType"},
            {"  SSN", "Leading Space in IdentificationType"},
            {"SSN  ", "Trailing Space in IdentificationType"},
            {"ssn", "Lower case letters as IdentificationType"},
            {"&^57JHVFGX", "Invalid data as IdentificationType"}  
        };
	}
	
	@DataProvider(name = "invalidIdentificationValue")
    public Object[][] invalidIdentificationValue() {
        return new Object[][] {
            {"", "Empty IdentificationValue"},       // Test case 1: Empty username
            {" ", "WhiteSpace as IdentificationValue"},
            {"  125478963", "Leading Space in IdentificationValue"},
            {"125478963  ", "Trailing Space in IdentificationValue"},
            {"1245", "IdentificationValue less than 9 digits"},
            {"12547896312", "IdentificationValue greater than 9 digits"},
            {"&^57JHVFGX", "Invalid data as IdentificationValue"}  
        };
	}
	
	@DataProvider(name = "invalidContactPhoneNumberValue")
    public Object[][] invalidContactPhoneNumberValue() {
        return new Object[][] {
            {"", "Empty ContactPhoneNumberValue"},       // Test case 1: Empty username
           // {" ", "WhiteSpace as ContactPhoneNumberValue"}, accepting
            //{"  125478963", "Leading Space in ContactPhoneNumberValue"}, accepting
           // {"125478963  ", "Trailing Space in ContactPhoneNumberValue"}, accepting
           // {"985471", "ContactPhoneNumberValue less than 10 digits"}, accepting
           // {"98547123621548512", "ContactPhoneNumberValue greater than 10 digits"},
            {"&^57JHVFGX", "Invalid data as IdentificationValue"}  
        };
	}
	
	@DataProvider(name = "invalidContactEmailValue")
    public Object[][] invalidContactEmailValue() {
        return new Object[][] {
            {"", "Empty ContactEmailValue"},       // Test case 1: Empty username
            {" ", "WhiteSpace as ContactEmailValue"}, 
            {"  tsptsp@netxd.com", "Leading Space in ContactEmailValue"}, 
            {"tsptsp@netxd.com  ", "Trailing Space in ContactEmailValue"}, 
            {"&^57JHVFGX", "Invalid data as ContactEmailValue"}  
        };
	}
	
	@DataProvider(name = "invalidApiCredential")
    public Object[][] invalidApiCredential() {
        return new Object[][] {
            {"", "Empty ApiCredential"},       // Test case 1: Empty username
            {" ", "WhiteSpace as ApiCredential"}, 
            {"  Basic cmVzdGFzc3VyZWRAbmV0eGQuY29tOlRlc3RAMTIzNA==", "Leading Space in ApiCredential"}, 
            {"Basic cmVzdGFzc3VyZWRAbmV0eGQuY29tOlRlc3RAMTIzNA==  ", "Trailing Space in ApiCredential"}, 
            {"&^57JHVFGX", "Invalid data as ApiCredential"}  
        };
	}
	
	@DataProvider(name = "invalidApiSignature")
    public Object[][] invalidApiSignature() {
        return new Object[][] {
            {"", "Empty ApiSignature"},       // Test case 1: Empty username
            {" ", "WhiteSpace as ApiSignature"}, 
            {"  tsptsp@netxd.com", "Leading Space in ApiSignature"}, 
            {"tsptsp@netxd.com  ", "Trailing Space in ApiSignature"}, 
            {"&^57JHVFGX", "Invalid data as ApiSignature"}  
        };
	}
	
	@DataProvider(name = "invalidApiKeyId")
    public Object[][] invalidApiKeyId() {
        return new Object[][] {
            {"", "Empty ApiKeyId"},       // Test case 1: Empty username
            {" ", "WhiteSpace as ApiKeyId"}, 
            {"  1420011", "Leading Space in ApiKeyId"}, 
            {"1420011  ", "Trailing Space in ApiKeyId"}, 
            {"&^57JHVFGX", "Invalid data as ApiKeyId"}
        };
	}
}
